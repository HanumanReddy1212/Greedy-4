// Time Complexity :O(n)
// Space Complexity :constant
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = findRotation(tops[0], tops, bottoms);
        if (result != -1)
            return result;
        return findRotation(bottoms[0], tops, bottoms);

    }

    public int findRotation(int candidate, int[] tops, int[] bottoms) {
        int n = tops.length;
        int topRes = 0;
        int bottomRes = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] != candidate && bottoms[i] != candidate) {
                return -1;
            }
            if (tops[i] != candidate) {
                topRes++;
            }
            if (bottoms[i] != candidate) {
                bottomRes++;
            }
        }
        return Math.min(topRes, bottomRes);
    }
}