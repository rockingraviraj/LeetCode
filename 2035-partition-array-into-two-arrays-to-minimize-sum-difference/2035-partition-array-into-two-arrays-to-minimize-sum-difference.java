class Solution {

    public int minimumDifference(int[] nums) {

        int n = nums.length;
        int half = n / 2;

        int total = 0;
        for(int x : nums) {
            total += x;
        }

        List<Integer>[] left = new ArrayList[half + 1];
        List<Integer>[] right = new ArrayList[half + 1];

        for(int i = 0; i <= half; i++) {
            left[i] = new ArrayList<>();
            right[i] = new ArrayList<>();
        }

        solve(nums, 0, half, 0, 0, left);
        solve(nums, half, n, 0, 0, right);

        for(int i = 0; i <= half; i++) {
            Collections.sort(right[i]);
        }

        int mini = Integer.MAX_VALUE;

        for(int cnt = 0; cnt <= half; cnt++) {

            int need = half - cnt;

            for(int s1 : left[cnt]) {

                int target = total / 2 - s1;

                List<Integer> list = right[need];

                int low = 0;
                int high = list.size() - 1;

                while(low <= high) {

                    int mid = low + (high - low) / 2;

                    if(list.get(mid) < target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

                if(low < list.size()) {
                    int s2 = list.get(low);
                    int diff = Math.abs(total - 2 * (s1 + s2));
                    mini = Math.min(mini, diff);
                }

                if(high >= 0) {
                    int s2 = list.get(high);
                    int diff = Math.abs(total - 2 * (s1 + s2));
                    mini = Math.min(mini, diff);
                }
            }
        }

        return mini;
    }

    private void solve(int[] nums, int index, int end,
                       int count, int sum,
                       List<Integer>[] list) {

        if(index == end) {
            list[count].add(sum);
            return;
        }

        // include
        solve(nums, index + 1, end,
              count + 1, sum + nums[index], list);

        // exclude
        solve(nums, index + 1, end,
              count, sum, list);
    }
}