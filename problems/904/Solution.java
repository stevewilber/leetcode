class Solution {
    //each basket can hold one type of fruit, but as many of that type as we find
    //return maximum # of fruit
    public int totalFruit(int[] fruits) {
        int fruitCount = 0;
        int maxFruitCount = 0;
        Map<Integer, Integer> baskets = new HashMap<>(); //fruit type: quantity

        for(int left = 0, right = 0; right < fruits.length; right++) {
            int rightFruit = fruits[right];
            while(baskets.size() == 2 & !baskets.containsKey(rightFruit)) {
                //no room for this fruit
                int leftFruit = fruits[left];
                int leftCount = baskets.get(leftFruit);
                if (leftCount == 1) {
                    baskets.remove(leftFruit);
                } else {
                    baskets.put(leftFruit, leftCount - 1);
                }
                left++;
                fruitCount--;
            }

            int rightCount = baskets.getOrDefault(rightFruit, 0);
            baskets.put(rightFruit, rightCount + 1);
            fruitCount++;
            maxFruitCount = Math.max(maxFruitCount, fruitCount);
        }

        return maxFruitCount;
    }
}