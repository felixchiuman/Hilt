package com.felix.gorenganku.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.felix.gorenganku.R
import com.felix.gorenganku.databinding.ActivityDetailBinding
import com.felix.gorenganku.ui.base.BaseActivity
import com.google.android.material.chip.Chip

class DetailActivity : BaseActivity<ActivityDetailBinding>() {

    val bundle = intent.extras
    val image = bundle?.getString("image")
    val rating = bundle?.getString("rating")
    val title = bundle?.getString("title")
    val desc = bundle?.getString("description")
    val ingredient = bundle?.getStringArrayList("ingredients")

    override fun getViewBinding() = ActivityDetailBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("image", "onCreate: $image")
        Log.d("rating", "onCreate: $rating")
        Log.d("detail", "onCreate: $title")
        Log.d("description", "onCreate: $desc")
        Log.d("ingredient", "onCreate: $ingredient")

        binding.apply {
            if (image != null) {
                Glide.with(root).load(image)
                    .into(ivFood)
            } else if (image == null) {
                ivFood.setImageResource(R.drawable.ic_baseline_broken_image_24)
            }

            if (rating != null) {
                tvRating.text = rating
            } else if (rating == null) {
                tvRating.text = "-"
            }

            if (title != null) {
                tvTitle.text = title
            } else if (title == null) {
                tvTitle.text = "-"
            }

            if (desc != null) {
                tvSummary.text = desc
            } else if (desc == null) {
                tvSummary.text = "No Description"
            }

            ivBack.setOnClickListener {
                onBackPressed()
            }
        }
        entryChip()
    }

    private fun createMyChips(txt: String) {
        val chip = Chip(this)
        chip.apply {
            text = txt
            chipIcon = ContextCompat.getDrawable(
                this@DetailActivity,
                R.drawable.ic_launcher_background)
            isChipIconVisible = false
            isCloseIconVisible = true
            isClickable = true
            isCheckable = false
            binding.cgIngredients.addView(chip as View)
            setOnCloseIconClickListener {
                binding.cgIngredients.removeView(chip as View)
            }
        }
    }

    private fun entryChip() {
            if (ingredient != null) {
                for (i in ingredient.indices) {
                    createMyChips(ingredient[i])
                }
            }
        }
}