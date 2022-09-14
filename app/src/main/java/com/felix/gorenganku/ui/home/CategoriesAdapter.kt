package com.felix.gorenganku.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.felix.gorenganku.R
import com.felix.gorenganku.data.api.model.category.GetCategoryListResponse
import com.felix.gorenganku.databinding.CategoryContentBinding

class CategoriesAdapter() : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    var rowIndex = 0

    private val diffCallback = object : DiffUtil.ItemCallback<GetCategoryListResponse.BrowseCategory>() {
        override fun areItemsTheSame(
            oldItem: GetCategoryListResponse.BrowseCategory,
            newItem: GetCategoryListResponse.BrowseCategory):
                Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: GetCategoryListResponse.BrowseCategory,
            newItem: GetCategoryListResponse.BrowseCategory):
                Boolean = oldItem.hashCode() == newItem.hashCode()
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitData(value: List<GetCategoryListResponse.BrowseCategory>?) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(CategoryContentBinding.inflate(inflater, parent,false))
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.ViewHolder, position: Int) {
        val data = differ.currentList[position]
        data.let { holder.bind(data) }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(private val binding: CategoryContentBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(data: GetCategoryListResponse.BrowseCategory){
            binding.apply {
                Glide.with(binding.root).load(data.display.iconImage)
                    .into(binding.ivCategory)
                tvTitle.text = data.display.displayName
                categoryCard.setOnClickListener {
                    rowIndex = layoutPosition
                    notifyDataSetChanged()
                }

                if (rowIndex == layoutPosition) {
                    categoryCard.setBackgroundResource(R.drawable.selected_card)
                } else {
                    categoryCard.setBackgroundResource(R.drawable.unselected_card)
                }
            }
        }
    }
}