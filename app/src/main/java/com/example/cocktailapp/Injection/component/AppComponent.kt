package com.example.cocktailapp.Injection.component

import com.example.cocktailapp.App
import com.example.cocktailapp.Fragment.Home.HomeViewModel
import com.example.cocktailapp.Fragment.Info.InfoViewModel
import com.example.cocktailapp.Fragment.Search.SearchViewModel
import com.example.cocktailapp.Injection.module.DatabaseModule
import com.example.cocktailapp.Injection.module.NetworkModule
import com.example.cocktailapp.Model.Repository.CocktailRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface AppComponent {

    fun inject(app: App)

    fun inject(cocktailRepository: CocktailRepository)

    fun inject(homeViewModel: HomeViewModel)
    fun inject(infoViewModel: InfoViewModel)
    fun inject(searchViewModel: SearchViewModel)

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
