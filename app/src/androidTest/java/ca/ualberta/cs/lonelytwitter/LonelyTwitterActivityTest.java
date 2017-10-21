package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;


/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    /**
     * Runs beofre starting the tests
     * @throws Exception
     */
    @Override
    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity());
    }


    public void testStart() throws Exception {
        Activity activity = getActivity();
    }


    public void testTweet() {
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
        solo.enterText((EditText) solo.getView(R.id.body), "Tweet Tweet!");
        solo.clickOnButton("Save");

        solo.enterText((EditText) solo.getView(R.id.body), "");
        assertTrue(solo.waitForText("Tweet Tweet!"));
        solo.clickOnButton("Clear");

    }

    public void testClickTweetList(){
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body), "Tweet");
        solo.clickOnButton("Save");
        solo.enterText((EditText) solo.getView(R.id.body), "");
        solo.enterText((EditText) solo.getView(R.id.body), "TWEET2");
        solo.clickOnButton("Save");
        solo.clickInList(2);
        solo.assertCurrentActivity("Wrong Activity", EditTweetActivity.class);
        assertTrue(solo.waitForText("TWEET2"));


    }



    /**
     * Runs after the tests
     * @throws Exception
     */
    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}