package days

import util.solve

fun main() {
    fun part1() = solve("Day02") { lines ->
        var score = 0

        val scores = mapOf<String, Int>(
            Pair("A X", 1 +3),
            Pair("A Y", 2 +6),
            Pair("A Z", 3 +0),

            Pair("B X", 1 +0),
            Pair("B Y", 2 +3),
            Pair("B Z", 3 +6),

            Pair("C X", 1 +6),
            Pair("C Y", 2 +0),
            Pair("C Z", 3 +3),
        )

        lines.forEach {line ->
            scores[line]?.let{
            score += it
            }
        }
        score
    }

    part1()

    fun part2() = solve("Day02"){lines ->
        var score = 0

        val scores = mapOf<String, Int>(
            Pair("A X", 0 +3),
            Pair("A Y", 3 +1),
            Pair("A Z", 6 +2),

            Pair("B X", 0 +1),
            Pair("B Y", 3 +2),
            Pair("B Z", 6 +3),

            Pair("C X", 0 +2),
            Pair("C Y", 3 +3),
            Pair("C Z", 6 +1),
        )

        lines.forEach {line ->
            scores[line]?.let{
                score += it
            }
        }
        score
    }

    part2()
}