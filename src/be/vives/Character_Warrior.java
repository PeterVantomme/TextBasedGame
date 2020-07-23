package be.vives;

public class Character_Warrior extends Character{
    public Character_Warrior(String name) {
        super(name, CharacterTypeSettings.WARRIOR);
        Skill a = new Skill(SkillSettings.MELEE);
        Skill b = new Skill(SkillSettings.HEAVYMELEE);
        Skill c = new Skill(SkillSettings.WARCRY);
        Skill d = new Skill(SkillSettings.ENERGYDRINK);
        Skill[] starterskills = {a,b,c,d};

        super.addSkills(starterskills);
    }
}
