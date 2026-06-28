class Solution {
    public int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            int lsb = (n & 1);
            // make a room for current bit
            res = res << 1;
            res = res | lsb;

            n = n >>> 1;
        }

        return res;
    }
}
