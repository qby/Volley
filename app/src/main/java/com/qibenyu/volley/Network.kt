package com.qibenyu.volley

import com.qibenyu.volley.toolbox.Request

interface Network {

    fun performRequest(request: Request<Any>): NetworkResponse
}