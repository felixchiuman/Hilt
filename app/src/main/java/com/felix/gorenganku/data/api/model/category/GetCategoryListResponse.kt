package com.felix.gorenganku.data.api.model.category


import com.google.gson.annotations.SerializedName

data class GetCategoryListResponse(
    @SerializedName("browse-categories")
    val browseCategories: List<BrowseCategory>,
    @SerializedName("shopping-categories")
    val shoppingCategories: List<ShoppingCategory>
) {
    data class BrowseCategory(
        @SerializedName("promoted")
        val promoted: Boolean,
        @SerializedName("tracking-id")
        val trackingId: String,
        @SerializedName("display")
        val display: Display,
        @SerializedName("content")
        val content: Content?,
        @SerializedName("type")
        val type: String
    ) {
        data class Display(
            @SerializedName("displayName")
            val displayName: String,
            @SerializedName("iconImage")
            val iconImage: String,
            @SerializedName("categoryImage")
            val categoryImage: String,
            @SerializedName("tag")
            val tag: String?,
            @SerializedName("backgroundImage")
            val backgroundImage: String?,
            @SerializedName("categoryTopics")
            val categoryTopics: List<CategoryTopic>?
        ) {
            data class CategoryTopic(
                @SerializedName("promoted")
                val promoted: Boolean,
                @SerializedName("tracking-id")
                val trackingId: String,
                @SerializedName("display")
                val display: Display,
                @SerializedName("content")
                val content: Content?,
                @SerializedName("type")
                val type: String
            ) {
                data class Display(
                    @SerializedName("displayName")
                    val displayName: String,
                    @SerializedName("iconImage")
                    val iconImage: String,
                    @SerializedName("tag")
                    val tag: String,
                    @SerializedName("backgroundImage")
                    val backgroundImage: String?
                )

                class Content
            }
        }

        class Content
    }

    data class ShoppingCategory(
        @SerializedName("promoted")
        val promoted: Boolean,
        @SerializedName("tracking-id")
        val trackingId: String,
        @SerializedName("display")
        val display: Display,
        @SerializedName("content")
        val content: Content?,
        @SerializedName("type")
        val type: String
    ) {
        data class Display(
            @SerializedName("displayName")
            val displayName: String,
            @SerializedName("categoryImage")
            val categoryImage: String,
            @SerializedName("tag")
            val tag: String
        )

        class Content
    }
}