class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list=new ArrayList<>();
        
        for(int i=1; i<9; i++){
            int cur_digit=i;
            int num=cur_digit;
            
            while(num<=high && cur_digit<=9){
                if(num>=low) list.add(num);
                
                cur_digit++;
                num=num*10+cur_digit;
            }
        }
        Collections.sort(list);
        return list;
    }
}