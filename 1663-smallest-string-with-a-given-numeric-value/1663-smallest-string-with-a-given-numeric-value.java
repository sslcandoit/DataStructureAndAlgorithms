class Solution {
    public String getSmallestString(int n, int k) {
        int z = (k - n) / 25, r = (k - n) % 25;
        return (z == n ? "" : "a".repeat(n - z - 1) + (char)('a' + r)) + "z".repeat(z);
        /*
        int d=(k-n-1)/25, m=(k-n-1)%25;
        return "a".repeat(n-d-1)+(char)('a'+m+1)+"z".repeat(d);
        */
    }
}