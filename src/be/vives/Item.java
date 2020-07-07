package be.vives;

public abstract class Item {
    private String itemName;
    private int level;
    private String description;
    private BodyParts bodypart;
    private int dmgBonus;
    private int healthBonus;
    private ItemType weapontype;

    public Item(String itemName, String description, BodyParts bodypart, int dmgBonus, int healthBonus, int level,ItemType weapontype) {
        this.itemName = itemName;
        this.description = description;
        this.bodypart = bodypart;
        this.dmgBonus = dmgBonus;
        this.healthBonus = healthBonus;
        this.level = level;
        this.weapontype= weapontype;
    }

    public String getItemName() {
        return itemName;
    }

    public int getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }

    public int getDmgBonus() {
        return dmgBonus;
    }

    public int getHealthBonus() {
        return healthBonus;
    }
}
