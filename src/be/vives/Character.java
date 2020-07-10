package be.vives;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Character {
    private String name;
    private CharacterTypeSettings type;
    private int level;
    private int xp;
    private int baseHP;
    private int currentHP;
    private int baseStamina;
    private int currentStamina;
    private int inventoryLimit;
    private ArrayList<Item> inventory;
    private ArrayList<Skill> skills;
    private HashMap<BodyPart, Item> equipped;

    public Character(String name, CharacterTypeSettings type) {
        this.name = name;
        this.type = type;
        this.level = 1;
        this.xp = 0;
        this.baseHP = type.baseHealth;
        this.currentHP = baseHP;
        this.baseStamina = type.baseStamina;
        this.currentStamina = baseStamina;
        this.inventoryLimit = 10;
        this.inventory = new ArrayList<>();
        this.skills = new ArrayList<>();
        this.equipped = new HashMap<>();
    }

    public void addSkill(Skill skill){
        skills.add(skill);
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
                processItems();
                return true;
            }
            else{                                                   //if nothing is in equipment slot
                inventory.remove(item);
                equipped.put(item.getBodypart(), item);
                processItems();
                return true;
            }
        }
        else{
            return false; // level too low/item not in inventory
        }
    }
    public boolean unequipItem(Item item){
        if(equipped.containsValue(item)){
            equipped.remove(item.getBodypart());
            processItems();
            return true;
        }
        else{
            return false;
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

    public void processItems (){
        for (Skill s: skills){  //change all skill stats to base
            s.changeEffectValue(s.getSkillSettings().effect);
        }
        equipped.forEach((bodypart,item)-> {  //start checking equipped items
            if(item.getValues().containsKey("damagebonus")){
                int damagebonus = item.getValues().get("damagebonus");
                for(Skill s: skills){
                    if(s.getSkillType().equals("physical")){
                        int skillBaseDamage = s.getBaseEffect();
                        s.changeEffectValue(skillBaseDamage+damagebonus);
                        // makes sure damage doesn't continue going up when replacing equipped items.
                    }
                }
            }
            else if(item.getValues().containsKey("healthbonus")){
                int healthbonus = item.getValues().get("healthbonus");
                for(Skill s: skills){
                    if(s.getSkillType().equals("health")){
                        int skillBaseHeal = s.getBaseEffect();
                        s.changeEffectValue(skillBaseHeal+healthbonus);
                    }
                }
            }
            else if(item.getValues().containsKey("staminabonus")){
                int staminabonus = item.getValues().get("staminabonus");
                for(Skill s: skills){
                    if(s.getSkillType().equals("stamina")){
                        int skillBaseStamina = s.getBaseEffect();
                        s.changeEffectValue(skillBaseStamina+staminabonus);
                    }
                }
            }
        });
    }

    public String getName() {
        return name;
    }

    public CharacterTypeSettings getType() {
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
