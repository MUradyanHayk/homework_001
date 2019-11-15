import java.util.*
import kotlin.Exception

const val LEFT_BOUND = 1
const val RIGHT_BOUND = 100
var step: Int = 0

fun main(args: Array<String>) {
    play()
}

fun play() {
    selectLevel()
    enterNumber()
}

fun enterNumber() {
    while (true) {

        println("to enter a number between 1 and 100")
        val number = generateNumber()

        var i = 0
        while (i < step) {
            val n = readLine()
            try {
                if (n != null) {
                    if (n.toInt() < LEFT_BOUND || n.toInt() > RIGHT_BOUND) {
                        throw Exception()
                    }
                    when {
                        n.toInt() > number -> println("take lowe")
                        n.toInt() < number -> println("take higher")
                        else -> {
                            println(" you won !!!")
                            return
                        }
                    }
                }
            } catch (e: Exception) {
                println("the number must be between 1 and 100, please enter again")
                continue
            }
            i++
        }
        println("\nYou lose\n")
    }
}

fun selectLevel() {
    println("select the level : ( 1- Easy, 2- Medium, 3- Hard)")
    while (true) {
        try {
            val level = readLine()
            if (level != null) {
                step = when (level.toInt()) {
                    1 -> {
                        println("You have 7 steps")
                        7
                    }
                    2 -> {
                        println("You have 5 steps")
                        5
                    }
                    3 -> {
                        println("You have 3 steps")
                        3
                    }
                    else -> throw Exception()
                }
                break
            }
        } catch (e: Exception) {
            println("You select an incorrect level, please try again")
        }
    }
}

fun generateNumber(): Int {
    val randomNumber = Random()
    return randomNumber.nextInt(RIGHT_BOUND) + 1
}