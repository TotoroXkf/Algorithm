import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter

fun splitFile(to: String) {
    val fileName = "src/input.txt"
    val bufferedReader = BufferedReader(FileReader(fileName))
    var line = bufferedReader.readLine()
    while (line != null && line.contains("###")) {
        val outputName = "src/$to/" + line.substring(4) + ".md"
        val fileWriter = FileWriter(outputName)
        fileWriter.write(line + "\n")
        line = bufferedReader.readLine()
        while (line != null && !line.contains("###")) {
            fileWriter.write(line + "\n")
            line = bufferedReader.readLine()
        }
        fileWriter.close()
    }


    bufferedReader.close()
}

fun createReadeMe() {
    val filWriter = FileWriter("F:\\KotlinCode\\Algorithm\\README.md")
    filWriter.write("# Algorithm\n" +
            "\n" +
            "本来做算法题是为了找工作的。但是渐渐的就喜欢上算法题了。逐步的分析问题，然后写成代码，这个过程十分美妙\n" +
            "\n" +
            "所以我决定一直保持算法的练习，也是对逻辑思维的训练\n" +
            "\n" +
            "Enjoy it！！！\n\n")

    val map = hashMapOf(
            "ArrayProblem" to "数组",
            "BinaryTreeProblem" to "二叉树",
            "DynamicProblem" to "递归与动态规划",
            "LinkedListProblem" to "链表",
            "OtherProblem" to "其它问题",
            "StackAndQueueProblem" to "栈和队列",
            "StringProblem" to "字符串问题"
    )

    val basePath = "F:\\KotlinCode\\Algorithm\\src"
    val baseUrl = "https://github.com/TotoroXkf/Algorithm/blob/master/src/"
    val src = File(basePath)
    var sum = 0
    for (directory in src.listFiles()) {
        if (directory.name.endsWith("Problem")) {
            val packageName = directory.name
            val category = map[packageName]
            if (category != null) {
                filWriter.write("### $category\n")
            } else {
                println("hashMap里面没有加新的问文件夹")
            }
            var number = 1
            for (file in directory.listFiles()) {
                if (file.isFile) {
                    val url = baseUrl + packageName + "/" + file.name.substring(0, file.name.length)
                    var line = "[${file.name.substring(0, file.name.length - 3)}]($url)\n"
                    line = line.replace(" ", "")
                    line = "$number. $line"
                    number++

                    filWriter.write(line)
                }
            }
            sum += number - 1
            filWriter.write("\n")
        }
    }
    filWriter.write("\n")
    filWriter.write("已经完成了 $sum 道题目")

    filWriter.close()
}