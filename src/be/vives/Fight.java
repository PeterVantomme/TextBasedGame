package be.vives;

public class Fight {
    public Character character;
    public Enemy enemy;

    public Fight(Character character, Enemy enemy) {
        this.character = character;
        this.enemy = enemy;
    }

    public int characterToEnemy(Skill skill){
        return 0;
    }
    public int enemyToCharacter(Skill skill){
        return 0;
    }
}