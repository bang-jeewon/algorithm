/**
 * 조이스틱 - 탐욕법(현재 상황에서 가장 좋은 최적의 해만 고르는 방법)
 * https://mishuni.tistory.com/36
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 */
package week13;

public class Programmers42860 {

	public static void main(String[] args) {
		
//		String name = "JEROEN";
		String name = "JAN";
		
		System.out.println(solution(name));
	}
	
	public static int solution(String name) {
		int len = name.length();
		int min = len - 1; // 첫글자부터 맨끝까지 이동횟수 => 가장 큰 이동값이 됨
		
        int answer = 0;
        for(int i = 0; i < len; i++) {
        	// 상하 이동: char변수를 아스키 코드로 변환헤서 숫자의 차로 구함
        	if(name.charAt(i) <= 'M') {
        		answer += name.charAt(i) - 'A'; // 상 으로 A에서 이동한 횟수
        	}else {
        		answer += 'Z' - name.charAt(i) + 1; // 하 로 Z에서 이동한 횟수
        	}
        	
        	// 좌우 이동: 연속으로 A가 나올 경우를 체크해줘야함
        	int next = i + 1;
        	while(next < len && name.charAt(next) == 'A') { // 다음 단어가 A이고, 단어가 끝나기 전까지 next 증가
        		next++;
        	}
        	min = Math.min(min, i + len - next + Math.min(i, len-next));
        	/*
        	 * 연속된 A의 등장에 따라 최소 움직임이 달라진다
        	 * min과 비교해주어야 하는 값은 = 왼쪽으로 방향을 바꿔서 다시 index=0쪽으로 이동하는 것
        	 * 내 위치에서 첫위치로 돌아간 후 (i + i)
        	 * A가 연속으로 나오는 지점의 다음 (next)을 끝(len)에서 빼준다 -> len - next
        	 * 
        	 * ** len-next >= 1 
        	 */
        	/*
        	 * len - next: 총 길이에서 현재 바로 다음에 연속된 A가 지나고 남은 문자 갯수
        	 * i: 오른쪽으로의 현재까지의 이동횟수
        	 * i + len - next + i: 현재까지 왔다가 다시 돌아가서 남은거까지 가는 이동 횟수
        	 * min(i, len-next)에서, 
        	 * i보다 len-next값이 작은 경우에 len-next를 선택하는데,
        	 * 이는 => 마지막 문자가 A인 경우를 제외하면 무조건 len-1보다 크게 된다.
        	 */
        	/*
        	 * 앞으로 쭉가는 경우는 처음 초기화로 하드코딩합니다. min = len - 1.
        	 * 그것보다 작은 경우를 찾는 알고리즘이 min = Math.min(min, i + len - next + Math.min(i, len - next)); 입니다.
        	 * i+len-next는 '바로옆의 a들을 제외한 다른 문자들의 길이 -1' 입니다. 
        	 * 예를 들면 AAABBBBBBBAA 는 i=2일 경우 next = 10, len는 12 이어서 4이됩니다.
        	 * 즉, B를 건너지 않고 반대로 넘어가는 경우를 고려하는 것입니다. 여기서 문제는 우리의 시작점은 인덱스 0인것에 있습니다.
        	 * 우리는 i까지 갔다가 되돌아가거나 처음부터 뒤로가서 len-next까지 갔다가 다시 돌아오는 경우를 생각해야합니다.
        	 * 앞의 예에서는 i=2 두칸앞으로 갔다가 돌아오느냐, 처음부터 뒤로가서 length-next = 12 - 10 = 2를 고려해야하는 것입니다.
        	 * 이 경우에는 두개가 같은 값이지만 다를 수 있어서 Math.min으로 방향을 선택해주는 것입니다.
        	 * 위의 댓글이 정확하지 않아서 댓글답니다.
        	 */
        }
        answer += min;
        
        return answer;
    }

}
