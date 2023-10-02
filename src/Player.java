public class Player {

    private Room currentRoom;

    public Player(Room currentroom) {
        this.currentRoom = currentroom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room updateCurrentRoom(Room newRoom){
        this.currentRoom = newRoom;
        return currentRoom;
    }

    public void movePlayer(String Direction) {


        Room nextRoom = getCurrentRoom().getRoomInDirection(Direction);
        if (nextRoom != null) {
            updateCurrentRoom(nextRoom);
            UserInterface.printMessage("You go " + Direction + ".");
            UserInterface.printMessage(getCurrentRoom().getRoomDescription());
        } else {
            UserInterface.printMessage("You cannot go that way.");
        }

            nextRoom = currentRoom.getRoomInDirection(Direction);

            if (nextRoom != null) {
                currentRoom = nextRoom;
            }

        }
    }

