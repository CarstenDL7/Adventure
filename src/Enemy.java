public class Enemy {
    private String name;
    private String description;
    private int health;
    private Weapon equippedWeapon;

    public Enemy(String name, String description, int health, Weapon equippedWeapon) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.equippedWeapon = equippedWeapon;
    }

    public int attackPlayer() {
        int damage = equippedWeapon.getDamage();

        return damage;
    }

    public String getName() {
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void hit(int damage) {
        // Implement logic to reduce enemy's health based on the damage
        if (damage > 0) {
            health -= damage;
            if (health <= 0) {
                health = 0; // Ensure health doesn't go below zero
            }
        }
    }

    public boolean isDefeated() {
        // Implement logic to check if the enemy is defeated
        return health <= 0;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }
}
