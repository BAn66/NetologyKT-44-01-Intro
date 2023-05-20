fun main(args: Array<String>) {
    println(agoToText(-1))
    println(agoToText(11))//только что
    println(agoToText(70))//1 миунту назад
    println(agoToText(121)) // 2 минуты назад
    println(agoToText(961)) // 16 минут назад
    println(agoToText(1921)) // 32 минут назад
    println(agoToText(2463)) // 41 минуту назад
    println(agoToText(3555)) // 59 минут назад

    println(agoToText(3601)) //1 час назад
    println(agoToText(7201)) //2 часа назад
    println(agoToText(14401)) //4 часа назад
    println(agoToText(21601)) //6 часов назад
    println(agoToText(39601)) //11 часов назад
    println(agoToText(54001)) //15 часов назад
    println(agoToText(75601)) //21 час назад
    println(agoToText(82800)) //23 часа назад

    println(agoToText(100000))//вчера
    println(agoToText(200000))//позавчера
    println(agoToText(300000)) //давно
}

fun agoToText(second: Int): String {
    var result: String

    var timeName = ""
    var endWordTime = ""
    when {
        second in 60..3599 -> timeName = "минут"
        second > 3599 -> timeName = "час"
    }

    when {
        second in 60..3600 -> endWordTime = endWordMinute(second)
        second > 3601 -> endWordTime = endWordHours(second)
    }

    var whenWas = when {
        second < 0 -> "ли?"
        second in 0..59 -> "только что"
        second in 60..3_599 -> "${second / 60} $timeName$endWordTime назад"
        second in 3_600..86_399 -> "${second / 3600} $timeName$endWordTime назад"
        second in 86_400..172_799 -> "вчера"
        second in 172_800..259_200 -> "позавчера"
        else -> "давно"
    }

    result = "был(а) $whenWas "

    return result
}

fun endWordMinute(second: Int): String =
    when {
        second in 60..119 -> "у" //минута до 2
        second in 300..1252 -> "" //от 5 до 20
        (second / 60)%10 == 1 -> "у"
        (second / 60)%10 in 2..4 -> "ы"
        else -> ""
    }

fun endWordHours(second: Int): String =
    when {
        (second / 3600) in 2..4 -> "а"
        (second / 3600) in 5..20 -> "ов"
        (second / 3600) in 22..24 -> "а"
        else -> ""
    }

