import os


def create_read_me():
    read_me = open("./README.md", mode="w", encoding="utf-8")
    read_me.write("# Algorithm  \n"
                  + "本来做算法题是为了找工作的。  \n"
                  + "但是渐渐的就喜欢上算法题了。逐步的分析问题，然后写成代码，这个过程十分美妙  \n"
                  + "所以我决定一直保持算法的练习，也是对逻辑思维的训练Enjoy it！！！  \n\n")

    title_map = {"ArrayProblem": "数组",
                 "BinaryTreeProblem": "二叉树",
                 "DynamicProblem": "递归与动态规划",
                 "LinkedListProblem": "链表",
                 "OtherProblem": "其它问题",
                 "StackAndQueueProblem": "栈和队列",
                 "StringProblem": "字符串"}

    base_url = "https://github.com/TotoroXkf/Algorithm/blob/master/"
    base_path = "./"

    files = os.listdir(base_path)
    problems = 0
    for package_name in files:
        if (os.path.isdir(base_path + package_name)) and (package_name.endswith("Problem")):
            read_me.write("### " + title_map[package_name] + "\n")
            notes = os.listdir(base_path + package_name)
            for note in notes:
                if note.endswith(".md"):
                    url = base_url + package_name + "/" + note
                    line = ("[" + note[0:note.__len__() - 3] + "]" +
                            "(" + url + ")").replace(" ", "")
                    line = "- " + line
                    problems += 1
                    read_me.write(line + "\n")
            read_me.write("\n")

    read_me.write("\n\n")
    read_me.write("一共完成了 " + str(problems) + " 道题目")
    read_me.close()


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


def traversing_files(action):
    base_path = "./"
    files = os.listdir(base_path)
    for package_name in files:
        if (os.path.isdir(base_path + package_name)) and (package_name.endswith("Problem")):
            notes = os.listdir(base_path + package_name)
            for note in notes:
                if note.endswith(".md"):
                    action(package_name, note[0:len(note)-3])


traversing_files(check_code)
create_read_me()