package com.mycode.walmartcode.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.walmart_challenge_qv.model.CountriesDetails
import com.mycode.walmartcode.databinding.CountriesItemBinding

class CountryListAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private var countriesList: MutableList<CountriesDetails> = mutableListOf()

    fun setCountries(countries: List<CountriesDetails>) {
        this.countriesList = countries.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = CountriesItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val countries = countriesList[position]
        holder.binding.countryName.text = String.format(countries.name)
        holder.binding.countryRegion.text = countries.region
        holder.binding.countryCode.text = countries.code
        holder.binding.countryCapital.text =countries.capital
    }

    override fun getItemCount(): Int {
        return countriesList.size
    }
}
class MainViewHolder(val binding: CountriesItemBinding) : RecyclerView.ViewHolder(binding.root) {

}