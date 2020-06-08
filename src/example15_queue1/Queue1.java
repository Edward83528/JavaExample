package example15_queue1;

import java.util.*;

public class Queue1 {
	// Queue�����i���X���X
	// �s�W/���������� offer() /poll()
	// peek()�q�W�C�����Y�}�l,���o�Ӥ������e��������,�Y���C���Ŧ^��null
	public static void main(String[] args) {
		Queue q = new LinkedList();
		q.offer("a"); // �W�[����
		q.offer("b");
		q.offer("c");
		q.offer("d");
		q.poll(); // "����"�̦���i�Ӫ�����a�è��oa�����e
		System.out.println(q.toString());// ��X[ b, c, d]
		System.out.println(q.peek());// �ƻs���Y�}�l�������ȿ�Xb,��"������","��poll"�ܹ��O�d�V
		System.out.println(q.toString());// ��X[ b, c, d]
		Object o;
		while ((o = q.poll()) != null) { // poll���o���Y�������e�ò���
			String s = (String) o;
			System.out.println(s);// �̧ǿ�Xb c d
		}
		System.out.println(q.toString());// �]���e���@���F�����ҥH�W�C���S�ȤF

	}

}
