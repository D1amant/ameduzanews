package br.com.opluss.ameduzanews.Repository.Remote

import android.content.Context
import com.google.gson.JsonObject
import com.koushikdutta.ion.Ion



/**
 * Created by luis on 9/29/17.
 */
abstract class BaseRemoteRepository{

    open fun execGetRequest(context : Context , url : String){
        Ion.with(context)
                .load(url)
                .asJsonObject()
                .setCallback { e, result ->
                    if(result != null){
                        getResponse(result)
                    }
                    if (e != null){
                        getError(e.message!!)
                    }
                }
    }

    abstract fun getResponse(reult: JsonObject)

    abstract fun getError(reult: String)

}