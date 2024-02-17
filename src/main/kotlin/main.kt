fun main() {
    println(agoToText(6 * 60 * 60))
}

fun agoToText(seconds: Int): String {
    return when (seconds) {
        in 0..60 -> "был(а) только что"
        in 61 until(60 * 60) -> "был(а) ${seconds/60} ${formatTimeAgo(seconds)}"
        in (60 * 60 )until(24 * 60 * 60) -> "был(а) ${seconds/3600} ${formatTimeAgo(seconds)}"
        in (24 * 60 * 60)until(2 * 24 * 60 * 60) -> "был(а) вчера"
        in (2 * 24 * 60 * 60)until(3 * 24 * 60 * 60) -> "был(а) позавчера"
        else -> "был(а) давно"
    }

}

fun formatTimeAgo(seconds: Int): String {
    if (seconds < 60 * 60) {
        return when (seconds/60) {
            1, 21, 31, 41, 51 -> "минуту назад"
            2, 3, 4, in 22..24, in 32..34, in 42..44, in 52..54 -> "минуты назад"
            in 5..9, in 25..29, in 35..39, in 45..49, in 55..59 -> "минут назад"
            in 11..14 -> "минут назад"


            else -> "минут назад"
        }
    }
    if (seconds >= 60 * 60 && seconds <= 24*60*60) {
        return when (seconds/3600) {
            1, 21 -> "час назад"
            2, 3, 4, 22, 23, 24 -> "часа назад"
            //in 5..20 -> "часов назад"


            else -> "часов назад"
        }
    }

return ""
}