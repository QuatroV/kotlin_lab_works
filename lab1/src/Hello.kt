class Hello {
    private var username: String = ""
    fun setUsernameFromInput() {
        println("Please enter your name: ")
        val username = readln()
        this.username = username
    }
    fun greetTheUser() {
        println("Hello ${this.username}!!!")
    }
}