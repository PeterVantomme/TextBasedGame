package be.vives;

public enum EnemyType {
    ENCHANTED_SKELETON(300,100), SKELETON(1,100), LARGE_ARACHNOID(600,200), ARACHNOID(300,100), BEWITCHED_SOLDIER(1000,333),
    WITCH(600,250), SLIME(50,25), MUCUS_SLIME(200,200), CRAB(300,200), PRESPIC(300,300);

    int baseHealth;
    int xpValue;
    EnemyType(int hp, int xp) {
        baseHealth = hp;
        xpValue = xp;
    }
}
