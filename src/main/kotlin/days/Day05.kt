package days

import util.solve

private val testInput = listOf(
    "    [D]",
    "[N] [C]",
    "[Z] [M] [P]",
    "1   2   3",
    "",
    "move 1 from 2 to 1",
    "move 3 from 1 to 3",
    "move 2 from 2 to 1",
    "move 1 from 1 to 2",
)

fun main() {
    fun part1() = solve("Day05") { lines ->
        val (movesInput, stacksInput) = lines.partition { it.startsWith("m") }

        val stacks = parseStacks(stacksInput)
        val moves =
            movesInput.map { it.split(" ").filter { it.contains(Regex("""\d""")) }.map { it.toInt() } }


        moves.forEach {
            println(it.joinToString(" "))
            val fromStack = it[1] - 1
            val toStack = it[2] - 1
            val amount = it[0]

            repeat(amount){
                val item = stacks[fromStack].last()
                stacks[fromStack].removeLast()

                stacks[toStack].add(item)
            }

            stacks.forEach {
                println(it.joinToString(""))
            }
        }

        stacks.joinToString("") { if (it.isNotEmpty()) it.last() else ""}
    }

    part1()

    fun part2() = solve("Day05") { lines ->
        val (movesInput, stacksInput) = lines.partition { it.startsWith("m") }

        val stacks = parseStacks(stacksInput)
        val moves =
            movesInput.map { it.split(" ").filter { it.contains(Regex("""\d""")) }.map { it.toInt() } }


        moves.forEach {
            println(it.joinToString(" "))
            val fromStack = it[1] - 1
            val toStack = it[2] - 1
            val amount = it[0]

            val crates = mutableListOf<String>()
            repeat(amount){
                crates.add(stacks[fromStack].last())
                stacks[fromStack].removeLast()
            }

            crates.reversed().forEach {
                stacks[toStack].add(it)
            }

            stacks.forEach {
                println(it.joinToString(""))
            }
        }

        stacks.joinToString("") { if (it.isNotEmpty()) it.last() else ""}
    }

    part2()
}

private fun parseStacks(input: List<String>): MutableList<MutableList<String>> {
    val groupedInput = input.filterNot { it.isEmpty() }.reversed().map { it.chunked(4) }
    val stacks = MutableList(9) { mutableListOf<String>() }
    groupedInput.forEach {
        it.forEachIndexed { index, stackInput ->
            val trimmed = stackInput.trim()
            if (trimmed.startsWith("[")) {
                stacks[index].add(trimmed.trim('[', ']'))
            }
        }
    }
    return stacks
}