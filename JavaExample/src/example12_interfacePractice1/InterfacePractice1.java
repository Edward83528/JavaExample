package example12_interfacePractice1;

public class InterfacePractice1 {

	public static void main(String[] args) {
		Human human = new Human("Tony"); // �����nnew�X�Ӥ@�w�n�⤶�����Ҧ���k��@�~�inew�X��
		human.swim();
		String s = human.skll;
		System.out.printf(",�ӥL�|%s", s);
	}

	////////////////////////////////////////////////////////////////////////////////////
	public static class Human implements swimmer { // ��������H��k�w�Q�ڹ�@,�ҥH���O���Υ[abstract,���n�[static
		private String name;

		public Human(String name) { // �H�����O���غc�l,�Q�Ϋغc�l�a�J�H���W�r���Ѽ�
			this.name = name;
		}

		public String getName() {
			return name;
		}

		// 1.public abstract void swim(); �S��@�N�n��H
		// 2.���M�N��@
		public void swim() {
			System.out.printf("%s�|��a", name);
		} // ��@��k���мg����ӥB�̦n��public,�]���мg��k���v�����i�p����k
	}

	////////////////////////////////////////////////////////////////////////////////////
	public interface swimmer { // �����n�b��k�~
		public static final String skll = "freestyle";// �۰��ܦ�public static final
														// String
														// skll="freestyle";

		void swim();// �{���w�] public abstract void swim();
	}
}