class Solution {
    public boolean isPalindrome(String s) {
        // have 2 pointers left and right
        // case 1 - if both are alpha numeric and they dont match - R -> F
        // case 2 - if one of them non alphanumeric then decrement
        // pointer pointing to non alphanumeric char

        int n = s.length();
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            char cl = s.charAt(left);
            char cr = s.charAt(right);

            if (!Character.isLetterOrDigit(cl)) {
                left += 1;
                continue;
            }

            if (!Character.isLetterOrDigit(cr)) {
                right -= 1;
                continue;
            }

            if (Character.toLowerCase(cl) != Character.toLowerCase(cr)) 
                return false;

            left += 1;
            right -= 1;
        }

        return true;
    }
}
