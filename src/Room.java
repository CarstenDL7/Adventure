import java.util.ArrayList;

public class Room {

    private final String name;
    private final String roomDescription;
    private Room north;
    private Room west;
    private Room south;
    private Room east;

    private ArrayList<Item> itemsInRoom = new ArrayList<>();
    private ArrayList<Enemy> enemiesInRoom = new ArrayList<>();


    public Room(String name, String roomDescription) {
        this.name = name;
        this.roomDescription = roomDescription;
    }

    public String getName() {
        return name;
    }

    public String getRoomDescription() {
        StringBuilder description = new StringBuilder(roomDescription);

        // Append items in the room to the description
        if (!itemsInRoom.isEmpty())
        description.append("\nItems in the room: ");
        for (Item item : itemsInRoom) {
            description.append(item.getFullName()).append(", ");
        }


        // Append enemies in the room to the description
        if (!enemiesInRoom.isEmpty())
        description.append("\nEnemies in the room: ");
        for (Enemy enemy : enemiesInRoom) {
            description.append(enemy.getDescription()).append(", ");
        }

        return description.toString();
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

    public void addItemToRoom(Item item)
    {
        itemsInRoom.add(item);
    }

    public void removeItemFromRoom(Item item)
    {
        itemsInRoom.remove(item);
    }

    public ArrayList<Item> getItemsInRoom()
    {
        return itemsInRoom;
    }

    public Item findItemInRoom(String itemName) {
        for (Item item : itemsInRoom) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void addEnemyToRoom(Enemy enemy) {
        enemiesInRoom.add(enemy);
    }

    public void removeEnemyFromRoom(Enemy enemy) {
        enemiesInRoom.remove(enemy);
    }

    public ArrayList<Enemy> getEnemiesInRoom() {
        return enemiesInRoom;
    }

    public Enemy findEnemyInRoom(String enemyName) {
        for (Enemy enemy : enemiesInRoom) {
            if (enemy.getName().equalsIgnoreCase(enemyName)) {
                return enemy;
            }
        }
        return null;
    }

}
