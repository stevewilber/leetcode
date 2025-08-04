class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int earliestFinish = Integer.MAX_VALUE;
        //for each land ride find earliest finish time after water
        for (int i = 0; i < landStartTime.length; i++) {
            int landFinish = landStartTime[i] + landDuration[i];
            for (int j = 0; j < waterStartTime.length; j++) {
                if (waterStartTime[j] <= landFinish) {
                    earliestFinish = Math.min(earliestFinish, landFinish + waterDuration[j]);
                } else {
                    earliestFinish = Math.min(earliestFinish, waterStartTime[j] + waterDuration[j]);
                }
            }
        }

        for (int i = 0; i < waterStartTime.length; i++) {
            int waterFinish = waterStartTime[i] + waterDuration[i];
            for (int j = 0; j < landStartTime.length; j++) {
                if (landStartTime[j] <= waterFinish) {
                    earliestFinish = Math.min(earliestFinish, waterFinish + landDuration[j]);
                } else {
                    earliestFinish = Math.min(earliestFinish, landStartTime[j] + landDuration[j]);
                }
            }
        }

        return earliestFinish;
    }
}
