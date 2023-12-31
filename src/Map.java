public class Map {

    private Room startingRoom;

    public Map() {

        Room room1 = new Room("Room 1", "Room 1");
        Room room2 = new Room("Room 2", "Room 2");
        Room room3 = new Room("Room 3", "Room 3");
        Room room4 = new Room("Room 4", "Room 4");
        Room room5 = new Room("Room 5", "Room 5");
        Room room6 = new Room("Room 6", "Room 6");
        Room room7 = new Room("Room 7", "Room 7");
        Room room8 = new Room("Room 8", "Room 8");
        Room room9 = new Room("Room 9", "Room 9");

        Enemy kingTut = new Enemy("Mummy","The Mummy of the ancient King Ramesess!", 25, new Weapon("The Ancient Sword of the Pharaoh", "Sword", 40));

        room1.setEast(room2);
        room1.setSouth(room4);

        room2.addItemToRoom(new RangedWeapon("An old Colt revolver", "Revolver", 25, 6));
        room2.setWest(room1);
        room2.setEast(room3);

        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.addEnemyToRoom(kingTut);
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

        startingRoom = room1;

    }

    public Room getStartingRoom() {
        return startingRoom;
    }

}
