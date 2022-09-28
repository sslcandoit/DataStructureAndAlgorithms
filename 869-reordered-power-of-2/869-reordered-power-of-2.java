class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = counter(n);
        for (int i = 0; i < 32; i++)
            if (counter(1 << i).equals(target)) return true;
        return false;
    }
    public String counter(int n){
        char[] c=(n+"").toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
    /* 统计每个数字（0-9）的个数
    
    public long counter(int n) {
        long res = 0;
        for (; n > 0; n /= 10){
            res += (int)Math.pow(10, n % 10);
        } 
        return res;
    }*/
}