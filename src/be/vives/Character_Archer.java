package be.vives;

public class Character_Archer extends Character{
    public Character_Archer(String name) {
        super(name, CharacterTypeSettings.ARCHER);
        addSkill(new Skill(SkillSettings.HIGH_IMPACT_ARROW));
        addSkill(new Skill(SkillSettings.TRIPLE_ARROW));
        addSkill(new Skill(SkillSettings.TAUNT));
        addSkill(new Skill(SkillSettings.DRAIN));
    }
}
