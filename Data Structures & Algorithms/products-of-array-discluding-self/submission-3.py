class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        left = [1] * len(nums)
        for i in range(1, len(nums)):
            left[i] = nums[i - 1] * left[i - 1]

        right = 1
        output = [1] * len(nums)
        for i in range(len(nums) -  1, -1, -1):
            output[i] = right * left[i]
            right *= nums[i]

        return output
        