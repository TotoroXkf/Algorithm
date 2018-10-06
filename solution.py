from base import *


def merge_k_lists(lists: list, start=-1, end=-1):
    if start == -1 and end == -1:
        return merge_k_lists(lists, 0, len(lists)-1)
    if start == end:
        return lists[start]
    if start < end:
        mid = (start+end)//2
        l1 = merge_k_lists(lists, start, mid)
        l2 = merge_k_lists(lists, mid+1, end)
        return merge_two_link_list(l1, l2)
    return None


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
