package days

import util.solve

val testLines = listOf(
    "vJrwpWtwJgWrhcsFMMfFFhFp",
    "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
    "PmmdzqPrVvPwwTWBwg",
    "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
    "ttgJtRGJQctTZtZT",
    "CrZsJsPPZsGzwwsLwLmpwMDw",
)

fun main() {
    fun part1() = solve("Day03") { lines ->

        lines.map { line ->
            val firstPart = line.take(line.length / 2)
            val lastPart = line.takeLast(line.length / 2)

            firstPart.filter { lastPart.contains(it) }.first().priority
        }.sum()
    }

    fun part2() = solve("Day03") { lines ->
        val groups = lines.chunked(3)

        groups.map { group ->
             group.first().filter { group[1].contains(it) && group[2].contains(it) }.first().priority
        }.sum()
    }

    part1()
    part2()
}

val Char.priority
    get() =
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(this) + 1
