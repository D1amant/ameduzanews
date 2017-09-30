package br.com.opluss.ameduzanews.Services

import android.content.Context
import br.com.opluss.ameduzanews.Model.News
import br.com.opluss.ameduzanews.Repository.Remote.NewsRemoteRepository
import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson
import com.google.gson.JsonObject

/**
 * Created by luis on 9/29/17.
 */
abstract class NewsService{
    var newsRepository = object : NewsRemoteRepository(){
        override fun response(reult: JsonObject) {
            var gson = Gson();
            var newsList =  gson.fromJson<List<News>>(reult.get("articles").asJsonArray)
            response(newsList)
        }

        override fun error(reult: String) {
            error(reult)
        }

    }

     fun execGetRequest(context: Context , url : String){
         newsRepository.execGetRequest(context , url)
    }

    abstract fun response(newsList: List<News>?)

    abstract fun error(e: String)
}