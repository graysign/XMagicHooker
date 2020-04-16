package com.magic.kernel.okhttp

import okhttp3.MediaType
import okhttp3.ResponseBody
import okio.*

class ProgressResponseBody(
    private var responseBody: ResponseBody,
    private var iProgressResponseCallback: IProgressResponseCallback? = null
) : ResponseBody() {

    override fun contentType(): MediaType? {
        return responseBody.contentType()
    }

    override fun contentLength(): Long {
        return responseBody.contentLength()
    }

    override fun source(): BufferedSource =
        object : ForwardingSource(responseBody.source()) {
            val bytesTotal = contentLength()
            var bytesReaded = 0L
            override fun read(sink: Buffer, byteCount: Long): Long {
                val bytesRead = super.read(sink, byteCount)
                bytesReaded += if (bytesRead != -1L) bytesRead else 0
                iProgressResponseCallback?.invoke(bytesReaded, bytesTotal, bytesRead != -1L)
                return bytesRead
            }

        }.buffer()
}