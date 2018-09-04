package com.qibenyu.volley

import android.os.Process
import com.qibenyu.volley.toolbox.Request
import java.util.concurrent.PriorityBlockingQueue

class CacheDispatcher(cacheQueue: PriorityBlockingQueue<Request<Any>>,
                      networkQueue: PriorityBlockingQueue<Request<Any>>,
                      cache: Cache) : Thread() {
    val mCacheQueue: PriorityBlockingQueue<Request<Any>> = cacheQueue
    val mNetworkQueue: PriorityBlockingQueue<Request<Any>> = networkQueue

    val mCache: Cache = cache

    private var mQuit = false

    override fun run() {
        Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND)

        mCache.initialize()

        while (true) {
            processRequest()
        }


    }

    private fun processRequest() {
        val request = mCacheQueue.take()
        processRequest(request)
    }

    private fun processRequest(request: Request<Any>?) {

        request?.addMarker("cache-queue-take")

        if (request?.isCancel()!!) {
            request.finish()
        }

        var entry = mCache.get(request.)
    }

    fun quit() {
        mQuit = true
        interrupt()
    }
}