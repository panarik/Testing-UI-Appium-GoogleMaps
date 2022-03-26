package model.screen;

import controller.Controller;
import model.base.Locator;
import model.base.MobileItem;

public class Map extends Controller {

    private final MobileItem SEARCH_FIELD = new MobileItem(
            "Search field",
            Locator.ID,
            "com.google.android.apps.maps:id/search_omnibox_text_box");

    public Map goToSearch() {
        click(SEARCH_FIELD);
        new Search().onDisplay();
        return this;
    }

}
