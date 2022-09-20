class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] in=Arrays.stream(arr).boxed().toArray(Integer[]::new);
        
        Arrays.sort(in, (a, b)-> Integer.bitCount(a)==Integer.bitCount(b)? a-b : Integer.bitCount(a)-Integer.bitCount(b));
        
        return Arrays.stream(in).mapToInt(i -> i).toArray();  
    }
}