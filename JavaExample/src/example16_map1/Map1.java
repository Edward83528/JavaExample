package example16_map1;

import java.util.*;

public class Map1 {
	// ���L���ǩʥB�L�Ƨǩ�
	// Map�èS���~�Ӷ��X����,�Q�k�������X���@����,�O�]Hashtable�PHashMap�o��Ӷ��X���O��@Map����
	// Map�Q�Ϋ��w�����(key)�ӨM�w�����\���m,��Ȥ��i�H����,�����P����ȥi�H�s���Ъ��������e
	// Map���u�I�N�O�i�H�ӧO�ާ@key�ȻP�������e,�W�[�{����@���u��
	// �Q��put��k��JMap��,�Q��get("key")���o�Ӥ������e
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("A", "�C��");
		map.put("1", "��");
		map.put("4", "tony");
		map.put("100", 200);
		map.put(null, null);// HashMap�i�H���\null
		System.out.println(map.toString());// ��X{null=null, A=�C��, 1=��,//
											// 100=200,// 4=tony}
		System.out.println(map.get("A"));// �C��
		System.out.println(map.get("100"));// 200
		System.out.println(map.get("null"));// null
		System.out.println(map.get("S"));// �S���Ӥ�����Xnull
		map.remove("1");// ����key=1���������e
		System.out.println(map.toString());// ��X{null=null, A=�C��, 100=200,//
											// 4=tony}
	}

}
