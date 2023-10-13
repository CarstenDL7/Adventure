import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();

    private Weapon equippedWeapon;

    private int health = 100;

    public Player(Room currentroom) {
        this.currentRoom = currentroom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    private Room updateCurrentRoom(Room newRoom) {
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
    }


    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public void removeItemFromInventory(Item item) {
        inventory.remove(item);
    }

    public ArrayList<Item> showInventory() {
        return inventory;
    }

    public Item findItemInInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public boolean eatFood(String foodName) {
        for (Item item : inventory)

            if (item.getShortName().equalsIgnoreCase(foodName))
                if (item instanceof Food) {
                    inventory.remove(item);
                    increaseHealth(((Food) item).getHealthPoints());
                    return true;
                }
        return false;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public boolean equipWeapon(String weaponName) {
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(weaponName) && item instanceof Weapon) {
                equippedWeapon = (Weapon) item;
                return true;
            }
        }
        return false;
    }

    private void increaseHealth(int healthPoints) {
        this.health += healthPoints;
        if (this.health > 100) {
            this.health = 100;
        }
    }

    public void decreaseHealth(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0; // Ensure health doesn't go negative
        }
    }


    public int getHealth() {
        return health;
    }

    public String getHealthStatus() {
        int health = getHealth();
        if (health >= 75) {
            return "Your health is excellent!";
        } else if (health >= 50) {
            return "You have taken a few hits, but your health is still okay";
        } else if (health >= 25) {
            return "Your health is getting low. Be cautious!";
        } else {
            return "Your health is critically low. Eat food to recover!";
        }
    }

    public AttackResult attack(String targetName) {

        Weapon equippedWeapon = getEquippedWeapon();
        if (equippedWeapon == null) {
            String Message = "You need to equip a weapon first.";
            return new AttackResult(false, Message);
        }

        if (equippedWeapon instanceof RangedWeapon) {

            RangedWeapon rangedWeapon = (RangedWeapon) equippedWeapon;
            if (!rangedWeapon.canUse()) {
                String Message = "Your weapon is out of ammo.";
                return new AttackResult(false, Message);
            }
        }

            Enemy target = getCurrentRoom().findEnemyInRoom(targetName);
            if (target == null) {
                String Message = "There is no such enemy in the room.";
                return new AttackResult(false, Message);
            }


            int damage = equippedWeapon.getDamage();
            target.hit(damage);
            String Message = "You attack the " + targetName + " with your " + equippedWeapon.getShortName() + " and deals " + damage + " damage!";

            if (target.isDefeated()) {
                Message += " You have defeated the " + targetName + "!";
                Item enemyWeapon = target.getEquippedWeapon();
                if (enemyWeapon != null) {
                    getCurrentRoom().addItemToRoom(enemyWeapon);
                    Message += "\n" + target.getEquippedWeapon() + " has been dropped!";
                }
                getCurrentRoom().removeEnemyFromRoom(target);

            } else {
                int enemyDamage = target.attackPlayer();
                decreaseHealth(enemyDamage);
                Message +="The " + targetName + " attacks you with its " + target.getEquippedWeapon() + " and deals " + enemyDamage + " damage!";
            }

            return new AttackResult(true, Message);
        }

    }
