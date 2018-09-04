package com.qibenyu.volley.toolbox

class Request<in T> {

    lateinit var mUrl: String

    enum class Method(val key: Int) {
        GET(0),
        POST(1)
    }

    fun isCancel(): Boolean {
        TODO()
    }

    fun finish() {

    }

    fun getCacheKey(): String {
        val url = getUrl()
        val method = getMethod()

        if (method.equals(Method.GET)) {
            return url
        }
        return method.toString() + "-" + url
    }

    fun getMethod(): Int {
        return Method.GET.key
    }

    fun getUrl(): String {
        return mUrl
    }

    fun addMarker(tag: String) {

    }
}