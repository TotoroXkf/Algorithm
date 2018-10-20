import os


def create_read_me():
    read_me = open("./README.md", mode="w", encoding="utf-8")
    read_me.write("# Algorithm  \n"
                  + "这是个算法总结仓库  \n"
                  + "每一道题目都力求最优解。使用Python语言实现  \n"
                  + "Enjoy it！！！  \n\n")

    title_map = {"ArrayProblem": "数组",
                 "BinaryTreeProblem": "二叉树",
                 "DynamicProblem": "递归与动态规划",
                 "LinkedListProblem": "链表",
                 "OtherProblem": "其它问题",
                 "StringProblem": "字符串",
                 "MatrixProblem": "矩阵"
                 }

    base_url = "https://github.com/TotoroXkf/Algorithm/blob/master/"

    problems = 0
    last_package_name = ""

    def action(package_name: str, note_name: str):
        nonlocal last_package_name, problems
        if last_package_name != package_name:
            read_me.write("### " + title_map[package_name] + "\n")
            last_package_name = package_name
        url = base_url + package_name + "/" + note_name+".md"
        line = ("[" + note_name + "]" +
                "(" + url + ")").replace(" ", "")
        line = "- " + line
        problems += 1
        read_me.write(line + "\n")

    traversing_files(action)

    read_me.write("\n\n")
    read_me.write("一共完成了 " + str(problems) + " 道题目")
    read_me.close()
    print("READEME 创建完成")


def check_code(package_name: str, note_name: str):
    note_file = open("./"+package_name+"/"+note_name+".md",
                     mode="r", encoding="utf-8")
    line = note_file.readline()
    while line != "":
        if line.__contains__("```java") or line.__contains__("```kotlin") or line.__contains__('"""'):
            print(note_name)
            note_file.close()
            return
        line = note_file.readline()
    note_file.close()


def add_line(package_name: str, note_name: str):
    note_file = open("./"+package_name+"/"+note_name+".md",
                     mode="r+", encoding="utf-8")
    temp_file = open("./temp.md", mode="w+", encoding="utf-8")
    line = note_file.readline()
    while line != "":
        if line.__contains__("**思路**") or line.__contains__("**代码**"):
            line = line+("-"*20)+"\n"
            temp_file.write(line)
        elif not line.__contains__("----------"):
            temp_file.write(line)
        line = note_file.readline()

    note_file.seek(0)
    temp_file.seek(0)

    line = temp_file.readline()
    while line != "":
        note_file.write(line)
        line = temp_file.readline()

    note_file.close()
    temp_file.close()


def traversing_files(action):
    base_path = "./"
    files = os.listdir(base_path)
    for package_name in files:
        if (os.path.isdir(base_path + package_name)) and (package_name.endswith("Problem")):
            notes = os.listdir(base_path + package_name)
            for note in notes:
                if note.endswith(".md"):
                    action(package_name, note[0:len(note)-3])


def new_note(path: str, file_name: str):
    if os.path.exists(path):
        print("已经存在文件！")
        return
    note_file = open(path, "w+", encoding="utf-8")
    note_file.write("# "+file_name+"\n> \n\n")
    note_file.write("**思路**\n")
    note_file.write("-"*20+"\n")
    note_file.write("\n")
    note_file.write("**代码**\n")
    note_file.write("-"*20+"\n")
    note_file.write("\n")
    note_file.write("```python\n")
    note_file.write("\n")
    note_file.write("```\n")
    note_file.close()
    print("成功的创建了文件："+file_name)


create_read_me()
