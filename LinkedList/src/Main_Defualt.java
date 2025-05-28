
public class Main_Defualt<T> {
	public Node<T> root = null;
	public int size = 0;
	
	public static void main(String[] args) {
		Main_Defualt<String> list = new Main_Defualt<>();
		
		

	}

	/*
	 * 전반적인 구조
	 * add가 addFirst와 addAfter를 상황에 맞게 호출
	 * getNode와 get은 엄연히 다른 기능
	 * */
	
	public void addFirst(T item) {
		Node<T> newNode = new Node<>(item);
		newNode.next = root;
		root = newNode;
		size++;
	}
	
	public void addAfter(Node<T> before, T item) {
		Node<T> temp = new Node<>(item);
		temp.next = before.next;
		before.next = temp;
		size++;
	}
	
	// 노드를 새로 만들어서 중간에 집어넣음
	public void add(int index, T item) {
		if(index < 0 || index > size) {
			return;
		}
		
		if(index == 0) {
			addFirst(item);
		} else {
			addAfter(getNode(index), item);
		}
	}
	
	public T removeFirst() {
		if(root == null) {
			return null;
		}
		T temp = root.data;
		root = root.next;
		size--;
		return temp;
	}
	
	public T removeAfter(Node<T> before) {
		if(before.next == null) {
			return null;
		}
		T temp = before.next.data;
		before.next = before.next.next;
		size--;
		return temp;
	}
	
	public T remove(int index, T item) {
		if(index < 0 || index >= size) {
			return null;
		}
		
		if(index == 0) {
			return removeFirst();
		}
		
		Node<T> prev = getNode(index-1);
		return removeAfter(prev);
	}
	
	public Node<T> getNode(int index) {
		if(index < 0 || index >= size) {
			return null;
		}
		
		Node<T> temp = root;
		
		for(int i = 0 ; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	public T get(int index) {
		if(index < 0 || index >= size) {
			return null;
		}
		return getNode(index).data;
	}
	
	public int indexOf(T item) {
		Node<T> temp = root;
		int index = 0;
		while(temp != null) {
			if(temp.data.equals(item)) {
				return index;
			}
			temp = temp.next; // p를 한칸씩 옮김
			index++;
		}
		return -1;
	}
	
	public static class Node<T> {
		public T data;
		public Node<T> next;
		
		public Node(T data) {
			this.data = data;
			next = null;
		}
	}
}