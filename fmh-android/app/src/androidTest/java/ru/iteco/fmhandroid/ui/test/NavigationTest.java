package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import static ru.iteco.fmhandroid.ui.data.AppElement.aboutButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.aboutPage;
import static ru.iteco.fmhandroid.ui.data.AppElement.backToMenuButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.claimPage;
import static ru.iteco.fmhandroid.ui.data.AppElement.mainButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.mainScreen;
import static ru.iteco.fmhandroid.ui.data.AppElement.menuButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.claimButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.newsButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.newsPage;
import static ru.iteco.fmhandroid.ui.data.AppElement.quotesButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.quotesPage;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)

public class NavigationTest {
    AuthTest auth = new AuthTest();

    @Before
    public void validAuth() {
        auth.loadAuthPage();
        auth.checkAuthScreenElements();

        auth.validAuth();
    }

    @Test
    public void navWithMenuToClaimPage() {
        menuButton.check(matches(isDisplayed()));
        menuButton.perform(click());

        claimButton.check(matches(isDisplayed()));
        claimButton.perform(click());

        claimPage.check(matches(isDisplayed()));
    }

    @Test
    public void navWithMenuToNewsPage() {
        menuButton.check(matches(isDisplayed()));
        menuButton.perform(click());

        newsButton.check(matches(isDisplayed()));
        newsButton.perform(click());

        newsPage.check(matches(isDisplayed()));
    }

    @Test
    public void navWithMenuToAboutPage() {
        menuButton.check(matches(isDisplayed()));
        menuButton.perform(click());

        aboutButton.check(matches(isDisplayed()));
        aboutButton.perform(click());

        aboutPage.check(matches(isDisplayed()));
    }

    @Test
    public void navWithBackToMenuButtonFromAboutPage() {
        menuButton.check(matches(isDisplayed()));
        menuButton.perform(click());

        aboutButton.check(matches(isDisplayed()));
        aboutButton.perform(click());

        aboutPage.check(matches(isDisplayed()));

        backToMenuButton.check(matches(isDisplayed()));
        backToMenuButton.perform(click());

        mainScreen.check(matches(isDisplayed()));
    }

    @Test
    public void navWithMenuToMainScreen() {
        menuButton.check(matches(isDisplayed()));
        menuButton.perform(click());

        claimButton.check(matches(isDisplayed()));
        claimButton.perform(click());

        claimPage.check(matches(isDisplayed()));

        menuButton.check(matches(isDisplayed()));
        menuButton.perform(click());

        mainButton.check(matches(isDisplayed()));
        mainButton.perform(click());

        mainScreen.check(matches(isDisplayed()));
    }

    @Test
    public void navToQuotes() {
        quotesButton.perform(click());

        quotesPage.check(matches(isDisplayed()));
    }

    @Test
    public void navWithSwipe() {
        quotesButton.perform(click());
        quotesPage.check(matches(isDisplayed()));

        quotesPage.perform(swipeRight());
        mainScreen.check(matches(isDisplayed()));
    }
}
