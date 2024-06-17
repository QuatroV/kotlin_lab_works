class CD {
    inner class Track(
        private val title: String,
        private val artist: String,
        private val duration: Int
    ) {
        override fun toString(): String {
            return "$title - $artist ($duration секунд)"
        }
    }

    fun createTrack(title: String, artist: String, duration: Int): Track {
        return Track(title, artist, duration)
    }
}

fun main() {
    val cd = CD()

    val track1 = cd.createTrack("Песня 1", "Исполнитель 1", 180)
    val track2 = cd.createTrack("Песня 2", "Исполнитель 2", 240)
    val track3 = cd.createTrack("Песня 3", "Исполнитель 3", 200)

    println(track1)
    println(track2)
    println(track3)
}
