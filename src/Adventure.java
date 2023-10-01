import java.util.Scanner;

public class Adventure {

    private Room currentRoom;

    public Adventure() {

        Room room1 = new Room("Room 1", "Room 1");
        Room room2 = new Room("Room 2", "Room 2");
        Room room3 = new Room("Room 3", "Room 3");
        Room room4 = new Room("Room 4", "Room 4");
        Room room5 = new Room("Room 5", "Room 5");
        Room room6 = new Room("Room 6", "Room 6");
        Room room7 = new Room("Room 7", "Room 7");
        Room room8 = new Room("Room 8", "Room 8");
        Room room9 = new Room("Room 9", "Room 9");

        room1.setEast(room2);
        room1.setSouth(room4);

        room2.setWest(room1);
        room2.setEast(room3);

        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);

        room9.setNorth(room6);
        room9.setWest(room8);


        currentRoom = room1;

    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome to the Adventure Game!");
        System.out.println(currentRoom.getRoomDescription());

        while (true) {
            System.out.print("> ");
            input = scanner.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Exiting Adventure Game");
                break;
            } else if (input.equals("help")) {
                System.out.println("Available commands to use: 'look', 'go (direction)', 'help', 'exit'");
            } else if (input.equals("look")) {
                System.out.println(currentRoom.getRoomDescription());
            } else if (input.contains("north") || input.contains("west") || input.contains("south") || input.contains("east")) {
                String Direction = null;

                if (input.contains("north")) {
                    Direction = "north";
                }
                if (input.contains("west")) {
                    Direction = "west";
                }
                if (input.contains("south")) {
                    Direction = "south";
                }
                if (input.contains("east")) {
                    Direction = "east";
                }

                Room nextRoom = currentRoom.getRoomInDirection(Direction);
                if (nextRoom != null) {
                    currentRoom = nextRoom;
                    System.out.println("You go " + Direction + ".");
                    System.out.println(currentRoom.getRoomDescription());
                } else {
                    System.out.println("You cannot go that way.");
                }

            } else {
                System.out.println("Invalid command. Type 'help' for a list of available commands");
            }
        }
    }
}


