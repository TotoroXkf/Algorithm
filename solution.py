from base import *


class Solution:
    def isPalindrome(self, s: str):
        n = len(s)
        s = s.lower()
        i, j = 0, n-1
        while i < j:
            if s[i].isalnum() == False:
                i += 1
                continue
            if s[j].isalnum() == False:
                j -= 1
                continue
            if s[i] != s[j]:
                return False
            i += 1
            j -= 1
        return True
