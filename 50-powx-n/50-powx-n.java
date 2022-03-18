class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        else if(n>0) return pow(x, n);
        else return 1/pow(x, n);
    }
    private double pow(double x, int n){
        if(n==0) return 1;
        double y=pow(x, n/2);
        if(n%2==0) return y*y;
        else return x*y*y;
    }
}