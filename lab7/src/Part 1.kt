/*
    \\b — начало слова.
    \\w{${k-1}} — первые k-1 букв в слове.
    (\\w) — k-я буква в слове.
 */
fun replaceKthLetter(text: String, k: Int, replacement: Char): String {
    val regex = Regex("\\b\\w{${k-1}}(\\w)")
    return regex.replace(text) { matchResult ->
        val word = matchResult.value
        if (word.length >= k) {
            word.substring(0, k - 1) + replacement + word.substring(k)
        } else {
            word
        }
    }
}

fun main() {
    val text = "Each word in this text will be processed."
    val k = 3
    val replacement = '*'

    val result = replaceKthLetter(text, k, replacement)
    println(result)
}
