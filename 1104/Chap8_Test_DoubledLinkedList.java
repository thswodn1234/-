package Chap8_List;

public class Chap8_Test_DoubledLinkedList {

}
package Chap8_List;

import java.util.Comparator;

import Chap8_List.DoubledLinkedListTester.Data;
import Chap8_List.LinkedListRevised.Node;

public class DoubledLinkedList<E> {

//원형 이중 연결 리스트 클래스 - first node를 가짐

	// --- 노드 ---//
	class Node<E> {
		private E data; // 데이터
		private Node<E> llink; // 앞쪽포인터(앞쪽 노드에 대한 참조)
		private Node<E> rlink; // 뒤쪽포인터(뒤쪽 노드에 대한 참조)

		// --- 생성자(constructor) ---//

	}

	private Node<E> first; // 머리 포인터(참조하는 곳은 더미노드)

	// --- 생성자(constructor) ---//
	public DoubledLinkedList() {
		first = new Node<E>(); // dummy(first) 노드를 생성
	}

	// --- 리스트가 비어있는가? ---//
	public boolean isEmpty() {
		return first.rlink == first;
	}

	// --- 노드를 검색 ---//
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = first.rlink; // 현재 스캔 중인 노드

		while (ptr != first) {
			if (c.compare(obj, ptr.data) == 0) {
				return ptr.data; // 검색 성공
			}
			ptr = ptr.rlink; // 뒤쪽 노드에 주목
		}
		return null; // 검색 실패
	}

	// --- 전체 노드 표시 ---//
	public void show() {
		Node<E> ptr = first.rlink; // 더미 노드의 뒤쪽 노드

		while (ptr != first) {
			System.out.println(ptr.data);
			ptr = ptr.rlink;
		}
	}

	// --- 올림차순으로 정렬이 되도록 insert ---//
	public void add(E obj, Comparator<? super E> c) {
	

	}

	// --- list에 삭제할 데이터가 있으면 해당 노드를 삭제 ---//
	public void delete(E obj, Comparator<? super E> c) {
	
}
