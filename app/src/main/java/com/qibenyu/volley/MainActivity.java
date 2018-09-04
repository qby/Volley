package com.qibenyu.volley;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qibenyu.volley.toolbox.VolleyKt;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VolleyKt.newRequestQueue(this);
    }
}
