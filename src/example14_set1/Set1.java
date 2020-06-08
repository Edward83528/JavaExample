package example14_set1;

import java.util.*;

public class Set1 {
	// Set���A�O�L���Ǹs���]Collection�^�A�޲z������"���|����"
	// �Q��set���Ѫ���kadd�W�[����,�����X�����n��Iterator���X�����X�γz�LtoArray()�N���X���e�ഫ��Object[],�óz�Lfor�j����X
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		hs.add("a");
		hs.add("s");
		hs.add("a");
		hs.add("d");
		hs.add("x");
		// 1. �Ӷ��X���O/�����ݭn��iterator��k(�z�L��@/�~��java.lang.Iterable�Ө�)
		// 2. �I�siterator��k�A���oIterator���A������A�Ӫ���]�t���X���Ҧ�����
		// 3. �ϥ�while�j��A�j�骺���󦡤��ϥ�Iterator���A������I�shasNext()�A�j��|���XIterator����
		// �������C�bwhile�j��϶����ϥ�next()�A�C������^��A�N�N���X�쪺�����Ȩ��X�C�j��������槹�� ��A�Ҧ����ȧY���X�����C
		// 4.�]��List�O���ǵ��c�æ����ޯS�ʡA��Set�h���L�Ǥ����ƪ��S�ʡA��̩Ҵ��Ѫ����}�s����k�]���ۦP�A���F���@�P���覡�ӳv�@��
		// �o���󤺳�����ơA�z�i�H���@��Iterator�󪫥󤺳��i�榬���A����Ǧ^Iterator����A�z�L��Iterator�ӳv�@���o���󤺳���ơC
		Iterator it = hs.iterator();
		while (it.hasNext()) {
			String data = (String) it.next();
			System.out.printf("%s\t", data);
		}

		// =================================================================
		System.out.println("");
		Scanner input = new Scanner(System.in);
		System.out.println("�п�J�^��:");
		Set words = toSplitSet(input.nextLine());
		System.out.printf("�����ƪ���r��%d��:%s %n", words.size(), words);
	}

	/////////////////////////////////////////////////////////////////////////
	static Set toSplitSet(String line) {
		String[] tosplit = line.split("");// �ϥ�String����split��k�A�N�r����Φ��ƭ�token�A�o��@�Ӧ^�Ǫ�String
											// array�C
		return new HashSet(Arrays.asList(tosplit));// Arrays.asList���Ʋժ����X�M���API����������C
	}// Hashset ��@set����
}
/////////////////////////////////////////////////////////////////////////