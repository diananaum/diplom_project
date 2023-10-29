package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.Espresso.onView;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static ru.iteco.fmhandroid.ui.data.AppElement.splashImage;
import static ru.iteco.fmhandroid.ui.data.AppElement.splashProgressIndicator;
import static ru.iteco.fmhandroid.ui.data.AppElement.splashText;

import android.view.View;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;

import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.concurrent.TimeoutException;

import ru.iteco.fmhandroid.R;

public class SplashScreenTest {

    @Test
    public void checkSplashElements() {
        splashImage.check(matches(isDisplayed()));
        splashProgressIndicator.check(matches(isDisplayed()));
        splashText.check(matches(isDisplayed()));
    }

    @Test
    public void appDownload() {
        elementWaiting(withId(R.id.splashscreen_image_view), 5000);
    }

    public static ViewAction waitForElement(final Matcher matcher, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with attribute <" + matcher + "> during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher<View> viewMatcher = matcher;

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        try {
                            if (viewMatcher.matches(child)) {
                                return;
                            }
                        } catch (NoMatchingViewException e) {
                        }

                        uiController.loopMainThreadForAtLeast(100);
                    }

                }
                while (System.currentTimeMillis() < endTime);

                throw new PerformException.Builder()
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };

    }

    public static void elementWaiting(Matcher matcher, int millis) {
        onView(isRoot()).perform(waitForElement(matcher, millis));
    }
}
