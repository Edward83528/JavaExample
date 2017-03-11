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
		System.out.printf("�C�h:(%s,%d,%d)%n", swordsMan.getName(), swordsMan.getLevel(), swordsMan.getBlood());
	}

	static void demomagician() {
		Magician magician = new Magician();
		magician.setName("king");
		magician.setLevel(100);
		magician.setBlood(10000);
		System.out.printf("�]�k�v:(%s,%d,%d)", magician.getName(), magician.getLevel(), magician.getBlood());
	}

}

////////////////////////////////////////////////////////////////////////////////////
class Role {
	private String name;
	private int level;
	private int blood;

	public void setName(String name) { // �Q��Set�M Get�⪫��ȫʸ�
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
		System.out.println("���C����");
	}
}

////////////////////////////////////////////////////////////////////////////////////
class Magician extends Role {
	public void fight() {
		System.out.println("�]�k����");
	}

	public void cure() {
		System.out.println("�]�k�v��");
	}
}
