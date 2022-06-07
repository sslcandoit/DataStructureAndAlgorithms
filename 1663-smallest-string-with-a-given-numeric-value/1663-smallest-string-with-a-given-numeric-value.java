class Solution {
    public String getSmallestString(int n, int k) {
        int d=(k-n-1)/25, m=(k-n-1)%25;
        return "a".repeat(n-d-1)+(char)('a'+m+1)+"z".repeat(d);
    }
}