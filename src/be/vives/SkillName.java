package be.vives;

public enum SkillName {
    MELEE("Inflicts medium physical damage on target","physical"),
    HEAVYMELEE("Inflicts heavy physical damage on target","physical"),
    MAGIC("Inflicts magic damage on target","magic"),
    DRAIN("Lowers enemy stamina","debuff"),
    ENERGYDRINK("Raises stamina","regen"),
    WARCRY("Buffs damage on next turn", "buff"),
    TAUNT("Buffs resistance on next turn", "buff"),
    LIFESTEAL("Steals HP from the enemy target","steal"),
    STAMINASTEAL("Steals stamina from the enemy target","steal"),
    HEAL("Heals character","regen");

    String description, type;
    SkillName(String d,String t) {
        description = d;
        type = t;
    }

}
