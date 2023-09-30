// 132 Pattern
// https://leetcode.com/problems/132-pattern/description/?envType=daily-question&envId=2023-09-30
class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int min_i = Integer.MIN_VALUE; 
        int potThird = nums.length; 
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < min_i) {
                return true; 
            }
            
            while (potThird < nums.length && nums[i] > nums[potThird]) {
                min_i = nums[potThird++];
            }
            
            potThird--;
            
            nums[potThird] = nums[i];
        }
        
        return false; 
    }
}
