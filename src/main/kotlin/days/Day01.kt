package days

import util.solve

fun main() = solve("Day01") { lines ->
    val elvesTotalCalories = mutableListOf<Int>()

    var calories = 0
    lines.forEach {
        when (it.isEmpty()) {
            true -> {
                elvesTotalCalories.add(calories)
                calories = 0
            }

            false -> calories += Integer.parseInt(it)
        }
    }

    println("Highest calories single elf: ${elvesTotalCalories.maxOrNull()}")

    elvesTotalCalories.sortDescending()
    val topThreeSum = elvesTotalCalories.take(3).sum()

    "Highest calories top 3 elves: $topThreeSum"
}