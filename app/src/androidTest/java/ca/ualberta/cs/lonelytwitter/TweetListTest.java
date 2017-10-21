package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by nicholasmayne on 2017-10-10.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest() {
        super(LonelyTwitterActivity.class );
    }

    public void testAddTweet() {


        TweetList tweets = new TweetList();
        Tweet myTweet = new NormalTweet("My Tweet");
        tweets.addTweet(myTweet);

        assertTrue(tweets.hasTweet(myTweet));
    }

    public void testDeleteTweet() {

        TweetList tweets = new TweetList();
        Tweet myTweet = new NormalTweet("My Tweet");
        tweets.addTweet(myTweet);
        tweets.deleteTweet(myTweet);

        assertFalse(tweets.hasTweet(myTweet));
    }

    public void testHasTweet() {

        TweetList tweets = new TweetList();
        Tweet myTweet = new NormalTweet("My Tweet");

        assertFalse(tweets.hasTweet(myTweet));

        tweets.addTweet(myTweet);

        assertTrue(tweets.hasTweet(myTweet));
    }

    public void testGetTweet() {
    // get tweet method will take an index and will return the tweet at that index
        TweetList tweets = new TweetList();
        Tweet myTweet = new NormalTweet("My Tweet");

        tweets.addTweet(myTweet);

        assertEquals(tweets.getTweet(0).getMessage(), myTweet.getMessage());
        assertEquals(tweets.getTweet(0).getDate(), myTweet.getDate());
    }


    public void testShuffleTweets(){
        TweetList tweets = new TweetList();

        for(int i = 0; i < 25; i++) {
            Tweet myTweet = new NormalTweet(Integer.toString(i));
            tweets.addTweet(myTweet);
//            Log.i("Did this", Integer.parseInt(i));

        }

        tweets.shuffleTweets();

        for(int i = 0; i < 22; i++) {
            assertTrue("ShuffleTweets failed to shuffle the tweets",
                    (Integer.parseInt(tweets.getTweet(i).getMessage()) +
                            Integer.parseInt(tweets.getTweet(i+1).getMessage()) +
                            Integer.parseInt(tweets.getTweet(i+2).getMessage()) +
                            Integer.parseInt(tweets.getTweet(i+3).getMessage())) != ((4 * i) + 3));

        }
    }


    public void testGetTweets(){
        TweetList tweets = new TweetList();

        for(int i = 0; i < 25; i++) {
            Tweet myTweet = new NormalTweet(Integer.toString(i));
            tweets.addTweet(myTweet);
            Log.i("DateAdded", tweets.getTweet(i).getDate().toString());

        }

        tweets.shuffleTweets();

        ArrayList<Tweet> sortedTweets = tweets.getTweets();

        for(int i = 0; i < 24; i++) {
            Log.i("Date", sortedTweets.get(i).getDate().toString());
            Log.i("Date", sortedTweets.get(i+1).getDate().toString());
            assertTrue("getTweets failed return a list of sorted tweets",
                    sortedTweets.get(i).getDate().after(sortedTweets.get(i+1).getDate()));
        }
    }


    public void testGetCount(){
        TweetList tweets = new TweetList();
        for(int i = 0; i < 25; i++) {
            Tweet myTweet = new NormalTweet(Integer.toString(i));
            tweets.addTweet(myTweet);
            assertEquals("getCount did not accurately count the tweets", tweets.getCount(), i);
        }


    }
}
