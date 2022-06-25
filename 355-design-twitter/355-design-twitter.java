class Twitter {
    class Tweet{
        int id, time;
        public Tweet(int id, int time){
            this.id=id;
            this.time=time;
        }
    }
    Map<Integer, Set<Integer>> followers;
    Map<Integer, List<Tweet>> tweets;
    int timeStamp;
    public Twitter() {
        this.followers=new HashMap<>();
        this.tweets=new HashMap<>();
        this.timeStamp=1;
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!followers.containsKey(userId)){
            followers.put(userId, new HashSet<>());
            followers.get(userId).add(userId);
        }
        if(!tweets.containsKey(userId)) tweets.put(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, this.timeStamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans=new ArrayList<>();
        if(!followers.containsKey(userId)) return ans;
        PriorityQueue<Tweet> pq=new PriorityQueue<>((a,b)-> b.time-a.time);
        followers.get(userId).stream()
            .filter(f -> tweets.containsKey(f))
            .forEach(f-> pq.addAll(tweets.get(f)));
        while(!pq.isEmpty() && ans.size()<10) ans.add(pq.poll().id);
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId)){
            followers.put(followerId, new HashSet<>());
            followers.get(followerId).add(followerId);
        }
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followers.get(followerId).remove(followeeId);
    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */