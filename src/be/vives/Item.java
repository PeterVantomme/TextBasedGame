package be.vives;

import java.util.ArrayList;
import java.util.HashMap;

public class Item {
    private String name;
    private int level;
    private final String[] itemKeys = {"damagebonus","healthbonus","staminabonus"};
    private HashMap<String, Integer> values;
    private BodyPart bodypart;

    public Item(String name, int level, BodyPart bodypart) {
        this.name = name;
        this.level = level;
        this.values = new HashMap<>();
        this.bodypart = bodypart;
    }

    public boolean addValue(String strKey, int value){ //add values to item (eg. dmgbonus and amount of dmgbonus)
        String key = strKey.trim().toLowerCase(); // makes key universal
        if(checkItem(key)) {  // Checks if item exists in list
            if (values.containsKey(key)) {  // Checks if item was already implemented in values
                values.remove(key);
                values.put(key, value);
                return true;  // value replaced
            }
            else{
                values.put(key, value);
                return true;  // item with value added
            }
        }
        else{
            return false; // item was not added since it doesn't exist in list
        }
    }

    protected boolean checkItem(String key){ //Checks if key from "addValues" exists as an item
        for(int i = 0; i<itemKeys.length-1;i++){
            if(itemKeys[i].equals(key.toLowerCase().trim())){
                return true;  // exists
            }
        }
        return false; // doesn't exist
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public HashMap<String, Integer> getValues() {
        return values;
    }

    public BodyPart getBodypart() {
        return bodypart;
    }
}
