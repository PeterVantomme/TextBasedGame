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

    public boolean addValues(String key, int value){
        if(checkSkill(key)) {
            if (values.containsKey(key)) {
                values.remove(key);
                values.put(key, value);
                return true;
            }
            else{
                values.put(key, value);
                return true;
            }
        }
        else{
            return false;
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
    

}
