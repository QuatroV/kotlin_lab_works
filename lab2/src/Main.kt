import java.util.*

fun main() {
    task11();
    task12();
    println("Enter the n number for the matrix: ")
    val dimensionsOfTheMatrix = readln().toInt()
    var matrix = generateRandomMatrix(dimensionsOfTheMatrix)
    println("Original generated matrix: ")
    printMatrix(matrix)
    var sortedMatrix = orderMatrix(matrix)
    println("Sorted matrix: ")
    printMatrix(sortedMatrix)
    var shiftedMatrix = cycleShiftMatrix(matrix, 2)
    println("Shifted matrix: ")
    printMatrix(shiftedMatrix)
    printSign()
}

/**
 * В приведенных ниже заданиях необходимо вывести внизу фамилию разработчика, дату и время получения задания,
 * а также дату и время сдачи задания. Для получения последней даты и времени следует использовать класс Date.
 */

fun printSign () {
    println("=============[sign]===============")
    println("Kurohtin")
    println("Task received: Fri Feb 9 14:30:00 MSK 2024")
    println("Task submitted: ${Date()}")
    println("=============[sign]===============")
}

fun getLinesFromInput (): ArrayList<String> {
    val res: ArrayList<String> = ArrayList();
    println("Enter the number of lines: ")
    val numberOfLines = readln().toInt();
    repeat(numberOfLines){
        val newStr = readln();
        res.add(newStr);
    }
    return res;
}

/**
 * Задание 1.1: Ввести n строк с консоли, найти самую короткую и самую длинную строки. Вывести найденные строки и их длину.
 */
fun task11(){
    val inputArray = getLinesFromInput();
    val longestStr = inputArray.maxBy { it -> it.length }
    val shortestStr = inputArray.minBy { it -> it.length }

    println("Shortest string is '$shortestStr', longest is '$longestStr'")
}

/**
 * Задание 1.2: Ввести n строк с консоли. Упорядочить и вывести строки в порядке возрастания (убывания) значений их длины.
 */
fun task12(){
    val inputArray = getLinesFromInput();

    inputArray.sortBy { it.length }

    println("Sorted array of strings: ")
    for (s in inputArray) {
        println(s)
    }
}

/**
 * Ввести с консоли n – размерность матрицы a[n][n].
 * Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел.
 */
fun generateRandomMatrix (n: Int): Array<Array<Int>>{
    val resArr = Array(n) { Array(n) { 0 } }

    for (i in resArr.indices) {
        for (j in resArr[i].indices){
            resArr[i][j] = Random().nextInt(-n, n + 1);
        }
    }

    return resArr;
}

fun printMatrix(matrix: Array<Array<Int>>) {
    for (i in matrix.indices) {
        for (j in matrix[i].indices){
            print("${matrix[i][j]}\t")
        }
        println()
    }
}

/**
 * Задание 2.1: Упорядочить **строки** (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
 */
fun orderMatrix(matrix: Array<Array<Int>>): Array<Array<Int>>{
    matrix.forEach { el -> el.sort() }
    return matrix;
}

/**
 * Задание 2.2: Выполнить циклический сдвиг заданной матрицы на k позиций **вправо** (влево, вверх, вниз).
 */
fun cycleShiftMatrix(matrix: Array<Array<Int>>, k: Int): Array<Array<Int>>{
    val newMatrix = Array(matrix.size) { Array(matrix.size) { 0 } }

    for (i in matrix.indices) {
        for (j in matrix[i].indices){
            newMatrix[i][j] = matrix[i][(j+k) % matrix.size]
        }
    }
    return newMatrix;
}