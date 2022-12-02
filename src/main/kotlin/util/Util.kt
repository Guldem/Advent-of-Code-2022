package util

fun solve(input: String, block: (lines: List<String>) -> Any?) {
    println("Solving $input")
    val lines = {}.javaClass.getResourceAsStream("/input/$input.txt").bufferedReader().readLines()
    val result = block(lines)

    println("Result for $input: $result")
}