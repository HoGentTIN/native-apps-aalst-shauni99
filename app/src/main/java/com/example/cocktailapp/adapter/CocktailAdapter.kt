package com.example.cocktailapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailapp.databinding.CocktailGridItemBinding
import com.example.cocktailapp.model.Cocktail

class CocktailAdapter(val onClickListener: OnClickListener) :
    ListAdapter<Cocktail, CocktailAdapter.CocktailViewHolder>(DiffCallBack) {

    class CocktailViewHolder(private var binding: CocktailGridItemBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(cocktail: Cocktail) {
            binding.cocktail = cocktail
            binding.executePendingBindings()
        }
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Cocktail>() {
        override fun areItemsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean {
            return oldItem.idDrink == newItem.idDrink
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        return CocktailViewHolder(CocktailGridItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        val cocktail: Cocktail = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(cocktail)
        }
        holder.bind(cocktail)
    }

    class OnClickListener(val clickListener: (cocktail: Cocktail) -> Unit) {

        fun onClick(cocktail: Cocktail) = clickListener(cocktail)
    }
}
