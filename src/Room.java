public class Room {

    private String name;
    private String roomDescription;
    private Room north;
    private Room west;
    private Room south;
    private Room east;


    public Room(String name, String roomDescription) {
        this.name = name;
        this.roomDescription = roomDescription;
    }

    public String getName() {
        return name;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getRoomInDirection(String direction) {
        switch (direction) {
            case "north":
                return north;
            case "west":
                return west;
            case "south":
                return south;
            case "east":
                return east;
            default:
                return null;

        }
    }

}
