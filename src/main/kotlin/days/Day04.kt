package days

import util.solve

private val testInput = listOf(
    "2-4,6-8",
    "2-3,4-5",
    "5-7,7-9",
    "2-8,3-7",
    "6-6,4-6",
    "2-6,4-8",
)

fun main() {

    fun part01() = solve("Day04") { lines ->
        val groupedRanges = lines.map { line ->
            val group = line.split(",").map { elf ->
                val ranges = elf.split("-")
                Pair(ranges.first().toInt(), ranges.last().toInt())
            }
            if (withinRange(group.first(), group.last())) 1 else 0
        }
        groupedRanges.sum()
    }

    part01()

    fun part02() = solve("Day04") { lines ->
        val groupedRanges = lines.map { line ->
            val group = line.split(",").map { elf ->
                val ranges = elf.split("-")
                Pair(ranges.first().toInt(), ranges.last().toInt())
            }
            if (withinRange2(group.first(), group.last())) 1 else 0
        }
        groupedRanges.sum()
    }

    part02()
}

private fun withinRange(pair1: Pair<Int, Int>, pair2: Pair<Int, Int>): Boolean {
    return (pair1.first >= pair2.first && pair1.second <= pair2.second) || (pair2.first >= pair1.first && pair2.second <= pair1.second)
}

private fun withinRange2(pair1: Pair<Int, Int>, pair2: Pair<Int, Int>): Boolean {
    return (pair1.first <= pair2.second && pair1.second >= pair2.first)
}