fun main(args: Array<String>) {
    endword(35)
    endword(1)
    endword(11)
    endword(0)
    endword(3)
    endword(61)
    endword(95)
    endword(101511)
}

fun endword(likes: Int) = if (likes % 10 == 1 && (likes.toString().takeLast(2)  != "11")) {
    println("Понравилось $likes человеку")
} else {
    println("Понравилось $likes людям")
}


