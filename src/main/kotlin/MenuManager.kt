import java.util.Scanner

class MenuManager {
    private val scanner = Scanner(System.`in`)

    fun showMenu(fn: () -> Unit): Int {
        var choice: Int
        while (true) {
            println()
            fn()
            choice = userInput()

            if (choice >= 0) {
                return choice
            } else {
                println()
                println("Неправильный ввод!")
                println("Введите номер пункта меню")
                println()
            }
        }
    }

    fun userInput(): Int {
        println()
        println("Выберите пункт меню")
        return if (scanner.hasNextInt()) {
            val input = scanner.nextInt()
            scanner.nextLine()
            input
        } else {
            scanner.nextLine()
            -1
        }
    }

    fun getInput(prompt: String): String {
        while (true) {
            println("Введите $prompt")
            val input = scanner.nextLine()
            if (input.isNotBlank()) {
                return input
            } else {
                println()
                println("$prompt не может быть пустым")
                println()
            }
        }
    }

    fun anyKey() {
        println("Для выхода в меню введите любой символ")
        scanner.nextLine()
    }

    fun printMenuError() {
        println()
        println("Несуществующий пункт меню")
        println()
    }
}
