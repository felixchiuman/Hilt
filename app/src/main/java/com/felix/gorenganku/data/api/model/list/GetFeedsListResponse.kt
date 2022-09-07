package com.felix.gorenganku.data.api.model.list


import com.google.gson.annotations.SerializedName

data class GetFeedsListResponse(
    @SerializedName("feed")
    val feed: List<Feed>,
    @SerializedName("seo")
    val seo: Seo
) {
    data class Feed(
        @SerializedName("display")
        val display: Display,
        @SerializedName("type")
        val type: String,
        @SerializedName("promoted")
        val promoted: Boolean,
        @SerializedName("proRecipe")
        val proRecipe: Boolean,
        @SerializedName("recipeType")
        val recipeType: List<String>,
        @SerializedName("tracking-id")
        val trackingId: String,
        @SerializedName("seo")
        val seo: Seo,
        @SerializedName("content")
        val content: Content
    ) {
        data class Display(
            @SerializedName("displayName")
            val displayName: String,
            @SerializedName("images")
            val images: List<String>,
            @SerializedName("flag")
            val flag: String,
            @SerializedName("source")
            val source: Source,
            @SerializedName("profiles")
            val profiles: List<Profile>,
            @SerializedName("displayPrepStepsInline")
            val displayPrepStepsInline: Boolean,
            @SerializedName("collections")
            val collections: List<Any>
        ) {
            data class Source(
                @SerializedName("sourceRecipeUrl")
                val sourceRecipeUrl: String,
                @SerializedName("sourceFaviconUrl")
                val sourceFaviconUrl: Any?,
                @SerializedName("sourceHttpsOk")
                val sourceHttpsOk: Boolean,
                @SerializedName("sourceInFrame")
                val sourceInFrame: Boolean,
                @SerializedName("sourceDisplayName")
                val sourceDisplayName: String,
                @SerializedName("proSource")
                val proSource: Any?,
                @SerializedName("sourceSiteUrl")
                val sourceSiteUrl: String,
                @SerializedName("introVideo")
                val introVideo: IntroVideo,
                @SerializedName("eyebrowText")
                val eyebrowText: Any?,
                @SerializedName("sourcePageUrl")
                val sourcePageUrl: String,
                @SerializedName("marketingCopy")
                val marketingCopy: Any?,
                @SerializedName("sourceHttpOk")
                val sourceHttpOk: Boolean,
                @SerializedName("marketingImage")
                val marketingImage: Any?
            ) {
                data class IntroVideo(
                    @SerializedName("id")
                    val id: Any?,
                    @SerializedName("originalUrl")
                    val originalUrl: Any?,
                    @SerializedName("hlsUrl")
                    val hlsUrl: Any?,
                    @SerializedName("dashUrl")
                    val dashUrl: Any?,
                    @SerializedName("hasAudio")
                    val hasAudio: Any?,
                    @SerializedName("snapshot")
                    val snapshot: Snapshot
                ) {
                    data class Snapshot(
                        @SerializedName("original")
                        val original: Any?,
                        @SerializedName("resizable")
                        val resizable: Any?
                    )
                }
            }

            data class Profile(
                @SerializedName("profileName")
                val profileName: String,
                @SerializedName("displayName")
                val displayName: String,
                @SerializedName("siteUrl")
                val siteUrl: String,
                @SerializedName("pictureUrl")
                val pictureUrl: String,
                @SerializedName("pageUrl")
                val pageUrl: String,
                @SerializedName("description")
                val description: String,
                @SerializedName("type")
                val type: String,
                @SerializedName("profileUrl")
                val profileUrl: String
            )
        }

        data class Seo(
            @SerializedName("web")
            val web: Web,
            @SerializedName("spotlightSearch")
            val spotlightSearch: SpotlightSearch,
            @SerializedName("firebase")
            val firebase: Firebase
        ) {
            data class Web(
                @SerializedName("noindex")
                val noindex: Boolean,
                @SerializedName("canonical-term")
                val canonicalTerm: String,
                @SerializedName("meta-tags")
                val metaTags: MetaTags,
                @SerializedName("link-tags")
                val linkTags: List<LinkTag>,
                @SerializedName("image-url")
                val imageUrl: String
            ) {
                data class MetaTags(
                    @SerializedName("title")
                    val title: String,
                    @SerializedName("description")
                    val description: String
                )

                data class LinkTag(
                    @SerializedName("rel")
                    val rel: String,
                    @SerializedName("href")
                    val href: String,
                    @SerializedName("hreflang")
                    val hreflang: String?
                )
            }

            data class SpotlightSearch(
                @SerializedName("keywords")
                val keywords: List<String>,
                @SerializedName("noindex")
                val noindex: Boolean
            )

            data class Firebase(
                @SerializedName("webUrl")
                val webUrl: String,
                @SerializedName("appUrl")
                val appUrl: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("description")
                val description: String
            )
        }

        data class Content(
            @SerializedName("description")
            val description: Any?,
            @SerializedName("urbSubmitters")
            val urbSubmitters: List<Any>,
            @SerializedName("tags")
            val tags: Tags,
            @SerializedName("preparationSteps")
            val preparationSteps: List<String>,
            @SerializedName("moreContent")
            val moreContent: MoreContent,
            @SerializedName("tagsAds")
            val tagsAds: TagsAds,
            @SerializedName("details")
            val details: Details,
            @SerializedName("relatedContent")
            val relatedContent: RelatedContent,
            @SerializedName("ingredientLines")
            val ingredientLines: List<IngredientLine>,
            @SerializedName("unitSystem")
            val unitSystem: String,
            @SerializedName("reviews")
            val reviews: Reviews,
            @SerializedName("relatedProducts")
            val relatedProducts: RelatedProducts,
            @SerializedName("preparationStepCount")
            val preparationStepCount: Int,
            @SerializedName("nutrition")
            val nutrition: Nutrition,
            @SerializedName("yums")
            val yums: Yums
        ) {
            data class Tags(
                @SerializedName("course")
                val course: List<Course>,
                @SerializedName("difficulty")
                val difficulty: List<Difficulty>,
                @SerializedName("technique")
                val technique: List<Technique>
            ) {
                data class Course(
                    @SerializedName("display-name")
                    val displayName: String,
                    @SerializedName("tag-url")
                    val tagUrl: String
                )

                data class Difficulty(
                    @SerializedName("display-name")
                    val displayName: String,
                    @SerializedName("tag-url")
                    val tagUrl: String
                )

                data class Technique(
                    @SerializedName("display-name")
                    val displayName: String,
                    @SerializedName("tag-url")
                    val tagUrl: String
                )
            }

            data class MoreContent(
                @SerializedName("mobileSectionName")
                val mobileSectionName: String,
                @SerializedName("queryParams")
                val queryParams: QueryParams,
                @SerializedName("feed")
                val feed: List<Any>
            ) {
                data class QueryParams(
                    @SerializedName("start")
                    val start: Int,
                    @SerializedName("authorId")
                    val authorId: String,
                    @SerializedName("id")
                    val id: String,
                    @SerializedName("apiFeedType")
                    val apiFeedType: String
                )
            }

            data class TagsAds(
                @SerializedName("adtag")
                val adtag: List<Adtag>
            ) {
                data class Adtag(
                    @SerializedName("display-name")
                    val displayName: String,
                    @SerializedName("tag-url")
                    val tagUrl: String
                )
            }

            data class Details(
                @SerializedName("directionsUrl")
                val directionsUrl: String,
                @SerializedName("totalTime")
                val totalTime: String,
                @SerializedName("displayName")
                val displayName: String,
                @SerializedName("images")
                val images: List<Image>,
                @SerializedName("name")
                val name: String,
                @SerializedName("keywords")
                val keywords: List<String>,
                @SerializedName("brand")
                val brand: Any?,
                @SerializedName("id")
                val id: String,
                @SerializedName("attribution")
                val attribution: Attribution,
                @SerializedName("recipeId")
                val recipeId: String,
                @SerializedName("numberOfServings")
                val numberOfServings: Int,
                @SerializedName("globalId")
                val globalId: String,
                @SerializedName("totalTimeInSeconds")
                val totalTimeInSeconds: Int,
                @SerializedName("rating")
                val rating: Int
            ) {
                data class Image(
                    @SerializedName("hostedLargeUrl")
                    val hostedLargeUrl: String,
                    @SerializedName("resizableImageUrl")
                    val resizableImageUrl: String,
                    @SerializedName("resizableImageHeight")
                    val resizableImageHeight: Int,
                    @SerializedName("resizableImageWidth")
                    val resizableImageWidth: Int
                )

                data class Attribution(
                    @SerializedName("html")
                    val html: String,
                    @SerializedName("url")
                    val url: String,
                    @SerializedName("text")
                    val text: String,
                    @SerializedName("logo")
                    val logo: String
                )
            }

            data class RelatedContent(
                @SerializedName("mobileSectionName")
                val mobileSectionName: String,
                @SerializedName("queryParams")
                val queryParams: QueryParams,
                @SerializedName("feed")
                val feed: List<Any>
            ) {
                data class QueryParams(
                    @SerializedName("start")
                    val start: Int,
                    @SerializedName("apiFeedType")
                    val apiFeedType: String,
                    @SerializedName("id")
                    val id: String
                )
            }

            data class IngredientLine(
                @SerializedName("category")
                val category: String,
                @SerializedName("amount")
                val amount: Amount,
                @SerializedName("unit")
                val unit: String,
                @SerializedName("ingredientId")
                val ingredientId: String,
                @SerializedName("categoryId")
                val categoryId: String,
                @SerializedName("relatedRecipeSearchTerm")
                val relatedRecipeSearchTerm: List<RelatedRecipeSearchTerm>,
                @SerializedName("ingredient")
                val ingredient: String,
                @SerializedName("id")
                val id: String,
                @SerializedName("remainder")
                val remainder: String,
                @SerializedName("quantity")
                val quantity: Int,
                @SerializedName("wholeLine")
                val wholeLine: String
            ) {
                data class Amount(
                    @SerializedName("metric")
                    val metric: Metric,
                    @SerializedName("imperial")
                    val imperial: Imperial
                ) {
                    data class Metric(
                        @SerializedName("unit")
                        val unit: Unit,
                        @SerializedName("quantity")
                        val quantity: Int
                    ) {
                        data class Unit(
                            @SerializedName("id")
                            val id: String,
                            @SerializedName("name")
                            val name: String,
                            @SerializedName("abbreviation")
                            val abbreviation: String,
                            @SerializedName("plural")
                            val plural: String,
                            @SerializedName("pluralAbbreviation")
                            val pluralAbbreviation: String,
                            @SerializedName("kind")
                            val kind: String,
                            @SerializedName("decimal")
                            val decimal: Boolean
                        )
                    }

                    data class Imperial(
                        @SerializedName("unit")
                        val unit: Unit,
                        @SerializedName("quantity")
                        val quantity: Int
                    ) {
                        data class Unit(
                            @SerializedName("id")
                            val id: String,
                            @SerializedName("name")
                            val name: String,
                            @SerializedName("abbreviation")
                            val abbreviation: String,
                            @SerializedName("plural")
                            val plural: String,
                            @SerializedName("pluralAbbreviation")
                            val pluralAbbreviation: String,
                            @SerializedName("kind")
                            val kind: String,
                            @SerializedName("decimal")
                            val decimal: Boolean
                        )
                    }
                }

                data class RelatedRecipeSearchTerm(
                    @SerializedName("allowedIngredient")
                    val allowedIngredient: String
                )
            }

            data class Reviews(
                @SerializedName("mobileSectionName")
                val mobileSectionName: String,
                @SerializedName("totalReviewCount")
                val totalReviewCount: Int,
                @SerializedName("averageRating")
                val averageRating: Double,
                @SerializedName("reviews")
                val reviews: List<Any>,
                @SerializedName("thisUserReview")
                val thisUserReview: Any?,
                @SerializedName("sortBy")
                val sortBy: String
            )

            data class RelatedProducts(
                @SerializedName("mobileSectionName")
                val mobileSectionName: String,
                @SerializedName("queryParams")
                val queryParams: QueryParams,
                @SerializedName("feed")
                val feed: List<Any>
            ) {
                data class QueryParams(
                    @SerializedName("start")
                    val start: Int,
                    @SerializedName("apiFeedType")
                    val apiFeedType: String,
                    @SerializedName("id")
                    val id: String,
                    @SerializedName("relatedContentType")
                    val relatedContentType: String
                )
            }

            data class Nutrition(
                @SerializedName("mobileSectionName")
                val mobileSectionName: String,
                @SerializedName("nutritionEstimates")
                val nutritionEstimates: List<NutritionEstimate>
            ) {
                data class NutritionEstimate(
                    @SerializedName("attribute")
                    val attribute: String,
                    @SerializedName("value")
                    val value: Double,
                    @SerializedName("unit")
                    val unit: Unit,
                    @SerializedName("display")
                    val display: Display
                ) {
                    data class Unit(
                        @SerializedName("name")
                        val name: String,
                        @SerializedName("abbreviation")
                        val abbreviation: String,
                        @SerializedName("plural")
                        val plural: String,
                        @SerializedName("decimal")
                        val decimal: Boolean
                    )

                    data class Display(
                        @SerializedName("value")
                        val value: Double?,
                        @SerializedName("unit")
                        val unit: String?,
                        @SerializedName("percentDailyValue")
                        val percentDailyValue: Int?
                    )
                }
            }

            data class Yums(
                @SerializedName("count")
                val count: Int,
                @SerializedName("this-user")
                val thisUser: String
            )
        }
    }

    data class Seo(
        @SerializedName("web")
        val web: Web,
        @SerializedName("spotlightSearch")
        val spotlightSearch: SpotlightSearch,
        @SerializedName("firebase")
        val firebase: Firebase
    ) {
        data class Web(
            @SerializedName("noindex")
            val noindex: Boolean
        )

        data class SpotlightSearch(
            @SerializedName("noindex")
            val noindex: Boolean
        )

        data class Firebase(
            @SerializedName("noindex")
            val noindex: Boolean
        )
    }
}