fun countWordOccurrences(text: String): Map<String, Int> {
    // Используем регулярное выражение для нахождения всех слов
    val regex = Regex("[а-яА-Я]+")
    val words = regex.findAll(text).map { it.value.lowercase() }.toList()

    // Считаем количество повторений каждого слова
    val wordCount = mutableMapOf<String, Int>()
    for (word in words) {
        wordCount[word] = wordCount.getOrDefault(word, 0) + 1
    }

    return wordCount
}

fun main() {
    val text = "Этот текст содержит некоторые слова, такие как мадам и мадам, а также слова, которые не являются палиндромами, например слово и овлос."

    val wordOccurrences = countWordOccurrences(text)
    if (wordOccurrences.isNotEmpty()) {
        println("Количество повторений каждого слова в тексте:")
        wordOccurrences.forEach { (word, count) -> println("$word: $count") }
    } else {
        println("В тексте не найдены слова.")
    }
}
