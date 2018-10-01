class ListNode:

    def __init__(self, value):
        self.next = None
        self.val = value


def create_linked_list(array):
    """
    :type array:list
    :rtype ListNode
    """
    head = None
    tail = None

    for value in array:
        if head is None:
            head = ListNode(value)
            tail = head
        else:
            new_node = ListNode(value)
            tail.next = new_node
            tail = tail.next
    return head


def print_linked_list(head):
    """
    :type head:ListNode
    """
    if head is None:
        print(None)

    node = head
    while node is not None:
        print(node.val, end=' ')
        node = node.next
    print()


class TreeNode:
    def __init__(self, value):
        self.left = None
        self.right = None
        self.val = value


def create_tree(array, position=0):
    """
    :type position:int
    :type array:list
    :rtype:TreeNode
    """
    if array[position] is None:
        return None
    root = TreeNode(array[position])
    left_position = (position + 1) * 2 - 1
    right_position = (position + 1) * 2
    if left_position < len(array):
        root.left = create_tree(array, position=left_position)
    if right_position < len(array):
        root.right = create_tree(array, position=right_position)
    return root


def print_tree(root, mode):
    """
    :type mode:str
    :type root:TreeNode
    """
    if root is not None:
        if mode.__eq__("pre"):
            print(root.val, end=" ")
            print_tree(root.left, "pre")
            print_tree(root.right, "pre")
        elif mode.__eq__("mid"):
            print_tree(root.left, "mid")
            print(root.val, end=" ")
            print_tree(root.right, "mid")
        elif mode.__eq__("post"):
            print_tree(root.left, "post")
            print_tree(root.right, "post")
            print(root.val, end=" ")
        elif mode.__eq__("layer"):
            queue = [root]
            while len(queue) > 0:
                node = queue.pop(0)
                print(node.val, end=" ")
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
        print()
