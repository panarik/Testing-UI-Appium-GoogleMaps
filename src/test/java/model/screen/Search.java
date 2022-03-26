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

    public Search search(String text) {
        enterText(SEARCH_EDIT_TEXT, text);
        return this;
    }

    public Search pikFirstSuggestion(){
        MobileItem item = new MobileItem(
                "First suggestion",
                Locator.XPATH,
                "//android.support.v7.widget.RecyclerView[@resource-id='com.google.android.apps.maps:id/typed_suggest_container']/\t\n" +
                        "android.widget.LinearLayout[1]");
        click(item);
        return this;
    }

}
