package com.qibenyu.volley

import com.qibenyu.volley.toolbox.Request
import java.io.File
import java.util.concurrent.PriorityBlockingQueue

class RequestQueue(file: File, network: BasicNetwork) {

    private val mNetworkQueue = PriorityBlockingQueue<Request<Any>>()

    private val mCacheQueue = PriorityBlockingQueue<Request<Any>>()

    private var mCacheDispatcher: CacheDispatcher? = null

    private var mDispatchers: Array<NetworkDispatcher> = arrayOf()

    private var mCache: Cache? = null


    fun start() {
        stop()

        mCacheDispatcher = CacheDispatcher(mCacheQueue, mNetworkQueue, mCache)
        mCacheDispatcher!!.start()

        for (i in mDispatchers.indices) {
            val networkDispatcher = NetworkDispatcher()
            mDispatchers[i] = networkDispatcher
            networkDispatcher.start()

        }


    }

    fun stop() {

        mCacheDispatcher?.quit()

        for (mDispatcher in mDispatchers) {
            mDispatcher.quit()
        }
    }

    fun <T> add(request: Request<T>): Request<T> {

        return request
    }

}


