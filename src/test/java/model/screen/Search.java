package model.screen;

import controller.Controller;
import model.base.Locator;
import model.base.MobileItem;

public class Search extends Controller {

    private final MobileItem SEARCH_EDIT_TEXT = new MobileItem(
            "Search edit test",
            Locator.ID,
            "com.google.android.apps.maps:id/search_omnibox_edit_text");

    public void onDisplay() {
        waitElement(SEARCH_EDIT_TEXT);
    }

    public void search(String text) {
        enterText(SEARCH_EDIT_TEXT, text);
    }

}
