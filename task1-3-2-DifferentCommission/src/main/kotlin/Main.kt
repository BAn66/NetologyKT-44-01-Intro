fun main(args: Array<String>) {
    println(countCommission("Мир", 0, 10000)) //75
    println(countCommission("Мир", 0, 1000)) //35
    println(countCommission(nowPay = 10000)) //0
    println(countCommission("Maestro", 35000, 10000)) //0
    println(countCommission("Masetrcard", 100000, 10000)) //80
}

fun countCommission(account: String = "VK pay", beforePay: Int = 0, nowPay: Int): Int =
    when (account.toLowerCase()) { //систему можно указывать в любом регистре
        accountType.VKPAY.nameAcc.toLowerCase() -> 0
        accountType.MASTERCARD.nameAcc.toLowerCase() -> commissionForMasterCardMaestro(beforePay, nowPay)
        accountType.MAESTRO.nameAcc.toLowerCase() -> commissionForMasterCardMaestro(beforePay, nowPay)
        accountType.VISA.nameAcc.toLowerCase() -> commissionForVisaMir(nowPay)
        accountType.MIR.nameAcc.toLowerCase() -> commissionForVisaMir(nowPay)
        else -> 0
    }


fun commissionForMasterCardMaestro(beforePay: Int, nowPay: Int): Int = if (beforePay < 75000) 0
else (nowPay * 0.006 + 20).toInt()

fun commissionForVisaMir(nowPay: Int): Int = if (nowPay * 0.0075 < 35) 35
else (nowPay * 0.0075).toInt()

enum class accountType(var nameAcc: String) {
    VKPAY("VK pay"),
    MASTERCARD("Masetrcard"),
    MAESTRO("Maestro"),
    VISA("Visa"),
    MIR("Мир")
}