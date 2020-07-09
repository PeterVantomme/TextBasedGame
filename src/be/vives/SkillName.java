package be.vives;

public enum SkillName {
    MELEE("Inflicts medium physical damage on target","physical",100, 25),
    HEAVYMELEE("Inflicts heavy physical damage on target","physical",150,60),
    MAGIC("Inflicts magic damage on target","magic",120, 40),
    DRAIN("Lowers enemy stamina","debuff",25, 25),
    ENERGYDRINK("Raises stamina","regen",50, 50),
    WARCRY("Buffs damage on next turn", "buff",150, 75),
    TAUNT("Buffs resistance on next turn", "buff",200, 75),
    LIFESTEAL("Steals HP from the enemy target","steal",100, 35),
    STAMINASTEAL("Steals stamina from the enemy target","steal", 50, 75 ),
    HEAL("Heals character","regen",200, 75);

    String description, type;
    int effect,staminaDrain;
    SkillName(String d,String t, int e, int s) {
        description = d;
        type = t;
        effect = e;
        staminaDrain = s;
    }

}
