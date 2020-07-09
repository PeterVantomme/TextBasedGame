package be.vives;

import java.sql.SQLOutput;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		Character player1 = new Character("player1",CharacterType.WARRIOR);
		Enemy thot1 = new Enemy("Thottinus The First",1, EnemyType.THOT);
		Item test = new Item("Thotslayer3000", 1, BodyPart.RHAND);
		test.addValue("damagebonus", 50);
		player1.addItemToInventory(test);
		player1.equipItem(test);
		for(Item it: player1.getInventory()){
			System.out.println(it.getName());
		}
	}
}
