package Chap8_List;

public class Chap8_Test_LinkedListTester {

}
package Chap8_List;

import java.util.Scanner;
import java.util.Comparator;

public class LinkedListTesterRevised {
	static Scanner stdIn = new Scanner(System.in);

	static class Data {
		static final int NO = 1; // 번호를 읽어 들일까요?
		static final int NAME = 2; // 이름을 읽어 들일까요?

		private Integer no; // 회원번호
		private String name; // 이름

		// --- 문자열 표현을 반환 ---//
		public String toString() {
			return "(" + no + ") " + name;
		}

		// --- 데이터를 읽어 들임 ---//
		void scanData(String guide, int sw) {
			System.out.println(guide + "할 데이터를 입력하세요.");

			if ((sw & NO) == NO) {
				System.out.print("번호: ");
				no = stdIn.nextInt();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("이름: ");
				name = stdIn.next();
			}
		}

		// --- 회원번호로 순서를 매기는 comparator ---//
		public static final Comparator<Data> NO_ORDER = new NoOrderComparator();

		private static class NoOrderComparator implements Comparator<Data> {
			public int compare(Data d1, Data d2) {
				return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0;
			}
		}

		// --- 이름으로 순서를 매기는 comparator ---//
		public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

		private static class NameOrderComparator implements Comparator<Data> {
			public int compare(Data d1, Data d2) {
				return d1.name.compareTo(d2.name);
			}
		}
	}

	// --- 메뉴 열거형 ---//
	enum Menu {
		ADD("삽입"), DELETE("삭제"), SEARCH_NO("번호 검색"), SEARCH_NAME("이름 검색"), SHOW("전체 명부 출력"), TERMINATE("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

//선형리스트 클래스 LinkedList<E>의 사용 예

//--- 데이터(회원번호＋이름) ---//

//--- 메뉴 선택 ---//
	static Menu SelectMenu() {
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.TERMINATE.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		// 자바 객체 배열을 만들어 linked list에 insert한다.
		Menu menu; // 메뉴
		Data data; // 추가용 데이터 참조
		Data ptr; // 검색용 데이터 참조
		Data temp = new Data(); // 읽어 들일 데이터

		LinkedListRevised<Data> list = new LinkedListRevised<Data>(); // 리스트를 생성

		do {
			switch (menu = SelectMenu()) {

			case ADD: // 삽입
				data = new Data();
				data.scanData("삽입", Data.NO | Data.NAME);

				break;

			case DELETE: // 삭제
				data = new Data();
				data.scanData("삽입", Data.NO | Data.NAME);

				break;

			case SEARCH_NO: // 회원 번호 검색
				temp.scanData("검색", Data.NO);
				ptr = list.search(temp, Data.NO_ORDER);
				if (ptr == null)
					System.out.println("그 번호의 데이터가 없습니다.");
				else
					System.out.println("검색 성공: " + ptr);
				break;

			case SEARCH_NAME: // 이름 검색
				temp.scanData("검색", Data.NAME);
				ptr = list.search(temp, Data.NAME_ORDER);
				if (ptr == null)
					System.out.println("그 이름의 데이터가 없습니다.");
				else
					System.out.println("검색 성공: " + ptr);
				break;

			case SHOW: // 전체 노드를 리스트 순서대로 표시
				list.show();
				break;


			}
		} while (menu != Menu.TERMINATE);
	}
}
