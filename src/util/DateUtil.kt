package util

import java.util.*

fun main() {
    val calendar = Calendar.getInstance()
    while (getYear(calendar) == "2020") {
        println(getMonth(calendar) + "/" + getDay(calendar) + "/" + getWeek(calendar))
        calendar.add(Calendar.DAY_OF_MONTH, 1)
    }
}

fun getYear(calendar: Calendar): String {
    return calendar.get(Calendar.YEAR).toString()
}

fun getMonth(calendar: Calendar): String {
    return when (calendar.get(Calendar.MONTH)) {
        Calendar.JANUARY -> "1"
        Calendar.FEBRUARY -> "2"
        Calendar.MARCH -> "3"
        Calendar.APRIL -> "4"
        Calendar.MAY -> "5"
        Calendar.JUNE -> "6"
        Calendar.JULY -> "7"
        Calendar.AUGUST -> "8"
        Calendar.SEPTEMBER -> "9"
        Calendar.OCTOBER -> "10"
        Calendar.NOVEMBER -> "11"
        Calendar.DECEMBER -> "12"
        else -> "0"
    }
}

fun getDay(calendar: Calendar): String {
    return calendar.get(Calendar.DAY_OF_MONTH).toString()
}

fun getWeek(calendar: Calendar): String {
    return when (calendar.get(Calendar.DAY_OF_WEEK)) {
        Calendar.SUNDAY -> "星期天"
        Calendar.MONDAY -> "星期一"
        Calendar.TUESDAY -> "星期二"
        Calendar.WEDNESDAY -> "星期三"
        Calendar.THURSDAY -> "星期四"
        Calendar.FRIDAY -> "星期五"
        Calendar.SATURDAY -> "星期六"
        else -> ""
    }
}