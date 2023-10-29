package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import static ru.iteco.fmhandroid.ui.data.AppElement.missionList;
import static ru.iteco.fmhandroid.ui.data.AppElement.missionName;

import org.junit.Before;
import org.junit.Test;

public class MissionScreenTest {

    AuthTest auth = new AuthTest();

    @Before
    public void validAuth() {
        auth.loadAuthPage();
        auth.checkAuthScreenElements();

        auth.validAuth();
    }

    @Test
    public void checkQuote() {
        missionName.check(matches(isDisplayed()));
        missionList.check(matches(isDisplayed()));
    }
}
