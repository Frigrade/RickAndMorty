package com.rickAndMorty.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rickAndMorty.data.repository.CharacterRepository
import com.rickAndMorty.domain.entity.CharactersList
import com.rickAndMorty.presentation.state.CharactersState
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


class CharactersViewModel @Inject constructor(
    private val characterRepository: CharacterRepository,
) : ViewModel() {
    val characterLiveData: MutableLiveData<CharactersState> = MutableLiveData()
    var characterPage = 1
    private var charactersList: CharactersList? = null

    init {
        getCharacter()
    }

    fun getCharacter() = viewModelScope.launch {
        characterLiveData.postValue(CharactersState.Loading)
        val rawResponse = characterRepository.getCharacter(characterPage)
        characterLiveData.postValue(handleCharactersResponse(rawResponse))
    }

    private fun handleCharactersResponse(
        list: Response<CharactersList>,
    ): CharactersState {
        if (list.isSuccessful) {
            list.body()?.let {
                characterPage++
                if (charactersList == null) {
                    charactersList = it
                } else {
                    val oldCharacters = charactersList?.results
                    val newCharacters = it.results
                    val newList = oldCharacters!! + newCharacters
                    charactersList = CharactersList(newList, charactersList!!.info)

                }
                return CharactersState.Content(charactersList!!)
            }
        }
        return CharactersState.Error(list.message())
    }
}