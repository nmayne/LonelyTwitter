package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by nicholasmayne on 2017-10-10.
 */

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    // add tweet to a list of tweets
    // should throw an IllegalArgumentException when one tries to add a duplicate tweet
    public void addTweet (Tweet tweet) throws IllegalArgumentException{
            tweets.add(tweet);

    }

    // delete tweet from a list of tweets
    public void deleteTweet (Tweet tweet) {
        tweets.remove(tweet);
    }

    // check if specified tweet is in the list of tweets and if it is return true, otherwise return false
    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    // return the number of tweets in tweet list
    public int getCount() {
        return tweets.size();
    }

    // get tweet method will take an index and will return the tweet at that index
    public Tweet getTweet(int idx) {
        return tweets.get(idx);
    }

    // shuffle the tweets in the list
    public void shuffleTweets() {
        Collections.shuffle(tweets);
    }

    // getTweets() -- should return a list of tweets in chronological order
    public ArrayList<Tweet> getTweets() {
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet tweet1, Tweet tweet2) {
                return tweet1.getDate().compareTo(tweet2.getDate());
            }
        });

        return tweets;
    }

//    getCount() -- should accurately count up the tweets


}
