class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        d = {}
        res = 0
        for num in nums:
            if num not in d:
                d[num] = d.get(num - 1, 0) + d.get(num + 1, 0) + 1
            d[num - d.get(num - 1, 0)] = d.get(num)
            d[num + d.get(num + 1, 0)] = d.get(num)
            res = max(res, d.get(num))
        return res