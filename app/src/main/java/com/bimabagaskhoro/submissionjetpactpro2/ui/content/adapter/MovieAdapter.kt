package com.bimabagaskhoro.submissionjetpactpro2.ui.content.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bimabagaskhoro.submissionjetpactpro2.R
import com.bimabagaskhoro.submissionjetpactpro2.databinding.ItemsShowBinding
import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.MovieEntity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private lateinit var callback: DataCallback
    private var listShow = ArrayList<MovieEntity>()

    companion object {
        const val EXTRA_LINK = "https://image.tmdb.org/t/p/w500"
    }

    fun callback(callback: DataCallback) {
        this.callback = callback
    }

    fun setShow(courses: List<MovieEntity>?) {
        if (courses == null) return
        this.listShow.clear()
        this.listShow.addAll(courses)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val itemsShowBinding =
            ItemsShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsShowBinding)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
        val show = listShow[position]
        holder.bind(show)
    }

    override fun getItemCount(): Int = listShow.size

    inner class MovieViewHolder(private val binding: ItemsShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(show: MovieEntity) {
            with(binding) {
                tvItemTitle.text = show.title
                tvItemDate.text = show.date
                tvItemOriginalLanguage.text = show.original_language
                Glide.with(itemView.context)
                    .load( EXTRA_LINK + show.image)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
                itemView.setOnClickListener {
                    callback.onItemClicked(show.id.toString())
                }
            }
        }
    }

    interface DataCallback  {
        fun onItemClicked(id: String)
    }
}