package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.ui.data.AppElement.addClaimButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.cancelButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.cancelFilterButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.cancelledFilter;
import static ru.iteco.fmhandroid.ui.data.AppElement.claimScreen;
import static ru.iteco.fmhandroid.ui.data.AppElement.dateInput;
import static ru.iteco.fmhandroid.ui.data.AppElement.descriptionInput;
import static ru.iteco.fmhandroid.ui.data.AppElement.editClaimButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.executedFilter;
import static ru.iteco.fmhandroid.ui.data.AppElement.executorInput;
import static ru.iteco.fmhandroid.ui.data.AppElement.filterButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.inProgressFilter;
import static ru.iteco.fmhandroid.ui.data.AppElement.openFilter;
import static ru.iteco.fmhandroid.ui.data.AppElement.saveButton;
import static ru.iteco.fmhandroid.ui.data.AppElement.timeInput;
import static ru.iteco.fmhandroid.ui.data.AppElement.titleInput;
import static ru.iteco.fmhandroid.ui.data.AppElement.titleView;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)

public class ClaimScreenTest {

    AuthTest auth = new AuthTest();

    @Before
    public void validAuth() {
        auth.loadAuthPage();
        auth.checkAuthScreenElements();

        auth.validAuth();
    }

    @Test
    public void addValidClaim() {
        addClaimButton.check(matches(isDisplayed()));
        addClaimButton.perform(click());

        titleInput.check(matches(isDisplayed()));
        titleInput.perform(typeText("Претензия1Претензия2Претензия3Претензия4Претензия5"));

        executorInput.perform(click());

        dateInput.perform(typeText("10.10.2023"));

        timeInput.perform(typeText("10:10"));

        descriptionInput.perform(typeText("Описание1234567890!№%:,.;description"));

        saveButton.perform(click());

        claimScreen.check(matches(isDisplayed()));
        claimScreen.check(matches(withText("Претензия1Претензия2Претензия3Претензия4Претензия5")));
    }

    @Test
    public void addClaimWithoutTitle() {
        addClaimButton.check(matches(isDisplayed()));
        addClaimButton.perform(click());

        titleInput.check(matches(isDisplayed()));

        executorInput.perform(click());

        dateInput.perform(typeText("10.10.2023"));

        timeInput.perform(typeText("10:10"));

        descriptionInput.perform(typeText("Описание1234567890!№%:,.;description"));

        saveButton.perform(click());

        titleInput.check(matches(hasErrorText("Заполните пустое поле")));
    }

    @Test
    public void addClaimWithoutDate() {
        addClaimButton.check(matches(isDisplayed()));
        addClaimButton.perform(click());

        titleInput.check(matches(isDisplayed()));
        titleInput.perform(typeText("Претензия1Претензия2Претензия3Претензия4Претензия5"));

        executorInput.perform(click());

        timeInput.perform(typeText("10:10"));

        descriptionInput.perform(typeText("Описание1234567890!№%:,.;description"));

        saveButton.perform(click());

        dateInput.check(matches(hasErrorText("Заполните пустое поле")));
    }

    @Test
    public void addClaimWithoutTime() {
        addClaimButton.check(matches(isDisplayed()));
        addClaimButton.perform(click());

        titleInput.check(matches(isDisplayed()));
        titleInput.perform(typeText("Претензия1Претензия2Претензия3Претензия4Претензия5"));

        executorInput.perform(click());

        dateInput.perform(typeText("10.10.2023"));

        descriptionInput.perform(typeText("Описание1234567890!№%:,.;description"));

        saveButton.perform(click());

        timeInput.check(matches(hasErrorText("Заполните пустое поле")));
    }

    @Test
    public void addClaimWithoutDescription() {
        addClaimButton.check(matches(isDisplayed()));
        addClaimButton.perform(click());

        titleInput.check(matches(isDisplayed()));
        titleInput.perform(typeText("Претензия1Претензия2Претензия3Претензия4Претензия5"));

        executorInput.perform(click());

        dateInput.perform(typeText("10.10.2023"));

        timeInput.perform(typeText("10:10"));

        saveButton.perform(click());

        descriptionInput.check(matches(hasErrorText("Заполните пустое поле")));
    }

    @Test
    public void addClaimWithoutExecutor() {
        addClaimButton.check(matches(isDisplayed()));
        addClaimButton.perform(click());

        titleInput.check(matches(isDisplayed()));
        titleInput.perform(typeText("Претензия1Претензия2Претензия3Претензия4Претензия5"));

        dateInput.perform(typeText("10.10.2023"));

        timeInput.perform(typeText("10:10"));

        descriptionInput.perform(typeText("Описание1234567890!№%:,.;description"));

        saveButton.perform(click());

        claimScreen.check(matches(isDisplayed()));
        claimScreen.check(matches(withText("Претензия1Претензия2Претензия3Претензия4Претензия5")));
    }

    @Test
    public void cancelCreatingClaim() {
        addClaimButton.check(matches(isDisplayed()));
        addClaimButton.perform(click());

        titleInput.check(matches(isDisplayed()));
        titleInput.perform(typeText("Претензия1Претензия2Претензия3Претензия4Претензия5"));

        executorInput.perform(click());

        dateInput.perform(typeText("10.10.2023"));

        timeInput.perform(typeText("10:10"));

        descriptionInput.perform(typeText("Описание1234567890!№%:,.;description"));

        cancelButton.perform(click());

        claimScreen.check(matches(isDisplayed()));
    }

    @Test
    public void editOpenClaim() {
        editClaimButton.perform(click());

        titleInput.check(matches(isDisplayed()));
        titleInput.perform(clearText());
        titleInput.perform(typeText("1234567890"));

        saveButton.perform(click());

        titleView.check(matches(withText("1234567890")));
    }

    @Test
    public void openFilterAndCancel() {
        filterButton.perform(click());
        openFilter.perform(click());
        cancelFilterButton.perform(click());

        claimScreen.check(matches(isDisplayed()));
    }

    @Test
    public void inProgressFilterAndCancel() {
        filterButton.perform(click());
        inProgressFilter.perform(click());
        cancelFilterButton.perform(click());

        claimScreen.check(matches(isDisplayed()));
    }

    @Test
    public void executedFilterAndCancel() {
        filterButton.perform(click());
        executedFilter.perform(click());
        cancelFilterButton.perform(click());

        claimScreen.check(matches(isDisplayed()));
    }

    @Test
    public void cancelledFilterAndCancel() {
        filterButton.perform(click());
        cancelledFilter.perform(click());
        cancelFilterButton.perform(click());

        claimScreen.check(matches(isDisplayed()));
    }
}
