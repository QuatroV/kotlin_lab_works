data class People(val name: String, val age: Int)

fun main() {
    val peoples = listOf(
        People("Ivan", 16),
        People("Petr", 23),
        People("Maria", 42)
    )

    val sortedPeoples = peoples.sortedByDescending { it.name }

    println("Отсортированная коллекция по имени в обратном алфавитном порядке:")
    for (person in sortedPeoples) {
        println("${person.name}, ${person.age}")
    }
}
