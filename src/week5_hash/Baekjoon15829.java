/** 
 * Hash - 전화번호 목록
 */
package week5;

import java.util.HashMap;

public class Baekjoon15829 {

	public static void main(String[] args) {

//		String[] phone_book = {"119", "97674223", "1195524421"};
		String[] phone_book = {"123","456","789", "123"};
//		String[] phone_book = {"12","123","1235","567","88"};
		
		System.out.println(solution(phone_book));
	}

	
	public static boolean solution(String[] phoneBook) {
		boolean answer = true;
		
		HashMap<Integer, String> map = new HashMap<>();
		
		//Hashing
		int keyMap = 1;
		for(String number : phoneBook) {
			map.put(keyMap++, number);
		}
		
		//substring : 문자열 자르기 (1195524421)
		for(int i = 0; i < phoneBook.length; i++) {
			for(int j = 1; j < phoneBook[i].length(); j++) {
				if(map.containsValue(phoneBook[i].substring(0,j))) {
					answer = false;
				}
			}
		}
		return answer;
	}
	
	
	
}
