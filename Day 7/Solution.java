//905. Sort Array By Parity
// https://leetcode.com/problems/sort-array-by-parity/description/?envType=daily-question&envId=2023-09-28
public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int ptrEven = 0; 
        int ptrOdd = nums.length - 1; 
        
        while (ptrEven < ptrOdd) {
            while (ptrEven < ptrOdd && nums[ptrEven] % 2 == 0) {
                ptrEven++;
            }
            
            while (ptrEven < ptrOdd && nums[ptrOdd] % 2 != 0) {
                ptrOdd--;
            }
            
            int temp = nums[ptrEven];
            nums[ptrEven] = nums[ptrOdd];
            nums[ptrOdd] = temp;
            
            ptrEven++;
            ptrOdd--;
        }
        
        return nums;
    }
}
