package com.bimabagaskhoro.submissionjetpactpro2.ui.content.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bimabagaskhoro.submissionjetpactpro2.databinding.FragmentMovieBinding
import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro2.ui.DetailActivity
import com.bimabagaskhoro.submissionjetpactpro2.ui.content.adapter.MovieAdapter
import com.bimabagaskhoro.submissionjetpactpro2.viewmodel.DetailViewModel.Companion.MOVIE
import com.bimabagaskhoro.submissionjetpactpro2.viewmodel.ShowViewModel
import com.bimabagaskhoro.submissionjetpactpro2.viewmodel.ViewModelFactory
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper

class MovieFragment : Fragment(), MovieAdapter.DataCallback {

    private lateinit var fragmentMovieBinding: FragmentMovieBinding
    private lateinit var moviesAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            if (activity != null) {
                true.progressBar()
                val factory = ViewModelFactory.getInstance(requireActivity())
                val viewModel = ViewModelProvider(this, factory)[ShowViewModel::class.java]
                moviesAdapter = MovieAdapter()
                viewModel.getListMovie().observe(viewLifecycleOwner, { movies ->
                    false.progressBar()
                    moviesAdapter.apply {
                        setShow(movies)
                        notifyDataSetChanged()
                        callback(this@MovieFragment)
                    }
                    fragmentMovieBinding.rvMovie.apply {
                        layoutManager = LinearLayoutManager(context)
                        setHasFixedSize(true)
                        adapter = moviesAdapter

                        OverScrollDecoratorHelper.setUpOverScroll(
                            this,
                            OverScrollDecoratorHelper.ORIENTATION_VERTICAL
                        )
                    }
                })
            }
        }
    }

    private fun Boolean.progressBar() {
        fragmentMovieBinding.progressBar.visibility = if (this) View.VISIBLE else View.GONE
    }

    override fun onItemClicked(id: String) {
        startActivity(Intent(context, DetailActivity::class.java)
            .putExtra(DetailActivity.EXTRAS_SHOW, id)
            .putExtra(DetailActivity.EXTRAS_CHOOSE, MOVIE)
        )
    }
}