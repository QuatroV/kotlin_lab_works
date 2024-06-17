fun charToAlphabetPosition(c: Char): Int? {
    val alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
    return alphabet.indexOf(c.lowercaseChar()).takeIf { it >= 0 }?.plus(1)
}

fun replaceLettersWithPosition(text: String): String {
    val regex = Regex("[а-яА-ЯёЁ]")
    val positions = StringBuilder()

    for (char in text) {
        if (regex.matches(char.toString())) {
            val pos = charToAlphabetPosition(char)
            if (pos != null) {
                positions.append(pos).append("  ")
            } else {
                positions.append("   ")
            }
        } else {
            positions.append("   ")
        }
    }
    return positions.toString().trim()
}

fun main() {
    val text = "Пример текста на русском языке."

    val positions = replaceLettersWithPosition(text)

    println(text)

    println(positions)
}
