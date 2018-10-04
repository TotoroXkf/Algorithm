from node import ListNode, create_linked_list, print_linked_list


def add_two_numbers(l1: ListNode, l2: ListNode):
    x, y = l1, l2
    while x is not None and y is not None:
        value = x.val+y.val
        x.val, y.val = value, value
        x, y = x.next, y.next
    y, x = x, l1
    if x is None:
        y, x = x, l2
    n = 0
    while x is not None:
        x.val += n
        if x.val >= 10:
            n = 1
            x.val -= 10
            if x.next is None:
                x.next = ListNode(1)
                break
        else:
            n = 0
        x = x.next
    return y


l1 = create_linked_list([1, 2, 3, 4, 5])
l2 = create_linked_list([2, 3, 4, 5, 6])
print_linked_list(add_two_numbers(l1, l2))
