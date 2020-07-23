package be.vives;

public class Main {

	public static void main(String[] args) {
		Character player1 = new Character_Warrior("player1");
		player1.skillSet();
		Enemy skelly= new Enemy("SkellyWelly",1, EnemyType.SKELETON);
		Item test = new Item("Skellyslayer3000", 1, BodyPart.RHAND);
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
