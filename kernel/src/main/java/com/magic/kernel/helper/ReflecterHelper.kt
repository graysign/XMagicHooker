package com.magic.kernel.helper

import android.util.Log
import com.magic.kernel.MagicGlobal
import com.magic.kernel.helper.ParserHelper.ClassTrie
import java.lang.reflect.Field
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.util.concurrent.ConcurrentHashMap

/**
 *  查找类、方法、属性，用于版本自动匹配
 */
object ReflecterHelper {

    private val classCache: MutableMap<String, Classes> = ConcurrentHashMap()
    private val methodCache: MutableMap<String, Methods> = ConcurrentHashMap()
    private val fieldCache: MutableMap<String, Fields> = ConcurrentHashMap()

    @JvmStatic
    fun shadowCopy(obj: Any, copy: Any, clazz: Class<*>? = obj::class.java) {
        if (clazz == null) return
        shadowCopy(obj, copy, clazz.superclass)
        clazz.declaredFields.forEach {
            it.isAccessible = true
            it.set(copy, it.get(obj))
        }
    }

    /** ------------- Class ------------ */
    @JvmStatic
    fun findClassIfExists(className: String, classLoader: ClassLoader): Class<*>? =
        try {
            if (classCache.containsKey(className)) {
                classCache[className]?.firstOrNull()
            } else {
                Class.forName(className, false, classLoader).also {
                    classCache[className] = Classes(listOf(it))
                }
            }
        } catch (throwable: Throwable) {
            if (MagicGlobal.unitTestMode) {
                throw  throwable
            }
            null
        }

    @JvmStatic
    fun findClassesInPackage(classLoader: ClassLoader, trie: ClassTrie, packageName: String, depth: Int = 0): Classes {
        val key = "$depth-$packageName"
        val cached = classCache[key]
        if (cached != null) {
            return cached
        }
        val classes = Classes(trie.search(packageName, depth).mapNotNull { name ->
                findClassIfExists(name, classLoader)
            })
        return classes.also { classCache[key] = classes }
    }

    /** ------------- Method ------------ */
    @JvmStatic
    fun findMethodsByExactName(clazz: Class<*>, methodName: String): Methods {
        val fullMethodName = "${clazz.name}#$methodName#exactnname"
        return when (methodCache[fullMethodName] != null) {
            true -> methodCache[fullMethodName]!!
            else -> Methods(clazz.declaredMethods.filter { return@filter it.name.equals(methodName, false) }
                .onEach { it.isAccessible = true })
                .also { methodCache[fullMethodName] = it }
        }
    }

    @JvmStatic
    fun findMethodIfExists(clazz: Class<*>, methodName: String, vararg parameterTypes: Class<*>): Method? =
        try {
            findMethodExact(clazz, methodName, *parameterTypes)
        } catch (_: Throwable) {
            null
        }

    @JvmStatic
    private fun findMethodExact(clazz: Class<*>, methodName: String, vararg parameterTypes: Class<*>): Method {
        val fullMethodName = "${clazz.name}#$methodName${getParametersString(*parameterTypes)}#exact"
        if (fullMethodName in methodCache) {
            return methodCache[fullMethodName]?.firstOrNull() ?: throw NoSuchMethodError(fullMethodName)
        }
        try {
            val method = clazz.getMethod(methodName, *parameterTypes).apply {
                isAccessible = true
            }
            return method.also { methodCache[fullMethodName] = Methods(listOf(method)) }
        } catch (e: NoSuchMethodException) {
            throw NoSuchMethodError(fullMethodName)
        }
    }

    @JvmStatic
    fun findMethodsByExactParameters(clazz: Class<*>, returnType: Class<*>?, vararg parameterTypes: Class<*>): Methods {
        val fullMethodName = "${clazz.name}#${returnType?.name ?: ""}#${getParametersString(*parameterTypes)}#exactParameters"
        var methods = clazz.declaredMethods.filter { method ->
            if (returnType != null && returnType != method.returnType) return@filter false

            val methodParameterTypes = method.parameterTypes
            if (parameterTypes.size != methodParameterTypes.size) return@filter false

            var match = true
            for (i in parameterTypes.indices) {
                if (parameterTypes[i] != methodParameterTypes[i]) {
                    match = false
                    break
                }
            }
            return@filter match
        }.apply {
            for (method in this) {
                method.isAccessible = true
                Log.e(ReflecterHelper.javaClass.name, "findMethodsByExactParameters:${clazz.name}   ${method.name}")
            }
        }
        return when (methods.isNotEmpty()) {
            true -> Methods(methods).also { methodCache[fullMethodName] = it }
            else -> (if (clazz.superclass != null) findMethodsByExactParameters(clazz.superclass!!, returnType, *parameterTypes
                    ) else Methods(listOf()))
                .also { methodCache[fullMethodName] = it }
        }
    }

    @JvmStatic
    private fun getParametersString(vararg clazzes: Class<*>): String =
        "(" + clazzes.joinToString(",") { it.canonicalName ?: "" } + ")"

    /** ------------- Field ------------ */
    @JvmStatic
    fun findFieldIfExists(clazz: Class<*>, fieldName: String): Field? {
        val fullFieldName = "${clazz.name}#$fieldName"
        return if (fieldCache.containsKey(fullFieldName)) {
            fieldCache[fullFieldName]?.firstOrNull()
        } else try {
                clazz.getDeclaredField(fieldName)
                    .apply { isAccessible = true }
                    .also { fieldCache[fullFieldName] = Fields(listOf(it)) }
            } catch (_: NoSuchFieldException) {
                if (clazz.superclass != null) findFieldIfExists(clazz.superclass!!, fieldName) else null
            }
    }

    @JvmStatic
    fun findFieldsWithType(clazz: Class<*>, type: Class<*>): Fields =
        findFieldsWithType(clazz, type.name)

    @JvmStatic
    fun findFieldsWithType(clazz: Class<*>, typeName: String): Fields {
        val fullFieldName = "${clazz.name}#$typeName#type"
        val fields = clazz.declaredFields.filter { it.type.name == typeName }
        return when (fields.isNotEmpty()) {
            true -> Fields(fields)
            false -> (if (clazz.superclass != null) findFieldsWithType(clazz.superclass!!, typeName) else Fields(listOf()))
                .also { fieldCache[fullFieldName] = it }
        }
    }

    @JvmStatic
    fun findFieldsWithGenericType(clazz: Class<*>, genericTypeName: String): List<Field> {
        val fields = clazz.declaredFields.filter { it.genericType.toString() == genericTypeName }
        return when (fields.isNotEmpty()) {
            true -> fields
            false -> if (clazz.superclass != null) findFieldsWithGenericType(
                clazz.superclass!!,
                genericTypeName
            ) else listOf()
        }
    }

    /** 通过其他方式过滤类 */
    class Classes( val classes: List<Class<*>>) {

        fun filterByInterfaces(vararg interfaceClasses: Class<*>): Classes =
            Classes(classes.filter {
                for (i in interfaceClasses.indices) {
                    if (it.interfaces.contains(interfaceClasses[i])) return@filter true
                }
                return@filter false
            })

        fun filterBySuper(superClass: Class<*>?): Classes =
            Classes(classes.filter { it.superclass == superClass })

        fun filterByEnclosingClass(enclosingClass: Class<*>?): Classes =
            Classes(classes.filter { it.enclosingClass == enclosingClass })

        fun filterBySubclass(subClass: Class<*>): Classes =
            Classes(classes.mapNotNull { it.asSubclass(subClass) })

        fun filterByMethod(returnType: Class<*>?, methodName: String, vararg parameterTypes: Class<*>): Classes =
            Classes(classes.filter { clazz ->
                val method = findMethodIfExists(clazz, methodName, *parameterTypes)
                return@filter method != null && method.returnType == returnType ?: method.returnType
            })

        fun filterByMethod(returnType: Class<*>?, vararg parameterTypes: Class<*>): Classes =
            Classes(classes.filter { clazz ->
                findMethodsByExactParameters(clazz, returnType, *parameterTypes).isNotEmpty()
            })

        fun filterByField(fieldName: String, fieldClazz: Class<*>): Classes =
            filterByField(fieldName, fieldClazz.canonicalName ?: "")

        fun filterByField(fieldName: String, fieldType: String): Classes =
            Classes(classes.filter { clazz ->
                val field = findFieldIfExists(clazz, fieldName)
                return@filter field != null && field.type.canonicalName == fieldType
            })

        fun filterByField(fieldClazz: Class<*>): Classes =
            filterByField(fieldClazz.name)

        fun filterByField(fieldType: String): Classes =
            Classes(classes.filter { findFieldsWithType(it, fieldType).isNotEmpty() })

        fun firstOrNull(): Class<*>? {
            if (classes.isNotEmpty()) {
                val names = classes.map { it.canonicalName }
                Log.e(ReflecterHelper.javaClass.name, "found a signature classes: $names")
            }
            return classes.firstOrNull()
        }

    }

    /** 通过其他方式过滤方法 */
    class Methods(private val methods: List<Method>) {

        fun filterByReturenType(clazz: Class<*>): Methods =
            Methods(methods.filter { it.returnType == clazz })

        fun filterByReturenSubType(subClazz: Class<*>): Methods =
            Methods(methods.mapNotNull {
                return@mapNotNull try {
                    Log.e(ReflecterHelper.javaClass.name, "filterByReturenSubType before: ${it.returnType.name}")
                    it.returnType.asSubclass(subClazz)
                    it
                } catch (_: Throwable) {
                    Log.e(ReflecterHelper.javaClass.name, "filterByReturenSubType fail: ${subClazz.name}")
                    null
                }
            })

        fun filterByModifiers(vararg modifiers: Int): Methods =
            if (modifiers.size < 0) this else Methods(methods.filter { it.modifiers == modifiers.reduce { acc, i -> acc.or(i) } })

        fun isNotEmpty(): Boolean = methods.isNotEmpty()

        fun isEmpty(): Boolean = methods.isEmpty()

        fun filter(func: (it: Method) -> Boolean): Methods =
            Methods(methods.filter { func(it) })

        fun mapNotNull(func: (it: Method) -> Method?): Methods =
            Methods(methods.mapNotNull{ func(it) })

        fun firstOrNull(): Method? {
            if (methods.isNotEmpty()) {
                val names = methods.map { it.name }
                Log.e(ReflecterHelper.javaClass.name, "found a signature methods: $names")
            }
            return methods.firstOrNull()
        }

    }

    /** 通过其他方式过滤属性 */
    class Fields(private val fields: List<Field>) {

        fun filterByModifiers(vararg modifiers: Int): Fields =
            if (modifiers.size < 0) this else Fields(fields.filter { it.modifiers == modifiers.reduce { acc, i -> acc.or(i) } })

        fun isNotEmpty(): Boolean = fields.isNotEmpty()

        fun isEmpty(): Boolean = fields.isEmpty()

        fun filter(func: (it: Field) -> Boolean): Fields =
            Fields(fields.filter { func(it) })

        fun mapNotNull(func: (it: Field) -> Field?): Fields =
            Fields(fields.mapNotNull{ func(it) })

        fun firstOrNull(): Field? {
            if (fields.isNotEmpty()) {
                val names = fields.map { it.name }
                Log.e(ReflecterHelper.javaClass.name, "found a signature fields: $names")
            }
            return fields.firstOrNull()
        }
    }
}
