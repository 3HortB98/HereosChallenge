package com.example.superheroeschallenge.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroeschallenge.Heroes
import com.example.superheroeschallenge.R

class HeroAdapter :RecyclerView.Adapter<HeroAdapter.HeroViewHolder>(){
    private val heroData = ArrayList<Heroes>()

    fun setData(heroes : List<Heroes>){
        heroData.clear()
        heroData.addAll(heroes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroAdapter.HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_item,parent,false)
        return HeroViewHolder(view)
    }

    override fun getItemCount() = heroData.size

    override fun onBindViewHolder(heroViewHolder: HeroViewHolder, position: Int) {
        heroViewHolder.heroName.text = heroData[position].Name
        heroViewHolder.heroScore.text = heroData[position].Score.toString()

    }

    class HeroViewHolder(view: View): RecyclerView.ViewHolder(view){
        val heroName: TextView = view.findViewById(R.id.hero_name)
        val heroScore: TextView = view.findViewById(R.id.score)
        val heroPic: ImageView = view.findViewById(R.id.heroImage)
    }
}

