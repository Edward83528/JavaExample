package example19_dice;

public class Dice {
	// ���߲v���C��
	public static void main(String[] args) {
		
		int[] p = new int[6];
		for (int i = 0; i < 20000; i++) {
			int a = (int) (Math.random() * 9);
			switch (a) {
			case 0:
				p[0]++;
				break;
			case 1:
				p[1]++;
				break;
			case 2:
				p[2]++;
				break;
			case 3:
				p[3]++;
				break;
			case 4:
				p[4]++;
				break;
			case 5:
				p[5]++;
				break;
			case 6:// �N7 8 9�I�����v�[��3 4 5�I�����W,�N���v����
			case 7:
			case 8:
			case 9:
				p[a - 4]++;
				break;

			}

		}
		for (int i = 0; i < p.length; i++) {
			System.out.println((i + 1) + "�X�{" + p[i] + "��");
		}
	}

}
