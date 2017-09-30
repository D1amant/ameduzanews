package br.com.opluss.ameduzanews.Repository.Remote;

import android.content.Context
import com.google.gson.JsonObject

/**
 * Created by luis on 9/29/17.
 */

abstract class NewsRemoteRepository  : BaseRemoteRepository() {


    override fun execGetRequest(context : Context , url : String){
        super.execGetRequest(context , url)
    }

    override fun getResponse(reult: JsonObject) {
        response(reult)
    }

    override fun getError(e: String) {
         error(e)
    }

    abstract fun response(reult: JsonObject)

    abstract fun error(reult: String)

}
