package example10_inheritPractice1;

public class InheritPractice1 {

	public static void main(String[] args) {
		demoswordsMan();
		demomagician();
	}

	static void demoswordsMan() {
		SwordsMan swordsMan = new SwordsMan();
		swordsMan.setName("Tony");
		swordsMan.setLevel(2);
		swordsMan.setBlood(1000);
		System.out.printf("劍士:(%s,%d,%d)%n", swordsMan.getName(), swordsMan.getLevel(), swordsMan.getBlood());
	}

	static void demomagician() {
		Magician magician = new Magician();
		magician.setName("king");
		magician.setLevel(100);
		magician.setBlood(10000);
		System.out.printf("魔法師:(%s,%d,%d)", magician.getName(), magician.getLevel(), magician.getBlood());
	}

}

////////////////////////////////////////////////////////////////////////////////////
class Role {
	private String name;
	private int level;
	private int blood;

	public void setName(String name) { // 利用Set和 Get把物件值封裝
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setBlood(int blood) {
		this.blood = blood;
	}

	public int getBlood() {
		return blood;
	}
}

////////////////////////////////////////////////////////////////////////////////////
class SwordsMan extends Role {
	public void fight() {
		System.out.println("揮劍攻擊");
	}
}

////////////////////////////////////////////////////////////////////////////////////
class Magician extends Role {
	public void fight() {
		System.out.println("魔法攻擊");
	}

	public void cure() {
		System.out.println("魔法治療");
	}
}
