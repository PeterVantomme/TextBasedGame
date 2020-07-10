package be.vives;

public class Character_Warrior extends Character{
    public Character_Warrior(String name) {
        super(name, CharacterTypeSettings.WARRIOR);
        addSkill(new Skill(SkillSettings.MELEE));
        addSkill(new Skill(SkillSettings.HEAVYMELEE));
        addSkill(new Skill(SkillSettings.WARCRY));
        addSkill(new Skill(SkillSettings.ENERGYDRINK));
    }
}
