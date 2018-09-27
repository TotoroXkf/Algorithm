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
    val filWriter = FileWriter("F:\\KotlinCode\\Algorithm\\README.md", true)
    val baseUrl = "https://github.com/TotoroXkf/Algorithm/blob/master/src/"
    val packageName = "BinaryTreeProblem"
    val directory = File("src/$packageName")
    if (directory.isDirectory) {
        val fileList = directory.listFiles()
        var number = 1
        for (file in fileList) {
            val url = baseUrl + packageName + "/" + file.name.substring(0, file.name.length)
            val line = "$number. [${file.name.substring(0, file.name.length - 3)}]($url)\n"
            number++

            filWriter.write(line)
        }
    }
    filWriter.close()
}
