class Twitter {
    int count;
    Map<Integer, List<int[]>> tweets;
    Map<Integer, Set<Integer>> follows;


    public Twitter() {
        count = 0;
        tweets = new HashMap<>();
        follows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count--, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        follows.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for (int followId: follows.get(userId)){
            if (tweets.containsKey(followId)){
                List<int[]> followTweets = tweets.get(followId);
                int last = followTweets.size() - 1;
                int[] tweet = followTweets.get(last);
                minHeap.offer(new int[]{tweet[0], tweet[1], followId, last});
            }
        }

        while (!minHeap.isEmpty() && res.size() < 10){
            int[] post = minHeap.poll();
            res.add(post[1]);
            int last = post[3];
            if (last > 0){
                int[] tweet = tweets.get(post[2]).get(last - 1);
                minHeap.offer(new int[]{tweet[0], tweet[1], post[2], last - 1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)){
            follows.get(followerId).remove(followeeId);
        }
    }
}
