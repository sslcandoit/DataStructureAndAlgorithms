class Leaderboard {
    Map<Integer, Integer> scores, players;
    public Leaderboard() {
        this.scores=new TreeMap<>(Collections.reverseOrder());
        this.players=new HashMap<>();
    }
    public void addScore(int playerId, int score) {
        if(!players.containsKey(playerId)){
            players.put(playerId, score);
            scores.put(score, scores.getOrDefault(score, 0)+1);
        }else{
            int oldScore=players.get(playerId);
            int newScore=oldScore+score;
            players.put(playerId, newScore);
            
            scores.put(oldScore, scores.get(oldScore)-1);
            if(scores.get(oldScore)==0) scores.remove(oldScore);
            
            scores.put(newScore, scores.getOrDefault(newScore, 0)+1);
        }
    }
    public int top(int K) {
        int sum=0;
        for(Map.Entry<Integer, Integer> entry:scores.entrySet()){
            if(entry.getValue()<=K){
                sum+=(entry.getKey()*entry.getValue());
                K-=entry.getValue();
                if(K==0) return sum;
            }else{
                sum+=(K*entry.getKey());
                return sum;
            }   
        }
        return sum;
    }
    public void reset(int playerId) {
        if(!players.containsKey(playerId)) return;
        int oldScore=players.get(playerId);
        
        players.remove(playerId);
        
        if(scores.get(oldScore)==1) scores.remove(oldScore);
        else scores.put(oldScore, scores.get(oldScore)-1);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */