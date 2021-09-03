package step4;

import java.util.Stack;

/**
 * Stack �ڷᱸ�� Ư¡: Last In, First Out(LIFO)
 * @author cheol
 *
 */
public class TestStack {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		System.out.println(stack);
		
		// ������ ��� ����
		// System.out.println(stack.pop());
		// System.out.println(stack);
		// System.out.println(stack.pop());
		// System.out.println(stack.isEmpty()); // ��������� true, ��Ұ� ������ false
		
		// while���� �̿��ؼ� stack�� ��Ҹ� ��� ���( isEmpty(), pop() )
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		System.out.println(stack);
	}
}
