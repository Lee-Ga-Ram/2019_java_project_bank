import java.awt.Color;
//Color클래스는 기본 sRGB 색상 공간에서 색상을 캡슐화하거나으로 식별되는 임의 색상 공간의 색상을 캡슐화하는 데 사용
import java.awt.FlowLayout;//FlowLayout을 불러옴.
import java.awt.Image;
//이미지를 만들고 수정하기위한 클래스를 제공함.
import java.awt.Toolkit;
//이 클래스는 Abstract Window Toolkit의 모든 실제 구현의 추상 수퍼 클래스이다. 클래스의 서브 Toolkit클래스는 다양한 컴포넌트를 특정 고유 툴킷 구현에 바인딩하는 데 사용함.
import javax.swing.JFrame;
//java.awt.Frame 클래스를 상속하는 컨테이너 유형. JFrame은 GUI를 만들기 위해 레이블, 버튼, 텍스트 필드와 같은 구성 요소가 추가되는 기본 창처럼 작동함.
import javax.swing.JLabel;
//JLabel은 java Swing 클래스이다. JLabel은 짧은 문자열 또는 이미지 아이콘을 표시하는 데 사용함.
import javax.swing.JPanel;
//Java Swing 패키지의 일부인 JPanel은 구성 요소 그룹(라벨, 버튼 등.)을 저장할 수있는 컨테이너이다.
import javax.swing.JTextArea;
//JTextArea 클래스의 객체는 텍스트를 표시하는 여러 줄 영역이다. 여러 줄의 텍스트를 편집 할 수 있다.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;//DB

class Book {

	int a1 = 0, gu;// a1 = 수입금액,지출금액, gu = 수입과 지출을 구분
	String memo = "";// 수입, 지출 내용을 저장함
	int getM = 0, outM = 0;// getM = 수입합계, outM = 지출합계
	public static int Total;// 수입과 지출의 합계

	public Book() {
//      JPanel titleP, titleP2, getP, outP;//제목 , 수입 내용, 지출 내용
//      JLabel Gresult1, Gresult2, Gresult3;//결과
//      JTextField getT, getT2, outL;//수입내역, 지출내역
		int sum1 = 0, sum2 = 0;// sum1 = 수입금액 합계, sum2 = 지출금액 합계

		JFrame f1 = new JFrame();// 장부가 나타날 창
		JPanel titleP = new JPanel();// Gresult1를 넣을 패널
		// JPanel은 라벨이나 버튼이 올라갈 액자같은 것
		titleP.setBackground(new Color(255, 204, 0));// titleP의 배경색 지정함

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("pig.png");
		f1.setIconImage(img);

		f1.setLayout(new FlowLayout());
		// FlowLayout = 컴포넌트들이 왼쪽에서 오른쪽으로 추가됨
		// 기본적으로 가운데 정렬,
		// container의 크기가 변경 => component크기는 고정되고 위치는 변함
		JLabel Gresult1 = new JLabel("  ==가계부 장부 보기!!!==   ");// 가계부의 제목을 나타내는 JLabel, Gresult1
		// JLabel은 짧은 문자열 또는 이미지 아이콘을 표시하는 데 사용
		JLabel Gresult2 = new JLabel("============================================================");
		// Gresult2에 ======을 저장함.
		JPanel titleP2 = new JPanel();// Gresult2를 넣을 패널 titleP2생성
		titleP2.setBackground(new Color(255, 204, 0));// titleP의 배경색 지정함

		JPanel getP = new JPanel();// getT를 넣을 패널 getP 생성

		getP.setSize(400, 400);// getP의 크기를 400X400으로 지정함
		JTextArea getT = new JTextArea();// 텍스트영역 getT를 생성, getT에 지출과 수입의 내용이 들어감
		getT.setColumns(44);// 텍스트 영역의 열 수를 지정된 정수로 설정합니다.
		getT.setRows(25);// 텍스트 영역의 행 수를 지정된 정수로 설정합니다.
		titleP.add(Gresult1);// titleP에 Gresult1을 부착함
		String title = "수입" + "\t" + "지출" + "\t" + "내   용" + "\r\n";
		// title에 문자열을 대입함.

		getT.setText(title);// getT의 텍스트를 title의 텍스트로 지정함
		titleP2.add(Gresult2);// titleP2에 Gresult2를 부착함

		getP.add(getT);// getP에 getT를 부착함

		f1.add(titleP);// f1에 titleP를 부착함
		f1.add(titleP2);// f1에 titleP2를 부착함
		f1.add(getP);// f1에 getP를 부착함

		f1.setTitle("==장부==");// f1의 제목 : 장부
		f1.setSize(500, 600);// f1의 크기 : 500 X 600
		f1.setVisible(true);// f1을 보이게 설정
		f1.setResizable(false);// f1의 크기를 변경할 수 없음
		f1.setLocationRelativeTo(null);// 가운데 정렬
		f1.getContentPane().setBackground(new Color(255, 204, 0));// f1의 배경색 지정함
		if (VectorData.vd.isEmpty()) {// 객체가 비어있는지 확인함
			System.out.println("아직 입력된 값이 없습니다");// 비어 있다면, 출력
		}

		else {
			for (BookTest_1 item : VectorData.vd) {// 저장되어 있는 자료들(item)을 가져움
				// item = VectorData에 있는 BookTest_1의 자료들
				title = title + item.toString();
				// title에 title과 item.toString을 합쳐서 대입
				if (item.getGu() == 1) {// 수입일 경우
					sum1 += item.getA1();// sum1에 item.getA1()을 누적합
				}
				if (item.getGu() == 2) {// 지출일 경우
					sum2 += item.getA1();// sum2에 item.getA1()을 누적합
				}
			}
		} // end of else

		/*
		 * title = title + "지출금액합계 : " + sum2 + "   ||    ";// title에 title +
		 * "지출금액합계 : " + sum2 + " || "를 연결하여 대입 title = title + "수입금액합계 : " + sum1 +
		 * "\r\n";// title에 title + "수입금액합계 : " + sum1에 줄바꿈을 하여 대입 int total = (sum1 -
		 * sum2);// total에 sum1 - sum2를 하여 대입함 title = title + "지출수입합계 : " + total +
		 * "\r\n";// title에 title + "지출수입합계 : " + total에 줄바꿈한것을 대입 Total = total;// 멤버변수
		 * Total에 total을 대입
		 */
		// getT.setText(title);// getT에 title이 찍히도록 함.
		// f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Connection conn = null; // DB연결된 상태(세션)을 담은 객체
		PreparedStatement pstm = null; // SQL 문을 나타내는 객체
		ResultSet rs = null; // 쿼리문을 날린것에 대한 반환값을 담을 객체
		int tist = 0;
		int tist2 = 0;
		int tist3 = 0;
		try {
			// SQL 문장을 만들고 만약 문장이 질의어(SELECT문)라면
			// 그 결과를 담을 ResulSet 객체를 준비한 후 실행시킨다.
			String quary = "SELECT * FROM DIARY";
			String test = "SELECT SUM(INCOME) FROME DIARY";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();

			/*
			 * EMP 테이블의 데이터 타입
			 * 
			 * EMPNO NOT NULL NUMBER(4) -- int ENAME VARCHAR2(10) -- String JOB VARCHAR2(9)
			 * -- String MGR NUMBER(4) -- int HIREDATE DATE -- Date SAL NUMBER(7,2) --
			 * float/double COMM NUMBER(7,2) -- float/double DEPTNO NUMBER(2) -- int
			 */

			System.out.println("완성");
			System.out.println("============================================");

			while (rs.next()) {
				int INCOME = rs.getInt(1);
				int EXPENCE = rs.getInt(2);
				int INCOME_SUM = rs.getInt(3);
				int EXPENCE_SUM = rs.getInt(4);
				java.sql.Date DATE_TIME = rs.getDate(7); // Date 타입 처리
				int TOTAL = rs.getInt(5);
				String CONTENTS = rs.getString(6);

				String result = INCOME + "\t" + EXPENCE + "\t" /*
																 * + INCOME_SUM + "\t" + EXPENCE_SUM + "\t" + TOTAL +
																 * "\t"
																 */
						+ CONTENTS + "\n"/* + DATE_TIME + " \n" */;
				tist += INCOME;
				tist2 += EXPENCE;
//System.out.println(tist);
				getT.append(result);// getT에 title이 찍히도록 함.
			}
			// System.out.println(tist);
			String title2 = "\n 수입 합계 : " + tist;
			String title3 = "\n 지출 합계 : " + tist2;
			tist3 = tist - tist2;
			String title4 = "\n 총 합계 : " + tist3;
			getT.append(title2);
			getT.append(title3);
			getT.append(title4);
		} catch (SQLException sqle) {
			System.out.println("SELECT문에서 예외 발생");
			sqle.printStackTrace();

		} finally {
			// DB 연결을 종료한다.
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}// end of Book()

}// end of class

public class BookTest {
//어떤 버튼을 누르면 클래스가 호출되도록 메인에서 해주어야 함.
	public static void main(String[] args) {
		new Book();

	}

}
