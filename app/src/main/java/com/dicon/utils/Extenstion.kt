package com.dicon.utils

import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId

fun getFirebaseInstanceId():String{
    var token:String?=null
    FirebaseInstanceId.getInstance().instanceId
        .addOnCompleteListener(OnCompleteListener { task ->
            if (task.isSuccessful)
                 token = task.result?.token?:""
            else
                Log.w("TAG", "getInstanceId failed", task.exception)
        })
  return token!!
}