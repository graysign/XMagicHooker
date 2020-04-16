package com.magic.kernel.media.audio.writer

interface IBaseWriter {

    fun initWriter(str: String): Boolean

    fun pushBuf(bArr: ByteArray, i: Int, z: Boolean)

    fun resetWriter(): Boolean

    fun waitStop()

    fun writeToFile(bArr: ByteArray, len: Int, i: Int): Boolean

    fun writeToFile(bArr: ByteArray, len: Int, i: Int, z: Boolean): Boolean

}