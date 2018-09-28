import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter


fun printCommonArea(head1: ListNode?, head2: ListNode?) {
    var first = head1
    var second = head2
    while (first != null && second != null) {
        when {
            first.value < second.value -> first = first.next
            first.value > second.value -> second = second.next
            else -> {
                println(first.value)
                first = first.next
                second = second.next
            }
        }
    }
}

fun main(args: Array<String>) {
    splitFile("OtherProblem")
    createReadeMe()
}



