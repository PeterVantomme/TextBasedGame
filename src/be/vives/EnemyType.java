package be.vives;

public enum EnemyType {
    CRYING_BABY(300,100), DEAD_MEME(1,100), DUTCH_PERSON(600,200), GAY_PERSON(600,200), KAREN(1000,333),
    FEMINIST(1000,333), AMERICAN_PERSON(50,25), GANGSTER_RAPPER(200,200), THOT(300,200), FURRY(300,200);

    int baseHealth;
    int xpValue;
    EnemyType(int hp, int xp) {
        baseHealth = hp;
        xpValue = xp;
    }
}
