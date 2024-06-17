import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread
import kotlin.random.Random

class BankAccount(var balance: Int) {
    private val lock = ReentrantLock()

    fun deposit(amount: Int) {
        lock.lock()
        try {
            balance += amount
            println("Пополнение: $amount, Текущий баланс: $balance")
        } finally {
            lock.unlock()
        }
    }

    fun withdraw(amount: Int) {
        lock.lock()
        try {
            if (balance >= amount) {
                balance -= amount
                println("Снятие: $amount, Текущий баланс: $balance")
            } else {
                println("Недостаточно средств для снятия: $amount, Текущий баланс: $balance")
            }
        } finally {
            lock.unlock()
        }
    }
}

fun main() {
    val bankAccount = BankAccount(1000)

    val threads = List(10) {
        thread {
            repeat(10) {
                val amount = Random.nextInt(1, 500)
                if (Random.nextBoolean()) {
                    bankAccount.deposit(amount)
                } else {
                    bankAccount.withdraw(amount)
                }
                Thread.sleep(100)
            }
        }
    }

    threads.forEach { it.join() }
    println("Финальный баланс: ${bankAccount.balance}")
}

