package be.vives;

import java.util.HashMap;
public class Character_Warrior extends Character {
    private int stamina;


    public Character_Warrior(String name, String characterClass) {
        super(name, characterClass, 1500);
        this.stamina = getBaseStamina()+100;
        this.skills = new HashMap<>();
        skills();
        setCurrentHealth(1500);
    }


    public void skills() {
        if(skills.containsKey("melee")){}//deals 100 damage to foe, consumes 10 stamina
        else{skills.put("melee",new Skill_Melee()); }
        if(skills.containsKey("warcry")){}//add 200% damage on next turn, consumes 20 stamina
        else{skills.put("warcry",new Skill_Warcry());}

        skills.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue().description());
        });
    }

    public int getStamina() {
        return stamina;
    }
}
