package be.vives;

import javax.swing.*;
import java.util.HashMap;

public class Skill {
    private SkillName skillName; //Contains the skillnames and their description
    private final String[] skillValues = {"damage","heal","buffdamage","buffhealth"}; //Temporary selection of possible skills
    private String description;
    private HashMap<String,Integer> values; //Here is dmg/buff/hp/... stored

    public Skill(SkillName skillName) {
        this.skillName = skillName;
        this.values = new HashMap<>();
        this.description = skillName.description;
    }

    public boolean addValue(String strKey, int value){ //add values to skill (eg. dmg + amount of dmg)
        String key = strKey.trim().toLowerCase(); // makes key universal
        if(checkSkill(key)) {  // Checks if skill exists in list
            if (values.containsKey(key)) {  // Checks if skill was already implemented in values
                values.remove(key);
                values.put(key, value);
                return true;  // value replaced
            }
            else{
                values.put(key, value);
                return true;  // skill with value added
            }
        }
        else{
            return false; // skill was not added since it doesn't exist in list
        }
    }
    protected boolean checkSkill(String key){ //Checks if key from "addValues" exists as a skill
        for(int i = 0; i<skillValues.length-1;i++){
            if(skillValues[i].equals(key.toLowerCase().trim())){
                return true;    // exists
            }
        }
        return false; // doesn't exist
    }

    public SkillName getSkillName(){
        return skillName;
    }

    public String getDescription(){
        return description;
    }

    public String getSkillType(){
        return skillName.type;
    }

    public HashMap<String, Integer> getValues() {
        return values;
    }
}
