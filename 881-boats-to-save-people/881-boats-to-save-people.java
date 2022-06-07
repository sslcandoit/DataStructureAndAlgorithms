class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l=0, r=people.length-1, count=0;
        while(l<=r){
            if(people[r]+people[l]<=limit) l++;
            r--;
            count++;   
        }
        return count;
    }
}
//[1,2,3,3,3,5,7,8,9] 10