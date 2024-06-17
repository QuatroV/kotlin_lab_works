interface Enrollee {
    fun enroll()
}

abstract class Student : Enrollee {
    abstract fun study()
}

class PartTimeStudent : Student() {
    override fun study() {
        println("Study as a part-time student...")
    }

    override fun enroll() {
        println("Enrolling as a part-time student...")
    }
}

fun main() {
    val partTimeStudent = PartTimeStudent()
    partTimeStudent.study()
    partTimeStudent.enroll()
}
