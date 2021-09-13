/**
 * Hash - 완주하지 못한 선수
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
		
		//동일한 map에 value를 인원수로 체크하면서, 마지막에 0이 아닌 key값을 반환한다
		//Integer : 인원수 체크
		HashMap<String, Integer> map =  new HashMap<>();
		
		//getOrDefault(key, key의 value가 존재하면 해당 value를 넣어주고 없다면 0을 넣어준다) 그리고 1을 더한다
		//HashMap 경우 동일 key값을 추가할 경우 value 값이 덮어쓰기하기 때문에
		//따라서 기존 key값의 value를 계속 사용하고 싶을 경우 getOrDefault메소드를 사용
		for(String person : participant) {
			map.put(person, map.getOrDefault(person, 0) +1);
		}
		System.out.println(map.get("stanko")); //1
		System.out.println(map.get("mislav")); //2 (처음 map에 담겼을 때는 0+1)
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
