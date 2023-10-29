package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.ui.data.AppElement.login;
import static ru.iteco.fmhandroid.ui.data.AppElement.mainScreen;
import static ru.iteco.fmhandroid.ui.data.AppElement.pass;
import static ru.iteco.fmhandroid.ui.data.AppElement.signInButton;
import static ru.iteco.fmhandroid.ui.data.Data.validLogin;
import static ru.iteco.fmhandroid.ui.data.Data.validPass;
import static ru.iteco.fmhandroid.ui.test.SplashScreenTest.elementWaiting;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@RunWith(AndroidJUnit4.class)

public class AuthTest {

    public void loadAuthPage() {
        elementWaiting(withId(R.id.enter_button), 5000);
    }

    public void checkAuthScreenElements() {
        login.check(matches(isDisplayed()));
        pass.check(matches(isDisplayed()));
        signInButton.check(matches(isDisplayed()));
    }

    @Test
    public void validAuth() {
        loadAuthPage();
        checkAuthScreenElements();

        login.perform(replaceText(validLogin));

        pass.perform(replaceText(validPass));

        signInButton.perform(click());

        mainScreen.check(matches(isDisplayed()));
    }

    @Test
    public void registeredWithWrongPass() {
        loadAuthPage();
        checkAuthScreenElements();

        login.perform(replaceText(validLogin));

        pass.perform(typeText("password"));

        signInButton.perform(click());

        mainScreen.check(matches(withText("Неверный логин или пароль")));
    }

    @Test
    public void invalidAuth() {
        loadAuthPage();
        checkAuthScreenElements();

        login.perform(typeText("login"));

        pass.perform(typeText("password"));

        signInButton.perform(click());

        mainScreen.check(matches(withText("Неверный логин или пароль")));
    }

    @Test
    public void emptyLogin() {
        loadAuthPage();
        checkAuthScreenElements();

        login.check(matches(isDisplayed()));

        pass.perform(typeText("password2"));

        signInButton.perform(click());

        mainScreen.check(matches(withText("Логин и пароль не могут быть пустыми")));
    }

    @Test
    public void emptyPass() {
        loadAuthPage();
        checkAuthScreenElements();


        login.perform(typeText("login2"));

        signInButton.perform(click());

        mainScreen.check(matches(withText("Логин и пароль не могут быть пустыми")));
    }
}
