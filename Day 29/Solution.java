class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parentCount = new int[n];

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                parentCount[leftChild[i]]++;
                if (parentCount[leftChild[i]] > 1) {
                    return false; 
                }
            }

            if (rightChild[i] != -1) {
                parentCount[rightChild[i]]++;
                if (parentCount[rightChild[i]] > 1) {
                    return false; 
                }
            }
        }

        int rootCount = 0;
        for (int i = 0; i < n; i++) {
            if (parentCount[i] == 0) {
                rootCount++;
                if (rootCount > 1) {
                    return false; 
                }
            }
        }

        return rootCount == 1; 
    }
}
