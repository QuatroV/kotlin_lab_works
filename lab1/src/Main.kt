
fun main(cmdArgs: Array<String>) {
//    task11()
//    task12(cmdArgs)
    task2()
}

/**
 * Задание 1.1: Создать класс Hello, который будет приветствовать любого пользователя, используя командную строку.
 */
fun task11(){
    val hello = Hello()
    hello.setUsernameFromInput();
    hello.greetTheUser();
}

/**
 * Задание 1.2: Создать приложение, которое отображает в окне консоли аргументы командной строки метода main()
 * в обратном порядке.
 */
fun task12(cmdArgs: Array<String>){
    println("Reversed command line arguments:")
    println(cmdArgs.reversedArray().contentToString())
}

/**
 * Задание 2: Ввести с консоли n целых чисел и поместить их в массив.
 * На консоль вывести: Четные и нечетные числа; Наибольшее и наименьшее число
 */
fun task2(){
    println("Enter array of integers divided by single space:");

    val input = readln()

    val inputArray = input.split(" ").map{it.toInt()}.toTypedArray()

    println("Odd numbers: ")
    println(inputArray.filter { it % 2 == 1})
    println("Even numbers: ")
    println(inputArray.filter { it % 2 == 0 })
    println("Number with the biggest value: ")
    println(inputArray.max())
    println("Number with the biggest value: ")
    println(inputArray.min())
}


