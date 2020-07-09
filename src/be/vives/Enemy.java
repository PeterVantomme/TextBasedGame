package be.vives;

import java.util.ArrayList;

public abstract class Enemy {
    private String name;
    private String level;
    private int baseHP;
    private int currentHP;
    private int xpValue;
    private EnemyType enemyType;
    private ArrayList<Item> droptable;
    private ArrayList<Skill> skills;

    public Enemy(String name, String level, int baseHP, int currentHP,
                 int xpValue, EnemyType enemyType, ArrayList<Item> droptable, ArrayList<Skill> skills) {
        this.name = name;
        this.level = level;
        this.baseHP = baseHP;
        this.currentHP = currentHP;
        this.xpValue = xpValue;
        this.enemyType = enemyType;
        this.droptable = droptable;
        this.skills = skills;
    }

    public boolean addItemToDroptist(Item item){
        if(droptable.contains(item)) {
            return false;
        }
        else{
            droptable.add(item);
            return true ;
        }
    }

    public boolean removeItemFromDroptable(Item item){
        if(droptable.contains(item)){
            droptable.remove(item);
            return true; //item removed
        }
        else{
            return false; //item not in droptable
        }
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

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public int getXpValue() {
        return xpValue;
    }

    public EnemyType getEnemyType() {
        return enemyType;
    }

    public ArrayList<Item> getDroptable() {
        return droptable;
    }
}
