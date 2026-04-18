class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        bucket = [[] for _ in range(len(nums) + 1)]

        d = {}
        for num in nums:
            d[num] = d.get(num, 0) + 1
        
        for key, value in d.items():
            bucket[value].append(key)
        
        res = []
        for i in range(len(bucket) - 1, 0, -1):
            for num in bucket[i]:
                res.append(num)
                k -= 1
                if k == 0: return res
        return res