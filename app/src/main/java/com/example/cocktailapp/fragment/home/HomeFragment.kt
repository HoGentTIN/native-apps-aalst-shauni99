package com.example.cocktailapp.fragment.home

import android.os.Bundle

import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.cocktailapp.R
import com.example.cocktailapp.adapter.CocktailAdapter
import com.example.cocktailapp.databinding.FragmentHomeBinding




class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding: FragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)


        activity?.setTitle("Home")

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this


        // Giving the binding access to the homeviewmodel
        binding.viewModel = viewModel


        // Sets the adapter of the photosGrid RecyclerView with clickHandler lambda that
        // tells the viewModel when our property is clicked
        binding.homeList.adapter = CocktailAdapter(CocktailAdapter.OnClickListener {
            viewModel.displayCocktailDetails(it)
        })


        // Observe the navigateToSelectedCocktailLiveData and Navigate when it isn't null
        // After navigating, call displayPropertyDetailsComplete() so that the ViewModel is ready
        // for another navigation event.
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
