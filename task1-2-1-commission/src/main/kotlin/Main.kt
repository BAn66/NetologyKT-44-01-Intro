fun main(args: Array<String>) {
    commission(35000)
}
/** Задание 1.2.1 "Денежные переводы"
 * фунция подсчета процента коммисии в рублях
 * amount вводится в рублях
 */
fun commission(amount:Int){
    val amountInKopp = amount*100 // Сумма перевода в копейках
    val commission = 0.0075 //Величина комиссии 0.75%
    val minCommission = 3500 //Минимальная коммисия в копейках 35 рублей
    val result = if(amountInKopp * commission > minCommission.toDouble()){      //Будущая комиссия в коппейках
        amountInKopp * commission
    } else {
        minCommission.toDouble()
    }
    println(result/100) //печать суммы коммисии в рублях
}