package fr.android.androidexercises;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.assertj.android.api.Assertions.*;

@RunWith(CustomRobolectricTestRunner.class)
public class JUnitLoginActivityTest {

    LoginActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(LoginActivity.class);
    }

    @Test
    public void should_set_logged_state() throws Exception {
        // given
        // when
        activity.logged();

        // then
        assertThat(activity.loginLayout).isGone();
        assertThat(activity.loggedText).isVisible();
    }

    @Test
    public void should_set_not_logged_state() throws Exception {
        // given
        // when
        activity.notLogged();

        // then
        assertThat(activity.loginLayout).isVisible();
        assertThat(activity.loggedText).isGone();
    }

}