public class BookTest_1 {

	private int a1, gu;// a1 = 수입한 금액,지출금액, gu = 수입과 지출을 구분
	private String memo;// memo :수입, 지출 내용

	public int getA1() {// A1값들을 누적해야 합계를 구하기 때문에 가져옴.
		return a1;
	}// return 해줌으로서 누적한다

	public int getGu() {// 수입과 지출을 구분하기 위해서 gu를 return 해줌.
		return gu;
	}// return 해줌으로서 누적한다

	public BookTest_1(int a1, String memo, int gu) {// 생성자 메서드
		this.a1 = a1;// a1값 지정
		this.gu = gu;// gu값 지정
		this.memo = memo;// memo값 지정
	}// 값을 생성해줌

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return gu == 1 ? "수입금액" + "\t" + a1 + "\t" + memo + "\r\n" : "지출금액" + "\t" + a1 + "\t" + memo + "\r\n";
		// gu의 값이 1이면 수입금액을 출력, 아니면 지출금액을 출력함.
	}
}
