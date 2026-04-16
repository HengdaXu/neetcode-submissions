class Twitter {
    int count;
    Map<Integer, List<int[]>> tweets;
    Map<Integer, Set<Integer>> follows; // key follows value

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
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        follows.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);

        for (int fid: follows.get(userId)){
            if (tweets.containsKey(fid)){
                List<int[]> ts = tweets.get(fid);
                int index = ts.size() - 1;
                int[] tweet = ts.get(index);
                minHeap.offer(new int[]{tweet[0], tweet[1], fid, index});
            }
        }

        while (!minHeap.isEmpty() && res.size() < 10){
            int[] cur = minHeap.poll();
            res.add(cur[1]);
            int index = cur[3];
            if (index > 0){
                List<int[]> ts = tweets.get(cur[2]);
                int[] tweet = ts.get(index - 1);
                minHeap.offer(new int[]{tweet[0], tweet[1], cur[2], index - 1});
            }
        }
        return res;    
    }
    
    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }  
    }
}
