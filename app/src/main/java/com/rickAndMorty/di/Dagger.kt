package com.rickAndMorty.di

import com.rickAndMorty.ui.CharactersActivity
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        RetrofitModule::class,
        AppModule::class,
        RepositoryModule::class,
        ViewModelModule::class,
    ]
)
@Singleton
interface AppComponent {
    @Component.Builder
    interface Builder {

        fun appModule(appModule: AppModule): Builder

        fun build(): AppComponent
    }

    fun inject(activity: CharactersActivity)
}