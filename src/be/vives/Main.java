package be.vives;

public class Main {

	public static void main(String[] args) {
		Character_Warrior player1 = new Character_Warrior("Test", "warrior");
		Enemy_InnocentSkeleton skelly = new Enemy_InnocentSkeleton();
		damage(player1,new Skill_Melee(),skelly);
		System.out.println(skelly.getStats());
		damage(player1,new Skill_Melee(),skelly);
		System.out.println(skelly.getStats());
		player1.getInventory();

	}

	public static void damage(Character source, Skill skill, Enemy target){
    	int damage = source.useSkill(skill)[0];
    	target.onDamageReceived(damage);
	}
}
