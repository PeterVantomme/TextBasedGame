package be.vives;

public class Skill_Warcry extends Skill{
    public Skill_Warcry() {
        super(0, 0, 3, "warcry");
    }
    public String description(){
        return "Standard warrior skill increases damage to "+getBuff()+"00% damage on next turn";
    }
}
