package be.vives;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Enemy {
    private String name;
    private int minDamage;
    private int maxDamage;
    private int health;
    private int level;
    private ArrayList<Item> droptable;
    private int xpValue;

    public Enemy(String name, int health, int level, int xpValue, ArrayList<Item> droptable) {
        this.name = name;
        this.health = health;
        this.level = level;
        this.xpValue = xpValue;
        this.droptable = droptable;
    }

    public void addItemToDroptable(Item item){
        droptable.add(item);
    }
    public void addItemsToDroptable(Item[] items){
        for(Item item: items){
                droptable.add(item);
        }
    }
    public void onDamageReceived(int damage){
        if (health-damage <= 0){onDeath();}
        else{health-=damage;}
    }
    public void onDeath(){
        health = 0;
        System.out.println(name+" has died.");
        Character.addXp(giveXp());
        Character.addItemToInventory(giveItem());
    }
    public int giveXp(){ ;
        return xpValue;
    }
    public Item giveItem(){
        int rand = (int)Math.random()*(droptable.size()-1);
        System.out.println("You've received: "+droptable.get(rand).getItemName()+" lvl: "+droptable.get(rand).getLevel());
        return droptable.get(rand);
    }

    public int damageDealt(){
        int damage = 0;
        while(damage < minDamage && damage > maxDamage) {
            damage = (int) Math.random() * maxDamage;
        }
        return damage;
    }


    public String getStats() {
        return name+" lvl: "+level+ "\nhp: " +health;
    }

    public int getHealth(){
        return health;
    }
}
