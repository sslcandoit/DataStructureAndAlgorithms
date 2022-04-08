class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if(jug1Capacity+jug2Capacity<targetCapacity) return false;
        if(jug1Capacity==targetCapacity || jug2Capacity==targetCapacity || jug1Capacity+jug2Capacity==targetCapacity) return true;
    
        return targetCapacity%greatCommonDivisor(jug1Capacity, jug2Capacity) == 0;
    }
    public int greatCommonDivisor(int a, int b){
        while(b != 0 ){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;  
    }
    //找出两个的最大公约数，如果目标数是最大公约数的倍数，则可行。
}