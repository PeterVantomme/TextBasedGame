package be.vives;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Character {
    private String name;
    private CharacterType type;
    private int level;
    private int xp;
    private int baseHP;
    private int currentHP;
    private int inventoryLimit;
    private ArrayList<Item> inventory;
    private ArrayList<Skill> skills;
    private HashMap<BodyPart, Item> equipped;

    public Character(String name, CharacterType type, int baseHP, int currentHP) {
        this.name = name;
        this.type = type;
        this.level = 1;
        this.xp = 0;
        this.baseHP = baseHP;
        this.currentHP = currentHP;
        this.inventoryLimit = 10;
        this.inventory = new ArrayList<>();
        this.skills = new ArrayList<>();
        this.equipped = new HashMap<>();

    }

    public boolean takeDamage(int damage){
        if(currentHP-damage > 0){
            currentHP-=damage;
            return true; //true == alive
        }
        else{
            currentHP = 0;
            return false; //false == dead
        }
    }

    public boolean addItemToInventory(Item item){
        if(inventory.size() < inventoryLimit){
            inventory.add(item);
            return true; // true = added
        }
        else{
            return false; // false = inventorySize too small;
        }
    }

    public boolean removeItemFromInventory(Item item){
        if (inventory.contains(item)){  // remove item in inventory
            inventory.remove(item);
            if (equipped.containsValue(item)){
                equipped.remove(item.getBodypart()); // remove equipped item
            }
            return true; // true = removed
        }
        else{
            return false; // false = item doesn't exist in inventory
        }
    }

    public boolean equipItem(Item item){
        if(inventory.contains(item) &&  level >= item.getLevel()){
            if(equipped.containsKey(item.getBodypart())) {          //if equipment slot is occupied
                inventory.add(equipped.get(item.getBodypart()));
                equipped.put(item.getBodypart(), item);
                return true;
            }
            else{                                                   //if nothing is in equipment slot
                equipped.put(item.getBodypart(), item);
                return true;
            }
        }
        else{
            return false; // level too low/item not in inventory
        }
    }

    public boolean addXp(int xpAmount){
        boolean leveledUp = false;
        int levelUpLimit = level*1000;
        xp += xpAmount;
        while(xp >= levelUpLimit){ // level up if xpAmount+xp > limit
            level ++;
            xp -= levelUpLimit;
            leveledUp = true;
        }
        return leveledUp; // true = level up; false = no level up
    }

    public String getName() {
        return name;
    }

    public CharacterType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public HashMap<BodyPart, Item> getEquipped() {
        return equipped;
    }

    public int getCurrentHP(){
        return currentHP;
    }

    public int getBaseHP(){
        return baseHP;
    }
}
