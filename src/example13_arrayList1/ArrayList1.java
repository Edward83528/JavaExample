package example13_arrayList1;

import java.util.*; //List�M��bjava.util��

public class ArrayList1 {
	// ArrayList�O�Ҧ����X�̹��}�C�����X,���]�i�������Y�ۦp���}�C
	// �����ǩm,�����ޭ�(�i�H�A�[�J�����ɵ��w���ޭ�)add(int index ,Object obj),�i����
	// �Q��add get()�W�[�Ψ��X����,���ޭȬݧA�n���n�[
	// remove(index)���X���w���ޭȤ���
	public static void main(String[] args) {
		List name = new ArrayList(); // �h�D�ŧi �]��ArrayList��@List
		collectNameTo(name);
		System.out.println("�Z�ŦW��:");
		printUpperCase(name);

	}

	// �W�[����
	static void collectNameTo(List name) { // �n�[Static
		Scanner a = new Scanner(System.in);
		while (true) {
			System.out.println("�Z�ŦP�ǦW�r");
			String whitchname = a.nextLine(); // ��J�P�ǦW�r
			if (whitchname.equals("end")) { // �J��end�����J
				break;
			} else {
				name.add(whitchname); // List ���Ѫ�add��k,�i�W�[�����Ǫ�����
			}
		}
	}

	// ���X����
	static void printUpperCase(List name) { // �n�[Static
		for (int i = 0; i < name.size(); i++) {
			String name1 = (String) name.get(i); // ��List���Ѫ�get��k�⪫�󮳥X��,get(int
													// index),�]���n��j�g,�ҥH�n���૬��String���O�~��toUpperCase��k
			System.out.printf("%d��:%s \t", i, name1.toUpperCase());
		}
	}

}
