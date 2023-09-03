package be.valerianpt.evaland2_part2_correction

class Item(
    var name: String,
    var count: Int,
    var type: ItemType
)

enum class ItemType {
    food,
    drink,
    hygiene,
    home
}

var itemList: MutableList<Item> = mutableListOf()