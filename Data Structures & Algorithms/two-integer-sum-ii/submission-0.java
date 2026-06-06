class Solution {
    public int[] twoSum(int[] numbers, int target) {
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
