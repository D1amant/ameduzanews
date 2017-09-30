package br.com.opluss.ameduzanews.Activities

import android.opengl.Visibility
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import br.com.opluss.ameduzanews.Adapters.NewsAdapter
import br.com.opluss.ameduzanews.Model.News
import br.com.opluss.ameduzanews.R
import br.com.opluss.ameduzanews.Services.NewsService
import de.mrapp.android.dialog.MaterialDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView : RecyclerView
    lateinit var myProgress : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = recycler_view
        myProgress = progress
        recyclerView.layoutManager = LinearLayoutManager(this)
        var newsService = object : NewsService(){
            override fun response(newsList: List<News>?) {
                var adapter = NewsAdapter(applicationContext , newsList)
                recyclerView.adapter = adapter
                myProgress.visibility = View.GONE
            }

            override fun error(e: String) {
                MaterialDialog.Builder(applicationContext)
                        .setTitle(R.string.title_error)
                        .setMessage(R.string.message_data_error)
                        .show();
                Log.e(MainActivity::class.simpleName , e)
            }
        }
        myProgress.visibility = View.VISIBLE;
        newsService.execGetRequest(applicationContext , getString(R.string.urlserver)+getString(R.string.key))
    }
}
