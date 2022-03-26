package model.screen;

import controller.Controller;
import model.base.Locator;
import model.base.MobileItem;

public class Map extends Controller {

    private final MobileItem SEARCH_FIELD = new MobileItem(
            "Search field",
            Locator.ID,
            "com.google.android.apps.maps:id/search_omnibox_text_box");

    private final MobileItem LOCATION_BUTTON = new MobileItem(
            "LOcation button",
            Locator.ID,
            "com.google.android.apps.maps:id/mylocation_button");

    public Map onDisplay() {
        verifyItem(SEARCH_FIELD);
        return this;
    }

    public Map setLondon() {
        setGeo(51.50, -0.118);
        click(LOCATION_BUTTON);
        getPermissionsGEO();
        return this;
    }

    public Map goToSearch() {
        click(SEARCH_FIELD);
        new Search().onDisplay();
        return this;
    }

    public Map verifySuggestion(String placeName) {
        MobileItem item = new MobileItem(
                "Suggestion: '" + placeName + "'",
                Locator.XPATH,
                "//android.widget.LinearLayout[@resource-id='com.google.android.apps.maps:id/business_place_card']//android.widget.TextView[contains(@content-desc, '" + placeName + "')]");
        verifyItem(item);
        return this;
    }

}
