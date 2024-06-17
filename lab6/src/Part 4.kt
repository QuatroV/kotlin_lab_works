class ParkingLot(private val capacity: Int) {
    private val slots: MutableList<Boolean> = MutableList(capacity) { false }

    fun arrive(): Boolean {
        for (i in 0..<capacity) {
            if (!slots[i]) {
                slots[i] = true
                println("Машина припарковалась на месте $i")
                return true
            }
        }
        println("Нет свободных мест для парковки")
        return false
    }

    fun depart(position: Int): Boolean {
        if (position !in 0..<capacity) {
            println("Неверная позиция: $position")
            return false
        }
        if (slots[position]) {
            slots[position] = false
            println("Машина покинула место $position")
            return true
        }
        println("Место $position уже свободно")
        return false
    }

    fun printStatus() {
        println("Состояние автостоянки: ${slots.joinToString(" ") { if (it) "X" else "_" }}")
    }
}

fun main() {
    val parkingLot = ParkingLot(10)

    parkingLot.printStatus()

    parkingLot.arrive()
    parkingLot.printStatus()

    parkingLot.arrive()
    parkingLot.printStatus()

    parkingLot.depart(0)
    parkingLot.printStatus()

    parkingLot.depart(0)
    parkingLot.printStatus()

    parkingLot.arrive()
    parkingLot.printStatus()

    parkingLot.arrive()
    parkingLot.printStatus()

    parkingLot.arrive()
    parkingLot.printStatus()
}
