package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.action.ViewActions.click;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import static ru.iteco.fmhandroid.ui.data.AppElement.addClaimButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.allNewsButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.createClaimScreen;
import static ru.iteco.fmhandroid.ui.data.AppElement.newsScreen;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@RunWith(AndroidJUnit4.class)

public class MainScreenTest {
    AuthTest auth = new AuthTest();

    @Before
    public void validAuth() {
        auth.loadAuthPage();
        auth.checkAuthScreenElements();

        auth.validAuth();
    }

    @Test
    public void allNewsFromMainScreen() {
        allNewsButton.perform(click());

        newsScreen.check(matches(isDisplayed()));
    }

    @Test
    public void addClaimFromMainScreen() {
        addClaimButton.perform(click());

        createClaimScreen.check(matches(isDisplayed()));
    }
}
