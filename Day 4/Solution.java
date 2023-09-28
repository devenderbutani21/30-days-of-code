public class Solution {
    public String decodeAtIndex(String s, int k) {
        
        long size = 0;
        int n = s.length();
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                size *= digit;
            } else {
                size++;
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                size /= digit;
                k %= size;
            } else {
                if (k == 0 || k == size) {
                    result.insert(0, c);
                    return result.toString();
                }
                size--; 
            }
        }
        return ""; 
    }
}
