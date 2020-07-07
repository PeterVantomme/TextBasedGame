package be.vives;

public abstract class Skill{
    private int dmg;
    private int heal;
    private int buff;
    private String name;

    public Skill(int dmg, int heal, int buff, String name) {
        this.dmg = dmg;
        this.heal = heal;
        this.buff = buff;
        this.name = name;
    }

    public int getDmg(){
        return dmg*(1+buff);
    }
    public int getHeal(){
        return heal*(1+buff);
    }
    public int getBuff(){
        return buff;
    }

    public abstract String description();
}

