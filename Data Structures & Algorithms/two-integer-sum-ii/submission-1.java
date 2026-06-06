class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // since the array is sorted
        // use two pointers left and right
        // check if left + right == target then return
        // else if left + right > target -> right--, else left++

        int n = numbers.length;
        int left = 0; 
        int right = n - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) return new int[]{left + 1, right + 1};

            if (sum > target) right -= 1;
            else left += 1;
        }

        return null;
    }

    public int[] twoSum_V1(int[] numbers, int target) {
        // Store cur element at each index in a map
        // curElement -> index
        // calculate target - num = rem
        // check if rem is in the map
        // if yes then return cur index and index from the map

        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            int rem = target - numbers[i];

            if (map.containsKey(rem)) {
                return new int[] {map.get(rem) + 1, i + 1};
            }

            map.put(numbers[i], i);
        }

        return null;
    }
}
