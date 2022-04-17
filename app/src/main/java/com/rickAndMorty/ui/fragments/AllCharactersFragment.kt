package com.rickAndMorty.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.rickAndMorty.R
import com.rickAndMorty.domain.entity.Character
import com.rickAndMorty.presentation.AllCharactersAdapter
import com.rickAndMorty.presentation.state.CharactersState
import com.rickAndMorty.ui.BaseFragment
import com.rickAndMorty.ui.CharactersActivity
import com.rickAndMorty.util.Constants.Companion.QUERY_PAGE_SIZE
import com.rickAndMorty.util.PaginationScrollListener
import kotlinx.android.synthetic.main.fragment_all_characters.*


class AllCharactersFragment : BaseFragment(R.layout.fragment_all_characters) {

    private lateinit var allCharactersAdapter: AllCharactersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as CharactersActivity).viewModel
        paginationScrollListener = PaginationScrollListener(viewModel::getCharacter)
        setupRecyclerView()
        viewModel.characterLiveData.observe(viewLifecycleOwner) { state ->
            renderContent(state)
        }
    }

    private fun renderContent(state: CharactersState) {
        when (state) {
            is CharactersState.Content -> {
                hideProgressBar(paginationProgressBar)
                allCharactersAdapter.submitList(state.data.results)
                updatePaginationListener(state)
            }

            is CharactersState.Error -> {
                hideProgressBar(paginationProgressBar)
                Toast.makeText(context, "Не удалось связаться с сервером", Toast.LENGTH_SHORT)
                    .show()
            }

            is CharactersState.Loading -> {
                showProgressBar(paginationProgressBar)
            }
        }
    }

    private fun openCharacterBio(character: Character) {
        val bundle = Bundle().apply {
            putSerializable("character", character)
        }

        findNavController().navigate(
            R.id.action_allCharactersFragment_to_characterBioFragment,
            bundle
        )
    }

    private fun updatePaginationListener(state: CharactersState.Content) {
        val totalPages = state.data.info.count / QUERY_PAGE_SIZE + 2
        paginationScrollListener.isLastPage = viewModel.characterPage == totalPages
        if (paginationScrollListener.isLastPage) {
            rvAllCharacters.setPadding(0, 0, 0, 0)
        }
    }

    private fun setupRecyclerView() {
        allCharactersAdapter = AllCharactersAdapter(::openCharacterBio)
        rvAllCharacters.adapter = allCharactersAdapter
        rvAllCharacters.addOnScrollListener(paginationScrollListener)
    }
}
