package com.rickAndMorty.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.rickAndMorty.R
import com.rickAndMorty.appComponent
import com.rickAndMorty.presentation.AllCharactersViewModel
import com.rickAndMorty.presentation.CharactersViewModelProviderFactory
import javax.inject.Inject


class CharactersActivity : AppCompatActivity() {

    lateinit var viewModelAll: AllCharactersViewModel

    @Inject
    lateinit var viewModelProviderFactory: CharactersViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        viewModelAll = ViewModelProvider(this,
            viewModelProviderFactory).get(AllCharactersViewModel::class.java)

        setContentView(R.layout.activity_characters)
    }
}

