from node import ListNode, create_linked_list, print_linked_list


def merge_two_link_list(l1: ListNode, l2: ListNode):
    if l1 is None:
        return l2
    if l2 is None:
        return l1
    if l1.val < l2.val:
        l1.next = merge_two_link_list(l1.next, l2)
        return l1
    else:
        l2.next = merge_two_link_list(l1, l2.next)
        return l2


l1 = create_linked_list([1, 3, 5, 7, 9])
l2 = create_linked_list([2, 4, 6, 8, 10])
print_linked_list(merge_two_link_list(l1,l2))
