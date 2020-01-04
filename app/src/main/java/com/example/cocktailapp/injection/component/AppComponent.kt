package com.example.cocktailapp.injection.component

import com.example.cocktailapp.App
import com.example.cocktailapp.fragment.detail.CocktailDetailViewModel
import com.example.cocktailapp.fragment.favorieten.FavorietenViewModel
import com.example.cocktailapp.fragment.home.HomeViewModel
import com.example.cocktailapp.fragment.info.InfoViewModel
import com.example.cocktailapp.injection.module.DatabaseModule
import com.example.cocktailapp.injection.module.NetworkModule
import com.example.cocktailapp.model.repository.CocktailRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface AppComponent {

    fun inject(app: App)

    fun inject(cocktailRepository: CocktailRepository)

    fun inject(homeViewModel: HomeViewModel)
    fun inject(infoViewModel: InfoViewModel)

    fun inject(cocktailDetailViewModel: CocktailDetailViewModel)
    fun inject(favorietenViewModel: FavorietenViewModel)

    /**
     * Builder om de subcomponenten toe te voegen.
     */
    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        fun networkModule(networkModule: NetworkModule): Builder
        fun databaseModule(databaseModule: DatabaseModule): Builder
    }
}
