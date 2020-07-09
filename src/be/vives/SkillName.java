package be.vives;

public enum SkillName {
    MELEE("Inflicts medium physical damage on target"),
    HEAVYMELEE("Inflicts heavy physical damage on target"),
    MAGIC("Inflicts magic damage on target"),
    DRAIN("Lowers enemy stamina"),
    ENERGYDRINK("Raises stamina"),
    WARCRY("Buffs damage on next turn"),
    TAUNT("Buffs resistance on next turn"),
    LIFESTEAL("Steals HP from the enemy target"),
    STAMINASTEAL("Steals stamina from the enemy target"),
    HEAL("Heals character");

    String description;
    SkillName(String d) { description = d; }

}
