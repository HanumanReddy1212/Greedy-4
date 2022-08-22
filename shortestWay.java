// Time Complexity :O(m+nlogk)where m is length of source n is length of target
// and k is average no of indices in map list
// Space Complexity :O(n)
class Solution {
    public int shortestWay(String source, String target) {
        int slength = source.length();
        int tlength = target.length();
        int count = 1;
        HashMap<Character, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < slength; i++) {
            char c = source.charAt(i);
            if (!indexMap.containsKey(c)) {
                indexMap.put(c, new ArrayList<>());
            }
            indexMap.get(c).add(i);

        }

        int tp = 0;
        int sp = 0;
        List<Integer> indexli;
        while (tp < tlength) {
            char tchar = target.charAt(tp);
            if (!indexMap.containsKey(tchar)) {
                return -1;
            }
            indexli = indexMap.get(tchar);
            int k = Collections.binarySearch(indexli, sp);
            if (k < 0) {
                k = -k - 1;

            } 
            if (k == indexli.size()) {
                count++;
                sp = 0;
            }
            else {
                sp = indexli.get(k);
                sp++;
                tp++;
            }

        }

        return count;
    }
} 