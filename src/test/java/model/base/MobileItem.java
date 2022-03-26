package model.base;


public class MobileItem {

    private final String name;
    private final String locatorType;
    private final String locatorBody;

    public MobileItem(String name, String locatorType, String locatorBody) {
        this.name = name;
        this.locatorType = locatorType;
        this.locatorBody = locatorBody;
    }

    public String getName() {
        return name;
    }

    public String getLocatorType() {
        return locatorType;
    }

    public String getLocatorBody() {
        return locatorBody;
    }


}
