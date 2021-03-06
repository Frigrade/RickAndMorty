package com.rickAndMorty.ui

import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.rickAndMorty.presentation.CharactersViewModel
import com.rickAndMorty.util.PaginationScrollListener

open class BaseFragment(resId: Int) : Fragment(resId) {
    lateinit var viewModel: CharactersViewModel
    lateinit var paginationScrollListener: PaginationScrollListener

    fun hideProgressBar(paginationProgressBar: ProgressBar) {
        paginationProgressBar.visibility = View.INVISIBLE
        paginationScrollListener.isLoading = false
    }

    fun showProgressBar(paginationProgressBar: ProgressBar) {
        paginationProgressBar.visibility = View.VISIBLE
        paginationScrollListener.isLoading = true
    }
}