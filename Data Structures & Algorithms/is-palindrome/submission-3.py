class Solution:
    def isPalindrome(self, s: str) -> bool:
        word = s.strip().lower()
        word = "".join(c for c in word if c.isalnum())

        i ,j =0, len(word) - 1
        while i <= j:
            if word[i] != word[j]:
                return False
            i += 1
            j -= 1
        return True