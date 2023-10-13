public class RangedWeapon extends Weapon {

    private int remainingShots;

    public RangedWeapon(String fullName, String shortName,int damage, int totalShots) {
        super(fullName, shortName, damage);
        remainingShots = totalShots;
    }


    public boolean canUse() {
        return remainingShots > 0;
    }

    public void use() {
        if (canUse()) {
            remainingShots--;
        }
    }

    public int getRemainingShots() {
        return remainingShots;
    }
}
