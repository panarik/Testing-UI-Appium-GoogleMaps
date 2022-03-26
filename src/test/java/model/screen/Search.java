package model.screen;

import controller.Controller;
import io.qameta.allure.Step;
import model.base.Locator;
import model.base.MobileItem;

/**
 * Search screen.
 */
public class Search extends Controller {

    private final MobileItem SEARCH_EDIT_TEXT = new MobileItem(
            "Search edit test",
            Locator.ID,
            "com.google.android.apps.maps:id/search_omnibox_edit_text");

    /**
     * Verify current screen is open and loaded.
     *
     * @return
     */
    @Step("Search screen has open.")
    public Search onDisplay() {
        log.info("Search screen has open.");
        verifyItem(SEARCH_EDIT_TEXT);
        return this;
    }

    @Step("Searching '{text}'.")
    public Search search(String text) {
        log.info("Searching '" + text + "'.");
        enterText(SEARCH_EDIT_TEXT, text);
        return this;
    }

    /**
     * Choose first suggestion from list.
     *
     * @return
     */
    @Step("Pick first suggestion from list.")
    public Search pickFirstSuggestion() {
        log.info("Pick first suggestion from list.");
        MobileItem item = new MobileItem(
                "First suggestion",
                Locator.XPATH,
                "//android.support.v7.widget.RecyclerView[@resource-id='com.google.android.apps.maps:id/typed_suggest_container']/\t\n" +
                        "android.widget.LinearLayout[1]");
        click(item);
        new Map().onDisplay();
        return this;
    }

}
