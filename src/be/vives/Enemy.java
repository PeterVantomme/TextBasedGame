package be.vives;

import java.util.ArrayList;

public class Enemy {
    private String name;
    private int level;
    private int baseHP;
    private int currentHP;
    private int xpValue;
    private EnemyType enemyType;
    private ArrayList<Item> droptable;
    private ArrayList<Skill> skills;

    public Enemy(String name, int level, EnemyType enemyType) {
        this.name = name;
        this.level = level;
        this.baseHP = enemyType.baseHealth*(int)(Math.round(1.1*level));
        this.currentHP = baseHP;
        this.xpValue = enemyType.xpValue*(int)(Math.round(1.1*level));
        this.enemyType = enemyType;
        this.droptable = new ArrayList<>();
        this.skills = new ArrayList<>();
        setSkills(enemyType);
    }
    public boolean setSkills(EnemyType enemyType){
        switch (enemyType){
            case ARACHNOID:
                skills.add(new Skill(SkillSettings.BITE));
                skills.add(new Skill(SkillSettings.POISON));
                skills.add(new Skill(SkillSettings.WEB));
                return true;
            case SKELETON:
                skills.add(new Skill(SkillSettings.BONER));
                skills.add(new Skill(SkillSettings.HEALTH_BOOST));
                return true;
            case SLIME:
                skills.add(new Skill(SkillSettings.MAGIC));
                skills.add(new Skill(SkillSettings.BODYSLAM));
                return true;
            default:
                return false;
        }
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

    public int getLevel() {
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
