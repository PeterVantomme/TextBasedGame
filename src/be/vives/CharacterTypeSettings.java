package be.vives;

public enum CharacterTypeSettings {
    ARCHER(1000, 100),SORCERER(800,200),WARRIOR(1300,100);

    int baseHealth,baseStamina;
    CharacterTypeSettings(int defaulthp, int defaultStamina) {
        baseHealth = defaulthp;
        baseStamina = defaultStamina;
    }
}
