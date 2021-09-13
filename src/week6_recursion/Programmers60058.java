/**
 * ����Լ� - ��ȣ��ȯ
 * ���� - https://gre-eny.tistory.com/67
 */
package week6;

import java.util.Stack;

public class Programmers60058 {

	public static void main(String[] args) {
//		String p = "(()())()";
		String p = ")(";
//		String p = "()))((()";
		
		System.out.println(solution(p));
	}
	
	public static String solution(String p) {
		String answer = "";
		
		/* 1. �Է��� �� ���ڿ��� ���, �� ���ڿ��� ��ȯ�մϴ�. */
		if(p.isEmpty() || check(p)) {
			return p;
		}
		
		/* 2. ���ڿ� w�� �� "�������� ��ȣ ���ڿ�" u�� v(������ ���ڿ�)�� �и��մϴ�. */
		int sep = divide(p);
		String u = p.substring(0, sep);
		String v = p.substring(sep, p.length());
		
		/* 3. ���ڿ� u�� "�ùٸ� ��ȣ ���ڿ�" �̶�� ���ڿ� v�� ���� 1�ܰ���� �ٽ� �����մϴ�. 
  		   3-1. ������ ��� ���ڿ��� u�� �̾� ���� �� ��ȯ�մϴ�. */
		if(check(u)) {
			answer = u + solution(v);
		/* 4. ���ڿ� u�� "�ùٸ� ��ȣ ���ڿ�"�� �ƴ϶�� �Ʒ� ������ �����մϴ�. */
		}else {
			/* 4-1. �� ���ڿ��� ù ��° ���ڷ� '('�� ���Դϴ�. 
  			   4-2. ���ڿ� v�� ���� 1�ܰ���� ��������� ������ ��� ���ڿ��� �̾� ���Դϴ�. 
  			   4-3. ')'�� �ٽ� ���Դϴ�. */
			String s = "(" + solution(v) + ")";
			/* 4-4. u�� ù ��°�� ������ ���ڸ� �����ϰ�, ������ ���ڿ��� ��ȣ ������ ����� �ڿ� ���Դϴ�. 
  			   4-5. ������ ���ڿ��� ��ȯ�մϴ�. */
			answer = s + replace(u.substring(1, u.length() - 1));
		}
		return answer;
	}
	
	
	//�ùٸ� ��ȣ ���ڿ����� check�Ͽ� true��ȯ�ϴ� ���� - stack �̿�
	public static boolean check(String p) {
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == '(') {
				stack.push('(');
			}else {
				if(stack.isEmpty()) {
					return false;
				}else {
					stack.pop();
				}
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	//p�� ���� ���� '���� ���� ��ȣ ���ڿ�'�� u�� ���ϱ� ����, ������ �ε����� ��ȯ
	public static int divide(String p) {
		int leftCnt = 0;
		int rightCnt = 0;
		
		for(int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == '(') {
				leftCnt++; // '('�� ����
			}else {
				rightCnt++; // ')'�� ����
			}
			if(leftCnt == rightCnt) { //¦�� �´� ���� for�� �����, �� ��ġ(leftCnt + rightCnt) �����ؼ� return
				break;
			}
		}
		return leftCnt + rightCnt;
	}
	
	//��ȣ ������ ������ ����
	public static String replace(String u) {
		String r = "";
		for(int i = 0; i < u.length(); i++) {
			if(u.charAt(i) == '(') {
				r = r + ")"; //u���ڿ��� �ϳ��� �˻��ϸ鼭 ( -> )�� ��ȯ
			}else {
				r = r + "("; // ) -> (�� ��ȯ
			}
		}
		return r;
	}
	

}
