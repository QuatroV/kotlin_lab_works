fun findReversedWordPairs(text: String): List<Pair<String, String>> {
    val regex = Regex("\\b\\w+\\b")
    val words = regex.findAll(text).map { it.value }.toList()
    val reversedPairs = mutableListOf<Pair<String, String>>()

    for (i in words.indices) {
        for (j in i + 1..<words.size) {
            if (words[i].reversed() == words[j]) {
                reversedPairs.add(Pair(words[i], words[j]))
            } else if (words[j].reversed() == words[i]) {
                reversedPairs.add(Pair(words[j], words[i]))
            }
        }
    }

    return reversedPairs
}

fun main() {
    val text = "sdfs test drow tset fdsv fdgg asads word"

    val pairs = findReversedWordPairs(text)
    if (pairs.isNotEmpty()) {
        println("Пары слов, одно из которых является обращением другого:")
        pairs.forEach { (word1, word2) -> println("$word1 - $word2") }
    } else {
        println("В тексте не найдены пары слов, одно из которых является обращением другого.")
    }
}
