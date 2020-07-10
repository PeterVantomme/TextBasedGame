package be.vives;

public class Character_Sorcerer extends Character{
    public Character_Sorcerer(String name) {
        super(name, CharacterTypeSettings.SORCERER);
        addSkill(new Skill(SkillSettings.MAGIC));
        addSkill(new Skill(SkillSettings.HEAL));
        addSkill(new Skill(SkillSettings.LIFESTEAL));
        addSkill(new Skill(SkillSettings.STAMINASTEAL));
    }
}
