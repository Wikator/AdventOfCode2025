class Dial(private var currentPoint: Int) {
    fun next() {
        if (currentPoint == 99) currentPoint = 0 else currentPoint += 1
    }
    
    fun previous() {
        if (currentPoint == 0) currentPoint = 99 else currentPoint -= 1
    }
    
    fun isPointingAtZero(): Boolean {
        return currentPoint == 0
    }
}

fun main() {
    fun part1(input: List<String>): Int {
        val dial = Dial(50)
        return input.sumOf { element ->
            val goRight = element[0] == 'R'
            val number = element.drop(1).toInt()
            if (goRight) {
                repeat(number) { _ -> dial.next() }
            } else {
                repeat(number) { _ -> dial.previous() }
            }
            if (dial.isPointingAtZero()) 1 else 0
        }
    }

    fun part2(input: List<String>): Int {
        val dial = Dial(50)
        return input.sumOf { element ->
            val goRight = element[0] == 'R'
            val number = element.drop(1).toInt()
            if (goRight) {
                (1..number).sumOf { _ ->
                    dial.next()
                    if (dial.isPointingAtZero()) 1 else 0
                }
            } else {
                (1..number).sumOf { _ ->
                    dial.previous()
                    if (dial.isPointingAtZero()) 1 else 0
                }
            }
        }
    }

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
