import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.util.Stack


fun main(args: Array<String>) {
    addLink()
}

fun splitFile() {
    val fileName = "src/input.txt"
    val bufferedReader = BufferedReader(FileReader(fileName))
    var line = bufferedReader.readLine()
    while (line != null && line.contains("###")) {
        val outputName = "src/" + line.substring(4) + ".md"
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

fun addLink() {
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
    for (directory in src.listFiles()) {
        if (directory.name.endsWith("Problem")) {
            val packageName = directory.name
            val category = map[packageName]
            if (category != null) {
                filWriter.write("### $category\n")
            } else {
                println("hashMap里面没有加新的问文件夹")
            }
            for ((number, file) in directory.listFiles().withIndex()) {
                val url = baseUrl + packageName + "/" + file.name.substring(0, file.name.length)
                val line = "$number. [${file.name.substring(0, file.name.length - 3)}]($url)\n"
                filWriter.write(line)
            }
            filWriter.write("\n")
        }
    }

    filWriter.close()
}

//fun addLink() {
//    val filWriter = FileWriter("F:\\KotlinCode\\Algorithm\\README.md", true)
//    val baseUrl = "https://github.com/TotoroXkf/Algorithm/blob/master/src/"
//    val packageName = "BinaryTreeProblem"
//    val directory = File("src/$packageName")
//    if (directory.isDirectory) {
//        val fileList = directory.listFiles()
//        var number = 1
//        for (file in fileList) {
//            val url = baseUrl + packageName + "/" + file.name.substring(0, file.name.length)
//            val line = "$number. [${file.name.substring(0, file.name.length - 3)}]($url)\n"
//            number++
//
//            filWriter.write(line)
//        }
//    }
//    filWriter.close()
//}
