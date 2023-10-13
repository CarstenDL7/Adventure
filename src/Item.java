public class Item {

    private String fullName;
    private String shortName;

    public Item(String fullName, String shortName)
    {
        this.fullName = fullName;
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return getFullName();
    }

    public String getFullName()
    {
        return fullName;
    }

    public String getShortName()
    {
        return shortName;
    }



}
