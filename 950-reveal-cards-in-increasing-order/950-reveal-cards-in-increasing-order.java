class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int m=deck.length;
        Arrays.sort(deck);
        Deque<Integer> deque=new ArrayDeque<>();
        
        for(int i=m-1; i>=0; i--){
            if(!deque.isEmpty()) deque.addFirst(deque.pollLast());
            deque.addFirst(deck[i]);
        }
        int[] ans=new int[m];
        int i=0;
        while(!deque.isEmpty()) ans[i++]=deque.pollFirst();
        return ans;
    }//deck: [2,3,5,7,11,13,17]
}