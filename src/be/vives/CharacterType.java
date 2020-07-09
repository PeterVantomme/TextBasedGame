package be.vives;

public enum CharacterType {
    ARCHER(1000),SORCERER(800),WARRIOR(1300);

    int baseHealth;
    CharacterType(int hp) { baseHealth = hp; }
}
