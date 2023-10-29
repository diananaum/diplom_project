package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.hasLinks;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.ui.data.AppElement.aboutButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.aboutPage;
import static ru.iteco.fmhandroid.ui.data.AppElement.menuButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.privacyPolicyLink;
import static ru.iteco.fmhandroid.ui.data.AppElement.termsOfUseLink;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.AppElement;
import ru.iteco.fmhandroid.ui.data.Data;

@RunWith(AndroidJUnit4.class)

public class AboutScreenTest {
    Data data = new Data();

    @Before
    public void validAuth() {
        ViewInteraction login = onView(withId(R.id.login_text_input_layout));
        ViewInteraction pass = onView(withId(R.id.password_text_input_layout));
        ViewInteraction signInButton = onView(withId(R.id.enter_button));

        login.check(matches(isDisplayed()));
        login.perform(replaceText(data.validLogin));

        pass.check(matches(isDisplayed()));
        pass.perform(replaceText(data.validPass));

        signInButton.check(matches(isDisplayed()));
        signInButton.perform(click());
    }

    @Test
    public void privacyPolicyShouldHaveLink() {
        menuButton.check(matches(isDisplayed()));
        menuButton.perform(click());

        aboutButton.check(matches(isDisplayed()));
        aboutButton.perform(click());

        aboutPage.check(matches(isDisplayed()));

        privacyPolicyLink.check(matches(hasLinks()));
    }

    @Test
    public void termsOfUseShouldHaveLink() {
        menuButton.check(matches(isDisplayed()));
        menuButton.perform(click());

        aboutButton.check(matches(isDisplayed()));
        aboutButton.perform(click());

        aboutPage.check(matches(isDisplayed()));

        termsOfUseLink.check(matches(hasLinks()));
    }
}
