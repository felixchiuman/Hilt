package com.felix.gorenganku.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.felix.gorenganku.R
import com.felix.gorenganku.databinding.ActivityDetailBinding
import com.felix.gorenganku.ui.base.BaseActivity
import com.google.android.material.chip.Chip

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    override fun getViewBinding() = ActivityDetailBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = intent.extras
        val image = bundle?.getString("image")
        val rating = bundle?.getString("rating")
        val title = bundle?.getString("title")
        val desc = bundle?.getString("description")
        val ingredient = bundle?.getString("ingredients")
        val ingredientTwo = bundle?.getString("ingredientsTwo")
        val ingredientThree = bundle?.getString("ingredientsThree")
        val ingredientFour = bundle?.getString("ingredientsFour")
        val ingredientFive = bundle?.getString("ingredientsFive")
        val ingredientSix = bundle?.getString("ingredientsSix")

        Log.d("image", "onCreate: $image")
        Log.d("rating", "onCreate: $rating")
        Log.d("detail", "onCreate: $title")
        Log.d("description", "onCreate: $desc")
        Log.d("ingredient", "onCreate: $ingredient")

        binding.apply {
            if (image != null){
                Glide.with(root).load(image)
                    .into(ivFood)
            }else if (image == null){
                ivFood.setImageResource(R.drawable.ic_baseline_broken_image_24)
            }

            if (rating != null){
                tvRating.text = rating
            }else if (rating == null){
                tvRating.text = "-"
            }

            if (title != null) {
                tvTitle.text = title
            }else if (title == null){
                tvTitle.text = "-"
            }

            if (desc != null) {
                tvSummary.text = desc
            }else if (desc == null){
                tvSummary.text = "No Description"
            }

            if (ingredient != null){
                chip1.text = ingredient
                chip1.visibility = Chip.VISIBLE
            }

            if (ingredientTwo != null){
                chip2.text = ingredientTwo
                chip2.visibility = Chip.VISIBLE
            }

            if (ingredientThree != null){
                chip3.text = ingredientThree
                chip3.visibility = Chip.VISIBLE
            }

            if (ingredientFour != null){
                chip4.text = ingredientFour
                chip4.visibility = Chip.VISIBLE
            }

            if (ingredientFive != null){
                chip5.text = ingredientFive
                chip5.visibility = Chip.VISIBLE
            }

            if (ingredientSix != null){
                chip6.text = ingredientSix
                chip6.visibility = Chip.VISIBLE
            }

            ivBack.setOnClickListener {
                onBackPressed()
            }
        }
    }
}