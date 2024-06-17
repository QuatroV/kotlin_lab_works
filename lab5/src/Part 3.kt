import java.io.File
import java.io.IOException

// Пользовательские исключения для обработки ошибок ввода-вывода
class FileReadException(message: String) : Exception(message)
class FileWriteException(message: String) : Exception(message)

// Функция для чтения файла
fun readFile(filePath: String): List<String> {
    return try {
        File(filePath).readLines()
    } catch (e: IOException) {
        throw FileReadException("Ошибка чтения файла: $filePath")
    }
}

// Функция для записи в файл
fun writeFile(filePath: String, lines: List<String>) {
    try {
        File(filePath).bufferedWriter().use { out ->
            lines.forEach { out.write(it + "\n") }
        }
    } catch (e: IOException) {
        throw FileWriteException("Ошибка записи в файл: $filePath")
    }
}

// Функция для удаления подстроки из каждой строки
fun removeSubstring(lines: List<String>, substring: String): List<String> {
    return lines.map { it.replace(substring, "") }
}

// Функция для замены подстроки в каждой строке
fun replaceSubstring(lines: List<String>, oldSubstring: String, newSubstring: String): List<String> {
    return lines.map { it.replace(oldSubstring, newSubstring) }
}

fun main(args: Array<String>) {
    if (args.size < 4) {
        println("Использование: <режим> <входной файл> <выходной файл> <подстрока1> [подстрока2]")
        println("Режимы: remove - удалить подстроку, replace - заменить подстроку")
        return
    }

    val mode = args[0]
    val inputFilePath = args[1]
    val outputFilePath = args[2]
    val substring1 = args[3]
    val substring2 = if (args.size > 4) args[4] else ""

    try {
        val lines = readFile(inputFilePath)
        val processedLines = when (mode) {
            "remove" -> removeSubstring(lines, substring1)
            "replace" -> replaceSubstring(lines, substring1, substring2)
            else -> {
                println("Неизвестный режим: $mode")
                return
            }
        }
        writeFile(outputFilePath, processedLines)
        println("Обработка завершена успешно.")
    } catch (e: FileReadException) {
        println("Ошибка при чтении файла: ${e.message}")
    } catch (e: FileWriteException) {
        println("Ошибка при записи файла: ${e.message}")
    } catch (e: Exception) {
        println("Произошла ошибка: ${e.message}")
    }
}
