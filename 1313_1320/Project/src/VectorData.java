import java.util.Vector;//java.util.Vector의 클래스는 객체의 가변 길이 배열을 구현
//Vector 클래스 = 확장 가능한 객체 배열을 구현
//Vector 클래스는 객체에 대한 참조값을 저장하는 배열이므로
//다양한 객체들이 하나의 Vector에 저장될 수 있고 길이도 
//필요에 따라 증감할 수 있다는 점이 배열과 다른 점이다.
//1. 항목의 추가 및 제거를 수용하기 위해 필요에 따라 Vector의 크기가 커지거나 줄어들 수 있다.
//2. 배열과 마찬가지로 정수 인덱스를 사용하여 액세스 할 수있는 구성 요소가 포함된다.
//3.Vector는 배열의 크기를 미리 모르거나 프로그램 수명 동안 크기를 변경할 수있는 배열이 필요한 경우 매우 유용함.

public class VectorData {
	public static Vector<BookTest_1> vd = new Vector<BookTest_1>(10, 5);
	// 장부의 자료구조로 Vector를 사용, Vector : 누적합을 구할 때 많이 사용함.
	// bookTest_1 클래스에 Vector라는 자료구조를 넣음. (10,5) = 10행 5열이지만, 입력한 양에 따라 알아서 증가함.
	// Vector = 자료들을 저장할 공간
}
