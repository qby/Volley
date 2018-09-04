package com.qibenyu.volley

interface Cache {

    fun put(entry: Entry)

    fun get(key: String): Entry

    fun initialize()

    fun remove(key: String)

    fun clear()

    fun invalidate(key: String, fullExpired: Boolean)

    data class Entry(
            val data: Array<Byte>,
            val etag: String,
            val serverData: Long,
            val lastModified: Long,
            val ttl: Long,
            val softTtl: Long, val responseHeaders: Map<String, String> = mapOf()) {
        fun isExpired(): Boolean {
            return ttl < System.currentTimeMillis()
        }

        fun refreshNeeded(): Boolean {
            return softTtl < System.currentTimeMillis()
        }
    }

}