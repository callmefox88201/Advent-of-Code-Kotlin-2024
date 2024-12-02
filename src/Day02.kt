import kotlin.math.abs

fun main() {
    fun getInput(input: String): List<List<Int>> = readInput(input).map { line ->
        line.split("\\s+".toRegex()).map { it.toInt() }
    }

    fun isSafe(list: List<Int>) : Boolean {
        if (list.size < 2) {
            return true
        }

        val isAscending = list[0] < list[1]
        for (i in 0 until list.size - 1) {
            val diff = list[i + 1] - list[i]

            if (abs(diff) !in 1..3) {
                return false
            }

            if ((isAscending && diff < 0) || (!isAscending && diff > 0)) {
                return false
            }
        }
        return true
    }

    fun isSafe2(list:List<Int>) :Boolean {
        if (isSafe(list)) {
            return true
        }

        for (i in list.indices) {
            if (isSafe(list.take(i) + list.drop(i + 1))) {
                return true
            }
        }
        return false
    }

    fun part1(input: List<List<Int>>): Int = input.count { isSafe(it) }

    fun part2(input: List<List<Int>>): Int = input.count { isSafe2(it) }

    val input = getInput("Day02")
    println(part1(input))
    println(part2(input))
}