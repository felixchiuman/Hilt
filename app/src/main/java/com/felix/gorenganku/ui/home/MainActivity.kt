package com.felix.gorenganku.ui.home

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.felix.gorenganku.data.api.model.list.GetFeedsListResponse
import com.felix.gorenganku.databinding.ActivityMainBinding
import com.felix.gorenganku.resource.Status
import com.felix.gorenganku.ui.base.BaseActivity
import com.felix.gorenganku.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var progressDialog: ProgressDialog
    private lateinit var favoriteAdapter: FavoriteAdapter
    private lateinit var detailAdapter: DetailAdapter
    private lateinit var categoriesAdapter: CategoriesAdapter

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        favoriteAdapter = FavoriteAdapter(object : FavoriteAdapter.OnClickListener{
            override fun onClickItem(data: GetFeedsListResponse.Feed) {
                val image = data.display.images[0]
                val rating = data.content.details?.rating.toString()
                val title = data.display.displayName
                val description = data.display.description.toString()
                val ingredients = data.content.ingredientLines?.get(0)?.ingredient
                val ingredientsTwo = data.content.ingredientLines?.get(1)?.ingredient
                val ingredientsThree = data.content.ingredientLines?.get(2)?.ingredient
                val ingredientsFour = data.content.ingredientLines?.get(3)?.ingredient
                val ingredientsFive = data.content.ingredientLines?.get(4)?.ingredient
                val ingredientsSix = data.content.ingredientLines?.get(5)?.ingredient
                Log.d("TAG", "onClickItem: $ingredients")
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                val bundle = Bundle()

                bundle.putString("image", image)
                if (rating != "null") {
                    bundle.putString("rating", rating)
                }
                if (title != null) {
                    bundle.putString("title", title)
                }
                if (description != "null") {
                    bundle.putString("description", description)
                }

                bundle.putString("ingredients", ingredients)

                bundle.putString("ingredientsTwo", ingredientsTwo)

                bundle.putString("ingredientsThree", ingredientsThree)

                bundle.putString("ingredientsFour", ingredientsFour)

                bundle.putString("ingredientsFive", ingredientsFive)

                bundle.putString("ingredientsSix", ingredientsSix)

                intent.putExtras(bundle)
                startActivity(intent)
            }
        })

        detailAdapter = DetailAdapter(object : DetailAdapter.OnClickListener{
            override fun onClickItem(data: GetFeedsListResponse.Feed) {
                val image = data.display.images[0]
                val rating = data.content.details?.rating.toString()
                val title = data.display.displayName
                val description = data.display.description.toString()
                val ingredients = data.content.ingredientLines?.get(0)?.ingredient
                val ingredientsTwo = data.content.ingredientLines?.get(1)?.ingredient
                val ingredientsThree = data.content.ingredientLines?.get(2)?.ingredient
                val ingredientsFour = data.content.ingredientLines?.get(3)?.ingredient
                val ingredientsFive = data.content.ingredientLines?.get(4)?.ingredient
                val ingredientsSix = data.content.ingredientLines?.get(5)?.ingredient
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                val bundle = Bundle()

                bundle.putString("image", image)
                if (rating != "null") {
                    bundle.putString("rating", rating)
                }
                if (title != null) {
                    bundle.putString("title", title)
                }
                if (description != "null") {
                    bundle.putString("description", description)
                }

                bundle.putString("ingredients", ingredients)

                bundle.putString("ingredientsTwo", ingredientsTwo)

                bundle.putString("ingredientsThree", ingredientsThree)

                bundle.putString("ingredientsFour", ingredientsFour)

                bundle.putString("ingredientsFive", ingredientsFive)

                bundle.putString("ingredientsSix", ingredientsSix)

                intent.putExtras(bundle)
                startActivity(intent)
            }
        })

        categoriesAdapter = CategoriesAdapter()

        progressDialog = ProgressDialog(this)
        binding.rvFavorite.adapter = favoriteAdapter
        binding.rvShowDetail.adapter = detailAdapter
        binding.rvCategory.adapter = categoriesAdapter
        setupObservers()
        viewModel.getAllFavorite()
        viewModel.getAllDetail()
        viewModel.getAllCategory()
    }

    private fun setupObservers() {
        viewModel.dataFavorite.observe(this){resource ->
            when(resource.status){
                Status.SUCCESS -> {
                    Log.d("Status","Success")
                    binding.apply {
                        tvFavorite.visibility = View.VISIBLE
                        tvShowDetail.visibility = View.VISIBLE
                    }
                    progressDialog.dismiss()
                    favoriteAdapter.submitData(resource.data?.body()?.feed)
                }
                Status.LOADING -> {
                    Log.d("Status","Loading")
                    progressDialog.show()
                }
                Status.ERROR -> {
                    Log.d("Status","Error ${resource.message}")
                    Toast.makeText(this, "Error ${resource.message}", Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                }
            }
        }

        viewModel.dataDetail.observe(this){resource ->
            when(resource.status){
                Status.SUCCESS -> {
                    Log.d("Status","Success")
                    detailAdapter.submitData(resource.data?.body()?.feed)
                }
                Status.LOADING -> {
                    Log.d("Status","Loading")
                }
                Status.ERROR -> {
                    Log.d("Status","Error ${resource.message}")
                    Toast.makeText(this, "Error ${resource.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewModel.categories.observe(this){resource ->
            when(resource.status){
                Status.SUCCESS -> {
                    Log.d("Status","Success")
                    categoriesAdapter.submitData(resource.data?.body()?.browseCategories)
                }
                Status.LOADING -> {
                    Log.d("Status","Loading")
                }
                Status.ERROR -> {
                    Log.d("Status","Error ${resource.message}")
                    Toast.makeText(this, "Error ${resource.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}