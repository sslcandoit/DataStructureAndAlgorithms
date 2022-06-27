class Solution {
    public int reachNumber(int target) {
        target=Math.abs(target);
        int move=0, sum=0;
        while(sum<target){
            move++;
            sum+=move;
        }
        while((sum-target)%2 ==1){
            move++;
            sum+=move;
        }
        return move;
    }
    /*   
      1+2+3=6   6-4=2 target=4
    -----------0---1------3--- 4------6
                  1th    2th         3th
     因为差值2是1的2倍，意味我们可以把第一步修改为朝左走，则可以达到目标
    --------1---0---1--------- 4        6
           1th     2th        3th
     因为-1这里先是到达-1，然后再跨过-1，需要减两次，这也就是为什么差值必须是偶数的原因         
                  
         1+2+3=6 target=5 6-5=1
    ------------0-----------------5
    这里差值是奇数1，意味着无法修改任何前面一步，所以只能继续向右找找出偶数差值
    */
}