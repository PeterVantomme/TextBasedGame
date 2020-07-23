package be.vives;

public enum SkillSettings {

    // CHARACTER SKILLS
    MELEE("Inflicts medium physical damage on target","physical",(int)Math.random()*100, 25),
    HIGH_IMPACT_ARROW("Inflicts high damage on target","physical",(int)Math.random()*200,50 ),
    TRIPLE_ARROW("Fires three arrows dealing 3*random[25-75] damage,\nitems do not change the effect","physical",1*TRIPLEARROW(),75),
    HEAVYMELEE("Inflicts heavy physical damage on target","physical",(int)Math.random()*150,60),
    MAGIC("Inflicts magic damage on target","magic",(int)Math.random()*120, 40),
    DRAIN("Lowers enemy stamina","debuff",(int)Math.random()*25, 25),
    ENERGYDRINK("Raises stamina","stamina",(int)Math.random()*50, 50),
    WARCRY("Buffs damage on next turn", "damage",(int)Math.random()*150, 75),
    TAUNT("Buffs resistance on next turn", "health",(int)Math.random()*200, 75),
    LIFESTEAL("Steals HP from the enemy target","health",(int)Math.random()*100, 35),
    STAMINASTEAL("Steals stamina from the enemy target","stamina", (int)Math.random()*50, 75 ),
    HEAL("Heals character","health",(int)Math.random()*200, 75),

    // ENEMY SKILLS
        // ARACHNOID SKILLSET
        WEB("Lowers target's stamina","stamina",(int)Math.random()*50),
        POISON("Inflicts damage over 2 turns","physical",(int)Math.random()*35),
        BITE("Inflicts physical damage on target","physical",(int)Math.random()*75),

        // SKELETON SKILLSET
        HEALTH_BOOST("Boost skeleton's health", "health",(int)Math.random()*200),
        BONER("Skeleton uses his boner to inflict damage","physical",(int)Math.random()*100),

        // SLIME SKILLSET
        // ##Magic
        BODYSLAM("Slime bodyslamms target","physical",(int)Math.random()*100);








    String description, type;
    int effect,staminaDrain;
    SkillSettings(String d, String t, int e, int s) {
        description = d;
        type = t;
        effect = e;
        staminaDrain = s;
    }
    SkillSettings(String d,String t, int e){
        description = d;
        type = t;
        effect = e;
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
