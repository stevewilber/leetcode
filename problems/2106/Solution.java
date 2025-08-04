//options: [startPos - k, k], [startPos-k/3, startPos+k/3], [startPos, startPos+k]
//[startPos - x, startPos + k - x]
//left and then right, right and then left
class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        Map<Integer, Integer> fruitsMap = new HashMap<>(); //fruit_position:fruit_amount
        for(int[] fruit : fruits) {
            fruitsMap.put(fruit[0], fruit[1]);
        }

        //create a prefix array around startPos
        int[] totalFruits = new int[k * 2 + 1];
        totalFruits[k] = fruitsMap.getOrDefault(startPos, 0);
        for (int i = k - 1; i >= 0; i--) {
            totalFruits[i] = totalFruits[i+1] + fruitsMap.getOrDefault(startPos - (k - i), 0);
        }
        for(int i = k + 1; i < totalFruits.length; i++) {
            totalFruits[i] = totalFruits[i-1] + fruitsMap.getOrDefault(startPos + i - k, 0);
        }

        int maxFruits = 0;

        //go right by i steps first
        for(int i = 0; i <= k/3; i++) {
            int left = i * 2;
            int right = k + i;
            int f = right == k ? //avoid double counting the fruits at k
                totalFruits[left] : 
                totalFruits[left] + totalFruits[right] - totalFruits[k];
            maxFruits = Math.max(f, maxFruits);
        }

        //go left by i steps first 
        for (int i = 0; i <= k/3; i++) {
            int left = k - i;
            int right = 2*k - 2*i;
            int f = left == k ? //avoid double counting the fruits at k
                totalFruits[right] : 
                totalFruits[left] + totalFruits[right] - totalFruits[k];
            maxFruits = Math.max(f, maxFruits);
        }

        return maxFruits;
    }
}