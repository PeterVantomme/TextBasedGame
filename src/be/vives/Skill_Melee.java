package be.vives;

public class Skill_Melee extends Skill{

    public Skill_Melee() {
        super(100, 0, 0, "melee");
    }
    public String description(){
        return "Basic melee attack with standard "+getDmg()+" attack damage";
    }

}
