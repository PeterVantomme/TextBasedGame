package be.vives;

import java.util.ArrayList;

public abstract class Item {
    private String name;
    private int level;
    private int[] values; //[0]> dmg; [1]> buff; [2]> heal; [3]> defense (hp+)
    private BodyPart bodypart;

    public Item(String name, int level, int[] values, BodyPart bodypart) {
        this.name = name;
        this.level = level;
        this.values = values;
        this.bodypart = bodypart;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int[] getValues() {
        return values;
    }

    public BodyPart getBodypart() {
        return bodypart;
    }
}
