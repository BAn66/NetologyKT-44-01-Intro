fun main(args: Array<String>) {
    val sum = 20000
    discont(sum, true)
}

fun discont(sum: Int, const: Boolean) {
    println("покупка - $sum ->")

    var disc: Int
    var newPrice: Int
    var value: String =""

    if (sum < 1001) {
        disc = 0
        newPrice = sum
        if (!const) {
            value = "у вас нет скидки"
        }
    } else if ((sum > 1000) && (sum < 10001)) {
        disc = 100
        newPrice = sum - 100
        value = "после применения скидки $disc рублей - $newPrice руб."
    } else {
        disc = (sum * 0.05).toInt()
        newPrice = sum - disc
        value = "после применения скидки 5% - $newPrice руб."
    }
    println(value)

    if (const) {
        disc = (newPrice * 0.01).toInt()
        value = "после применения скидки 1% - ${(newPrice * 0.99).toInt()} руб."
        println(value)
    }

}


