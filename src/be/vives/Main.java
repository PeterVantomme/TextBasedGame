package be.vives;

import java.sql.SQLOutput;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		Skill warcry = new Skill(SkillName.WARCRY);
		System.out.println(warcry.testSkillName());
		System.out.println(warcry.getDescription());
	}
}
