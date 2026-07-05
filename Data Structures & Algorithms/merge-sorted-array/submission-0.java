class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int left = m - 1;
        int right = n - 1;

        while (left >= 0 && right >= 0) {
            if (nums1[left] >= nums2[right]) {
                nums1[k] = nums1[left];
                left -= 1;
            } else {
                nums1[k] = nums2[right];
                right -= 1;
            }

            k -= 1;
        }

        while (left >= 0) {
            nums1[k] = nums1[left];
            left -= 1;
            k -= 1;
        }

        while (right >= 0) {
            nums1[k] = nums2[right];
            right -= 1;
            k -= 1;
        }
    }
}