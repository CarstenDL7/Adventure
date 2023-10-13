public class Weapon extends Item {
    private int damage;

    public Weapon(String fullName, String shortName, int damage) {
        super(fullName, shortName);
        this.damage = damage;

    }

    public int getDamage() {
        return damage;
    }
}


