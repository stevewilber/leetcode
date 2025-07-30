class Solution {
    public int longestSubarray(int[] nums) {
        int largestNum = nums[0];
        int longest = 1;
        int currentRun = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < largestNum) {
                currentRun = 0;
            } else if (nums[i] > largestNum) {
                largestNum = nums[i];
                currentRun = 1;
                longest = 1;
            } else if (nums[i] == largestNum) {
                currentRun++;
                longest = Math.max(longest, currentRun);
            }
        }

        return longest;
    }
}