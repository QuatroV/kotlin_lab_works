class City {
    enum class LocationType {
        PROSPECT,
        STREET,
        SQUARE
    }

    inner class Location(
        private val name: String,
        private val type: LocationType
    ) {
        override fun toString(): String {
            return "${type.name}: $name"
        }
    }

    fun createLocation(name: String, type: LocationType): Location {
        return Location(name, type)
    }
}

fun main() {
    val city = City()

    val prospect = city.createLocation("Проспект Мира", City.LocationType.PROSPECT)
    val street = city.createLocation("Тульская улица", City.LocationType.STREET)
    val square = city.createLocation("Площадь Ленина", City.LocationType.SQUARE)

    println(prospect)
    println(street)
    println(square)
}
