class Solution {
    public int nextGreaterElement(int n) {
        char[] array=(n+"").toCharArray();
        int len=array.length;
        
        for(int i=len-2; i>=0; i--){
            if(array[i]-'0' < array[i+1]-'0'){
                int j=len-1;
                while(j>i && array[j]-'0'<=array[i]-'0') j--;
                
                swap(array, i, j);
                reverse(array, i+1, len-1);
                break;
            }
        }
        long ans=Long.parseLong(new String(array));
        if(ans>Integer.MAX_VALUE || (int)ans==n) return -1;
        return Integer.parseInt(new String(array));
    }
    private void swap(char[] array, int i, int j){
        char temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    private void reverse(char[] array, int l, int r){
        while(l<r){
            swap(array, l++, r--);
        }
    }
}