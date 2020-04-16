package com.magic.shared.hookers.interfaces

interface IXLogHooker {

    fun onXLogWrite(level: String, tag: String, msg: String) { }

    fun onXLogWrite2(level: String, tag: String, msg: String) { }

}