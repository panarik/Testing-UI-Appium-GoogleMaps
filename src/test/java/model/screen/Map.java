package model.screen;

import controller.Controller;
import io.qameta.allure.Step;
import model.base.Locator;
import model.base.MobileItem;

/**
 * Map screen.
 */
public class Map extends Controller {

    private final MobileItem SEARCH_FIELD = new MobileItem(
            "Search field",
            Locator.ID,
            "com.google.android.apps.maps:id/search_omnibox_text_box");

    private final MobileItem LOCATION_BUTTON = new MobileItem(
            "Location button",
            Locator.ID,
            "com.google.android.apps.maps:id/mylocation_button");

    /**
     * Verify current screen is open and loaded.
     *
     * @return
     */
    @Step("Map screen has open.")
    public Map onDisplay() {
        log.info("Map screen has open.");
        verifyItem(SEARCH_FIELD);
        return this;
    }

    @Step("Set location to London.")
    public Map setLondon() {
        log.info("Set location to London.");
        setGeo(51.50, -0.118);
        click(LOCATION_BUTTON);
        getPermissionsGEO();
        return this;
    }

    @Step("Go to search.")
    public Map goToSearch() {
        log.info("Go to search.");
        click(SEARCH_FIELD);
        new Search().onDisplay();
        return this;
    }

    @Step("Verify suggestions with '{placeName}'.")
    public Map verifySuggestion(String placeName) {
        log.info("Verify suggestions with '" + placeName + "'.");
        MobileItem item = new MobileItem(
                "Suggestion: '" + placeName + "'",
                Locator.XPATH,
                "//android.widget.LinearLayout[@resource-id='com.google.android.apps.maps:id/business_place_card']//android.widget.TextView[contains(@content-desc, '" + placeName + "')]");
        verifyItem(item);
        return this;
    }

}
