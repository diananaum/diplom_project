package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.ui.data.AppElement.addNewsButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.allNewsButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.categoryNews;
import static ru.iteco.fmhandroid.ui.data.AppElement.dateNews;
import static ru.iteco.fmhandroid.ui.data.AppElement.descriptionNews;
import static ru.iteco.fmhandroid.ui.data.AppElement.newsScreen;
import static ru.iteco.fmhandroid.ui.data.AppElement.saveButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.switcherActive;
import static ru.iteco.fmhandroid.ui.data.AppElement.timeNews;
import static ru.iteco.fmhandroid.ui.data.AppElement.titleNews;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@RunWith(AndroidJUnit4.class)

public class NewsScreenTest {

    AuthTest auth = new AuthTest();

    @Before
    public void validAuth() {
        auth.loadAuthPage();
        auth.checkAuthScreenElements();

        auth.validAuth();
    }

    @Test
    public void addNews() {
        allNewsButton.perform(click());
        newsScreen.check(matches(isDisplayed()));

        addNewsButton.perform(click());
        titleNews.check(matches(isDisplayed()));

        categoryNews.perform(click());
        titleNews.perform(typeText("1234567890!#$%^&*():;@<>,./?"));
        dateNews.perform(typeText("10.10,.2023"));
        timeNews.perform(typeText("10:10"));
        descriptionNews.perform(typeText("vjdfeoiwjfqojqwnjkwvjkebavjekbjgbrnwjlw"));
        switcherActive.perform(click());

        saveButton.perform(click());
        newsScreen.check(matches(withText("1234567890!#$%^&*():;@<>,./?")));
    }
}
