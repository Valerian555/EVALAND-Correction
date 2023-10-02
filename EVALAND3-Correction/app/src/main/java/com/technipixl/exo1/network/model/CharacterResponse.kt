package com.technipixl.exo1.network.model

data class CharacterResponse (
    val data: CharacterDataContainer
)

data class CharacterDataContainer (
    val results: MutableList<Character>
)

data class Character(
    val id: Long,
    val name: String,
    val thumbnail: Image,
    val comics: ComicList
)

data class Image(
    val path: String,
    val extension: String
)

data class ComicList(
    val items: MutableList<Comic>
)

data class Comic(
    val resourceURI: String?,
    val name: String?
)

