// Count Primes
// https://leetcode.com/problems/count-primes/description/
import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime
        
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false; // Mark multiples of i as not prime
                }
            }
        }
        
        int count = 0;
        for (boolean prime : isPrime) {
            if (prime) {
                count++;
            }
        }
        
        return count;
    }
}