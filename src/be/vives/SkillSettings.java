package be.vives;

public enum SkillSettings {
    MELEE("Inflicts medium physical damage on target","physical",100, 25),
    HIGH_IMPACT_ARROW("Inflicts high damage on target","physical",200,50 ),
    TRIPLE_ARROW("Fires three arrows dealing 3*random[25-75] damage,\nitems do not change the effect","physical",1*TRIPLEARROW(),75),
    HEAVYMELEE("Inflicts heavy physical damage on target","physical",150,60),
    MAGIC("Inflicts magic damage on target","magic",120, 40),
    DRAIN("Lowers enemy stamina","debuff",25, 25),
    ENERGYDRINK("Raises stamina","stamina",50, 50),
    WARCRY("Buffs damage on next turn", "damage",150, 75),
    TAUNT("Buffs resistance on next turn", "health",200, 75),
    LIFESTEAL("Steals HP from the enemy target","health",100, 35),
    STAMINASTEAL("Steals stamina from the enemy target","stamina", 50, 75 ),
    HEAL("Heals character","health",200, 75);

    String description, type;
    int effect,staminaDrain;
    SkillSettings(String d, String t, int e, int s) {
        description = d;
        type = t;
        effect = e;
        staminaDrain = s;
    }

    private static int TRIPLEARROW(){
        int[] damageSet={0,0,0};
        for(int i = 0; i<3;i++){
            while (damageSet[i]<75) {
                damageSet[i] = (int) Math.random() * 150;
            }
        }
        return damageSet[0]+damageSet[1]+damageSet[2];
    }

}
