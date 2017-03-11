package example11_inheritPractice2;

public class InheritPractice2 {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.setAge(10);
		dog.setName("�Ӻ�");
		System.out.printf("���@�����s%s,�e���~�֬O%d��", dog.getName(), dog.getAge());
		dog.sleep(); // �]���~�Ӱʪ������O,�ҥH�֦������O����k
		dog.skill();// �ۤv�֦�����k
		dog.eat();// �l���O�M�����O�W�٬ۦP��,�|���мg����,�l���O����k�|�мg�����O����k,����ܤl���O
		System.out.println("===========================================");
		Cat cat = new Cat();
		cat.setAge(8);
		cat.setName("�p�p");
		System.out.printf("���@���ߥs%s,�e���~�֬O%d��,", cat.getName(), cat.getAge());
		cat.sleep();// �]���~�Ӱʪ������O,�ҥH�֦������O����k
		cat.playGame();//// �ۤv�֦�����k
		System.out.println("===========================================");
		Animal tiger1 = new Tiger();// �h�����ŧi Animal�֦���
									// tiger����,���@���l���O�M�����O��������k,�|�Ѥl���O�мg��k
		tiger1.move();
		Cat tiger2 = new Tiger();// �h�����ŧi cat�֦���
									// tiger����,���@���l���O�M�����O��������k,�|�Ѥl���O�мg��k
		tiger2.move();
	}

}

////////////////////////////////////////////////////////////////////////////////
class Animal {
	private String name; // �Q��private�ʸˤFname��,�@�w�n�Q��SET GET��k�h�]�w�Ψ��o��
	private int age; // �Q��private�ʸˤFage��,�@�w�n�Q��SET GET��k�h�]�w�Ψ��o��
	// �غc�l���W�r�|�M���O�W�٤@��

	Animal() {
	}// ���a���Ѽƪ��غc��,�i���i�L,�S�g�t�η|�w�]�g�J�L�Ѽƪ��غc��,���@���g,�]�p�v�N�@�w�n�A�[���Ѽƪ��غc�l

	Animal(String name, int age) { // �a���Ѽƪ��غc��,�Q�γo�ӫغc���]�w��l��
		this.name = name;
		this.age = age;
	}

	public void setName(String name) { // �Q��set ��k �]�w��
		this.name = name;
	}

	public String getName() { // �Q��get��k ���o��
		return name;
	}

	public void setAge(int age) { // �Q��set ��k �]�w��
		this.age = age;
	}

	public int getAge() { // �Q��get��k ���o��
		return age;
	}

	void sleep() {
		System.out.print("�e�|��ı");
	}

	void eat() {
		System.out.printf("�u�n�O�����ʪ����Y");
	}

	void move() {
		System.out.printf("�]");
	}
}
////////////////////////////////////////////////////////////////////////////////

class Dog extends Animal {
	Dog() {
	} // ���a���Ѽƪ��غc��,�i���i�L,�S�g�t�η|�w�]�g�J�L�Ѽƪ��غc��,���@���g,�]�p�v�N�@�w�n�A�[���Ѽƪ��غc�l

	Dog(String name, int age) {// �a���Ѽƪ��غc��,�Q�γo�ӫغc���]�w��l��
		super(name, age);
	}

	void skill() {
		System.out.printf("�e�|�ݪ�");
	}

	void eat() {
		System.out.println("�e���w�Y��");// �|�мg�����O����k,�]�M�����O����k�P�W
	}

}

////////////////////////////////////////////////////////////////////////////////
class Cat extends Animal {
	public Cat() {
	}// ���a���Ѽƪ��غc��,�i���i�L,�S�g�t�η|�w�]�g�J�L�Ѽƪ��غc��,���@���g,�]�p�v�N�@�w�n�A�[���Ѽƪ��غc�l

	public Cat(String name, int age, String color) {// �a���Ѽƪ��غc��,�Q�γo�ӫغc���]�w��l��
		super(name, age);
	}

	public void playGame() {
		System.out.println("��¸�y");
	}

	void move() {
		System.out.printf("��");
	}
}

////////////////////////////////////////////////////////////////////////////////
class Tiger extends Cat {
	void skill() {
		System.out.printf("�e�|���y");
	}

}