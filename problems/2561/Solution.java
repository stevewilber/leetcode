class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> b1 = new HashMap<>();
        Map<Integer, Integer> b2 = new HashMap<>();
        int smallestNum = Integer.MAX_VALUE;

        for (int i : basket1) {
            smallestNum = Math.min(smallestNum, i);
            int times = b1.getOrDefault(i, 0);
            b1.put(i, times + 1);
        }
        for (int i : basket2) {
            smallestNum = Math.min(smallestNum, i);
            int times = b2.getOrDefault(i, 0);
            b2.put(i, times + 1);
        }

        List<Integer> numsToMove = new ArrayList<>();
        Set<Integer> allKeys = new HashSet<>(b1.keySet());
        allKeys.addAll(b2.keySet());
        for (int key : allKeys) {
            if (b1.getOrDefault(key, 0) + b2.getOrDefault(key, 0) % 2 == 1) {
                //if there are an odd amount of any number, can't make baskets equal
                return -1;
            }

            int diff = Math.abs(b1.getOrDefault(key, 0) - b2.getOrDefault(key, 0));
            while(diff > 0) {
                numsToMove.add(key);
                diff -= 2;
            }
        }

        Collections.sort(numsToMove);

        long total = 0;
        for(int i = 0; i < numsToMove.size() / 2; i++) {
            total += (long) Math.min(numsToMove.get(i), smallestNum * 2); //if have a smaller number can move it back and forth to make swap cheaper
        }

        return total;
    }
}