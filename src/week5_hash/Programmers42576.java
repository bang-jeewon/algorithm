/**
 * Hash - �������� ���� ����
 */
package week5;

import java.util.HashMap;

public class Programmers42576 {

	public static void main(String[] args) {

//		String[] participant = {"leo", "kiki", "eden"};
//		String[] completion = {"eden", "kiki"};
		
//		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
//		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		System.out.println(solution(participant, completion));
		
	}
	
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		
		//������ map�� value�� �ο����� üũ�ϸ鼭, �������� 0�� �ƴ� key���� ��ȯ�Ѵ�
		//Integer : �ο��� üũ
		HashMap<String, Integer> map =  new HashMap<>();
		
		//getOrDefault(key, key�� value�� �����ϸ� �ش� value�� �־��ְ� ���ٸ� 0�� �־��ش�) �׸��� 1�� ���Ѵ�
		//HashMap ��� ���� key���� �߰��� ��� value ���� ������ϱ� ������
		//���� ���� key���� value�� ��� ����ϰ� ���� ��� getOrDefault�޼ҵ带 ���
		for(String person : participant) {
			map.put(person, map.getOrDefault(person, 0) +1);
		}
		System.out.println(map.get("stanko")); //1
		System.out.println(map.get("mislav")); //2 (ó�� map�� ����� ���� 0+1)
		System.out.println(map.get("ana"));    //1
		
		for(String person : completion) {
			map.put(person, map.get(person) -1);
		}
		System.out.println(map.get("stanko")); //0
		System.out.println(map.get("mislav")); //1
		System.out.println(map.get("ana"));    //0
		
		for(String key : map.keySet()) {
			if(map.get(key) != 0) {
				answer = key;
			}
		}
		
		return answer;
	}
	

}
