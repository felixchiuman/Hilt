package com.felix.gorenganku.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.felix.gorenganku.data.api.model.list.GetFeedsListResponse
import com.felix.gorenganku.databinding.FavoriteContentBinding

class FavoriteAdapter (private val onItemClick: OnClickListener) : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<GetFeedsListResponse.Feed>() {
        override fun areItemsTheSame(
            oldItem: GetFeedsListResponse.Feed,
            newItem: GetFeedsListResponse.Feed):
                Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: GetFeedsListResponse.Feed,
            newItem: GetFeedsListResponse.Feed):
                Boolean = oldItem.hashCode() == newItem.hashCode()
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitData(value: List<GetFeedsListResponse.Feed>?) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(FavoriteContentBinding.inflate(inflater, parent,false))
    }

    override fun onBindViewHolder(holder: FavoriteAdapter.ViewHolder, position: Int) {
        val data = differ.currentList[position]
        data.let { holder.bind(data) }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(private val binding: FavoriteContentBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(data: GetFeedsListResponse.Feed){
            binding.apply {
                if (data.display.images.isNotEmpty()){
                    Glide.with(binding.root).load(data.display.images[0])
                        .into(binding.ivFood)
                }
                tvTitle.text = data.display.displayName
                ratingBar.rating = data.content.details?.rating?.toFloat() ?: 0f
                root.setOnClickListener {
                    onItemClick.onClickItem(data)
                }
            }
        }
    }

    interface OnClickListener{
        fun onClickItem(data: GetFeedsListResponse.Feed)
    }
}