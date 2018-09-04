package com.qibenyu.volley

class NetworkDispatcher : Thread() {

    private var mQuit = false

    fun quit(){

        mQuit = true
        interrupt()
    }
}