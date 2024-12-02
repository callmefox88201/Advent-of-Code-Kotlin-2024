import kotlin.math.abs

fun main() {
    fun getInput(input: String): Pair<List<Int>, List<Int>> {
        val lines = readInput(input)
        return lines.map { line ->
            val first = line.substringBefore(" ").toInt()
            val second = line.substringAfterLast(" ").toInt()
            first to second
        }.unzip()
    }

    fun part1(input: Pair<List<Int>, List<Int>>): Int {
        val (left, right) = input

        return left.sorted().zip(right.sorted()).sumOf { (first, second) ->
            abs(first - second)
        }
    }

    fun part2(input: Pair<List<Int>, List<Int>>): Int {
        val (left, right) = input

        val frequencies = right.groupingBy { it }.eachCount()

        return left.sumOf { num ->
            (num * frequencies.getOrDefault(num, 0))
        }
    }

    val input = getInput("Day01")

    println(part1(input))
    println(part2(input))
}