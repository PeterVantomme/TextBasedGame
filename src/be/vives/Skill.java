package be.vives;

import java.util.HashMap;

//TODO: add the values from enum to class

public class Skill {
    private SkillSettings skillSettings; //Contains the skillnames and their description
    private String description;
    private HashMap<String,Integer> values; //Here is dmg/buff/hp/... stored
    private int effect;
    private int baseEffect;

    public Skill(SkillSettings skillSettings) {
        this.skillSettings = skillSettings;
        this.values = new HashMap<>();
        this.description = skillSettings.description;
        this.effect = skillSettings.effect;
        this.baseEffect = effect;
    }
    public void changeEffectValue(int replaceValue) {
        effect = replaceValue;
    }

    /* //Once multistat mods are implemented, this becomes useful
    public boolean addOrReplaceValue(String strKey, int value){ //add values to skill (eg. dmg + amount of dmg)
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
    */

    public SkillSettings getSkillSettings(){
        return skillSettings;
    }

    public String getDescription(){
        return description;
    }

    public String getSkillType(){
        return skillSettings.type;
    }

    /* public HashMap<String, Integer> getValues() {
        return values;
    }
    */

    public int getEffect() {
        return effect;
    }
    public int getBaseEffect() {
        return baseEffect;
    }
}
