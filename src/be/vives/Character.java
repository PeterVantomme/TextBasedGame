package be.vives;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Character {
    private String name;
    private int baseHealth;
    private int baseStamina = 100;
    private int currentHealth;
    private int level;
    private int xp;
    private int skillPoints;
    private ArrayList<Item> inventory;
    private int inventoryLimit;
    private String characterClass;
    public HashMap<String,Skill> skills;


    public Character(String name,String characterClass, int baseHealth) {
        checkClass(characterClass);
        this.name = name;
        this.level = 1;
        this.xp = 0;
        this.inventoryLimit = 10;
        this.inventory = new ArrayList<>();
        this.baseHealth = baseHealth;
        this.skills = skills;
    }
    public int[] useSkill(Skill skill) {
        int[] values = {0, 0, 0};
        if (skill.getDmg() != 0) {
            values[0] = skill.getDmg();
        }
        if (skill.getBuff() != 0) {
            values[1] = skill.getBuff();
        }
        if (skill.getHeal() != 0) {
            values[2] = skill.getHeal();
        }
        return values;
    }

    public void checkClass(String charClass){
        if(charClass.trim().toLowerCase().equals("warrior")){
            characterClass = "warrior";
        }
    }
    public void addItemToInventory(Item item) {
        if (inventory.size() + 1 < inventoryLimit) {
            inventory.add(item);
        } else {
            System.out.println("Your inventory is full!");
        }
    }
    public void removeItemFromInventory(Item item){
        boolean removed = false;
        for(Item it : inventory){
            if(it == item){
                inventory.remove(it);
                removed = true;
            }
        }
        if(!removed){
            System.out.println("Item not in inventory");
        }

    }
    public void addInventoryLimit(int num){
        inventoryLimit+=num;
    }
    public void addInventoryLimit(){
        inventoryLimit++;
    }
    public void addXp(int inputXpAdd){
        xp += inputXpAdd;
        levelUp();
    }
    public void levelUp(){
        int xpCap = 1000*level;

        while(xpCap<=xp){
            skillPoints++;
            level ++;
            System.out.println("You leveled up! \nLevel: "+level);
            xp-=xpCap;
        }
    }
    public void receiveHealth(int hp){
        if(currentHealth+hp > baseHealth){
            currentHealth = baseHealth;
        }
        else{
            currentHealth+=hp;
        }
    }
    public void receiveDamage(int damage){
        if (damage>=baseHealth) {
            currentHealth = 0;
            death();
        }
        else{baseHealth -= damage;}
    }
    public void death(){
        System.out.println("You've died!");
    }
    public void setBaseHealth(int hp){
        baseHealth = hp;
    }

    public void setCurrentHealth(int hp){
        currentHealth = hp;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public int getBaseStamina() {
        return baseStamina;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }
    public String getCharacterClass(){
        return  characterClass;
    }
}
