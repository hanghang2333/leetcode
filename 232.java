//���ö�ջ��ʵ�ֶ���
//����������������ջ��һ������Ԫ�ؽ��룬��������pop����һ����ջ�и�������ڵ���pop��peekʱ���д˶�����
class MyQueue {
    private Stack<Integer> in = new Stack<>();
	private Stack<Integer> out = new Stack<>();

	// Push element x to the back of queue.
	public void push(int x) {
		in.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		if (!out.isEmpty()) {
			out.pop();
		} else {
			while (!in.isEmpty())
				out.push(in.pop());
			out.pop();
		}
	}

	// Get the front element.
	public int peek() {
		if (!out.isEmpty())
			return out.peek();
		while (!in.isEmpty())
			out.push(in.pop());
		return out.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return out.empty() && in.empty();
	}
}