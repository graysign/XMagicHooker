package com.magic.kernel.okhttp

import okhttp3.MediaType
import okhttp3.RequestBody
import okio.*

class ProgressRequestBody(
    private var requestBody: RequestBody,
    private var iProgressRequestCallback: IProgressRequestCallback? = null
): RequestBody() {

    private var bufferedSink: BufferedSink? = null

    override fun contentType(): MediaType? {
        return requestBody.contentType()
    }

    override fun contentLength(): Long {
        return requestBody.contentLength()
    }

    override fun writeTo(sink: BufferedSink) {
        if (bufferedSink == null) {
            bufferedSink = object : ForwardingSink(sink) {
                var bytesWritten = 0L
                var bytesTotal = 0L

                override fun write(source: Buffer, byteCount: Long) {
                    super.write(source, byteCount)
                    if (bytesTotal == 0L) {
                        bytesTotal = contentLength()
                    }
                    bytesWritten += byteCount
                    iProgressRequestCallback?.invoke(bytesWritten, bytesTotal, bytesWritten >= bytesTotal)
                }
            }.buffer()
        }
        requestBody.writeTo(bufferedSink!!)
        bufferedSink?.flush()
    }

}