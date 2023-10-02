package com.technipixl.exo1.network.model

data class ComicDetailResponse(
    val data: ComicDetailDataContainer
)

data class ComicDetailDataContainer(
    val results: MutableList<ComicDetail>
)

data class ComicDetail(
    val title: String,
    val description: String,
    val thumbnail: ComicImage
)

data class ComicImage(
    val path: String,
    val extension: String
)
