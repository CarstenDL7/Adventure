

public class Adventure {

    private Player player;
    private Map gameMap;

    public Adventure() {
        this.gameMap = new Map();
        this.player = new Player(gameMap.getStartingRoom());
    }


    public void play() {

        UserInterface.printMessage("Welcome to the Adventure Game!");
        UserInterface.printMessage(player.getCurrentRoom().getRoomDescription());

        while (true) {
            String input = UserInterface.getInput("> ");

            if (input.equals("exit")) {
                UserInterface.printMessage("Exiting Adventure Game");
                break;
            } else if (input.equals("help")) {
                UserInterface.printMessage("Available commands to use: 'look', 'go (direction)', 'help', 'exit'");
            } else if (input.equals("look")) {
                UserInterface.printMessage(player.getCurrentRoom().getRoomDescription());
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

                player.movePlayer(Direction);



            } else {
                UserInterface.printMessage("Invalid command. Type 'help' for a list of available commands");
            }
        }
    }
}


