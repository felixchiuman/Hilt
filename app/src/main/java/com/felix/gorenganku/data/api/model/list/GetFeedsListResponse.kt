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
        val proRecipe: Boolean?,
        @SerializedName("recipeType")
        val recipeType: List<String>?,
        @SerializedName("tracking-id")
        val trackingId: String,
        @SerializedName("seo")
        val seo: Seo?,
        @SerializedName("content")
        val content: Content
    ) {
        data class Display(
            @SerializedName("displayName")
            val displayName: String?,
            @SerializedName("images")
            val images: List<String>,
            @SerializedName("flag")
            val flag: String,
            @SerializedName("source")
            val source: Source?,
            @SerializedName("profiles")
            val profiles: List<Profile>?,
            @SerializedName("displayPrepStepsInline")
            val displayPrepStepsInline: Boolean?,
            @SerializedName("collections")
            val collections: List<Any>?,
            @SerializedName("title")
            val title: String?,
            @SerializedName("description")
            val description: Any?,
            @SerializedName("callToActionText")
            val callToActionText: Any?,
            @SerializedName("cardType")
            val cardType: String?,
            @SerializedName("textLocation")
            val textLocation: String?,
            @SerializedName("displayName_h2")
            val displayNameH2: String?
        ) {
            data class Source(
                @SerializedName("sourceRecipeUrl")
                val sourceRecipeUrl: String,
                @SerializedName("sourceFaviconUrl")
                val sourceFaviconUrl: String?,
                @SerializedName("sourceHttpsOk")
                val sourceHttpsOk: Boolean,
                @SerializedName("sourceInFrame")
                val sourceInFrame: Boolean,
                @SerializedName("sourceDisplayName")
                val sourceDisplayName: String,
                @SerializedName("proSource")
                val proSource: Boolean?,
                @SerializedName("sourceSiteUrl")
                val sourceSiteUrl: String,
                @SerializedName("introVideo")
                val introVideo: IntroVideo,
                @SerializedName("eyebrowText")
                val eyebrowText: String?,
                @SerializedName("sourcePageUrl")
                val sourcePageUrl: String,
                @SerializedName("marketingCopy")
                val marketingCopy: String?,
                @SerializedName("sourceHttpOk")
                val sourceHttpOk: Boolean,
                @SerializedName("marketingImage")
                val marketingImage: String?
            ) {
                data class IntroVideo(
                    @SerializedName("id")
                    val id: String?,
                    @SerializedName("originalUrl")
                    val originalUrl: String?,
                    @SerializedName("hlsUrl")
                    val hlsUrl: String?,
                    @SerializedName("dashUrl")
                    val dashUrl: String?,
                    @SerializedName("hasAudio")
                    val hasAudio: Boolean?,
                    @SerializedName("snapshot")
                    val snapshot: Snapshot
                ) {
                    data class Snapshot(
                        @SerializedName("original")
                        val original: String?,
                        @SerializedName("resizable")
                        val resizable: String?
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
                val description: String?,
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
                val webUrl: String?,
                @SerializedName("appUrl")
                val appUrl: String?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("description")
                val description: String?,
                @SerializedName("noindex")
                val noindex: Boolean?
            )
        }

        data class Content(
            @SerializedName("description")
            val description: Description?,
            @SerializedName("urbSubmitters")
            val urbSubmitters: List<Any>?,
            @SerializedName("tags")
            val tags: Tags?,
            @SerializedName("preparationSteps")
            val preparationSteps: List<String>?,
            @SerializedName("moreContent")
            val moreContent: MoreContent?,
            @SerializedName("tagsAds")
            val tagsAds: TagsAds?,
            @SerializedName("details")
            val details: Details?,
            @SerializedName("relatedContent")
            val relatedContent: RelatedContent?,
            @SerializedName("ingredientLines")
            val ingredientLines: List<IngredientLine>?,
            @SerializedName("unitSystem")
            val unitSystem: String?,
            @SerializedName("reviews")
            val reviews: Reviews?,
            @SerializedName("relatedProducts")
            val relatedProducts: RelatedProducts?,
            @SerializedName("preparationStepCount")
            val preparationStepCount: Int?,
            @SerializedName("nutrition")
            val nutrition: Nutrition?,
            @SerializedName("yums")
            val yums: Yums?,
            @SerializedName("ctaUrl")
            val ctaUrl: String?,
            @SerializedName("platformName")
            val platformName: String?,
            @SerializedName("videos")
            val videos: Videos?,
            @SerializedName("search")
            val search: Search?,
            @SerializedName("total")
            val total: Int?,
            @SerializedName("matches")
            val matches: Matches?,
            @SerializedName("start")
            val start: Int?,
            @SerializedName("end")
            val end: Int?
        ) {
            data class Description(
                @SerializedName("mobileSectionName")
                val mobileSectionName: String,
                @SerializedName("text")
                val text: String?,
                @SerializedName("shortText")
                val shortText: String?
            )

            data class Tags(
                @SerializedName("course")
                val course: List<Course>?,
                @SerializedName("difficulty")
                val difficulty: List<Difficulty>?,
                @SerializedName("technique")
                val technique: List<Technique>?,
                @SerializedName("nutrition")
                val nutrition: List<Nutrition>?,
                @SerializedName("cuisine")
                val cuisine: List<Cuisine>?,
                @SerializedName("dish")
                val dish: List<Dish>?,
                @SerializedName("pro")
                val pro: List<Pro>?
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

                data class Nutrition(
                    @SerializedName("display-name")
                    val displayName: String,
                    @SerializedName("tag-url")
                    val tagUrl: String
                )

                data class Cuisine(
                    @SerializedName("display-name")
                    val displayName: String,
                    @SerializedName("tag-url")
                    val tagUrl: String
                )

                data class Dish(
                    @SerializedName("display-name")
                    val displayName: String,
                    @SerializedName("tag-url")
                    val tagUrl: String
                )

                data class Pro(
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
                val adtag: List<Adtag>?
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
                val directionsUrl: String?,
                @SerializedName("totalTime")
                val totalTime: String?,
                @SerializedName("displayName")
                val displayName: String?,
                @SerializedName("images")
                val images: List<Image>?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("keywords")
                val keywords: List<String>?,
                @SerializedName("brand")
                val brand: Any?,
                @SerializedName("id")
                val id: String,
                @SerializedName("attribution")
                val attribution: Attribution?,
                @SerializedName("recipeId")
                val recipeId: String?,
                @SerializedName("numberOfServings")
                val numberOfServings: Int?,
                @SerializedName("globalId")
                val globalId: String?,
                @SerializedName("totalTimeInSeconds")
                val totalTimeInSeconds: Int?,
                @SerializedName("rating")
                val rating: Double?
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
                val category: String?,
                @SerializedName("amount")
                val amount: Amount,
                @SerializedName("unit")
                val unit: String,
                @SerializedName("ingredientId")
                val ingredientId: String,
                @SerializedName("categoryId")
                val categoryId: String?,
                @SerializedName("relatedRecipeSearchTerm")
                val relatedRecipeSearchTerm: List<RelatedRecipeSearchTerm>,
                @SerializedName("ingredient")
                val ingredient: String,
                @SerializedName("id")
                val id: String,
                @SerializedName("remainder")
                val remainder: String,
                @SerializedName("quantity")
                val quantity: Double?,
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
                        val quantity: Double?
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
                        val quantity: Double?
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
                val averageRating: Double?,
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
                        val value: Any?,
                        @SerializedName("unit")
                        val unit: String?,
                        @SerializedName("percentDailyValue")
                        val percentDailyValue: Double?
                    )
                }
            }

            data class Yums(
                @SerializedName("count")
                val count: Int,
                @SerializedName("this-user")
                val thisUser: String
            )

            data class Videos(
                @SerializedName("snapshotUrl")
                val snapshotUrl: String,
                @SerializedName("videoUrls")
                val videoUrls: VideoUrls?,
                @SerializedName("videoDetails")
                val videoDetails: VideoDetails,
                @SerializedName("originalVideoUrl")
                val originalVideoUrl: String,
                @SerializedName("createTime")
                val createTime: String
            ) {
                class VideoUrls

                data class VideoDetails(
                    @SerializedName("ios")
                    val ios: List<Io>,
                    @SerializedName("android")
                    val android: List<Android>
                ) {
                    data class Io(
                        @SerializedName("videoTypeCode")
                        val videoTypeCode: String,
                        @SerializedName("videoUrl")
                        val videoUrl: String,
                        @SerializedName("hasAudio")
                        val hasAudio: Boolean
                    )

                    data class Android(
                        @SerializedName("videoTypeCode")
                        val videoTypeCode: String,
                        @SerializedName("videoUrl")
                        val videoUrl: String,
                        @SerializedName("hasAudio")
                        val hasAudio: Boolean
                    )
                }
            }

            data class Search(
                @SerializedName("q")
                val q: String
            )

            data class Matches(
                @SerializedName("seo")
                val seo: Seo,
                @SerializedName("feed")
                val feed: List<Feed>,
                @SerializedName("parsedIngredients")
                val parsedIngredients: List<ParsedIngredient>,
                @SerializedName("indexableMatches")
                val indexableMatches: Any?,
                @SerializedName("relatedPhrases")
                val relatedPhrases: RelatedPhrases,
                @SerializedName("adTrackingCampaign")
                val adTrackingCampaign: Int,
                @SerializedName("criteria")
                val criteria: Criteria,
                @SerializedName("ingredientMatchCount")
                val ingredientMatchCount: IngredientMatchCount?,
                @SerializedName("totalMatchCount")
                val totalMatchCount: Int,
                @SerializedName("noindex")
                val noindex: Boolean,
                @SerializedName("adTargetingPhrase")
                val adTargetingPhrase: Any?,
                @SerializedName("unrelatedSearchResults")
                val unrelatedSearchResults: List<Any>,
                @SerializedName("relatedSearchResults")
                val relatedSearchResults: Any?
            ) {
                data class Seo(
                    @SerializedName("web")
                    val web: Web,
                    @SerializedName("firebase")
                    val firebase: Firebase
                ) {
                    data class Web(
                        @SerializedName("noindex")
                        val noindex: Boolean,
                        @SerializedName("display-title")
                        val displayTitle: String,
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
                            @SerializedName("hreflang")
                            val hreflang: String,
                            @SerializedName("href")
                            val href: String
                        )
                    }

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

                data class Feed(
                    @SerializedName("seo")
                    val seo: Seo,
                    @SerializedName("tracking-id")
                    val trackingId: String,
                    @SerializedName("content")
                    val content: Content,
                    @SerializedName("type")
                    val type: String,
                    @SerializedName("recipeType")
                    val recipeType: List<String>,
                    @SerializedName("proRecipe")
                    val proRecipe: Boolean,
                    @SerializedName("display")
                    val display: Display,
                    @SerializedName("promoted")
                    val promoted: Boolean,
                    @SerializedName("searchResult")
                    val searchResult: SearchResult
                ) {
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
                            @SerializedName("noindex")
                            val noindex: Boolean
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
                        val preparationSteps: Any?,
                        @SerializedName("moreContent")
                        val moreContent: MoreContent,
                        @SerializedName("tagsAds")
                        val tagsAds: TagsAds?,
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
                            @SerializedName("difficulty")
                            val difficulty: List<Difficulty>,
                            @SerializedName("dish")
                            val dish: List<Dish>,
                            @SerializedName("nutrition")
                            val nutrition: List<Nutrition>?,
                            @SerializedName("course")
                            val course: List<Course>?
                        ) {
                            data class Difficulty(
                                @SerializedName("display-name")
                                val displayName: String,
                                @SerializedName("tag-url")
                                val tagUrl: String
                            )

                            data class Dish(
                                @SerializedName("display-name")
                                val displayName: String,
                                @SerializedName("tag-url")
                                val tagUrl: String
                            )

                            data class Nutrition(
                                @SerializedName("display-name")
                                val displayName: String,
                                @SerializedName("tag-url")
                                val tagUrl: String
                            )

                            data class Course(
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
                            val adtag: List<Adtag>?
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
                            val rating: Double
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
                            val remainder: String?,
                            @SerializedName("quantity")
                            val quantity: Double?,
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
                                    val quantity: Double?
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
                                    val quantity: Double?
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
                            val averageRating: Double?,
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
                                    val value: Any?,
                                    @SerializedName("unit")
                                    val unit: String?,
                                    @SerializedName("percentDailyValue")
                                    val percentDailyValue: Double?
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

                    data class Display(
                        @SerializedName("displayName")
                        val displayName: String,
                        @SerializedName("images")
                        val images: List<String>,
                        @SerializedName("flag")
                        val flag: Any?,
                        @SerializedName("source")
                        val source: Source,
                        @SerializedName("profiles")
                        val profiles: List<Profile>,
                        @SerializedName("displayPrepStepsInline")
                        val displayPrepStepsInline: Any?,
                        @SerializedName("collections")
                        val collections: List<Any>
                    ) {
                        data class Source(
                            @SerializedName("sourceRecipeUrl")
                            val sourceRecipeUrl: String,
                            @SerializedName("sourceFaviconUrl")
                            val sourceFaviconUrl: String?,
                            @SerializedName("sourceHttpsOk")
                            val sourceHttpsOk: Boolean,
                            @SerializedName("sourceInFrame")
                            val sourceInFrame: Boolean,
                            @SerializedName("sourceDisplayName")
                            val sourceDisplayName: String,
                            @SerializedName("proSource")
                            val proSource: Boolean?,
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
                            val description: String?,
                            @SerializedName("type")
                            val type: String,
                            @SerializedName("profileUrl")
                            val profileUrl: String
                        )
                    }

                    data class SearchResult(
                        @SerializedName("score")
                        val score: Double
                    )
                }

                data class ParsedIngredient(
                    @SerializedName("name")
                    val name: String,
                    @SerializedName("image-url")
                    val imageUrl: String,
                    @SerializedName("id")
                    val id: String
                )

                data class RelatedPhrases(
                    @SerializedName("relatedPhrases")
                    val relatedPhrases: List<String>,
                    @SerializedName("unrelatedPhrases")
                    val unrelatedPhrases: List<String>,
                    @SerializedName("keywords")
                    val keywords: List<String>,
                    @SerializedName("recipes")
                    val recipes: List<String>,
                    @SerializedName("phrase")
                    val phrase: String
                )

                data class Criteria(
                    @SerializedName("q")
                    val q: String,
                    @SerializedName("boost-locales")
                    val boostLocales: List<String>,
                    @SerializedName("flavor")
                    val flavor: Flavor?,
                    @SerializedName("full-reviews?")
                    val fullReviews: Boolean,
                    @SerializedName("locale")
                    val locale: String,
                    @SerializedName("time")
                    val time: Any?,
                    @SerializedName("connected")
                    val connected: Boolean,
                    @SerializedName("fetch-recipes?")
                    val fetchRecipes: Boolean,
                    @SerializedName("ignore-taste-pref?")
                    val ignoreTastePref: Boolean,
                    @SerializedName("myyums")
                    val myyums: Boolean,
                    @SerializedName("expand-related-searches?")
                    val expandRelatedSearches: Boolean,
                    @SerializedName("timeout-millis")
                    val timeoutMillis: Int,
                    @SerializedName("facet-fields")
                    val facetFields: Any?,
                    @SerializedName("require-pictures?")
                    val requirePictures: Boolean,
                    @SerializedName("passthrough")
                    val passthrough: Passthrough?,
                    @SerializedName("reviews-per-recipe")
                    val reviewsPerRecipe: Int,
                    @SerializedName("ingredients")
                    val ingredients: Ingredients?,
                    @SerializedName("max")
                    val max: Int,
                    @SerializedName("ingredient-count")
                    val ingredientCount: Any?,
                    @SerializedName("image-size")
                    val imageSize: Any?,
                    @SerializedName("recipe_unsearchable")
                    val recipeUnsearchable: Boolean,
                    @SerializedName("guided")
                    val guided: Boolean,
                    @SerializedName("autocomplete")
                    val autocomplete: Boolean,
                    @SerializedName("timeout")
                    val timeout: Int,
                    @SerializedName("nutrition")
                    val nutrition: Nutrition?,
                    @SerializedName("recognition-enabled")
                    val recognitionEnabled: Boolean,
                    @SerializedName("skip")
                    val skip: Any?,
                    @SerializedName("review-images-per-recipe")
                    val reviewImagesPerRecipe: Any?
                ) {
                    class Flavor

                    class Passthrough

                    class Ingredients

                    class Nutrition
                }

                class IngredientMatchCount
            }
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