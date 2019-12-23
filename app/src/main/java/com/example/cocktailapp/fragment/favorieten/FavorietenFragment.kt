package com.example.cocktailapp.fragment.favorieten

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailapp.R
import com.example.cocktailapp.adapter.CocktailAdapter
import com.example.cocktailapp.databinding.FragmentFavorietenBinding
import com.example.cocktailapp.fragment.home.HomeFragmentDirections

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

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.favsList.adapter = CocktailAdapter(CocktailAdapter.OnClickListener {
            viewModel.displayCocktailDetails(it)
        })

        viewModel.navigateToSelectedCocktail.observe(this, Observer {
            if (null != it) {
                // Must find the NavController from the Fragment
                this.findNavController().navigate(HomeFragmentDirections.showCocktailDetail(it))
                // Tell the ViewModel we've made the navigate call to prevent multiple navigation
                viewModel.displayCocktailDetailsComplete(it)
            }
        })

        return binding.root
    }
}
