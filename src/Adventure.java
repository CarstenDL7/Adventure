

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

            } else if (input.equals("Inventory") || input.equals("inv") || input.equals("invent")) {
                UserInterface.printMessage("Inventory:");
                for (Item item : player.showInventory()) {
                    String itemName = item.getFullName();
                    if (item == player.getEquippedWeapon()) {
                        itemName += " (equipped)";
                    }
                    UserInterface.printMessage("- " + itemName);
                }

            } else if (input.startsWith("take ")) {
                String itemName = input.substring(5).toLowerCase();
                Item itemToTake = player.getCurrentRoom().findItemInRoom(itemName);
                if (itemToTake != null) {
                    player.addItemToInventory(itemToTake);
                    player.getCurrentRoom().removeItemFromRoom(itemToTake);
                    UserInterface.printMessage("You take the " + itemToTake.getFullName() + ".");
                } else {
                    UserInterface.printMessage("There is nothing like '" + itemName + "' to take around here.");
                }
            } else if (input.startsWith("drop ")) {
                String itemName = input.substring(5).toLowerCase();
                Item itemToDrop = player.findItemInInventory(itemName);
                if (itemToDrop != null) {
                    player.removeItemFromInventory(itemToDrop);
                    player.getCurrentRoom().addItemToRoom(itemToDrop);
                    UserInterface.printMessage("You drop " + itemToDrop.getFullName() + ".");
                } else {
                    UserInterface.printMessage("You don't have '" + itemName + "' in your inventory.");
                }
            } else if (input.equals("health")) {
                String healthStatus = player.getHealthStatus();
                int currentHealth = player.getHealth();
                UserInterface.printMessage("health: " + currentHealth + " – " + healthStatus);


            } else if (input.startsWith("eat ")) {
                String foodName = input.substring(4);
                if (player.eatFood(foodName)) {
                    UserInterface.printMessage("You eat " + foodName);
                } else {
                    UserInterface.printMessage("You have no such thing as " + foodName + " to eat");
                }


            } else if (input.startsWith("equip ")) {
                String weaponName = input.substring(6);
                if (player.equipWeapon(weaponName)) {
                    UserInterface.printMessage("You have equipped " + weaponName);
                } else {
                    UserInterface.printMessage("You don't have such a weapon in your inventory.");
                }


            } else if (input.equals("inventory")) {
                UserInterface.printMessage("Inventory:");
                for (Item item : player.showInventory()) {
                    UserInterface.printMessage(item.getFullName());
                }
                if (player.getEquippedWeapon() != null) {
                    UserInterface.printMessage("Equipped weapon: " + player.getEquippedWeapon().getFullName());
                } else {
                    UserInterface.printMessage("No weapon equipped.");
                }


            } else if (input.startsWith("attack ")) {
                String targetName = input.substring(7);
                AttackResult attackResult = player.attack(targetName);

                if (attackResult.isSuccess()) {
                    UserInterface.printMessage(attackResult.getMessage());
                } else {
                    UserInterface.printMessage(attackResult.getMessage());
                }

            } else {
                UserInterface.printMessage("Invalid command. Type 'help' for a list of available commands");
            }

        }
    }
}


