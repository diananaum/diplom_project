package ru.iteco.fmhandroid.ui.data;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AppElement {
    public static ViewInteraction login = onView(withId(R.id.login_text_input_layout));
    public static ViewInteraction pass = onView(withId(R.id.password_text_input_layout));
    public static ViewInteraction signInButton = onView(withId(R.id.enter_button));
    public static ViewInteraction mainScreen = onView(withId(R.id.main_swipe_refresh));

    public static ViewInteraction menuButton = onView(withId(R.id.main_menu_image_button));
    public static ViewInteraction aboutButton = onView(allOf(withId(android.R.id.title), withText("About")));
    public static ViewInteraction aboutPage = onView(withId(R.id.about_privacy_policy_label_text_view));
    public static ViewInteraction privacyPolicyLink = onView(withId(R.id.about_privacy_policy_value_text_view));
    public static ViewInteraction termsOfUseLink = onView(withId(R.id.about_terms_of_use_value_text_view));

    public static ViewInteraction claimScreen = onView(withId(R.id.claim_list_recycler_view));
    public static ViewInteraction filterButton = onView(withId(R.id.filters_material_button));
    public static ViewInteraction openFilter = onView(withId(R.id.item_filter_open));
    public static ViewInteraction inProgressFilter = onView(withId(R.id.item_filter_in_progress));
    public static ViewInteraction executedFilter = onView(withId(R.id.item_filter_executed));
    public static ViewInteraction cancelledFilter = onView(withId(R.id.item_filter_cancelled));
    public static ViewInteraction cancelFilterButton = onView(withId(R.id.claim_filter_cancel_material_button));
    public static ViewInteraction addClaimButton = onView(withId(R.id.add_new_claim_material_button));
    public static ViewInteraction titleInput = onView(withId(R.id.title_edit_text));
    public static ViewInteraction titleView = onView(withId(R.id.title_text_view));
    public static ViewInteraction executorInput = onView(withId(R.id.executor_drop_menu_auto_complete_text_view));
    public static ViewInteraction dateInput = onView(withId(R.id.date_in_plan_text_input_edit_text));
    public static ViewInteraction timeInput = onView(withId(R.id.time_in_plan_text_input_edit_text));
    public static ViewInteraction descriptionInput = onView(withId(R.id.description_edit_text));
    public static ViewInteraction saveButton = onView(withId(R.id.save_button));
    public static ViewInteraction cancelButton = onView(withId(R.id.cancel_button));
    public static ViewInteraction editClaimButton = onView(withId(R.id.edit_processing_image_button));

    public static ViewInteraction allNewsButton = onView(withId(R.id.all_news_text_view));
    public static ViewInteraction newsScreen = onView(withId(R.id.news_list_recycler_view));
    public static ViewInteraction createClaimScreen = onView(withId(R.id.container_custom_app_bar_include_on_fragment_create_edit_claim));

    public static ViewInteraction missionName = onView((withId(R.id.our_mission_title_text_view)));
    public static ViewInteraction missionList = onView(withId(R.id.our_mission_item_list_recycler_view));

    public static ViewInteraction mainButton = onView(allOf(withId(android.R.id.title), withText("Main")));
    public static ViewInteraction claimButton = onView(allOf(withId(android.R.id.title), withText("Claims")));
    public static ViewInteraction claimPage = onView(withId(R.id.container_list_claim_include));
    public static ViewInteraction newsButton = onView(allOf(withId(android.R.id.title), withText("News")));
    public static ViewInteraction newsPage = onView(withId(R.id.all_news_cards_block_constraint_layout));
    public static ViewInteraction backToMenuButton = onView(withId(R.id.about_back_image_button));
    public static ViewInteraction quotesButton = onView(withId(R.id.our_mission_image_button));
    public static ViewInteraction quotesPage = onView(withId(R.id.our_mission_item_list_recycler_view));

    public static ViewInteraction addNewsButton = onView(withId(R.id.add_news_image_view));
    public static ViewInteraction categoryNews = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public static ViewInteraction titleNews = onView(withId(R.id.news_item_title_text_input_edit_text));
    public static ViewInteraction dateNews = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    public static ViewInteraction timeNews = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    public static ViewInteraction descriptionNews = onView(withId(R.id.news_item_description_text_input_edit_text));
    public static ViewInteraction switcherActive = onView(withId(R.id.switcher));

    public static ViewInteraction splashImage = onView(withId(R.id.splashscreen_image_view));
    public static ViewInteraction splashText = onView(withId(R.id.splashscreen_text_view));
    public static ViewInteraction splashProgressIndicator = onView(withId(R.id.splash_screen_circular_progress_indicator));
}
