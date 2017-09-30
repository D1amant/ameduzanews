package br.com.opluss.ameduzanews.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.opluss.ameduzanews.Model.News
import br.com.opluss.ameduzanews.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_news_list.view.*


/**
 * Created by luis on 9/29/17.
 */


class NewsAdapter (val context : Context , val newsList : List<News>?): RecyclerView.Adapter<NewsAdapter.ListViewHolder>() {

    override fun onBindViewHolder(holder: ListViewHolder?, position: Int) {
        holder!!.title.setText(newsList!!.get(position).title)
        holder!!.description.setText(newsList!!.get(position).description)
        holder!!.description.setText(newsList!!.get(position).description)
        Picasso.with(context)
                .load(newsList!!.get(position).urlToImage)
                .resize(50, 50)
                .centerCrop()
                .into(holder.imgem)
    }

    override fun getItemCount(): Int {
        return if (this.newsList != null) this.newsList.size else 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_news_list, parent, false)

        // Cria o ViewHolder
        val holder = ListViewHolder(view)
        return holder
    }


    class ListViewHolder(view: View)  : RecyclerView.ViewHolder(view) {

        var title = view.textTitle
        var description = view.textDescription
        var imgem = view.img
    }
}