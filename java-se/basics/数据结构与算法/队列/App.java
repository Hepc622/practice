package 队列;

/**
 * 此类是：队列的实现
 * 
 * @author hpc
 * @date 2016年12月20日 下午1:42:50
 */
public class App<E> {
	private Node front, rear;
	private int size;

	public static void main(String[] str) {
		App<String> app = new App<String>();
		app.insert("1");
		app.insert("2");
		app.insert("3");
		app.insert("4");
		app.insert("5");
		app.insert("6");
	}

	public App() {
		front = new Node(new Node());
		rear = front;
	}

	public App(E data) {
		front = new Node(data, new Node());
		rear = front;
		size++;
	}

	public void insert(E e) {
		Node node = new Node(e, new Node());
		if (front.data == null)
			front = node;
		rear.node = node;
		rear = node;
		size++;
	}

	public E delete() {
		E e = front.data;
		front = front.node;
		size--;
		return e;
	}

	public void show() {
		Node traverse = front;
		while (traverse != rear && traverse != null) {
			System.out.print(traverse.data);
			traverse = traverse.node;
		}
		if (traverse == rear) {
			System.out.println(rear.data);
		}
	}

	public class Node {
		public E data;
		public Node node;

		public Node(E data) {
			this.data = data;
		}

		public Node() {
		}

		public Node(E data, Node node) {
			this.data = data;
			this.node = node;
		}

		public Node(Node node) {
			this.node = node;
		}
	}

}
