package be.vives;

public class Main {

	public static void main(String[] args) {
		Character player1 = new Character("player1", CharacterTypeSettings.WARRIOR);
		Skill meleeTest = new Skill(SkillSettings.MELEE);
		player1.addSkill(meleeTest);
		System.out.println(player1.getSkills().get(0).getEffect());
		Enemy thot1 = new Enemy("Thottinus The First",1, EnemyType.THOT);
		Item test = new Item("Thotslayer3000", 1, BodyPart.RHAND);
		test.addValue("damagebonus", 50);
		player1.addItemToInventory(test);
		player1.equipItem(test);
		for(Item it: player1.getInventory()){
			System.out.println(it.getName());
		}
		System.out.println(player1.getSkills().get(0).getEffect());
		player1.unequipItem(test);
		System.out.println(player1.getSkills().get(0).getEffect());
	}
}
