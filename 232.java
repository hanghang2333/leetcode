//利用堆栈来实现队列
//方法是利用两个堆栈，一个负责元素进入，而后依次pop到另一个堆栈中负责出。在调用pop和peek时进行此动作。
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