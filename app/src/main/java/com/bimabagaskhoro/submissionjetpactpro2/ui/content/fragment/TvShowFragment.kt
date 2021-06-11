package com.bimabagaskhoro.submissionjetpactpro2.ui.content.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bimabagaskhoro.submissionjetpactpro2.databinding.FragmentTvShowBinding
import com.bimabagaskhoro.submissionjetpactpro2.model.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro2.ui.DetailActivity
import com.bimabagaskhoro.submissionjetpactpro2.ui.content.adapter.MovieAdapter
import com.bimabagaskhoro.submissionjetpactpro2.ui.content.adapter.TvShowAdapter
import com.bimabagaskhoro.submissionjetpactpro2.viewmodel.DetailViewModel.Companion.TV_SHOW
import com.bimabagaskhoro.submissionjetpactpro2.viewmodel.ShowViewModel
import com.bimabagaskhoro.submissionjetpactpro2.viewmodel.ViewModelFactory
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper

class TvShowFragment : Fragment() , TvShowAdapter.DataCallback{
    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            if (activity != null) {
                true.progressBar()
                val factory = ViewModelFactory.getInstance(requireActivity())
                val viewModel = ViewModelProvider(this, factory)[ShowViewModel::class.java]
                tvShowAdapter = TvShowAdapter()
                viewModel.getListTvShow().observe(viewLifecycleOwner, { tvshow ->
                    false.progressBar()
                    tvShowAdapter.apply {
                        setShow(tvshow)
                        notifyDataSetChanged()
                        callback(this@TvShowFragment)
                    }

                    fragmentTvShowBinding.rvTvShow.apply {
                        layoutManager = LinearLayoutManager(context)
                        setHasFixedSize(true)
                        adapter = tvShowAdapter

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
        fragmentTvShowBinding.progressBar.visibility = if (this) View.VISIBLE else View.GONE
    }

    override fun onItemClicked(id: String) {
        startActivity(Intent(context, DetailActivity::class.java)
            .putExtra(DetailActivity.EXTRAS_SHOW, id)
            .putExtra(DetailActivity.EXTRAS_CHOOSE, TV_SHOW)
        )
    }
}