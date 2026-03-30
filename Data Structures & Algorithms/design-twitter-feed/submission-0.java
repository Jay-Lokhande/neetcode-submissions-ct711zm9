class Twitter {
    static int time = 0;
    public class Tweet {
        int id;
        int time;
        Tweet (int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    HashMap<Integer, List<Tweet>> tweets;
    HashMap<Integer, Set<Integer>> follow;

    public Twitter() {
        tweets = new HashMap<>();    
        follow = new HashMap<>();    
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );
        follow.putIfAbsent(userId, new HashSet<>());
        follow.get(userId).add(userId);

        for (int user: follow.get(userId)) {
            if (tweets.containsKey(user)) {
                pq.addAll(tweets.get(user));
            }
        }

        List<Integer> res = new ArrayList<>();
        int count = 10;
        while (!pq.isEmpty() && count-- > 0) {
            res.add(pq.poll().id);
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        follow.putIfAbsent(followerId, new HashSet<>());
        follow.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (follow.containsKey(followerId) && followerId != followeeId) {
            follow.get(followerId).remove(followeeId);
        }
    }
}
