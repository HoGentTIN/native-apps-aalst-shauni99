package com.example.cocktailapp.fragment.favorieten

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailapp.R
import com.example.cocktailapp.database.CocktailDatabase
import com.example.cocktailapp.database.CocktailDatabaseDao
import com.example.cocktailapp.databinding.FragmentFavorietenBinding
import com.example.cocktailapp.fragment.home.HomeViewModel
import com.revosleap.simpleadapter.SimpleAdapter
import com.revosleap.simpleadapter.SimpleCallbacks
import com.example.cocktailapp.model.Favorite
import kotlinx.android.synthetic.main.cocktail_list_item.view.cocktail_foto
import kotlinx.android.synthetic.main.cocktail_list_item.view.cocktail_name

/**
 * A simple [Fragment] subclass.
 */
class FavorietenFragment : Fragment() {
    private val viewModel: FavorietenViewModel by lazy {
        ViewModelProviders.of(this).get(FavorietenViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentFavorietenBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_favorieten, container, false
        )








        return binding.root
    }
}



