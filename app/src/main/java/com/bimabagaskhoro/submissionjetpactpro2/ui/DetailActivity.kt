package com.bimabagaskhoro.submissionjetpactpro2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bimabagaskhoro.submissionjetpactpro2.R
import com.bimabagaskhoro.submissionjetpactpro2.databinding.ActivityDetailBinding
import com.bimabagaskhoro.submissionjetpactpro2.databinding.ContentDetailBinding
import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.DetailEntity
import com.bimabagaskhoro.submissionjetpactpro2.ui.content.adapter.MovieAdapter
import com.bimabagaskhoro.submissionjetpactpro2.viewmodel.DetailViewModel
import com.bimabagaskhoro.submissionjetpactpro2.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {
    private lateinit var contentDetailBinding: ContentDetailBinding

    companion object {
        const val EXTRAS_SHOW = "extras_show"
        const val EXTRAS_CHOOSE = "choose"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        contentDetailBinding = activityDetailBinding.detailContent
        setContentView(activityDetailBinding.root)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(
            this, factory)[DetailViewModel::class.java]
        val extras = intent.extras
        if (extras != null) {
            val showId = extras.getString(EXTRAS_SHOW)
            val showChoose = extras.getString(EXTRAS_CHOOSE)
            if (showId != null && showChoose != null) {
                true.progressBar()

                viewModel.setDetail(showId, showChoose)
                viewModel.getDetail().observe(this, { detail ->
                    false.progressBar()
                    dataDetail(detail)
                })
            }
        }
    }

    private fun dataDetail(detail: DetailEntity) {

        if (supportActionBar != null) {
            title = detail.title
        }

        contentDetailBinding.tvTitle.text = detail.title
        contentDetailBinding.tvDate.text = detail.date
        contentDetailBinding.tvGenre.text = detail.genres.toString()
        contentDetailBinding.tvDesc.text = detail.desc
        contentDetailBinding.tvOriginalLanguage.text = detail.original_language
        Glide.with(this@DetailActivity)
            .load("https://image.tmdb.org/t/p/w500" + detail.imageBackdrop)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(contentDetailBinding.imgBackdrop)
        Glide.with(this@DetailActivity)
            .load("https://image.tmdb.org/t/p/w500" + detail.imageDetail)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(contentDetailBinding.imgPosterDetail)
    }

    private fun Boolean.progressBar() {
        contentDetailBinding.progressBar.visibility = if (this) View.VISIBLE else View.GONE
    }
}