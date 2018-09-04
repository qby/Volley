package com.qibenyu.volley.toolbox

import android.content.Context
import com.qibenyu.volley.BasicNetwork
import com.qibenyu.volley.RequestQueue
import java.io.File


const val DEFAULT_CACHE_DIR = "volley"

fun newRequestQueue(context: Context): RequestQueue {
    val network = BasicNetwork()
    val file = File(context.cacheDir, DEFAULT_CACHE_DIR)
    val requestQueue = RequestQueue(file, network)
    requestQueue.start()
    return requestQueue

}

