abstract class Book(
    val code: String,
    val author: String,
    val title: String,
    val year: Int,
    val publisher: String
) {
    abstract fun getInfo(): String
}

class Directory(
    code: String,
    author: String,
    title: String,
    year: Int,
    publisher: String,
    private val category: String
) : Book(code, author, title, year, publisher) {
    override fun getInfo(): String {
        return "Справочник: $title, Автор: $author ($year), Издатель: $publisher, Категория: $category"
    }
}

class Encyclopedia(
    code: String,
    author: String,
    title: String,
    year: Int,
    publisher: String,
    private val volume: Int
) : Book(code, author, title, year, publisher) {
    override fun getInfo(): String {
        return "Энциклопедия: $title, Автор: $author ($year), Издатель: $publisher, Том: $volume"
    }
}

fun main() {
    val directory = Directory("D001", "Автор 1", "Название 1", 2020, "Издатель 1", "Категория 1")
    val encyclopedia = Encyclopedia("E001", "Автор 2", "Название 2", 2018, "Издатель 2", 3)

    println(directory.getInfo())
    println(encyclopedia.getInfo())
}
