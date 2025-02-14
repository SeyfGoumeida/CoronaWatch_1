package com.example.coronawatch

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.toolbox.Volley
import java.security.AccessControlContext

class VolleySingleton constructor(context: Context) {

    companion object {

        @Volatile
        private var INSTANCE: VolleySingleton? = null

        fun getInstance(context: Context) =

            INSTANCE ?: synchronized(this) {
                INSTANCE ?: VolleySingleton(context).also {
                    INSTANCE = it
                }
            }
    }

    private val requestQueue by lazy {

        Volley.newRequestQueue(context.applicationContext)  }

    fun <T> addToRequestQueue(req:Request<T>)  {
        requestQueue.add(req)

    }

}
