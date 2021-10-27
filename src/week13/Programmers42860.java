/**
 * ���̽�ƽ - Ž���(���� ��Ȳ���� ���� ���� ������ �ظ� ���� ���)
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
		int min = len - 1; // ù���ں��� �ǳ����� �̵�Ƚ�� => ���� ū �̵����� ��
		
        int answer = 0;
        for(int i = 0; i < len; i++) {
        	// ���� �̵�: char������ �ƽ�Ű �ڵ�� ��ȯ�켭 ������ ���� ����
        	if(name.charAt(i) <= 'M') {
        		answer += name.charAt(i) - 'A'; // �� ���� A���� �̵��� Ƚ��
        	}else {
        		answer += 'Z' - name.charAt(i) + 1; // �� �� Z���� �̵��� Ƚ��
        	}
        	
        	// �¿� �̵�: �������� A�� ���� ��츦 üũ�������
        	int next = i + 1;
        	while(next < len && name.charAt(next) == 'A') { // ���� �ܾ A�̰�, �ܾ ������ ������ next ����
        		next++;
        	}
        	min = Math.min(min, i + len - next + Math.min(i, len-next));
        	/*
        	 * ���ӵ� A�� ���忡 ���� �ּ� �������� �޶�����
        	 * min�� �����־�� �ϴ� ���� = �������� ������ �ٲ㼭 �ٽ� index=0������ �̵��ϴ� ��
        	 * �� ��ġ���� ù��ġ�� ���ư� �� (i + i)
        	 * A�� �������� ������ ������ ���� (next)�� ��(len)���� ���ش� -> len - next
        	 * 
        	 * ** len-next >= 1 
        	 */
        	/*
        	 * len - next: �� ���̿��� ���� �ٷ� ������ ���ӵ� A�� ������ ���� ���� ����
        	 * i: ������������ ��������� �̵�Ƚ��
        	 * i + len - next + i: ������� �Դٰ� �ٽ� ���ư��� �����ű��� ���� �̵� Ƚ��
        	 * min(i, len-next)����, 
        	 * i���� len-next���� ���� ��쿡 len-next�� �����ϴµ�,
        	 * �̴� => ������ ���ڰ� A�� ��츦 �����ϸ� ������ len-1���� ũ�� �ȴ�.
        	 */
        	/*
        	 * ������ �߰��� ���� ó�� �ʱ�ȭ�� �ϵ��ڵ��մϴ�. min = len - 1.
        	 * �װͺ��� ���� ��츦 ã�� �˰����� min = Math.min(min, i + len - next + Math.min(i, len - next)); �Դϴ�.
        	 * i+len-next�� '�ٷο��� a���� ������ �ٸ� ���ڵ��� ���� -1' �Դϴ�. 
        	 * ���� ��� AAABBBBBBBAA �� i=2�� ��� next = 10, len�� 12 �̾ 4�̵˴ϴ�.
        	 * ��, B�� �ǳ��� �ʰ� �ݴ�� �Ѿ�� ��츦 ����ϴ� ���Դϴ�. ���⼭ ������ �츮�� �������� �ε��� 0�ΰͿ� �ֽ��ϴ�.
        	 * �츮�� i���� ���ٰ� �ǵ��ư��ų� ó������ �ڷΰ��� len-next���� ���ٰ� �ٽ� ���ƿ��� ��츦 �����ؾ��մϴ�.
        	 * ���� �������� i=2 ��ĭ������ ���ٰ� ���ƿ�����, ó������ �ڷΰ��� length-next = 12 - 10 = 2�� ����ؾ��ϴ� ���Դϴ�.
        	 * �� ��쿡�� �ΰ��� ���� �������� �ٸ� �� �־ Math.min���� ������ �������ִ� ���Դϴ�.
        	 * ���� ����� ��Ȯ���� �ʾƼ� ��۴�ϴ�.
        	 */
        }
        answer += min;
        
        return answer;
    }

}
