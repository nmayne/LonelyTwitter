package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

/**
 * Created by nicholasmayne on 2017-10-17.
 */

public class EditTweetActivityTest extends ActivityInstrumentationTestCase2<EditTweetActivity> {

    private Solo solo;

    public EditTweetActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.EditTweetActivity.class);
    }


    /**
     * Runs beofre starting the tests
     * @throws Exception
     */
    @Override
    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity());
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
