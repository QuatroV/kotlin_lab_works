class Customer(
    private val id: Int,
    private var lastName: String,
    private var firstName: String,
    private var middleName: String,
    private var address: String,
    private var creditCardNumber: Long,
    private var bankAccountNumber: Long
) {
    fun setLastName(lastName: String) { this.lastName = lastName }
    fun getLastName() = lastName

    fun setFirstName(firstName: String) { this.firstName = firstName }
    fun getFirstName() = firstName

    fun setMiddleName(middleName: String) { this.middleName = middleName }
    fun getMiddleName() = middleName

    fun setAddress(address: String) { this.address = address }
    fun getAddress() = address

    fun setCreditCardNumber(creditCardNumber: Long) { this.creditCardNumber = creditCardNumber }
    fun getCreditCardNumber() = creditCardNumber

    fun setBankAccountNumber(bankAccountNumber: Long) { this.bankAccountNumber = bankAccountNumber }
    fun getBankAccountNumber() = bankAccountNumber

    override fun toString(): String {
        return "{id=$id, lastName='$lastName', firstName='$firstName', middleName='$middleName', " +
                "address='$address', creditCardNumber='$creditCardNumber', bankAccountNumber='$bankAccountNumber'}"
    }
}

class Customers(private val customers: Array<Customer>){
    fun sortCustomers(): List<Customer> {
        return customers.sortedBy {  it.getLastName() + it.getFirstName() + it.getMiddleName() }
    }
    fun getCustomersByCreditCardNumberInInterval(start: Long, end: Long): List<Customer>{
        return customers.filter {
            it.getCreditCardNumber() in (start + 1)..<end
        }
    }
}

fun main() {
    val customersArray = arrayOf(
        Customer(1, "Smith", "John", "Edward", "123 Elm St", 1234567890123456, 9876543210),
        Customer(2, "Doe", "Jane", "Marie", "456 Maple St", 9876543210987654, 1234567890),
        Customer(3, "Brown", "Jim", "Thomas", "789 Oak St", 5555666677778888, 1122334455)
    )

    val customers = Customers(customersArray)

    // a) список покупателей в алфавитном порядке
    val sortedCustomers = customers.sortCustomers()
    println("Customers sorted by last name:")
    sortedCustomers.forEach { println(it) }

    // b) список покупателей с номерами кредитных карт в заданном интервале
    val startCardNumber = 1234567890123450
    val endCardNumber = 6234567890123456
    val customersInRange = customers.getCustomersByCreditCardNumberInInterval(startCardNumber, endCardNumber)
    println("\nCustomers with credit card numbers in the range $startCardNumber-$endCardNumber:")
    customersInRange.forEach { println(it) }
}
