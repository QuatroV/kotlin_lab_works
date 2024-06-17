import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Student(
    private val id: Int,
    private var lastName: String,
    private var firstName: String,
    private var middleName: String,
    private var birthDate: LocalDate,
    private var address: String,
    private var phone: String,
    private var faculty: String,
    private var course: Int,
    private var group: String
) {
    fun setLastName(name: String) {
        lastName = name
    }

    fun getLastName() = lastName

    fun setFirstName(name: String) {
        firstName = name
    }

    fun getFirstName() = firstName

    fun setMiddleName(name: String) {
        middleName = name
    }

    fun getMiddleName() = middleName

    fun setBirthDate(date: LocalDate) {
        birthDate = date
    }

    fun getBirthDate() = birthDate

    fun setAddress(add: String) {
        address = add
    }

    fun getAddress() = address

    fun setPhone(num: String) {
        phone = num
    }

    fun getPhone() = phone

    fun setFaculty(fac: String) {
        faculty = fac
    }

    fun getFaculty() = faculty

    fun setCourse(crs: Int) {
        course = crs
    }

    fun getCourse() = course

    fun setGroup(grp: String) {
        group = grp
    }

    fun getGroup() = group

    override fun toString() = "{id=$id, name=$lastName $firstName $middleName, " +
            "birthDate=${birthDate.format(DateTimeFormatter.ISO_LOCAL_DATE)}, " +
            "address=$address, phone=$phone, faculty=$faculty, course=$course, group=$group}"
}

class Students(private val students: Array<Student>) {
    fun getStudentsByFaculty(faculty: String): List<Student>{
        return students.filter { it.getFaculty() == faculty }
    }
    fun getGroupedStudents(): Map<Pair<String, Int>, List<Student>>{
        return students.groupBy { it.getFaculty() to it.getCourse() }
    }
    fun getStudentsBornAfter(year: Int): List<Student> {
        return students.filter { it.getBirthDate().year > year }
    }
    fun getStudentsByGroup(group: String): List<Student> {
        return students.filter { it.getGroup() == group }
    }
}

fun main() {
    val studentsArray = arrayOf(
        Student(1, "Smith", "John", "Edward", LocalDate.of(1998, 6, 24), "123 Elm St", "555-1234", "Engineering", 3, "ENGR202"),
        Student(2, "Doe", "Jane", "Marie", LocalDate.of(2000, 3, 14), "456 Maple St", "555-5678", "Arts", 2, "ARTS105"),
        Student(3, "Brown", "Jim", "Thomas", LocalDate.of(1999, 8, 16), "789 Oak St", "555-8765", "Engineering", 3, "ENGR202"),
    )

    val students = Students(studentsArray)

    // a) Список студентов заданного факультета
    val faculty = "Engineering"
    println("Students from the $faculty faculty:")
    students.getStudentsByFaculty(faculty).forEach { println(it) }

    // b) Списки студентов для каждого факультета и курса
    val groupedByFacultyAndCourse = students.getGroupedStudents()
    groupedByFacultyAndCourse.forEach { (key, list) ->
        println("Faculty: ${key.first}, Course: ${key.second}")
        list.forEach { println(it) }
    }

    // c) Список студентов, родившихся после заданного года
    val year = 1999
    println("Students born after $year:")
    students.getStudentsBornAfter(year).forEach { println(it) }

    // d) Список учебной группы
    val group = "ENGR202"
    println("Students in the group $group:")
    students.getStudentsByGroup(group).forEach { println(it) }
}
