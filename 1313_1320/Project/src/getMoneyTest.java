import java.awt.Color;
//Color클래스는 기본 sRGB 색상 공간에서 색상을 캡슐화하거나으로 식별되는 임의 색상 공간의 색상을 캡슐화하는 데 사용
import java.awt.FlowLayout;//FlowLayout을 불러옴.
import java.awt.Font;
//Swing 에서 Font 클래스를 글자체 즉 폰트를 지정하기 위해서는 사용
import java.awt.Image;
//이미지를 만들고 수정하기위한 클래스를 제공함.
import java.awt.Toolkit;
//이 클래스는 Abstract Window Toolkit의 모든 실제 구현의 추상 수퍼 클래스이다. 클래스의 서브 Toolkit클래스는 다양한 컴포넌트를 특정 고유 툴킷 구현에 바인딩하는 데 사용함.
import java.awt.event.ActionEvent;
//구성 요소 정의 조치가 발생했음을 나타내는 의미 론적 이벤트. 
import java.awt.event.ActionListener;
//버튼 또는 메뉴 항목을 클릭 할 때마다 Java ActionListener에 알린다. ActionEvent에 대해 통지
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
//ImageIcon은 아주 작은 이미지, 즉 아이콘을 이미지객체로 만든 것
import javax.swing.JButton;
//JButton 클래스는 플랫폼 독립적인 구현이있는 레이블이 지정된 단추를 작성하는 데 사용됨
import javax.swing.JFrame;
//java.awt.Frame 클래스를 상속하는 컨테이너 유형. JFrame은 GUI를 만들기 위해 레이블, 버튼, 텍스트 필드와 같은 구성 요소가 추가되는 기본 창처럼 작동함.
import javax.swing.JLabel;
//JLabel은 java Swing 클래스이다. JLabel은 짧은 문자열 또는 이미지 아이콘을 표시하는 데 사용함.
import javax.swing.JPanel;
//Java Swing 패키지의 일부인 JPanel은 구성 요소 그룹(라벨, 버튼 등.)을 저장할 수있는 컨테이너이다.
import javax.swing.JTextField;
//JTextField 클래스의 객체는 한 줄 텍스트를 편집 할 수있는 텍스트 구성 요소이다.
import javax.swing.border.EtchedBorder;
//테두리에 홈이 파여있는 느낌 Border를 불러옴.

class getMoney {
	int a1 = 0, gu;// a1 = 수입한 금액,지출금액, gu = 수입과 지출을 구분
	String memo = "";// 수입, 지출 내용

	public getMoney() {
		// 수입 - getMoney : 벌어들인 돈을 입력한다

//      JFrame f1;
//      JLabel l1, l2, l3
//      JTextField t1;//텍스트필드 t1
//      JPanel titleP getP, priceP, buttonP;//JPanel = 컴포넌트 들을 감싸줌
//       //getP = 얻은 금액, priceP = 돈이 생긴 이유, buttonP = 저장하기 버튼
//      JButton b1;//버튼 b1
		JFrame f1 = new JFrame();// '수입' 화면
		JPanel titleP = new JPanel();// 제목을 넣을 패널
		JPanel getP = new JPanel();// 수입 내용을 넣을 패널
		JPanel ImageP = new JPanel();// 이미지를 넣을 패널
		JPanel priceP = new JPanel();// 수입내용을 넣을 패널

		f1.setBackground(new Color(255, 204, 0));// f1의 색깔 지정
		getP.setBackground(new Color(255, 204, 0));// getP의 색깔 지정
		titleP.setBackground(new Color(255, 204, 0));// titleP의 색깔 지정
		priceP.setBackground(new Color(255, 204, 0));// priceP의 색깔 지정
		ImageP.setBackground(new Color(255, 204, 0));// ImageP의 색깔 지정

		Toolkit toolkit = Toolkit.getDefaultToolkit();// 아이콘 추가
		Image img = toolkit.getImage("pig.png");
		f1.setIconImage(img);

		// FlowLayout = 컴포넌트들이 왼쪽에서 오른쪽으로 추가됨
		// 기본적으로 가운데 정렬,
		// container의 크기가 변경 => component크기는 고정되고 위치는 변함
		f1.setLayout(new FlowLayout());
		// FlowLayout = 컴포넌트들이 왼쪽에서 오른쪽으로 추가됨
		// 기본적으로 가운데 정렬,
		// container의 크기가 변경 => component크기는 고정되고 위치는 변함

		EtchedBorder border = new EtchedBorder();
		// EhchedBorder = 컴포넌트 주위 홈이 파여있는 모양을 표현한 객체
		JLabel l1 = new JLabel("===========수입 입력===========");
		// JLabel l1에 "====수입 입력===="을 지정함
		l1.setFont(new Font("굴림", Font.PLAIN, 16));// l1의 글꼴 / 크기
		l1.setBorder(border);// Border = 경계선

		// 돈이 생긴 이유, 금액 입력을 위한 패널생성
		JLabel l2 = new JLabel("수입 입력:>> ");// JLabel l2에 "수입 입력:>>"을 지정함
		l2.setFont(new Font("굴림", Font.PLAIN, 17));// l2의 글꼴 / 크기
		JTextField t1 = new JTextField(15);// 크기 15의 JTextField t1을 생성
		t1.setForeground(new Color(0, 0, 204));// t1 텍스트 박스 안 글자색
		JLabel l3 = new JLabel("수입 카테고리:>> ");// JLabel l3에 "수입 카테고리:>> "를 지정함
		l3.setFont(new Font("굴림", Font.PLAIN, 17));// l3의 글꼴 / 크기
		JTextField t2 = new JTextField(15);// 크기 15의 JTextField t2를 생성
		t2.setForeground(new Color(0, 0, 204));// t2 텍스트 박스 안 글자색
		l2.setBackground(new Color(153, 204, 204));// l2의 배경색
		titleP.add(l1);// titleP에 l1(제목)을 부착

		priceP.add(l2);// priceP에 l2(수입 입력:>>)부착
		priceP.add(t1);// priceP에 t1(JTextField)부착
		getP.add(l3);// getP에 l3(수입 카테고리:>>)부착
		getP.add(t2);// getP에 t2(JTextField)부착

		ImageIcon image = new ImageIcon("newget.jpg");// 사진 넣기
		// java project안에있는 이미지를 불러온다(파일 탐색기의 자바 프로젝트안에 이미지를 삽입해둔다)
		JLabel labelImage = new JLabel(image);// Label을 이용하여 image를 출력함

		JPanel buttonP = new JPanel();// 저장을 위한 패널생성
		JButton b1 = new JButton("저장하기");// JButton b1에 "저장하기" 글을 넣음
		buttonP.add(b1);// buttonP에 b1(저장하기 버튼)을 부착
		buttonP.setBackground(new Color(255, 204, 0));// buttonP의 색깔
		b1.setBackground(new Color(255, 255, 204));// 버튼 b1의 색깔

		ImageP.add(labelImage);// ImageP에 labelImage부착

		f1.add(titleP);// f1에 titleP부착
		f1.add(priceP);// f1에 priceP부착
		f1.add(getP);// f1에 getP부착
		f1.add(buttonP);// f1에 buttonP부착
		f1.add(ImageP);// frame1에 ImageP부착

		// b1의 기능 추가
		b1.addActionListener(new ActionListener() {

			// b1을 클릭하면 무언가를 하라는 지시(기능을 넣을 수 있음)
			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame();// '수입내용 저장' 화면 JFrame (frame)
				JPanel panel = new JPanel();// '수입내용 저장' 화면의 JPanel (panel)
				JLabel label = new JLabel("저장되었습니다.");
				// JLabel label에 "저장되었습니다."를 지정함

				panel.add(label);// paenl에 label(저장되었습니다.) 부착
				frame.add(panel);// frame에 panel 부착
				panel.setBackground(new Color(255, 204, 102));// panel의 배경 색깔 지정
				// panel.setBackground(new Color(180, 183, 233));// panel의 배경 색깔 지정

				frame.setTitle("수입저장");// frame의 제목 : 수입저장
				label.setFont(new Font("굴림", Font.PLAIN, 44));// label의 폰트 지정( 글꼴, 크기)
				frame.setSize(400, 115);// frame의 크기 : 400 X 115
				frame.setVisible(true);// frame을 보이게 지정
				frame.setResizable(false);// frame의 크기 변경 불가능 하게 함
				frame.setLocationRelativeTo(null);// 가운데 정렬
				frame.setResizable(false);// 창 늘리기 불가능 하게 할 수 있는것

				gu = 1;// gu를 1로 지정(1이면 수입, 2이면 지출로 구분함)
				a1 = Integer.parseInt(t1.getText().trim());
				// a1에 t1(수입 금액 )의 텍스트를 가져와 공백을 없앤 후 int타입으로 바꾸어 대입.
				memo = t2.getText().trim();
				// memo에 t2(지출한 이유)의 텍스트를 가져와서 공백을 없앤 후 대입
				VectorData.vd.add(new BookTest_1(a1, memo, gu));
				// BookTest_1의 자료가 생성되어 vectorData(자료구조)에 들어감.

				Connection conn = null; // DB연결된 상태(세션)을 담은 객체
				PreparedStatement pstm = null; // SQL 문을 나타내는 객체
				ResultSet rs = null; // 쿼리문을 날린것에 대한 반환값을 담을 객체

				try {
					// SQL 문장을 만들고 만약 문장이 질의어(SELECT문)라면
					// 그 결과를 담을 ResulSet 객체를 준비한 후 실행시킨다.
					String quary = "SELECT * FROM DIARY";
					conn = DBConnection.getConnection();
					pstm = conn.prepareStatement(quary);
					rs = pstm.executeQuery();

					String sql = "INSERT INTO DIARY (INCOME, CONTENTS, DATE_TIME) VALUES ( " + a1 + ",'" + memo
							+ "' ,sysdate)";
					// insert문
					pstm.executeUpdate(sql);

					while (rs.next()) {
					}

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
					} catch (Exception e1) {
						throw new RuntimeException(e1.getMessage());
					}
				}

			}
		});
		f1.setTitle("==수입==");// 프레임 제목 : 수입
		f1.setSize(350, 340);// 프레임 크기 지정
		f1.setVisible(true);// 프레임 보이기
		f1.setResizable(false);// 프레임의 크기를 바꿀 수 없다
		f1.setLocationRelativeTo(null);// 가운데 정렬
		f1.setResizable(false);// 창 늘리기 불가능 하게 할 수 있는것
		f1.getContentPane().setBackground(new Color(255, 204, 0));// frame1의 배경색 지정함
		// f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//X버튼 누르면 닫힘

	}// end of getMoneyTest()

}// end of class

public class getMoneyTest {

	public static void main(String[] args) {
		new getMoney();

	}
}
