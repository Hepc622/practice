package base.structure;

/**
 * 此类是：栈的实现，后进先出
 * @author hpc
 * @date 2016年12月20日 下午3:08:51
 */
public class Stacks<E> {
	private LinkNode first;
	private LinkNode last;
	private int size;

	public static void main(String[] args) {
		Stacks<String> app = new Stacks<String>();
		for (int i = 1; i <= 30; i++) {
			app.insert(i + "");
		}
		app.show();
	}

	public Stacks() {
		first = new LinkNode(null, null);
		last = first;
	}

	/**
	 * 打印出所有节点的数据
	 */
	public void show() {
		LinkNode node = first.next;
		while (node != null) {
			System.out.print(node.e + ",");
			node = node.next;
		}
	}

	/**
	 * 链表是否为空
	 */
	public boolean isEmpty() {
		return this.size == 0 ? true : false;
	}

	/**
	 * 在链里添加元素
	 */
	public void insert(E e) {
		// 头插入法
		first.next = new LinkNode(e, first.next);
		// 尾插入法
		// 将last指向first
		// LinkNode newNode = new LinkNode(e, null);
		// last.next = newNode;
		// last = newNode;
		size++;
	}

	/**
	 * 在链里添加元素
	 */
	public void insert(E e, int index) {
		if (index > size)
			throw new ArrayIndexOutOfBoundsException("out size:" + index);
		int count = 0;
		last = first.next;
		while (last != null) {
			if (count == index) {
				LinkNode node = new LinkNode(e, null);
				node.next = last.next;
				last.next = node;
				break;
			}
			last = last.next;
			count++;
		}
		size++;

	}

	/**
	 * 获取指定下表的元素
	 */
	@SuppressWarnings("unchecked")
	public E getElement(int index) {
		if (index > size)
			throw new ArrayIndexOutOfBoundsException("out size:" + index);
		int count = 0;
		last = first.next;
		while (last != null) {
			if (count == index) {
				return (E) last.e;
			} else {
				last = last.next;
			}
			count++;
		}
		return null;
	}

	public void deleteElement(int index) {
		if (index > size)
			throw new ArrayIndexOutOfBoundsException("out size:" + index);
		int count = 0;
		last = first.next;
		while (last != null) {
			if (index != 0)
				if (count == index - 1) {
					if (last.next != null) {
						last.next = last.next.next;
					} else {
						last = null;
					}
					size--;
					break;
				} else {
					last = last.next;
				}
			else {
				LinkNode next = last.next;
				first.next = next;
				break;
			}
			count++;
		}
	}

	/**
	 * 消除链的所有节点
	 */
	public void disDestroyLinke() {
		LinkNode node = last.next;
		while (node != null) {
			last = null;
			last = node;
			node = last.next;
			size--;
		}
	}

	class LinkNode {
		public Object e;
		public LinkNode next;

		public LinkNode(Object e, LinkNode next) {
			this.e = e;
			this.next = next;
		}

		public LinkNode(LinkNode next) {
			this.next = next;
		}

		public LinkNode() {
		}
	}
}
