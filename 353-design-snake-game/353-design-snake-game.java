class SnakeGame {
    Set<Integer> set;
    Deque<Integer> deque;
    int score;
    int foodIndex;
    int[][] food;
    int width;
    int height;
    
    public SnakeGame(int width, int height, int[][] food) {
        this.set=new HashSet<>();
        set.add(0);
        this.deque=new LinkedList<>();
        deque.offerLast(0);
        this.food=food;
        this.foodIndex=0;
        this.score=0;
        this.width=width;
        this.height=height;
    }
    public int move(String direction) {
        
        int rowHead=deque.peekFirst()/width;
        int colHead=deque.peekFirst()%width;
        
        switch(direction){
            case "U": rowHead--;
                break;
            case "D": rowHead++;
                break;
            case "L": colHead--;
                break;
            default: colHead++;
        }
        
        int head=rowHead*width+colHead;
        set.remove(deque.peekLast());
        if(rowHead<0 || rowHead==height || colHead<0 || colHead==width || set.contains(head)) return -1;
        
        set.add(head);
        deque.offerFirst(head);
        if(foodIndex<food.length && rowHead==food[foodIndex][0] && colHead==food[foodIndex][1]){
            foodIndex++;
            score++;
            set.add(deque.peekLast());
            return score;
        }
        
        deque.pollLast();
        return score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */