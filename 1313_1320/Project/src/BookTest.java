import java.awt.Color;
//ColorŬ������ �⺻ sRGB ���� �������� ������ ĸ��ȭ�ϰų����� �ĺ��Ǵ� ���� ���� ������ ������ ĸ��ȭ�ϴ� �� ���
import java.awt.FlowLayout;//FlowLayout�� �ҷ���.
import java.awt.Image;
//�̹����� ����� �����ϱ����� Ŭ������ ������.
import java.awt.Toolkit;
//�� Ŭ������ Abstract Window Toolkit�� ��� ���� ������ �߻� ���� Ŭ�����̴�. Ŭ������ ���� ToolkitŬ������ �پ��� ������Ʈ�� Ư�� ���� ��Ŷ ������ ���ε��ϴ� �� �����.
import javax.swing.JFrame;
//java.awt.Frame Ŭ������ ����ϴ� �����̳� ����. JFrame�� GUI�� ����� ���� ���̺�, ��ư, �ؽ�Ʈ �ʵ�� ���� ���� ��Ұ� �߰��Ǵ� �⺻ âó�� �۵���.
import javax.swing.JLabel;
//JLabel�� java Swing Ŭ�����̴�. JLabel�� ª�� ���ڿ� �Ǵ� �̹��� �������� ǥ���ϴ� �� �����.
import javax.swing.JPanel;
//Java Swing ��Ű���� �Ϻ��� JPanel�� ���� ��� �׷�(��, ��ư ��.)�� ������ ���ִ� �����̳��̴�.
import javax.swing.JTextArea;
//JTextArea Ŭ������ ��ü�� �ؽ�Ʈ�� ǥ���ϴ� ���� �� �����̴�. ���� ���� �ؽ�Ʈ�� ���� �� �� �ִ�.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;//DB

class Book {

	int a1 = 0, gu;// a1 = ���Աݾ�,����ݾ�, gu = ���԰� ������ ����
	String memo = "";// ����, ���� ������ ������
	int getM = 0, outM = 0;// getM = �����հ�, outM = �����հ�
	public static int Total;// ���԰� ������ �հ�

	public Book() {
//      JPanel titleP, titleP2, getP, outP;//���� , ���� ����, ���� ����
//      JLabel Gresult1, Gresult2, Gresult3;//���
//      JTextField getT, getT2, outL;//���Գ���, ���⳻��
		int sum1 = 0, sum2 = 0;// sum1 = ���Աݾ� �հ�, sum2 = ����ݾ� �հ�

		JFrame f1 = new JFrame();// ��ΰ� ��Ÿ�� â
		JPanel titleP = new JPanel();// Gresult1�� ���� �г�
		// JPanel�� ���̳� ��ư�� �ö� ���ڰ��� ��
		titleP.setBackground(new Color(255, 204, 0));// titleP�� ���� ������

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("pig.png");
		f1.setIconImage(img);

		f1.setLayout(new FlowLayout());
		// FlowLayout = ������Ʈ���� ���ʿ��� ���������� �߰���
		// �⺻������ ��� ����,
		// container�� ũ�Ⱑ ���� => componentũ��� �����ǰ� ��ġ�� ����
		JLabel Gresult1 = new JLabel("  ==����� ��� ����!!!==   ");// ������� ������ ��Ÿ���� JLabel, Gresult1
		// JLabel�� ª�� ���ڿ� �Ǵ� �̹��� �������� ǥ���ϴ� �� ���
		JLabel Gresult2 = new JLabel("============================================================");
		// Gresult2�� ======�� ������.
		JPanel titleP2 = new JPanel();// Gresult2�� ���� �г� titleP2����
		titleP2.setBackground(new Color(255, 204, 0));// titleP�� ���� ������

		JPanel getP = new JPanel();// getT�� ���� �г� getP ����

		getP.setSize(400, 400);// getP�� ũ�⸦ 400X400���� ������
		JTextArea getT = new JTextArea();// �ؽ�Ʈ���� getT�� ����, getT�� ����� ������ ������ ��
		getT.setColumns(44);// �ؽ�Ʈ ������ �� ���� ������ ������ �����մϴ�.
		getT.setRows(25);// �ؽ�Ʈ ������ �� ���� ������ ������ �����մϴ�.
		titleP.add(Gresult1);// titleP�� Gresult1�� ������
		String title = "����" + "\t" + "����" + "\t" + "��   ��" + "\r\n";
		// title�� ���ڿ��� ������.

		getT.setText(title);// getT�� �ؽ�Ʈ�� title�� �ؽ�Ʈ�� ������
		titleP2.add(Gresult2);// titleP2�� Gresult2�� ������

		getP.add(getT);// getP�� getT�� ������

		f1.add(titleP);// f1�� titleP�� ������
		f1.add(titleP2);// f1�� titleP2�� ������
		f1.add(getP);// f1�� getP�� ������

		f1.setTitle("==���==");// f1�� ���� : ���
		f1.setSize(500, 600);// f1�� ũ�� : 500 X 600
		f1.setVisible(true);// f1�� ���̰� ����
		f1.setResizable(false);// f1�� ũ�⸦ ������ �� ����
		f1.setLocationRelativeTo(null);// ��� ����
		f1.getContentPane().setBackground(new Color(255, 204, 0));// f1�� ���� ������
		if (VectorData.vd.isEmpty()) {// ��ü�� ����ִ��� Ȯ����
			System.out.println("���� �Էµ� ���� �����ϴ�");// ��� �ִٸ�, ���
		}

		else {
			for (BookTest_1 item : VectorData.vd) {// ����Ǿ� �ִ� �ڷ��(item)�� ������
				// item = VectorData�� �ִ� BookTest_1�� �ڷ��
				title = title + item.toString();
				// title�� title�� item.toString�� ���ļ� ����
				if (item.getGu() == 1) {// ������ ���
					sum1 += item.getA1();// sum1�� item.getA1()�� ������
				}
				if (item.getGu() == 2) {// ������ ���
					sum2 += item.getA1();// sum2�� item.getA1()�� ������
				}
			}
		} // end of else

		/*
		 * title = title + "����ݾ��հ� : " + sum2 + "   ||    ";// title�� title +
		 * "����ݾ��հ� : " + sum2 + " || "�� �����Ͽ� ���� title = title + "���Աݾ��հ� : " + sum1 +
		 * "\r\n";// title�� title + "���Աݾ��հ� : " + sum1�� �ٹٲ��� �Ͽ� ���� int total = (sum1 -
		 * sum2);// total�� sum1 - sum2�� �Ͽ� ������ title = title + "��������հ� : " + total +
		 * "\r\n";// title�� title + "��������հ� : " + total�� �ٹٲ��Ѱ��� ���� Total = total;// �������
		 * Total�� total�� ����
		 */
		// getT.setText(title);// getT�� title�� �������� ��.
		// f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Connection conn = null; // DB����� ����(����)�� ���� ��ü
		PreparedStatement pstm = null; // SQL ���� ��Ÿ���� ��ü
		ResultSet rs = null; // �������� �����Ϳ� ���� ��ȯ���� ���� ��ü
		int tist = 0;
		int tist2 = 0;
		int tist3 = 0;
		try {
			// SQL ������ ����� ���� ������ ���Ǿ�(SELECT��)���
			// �� ����� ���� ResulSet ��ü�� �غ��� �� �����Ų��.
			String quary = "SELECT * FROM DIARY";
			String test = "SELECT SUM(INCOME) FROME DIARY";
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();

			/*
			 * EMP ���̺��� ������ Ÿ��
			 * 
			 * EMPNO NOT NULL NUMBER(4) -- int ENAME VARCHAR2(10) -- String JOB VARCHAR2(9)
			 * -- String MGR NUMBER(4) -- int HIREDATE DATE -- Date SAL NUMBER(7,2) --
			 * float/double COMM NUMBER(7,2) -- float/double DEPTNO NUMBER(2) -- int
			 */

			System.out.println("�ϼ�");
			System.out.println("============================================");

			while (rs.next()) {
				int INCOME = rs.getInt(1);
				int EXPENCE = rs.getInt(2);
				int INCOME_SUM = rs.getInt(3);
				int EXPENCE_SUM = rs.getInt(4);
				java.sql.Date DATE_TIME = rs.getDate(7); // Date Ÿ�� ó��
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
				getT.append(result);// getT�� title�� �������� ��.
			}
			// System.out.println(tist);
			String title2 = "\n ���� �հ� : " + tist;
			String title3 = "\n ���� �հ� : " + tist2;
			tist3 = tist - tist2;
			String title4 = "\n �� �հ� : " + tist3;
			getT.append(title2);
			getT.append(title3);
			getT.append(title4);
		} catch (SQLException sqle) {
			System.out.println("SELECT������ ���� �߻�");
			sqle.printStackTrace();

		} finally {
			// DB ������ �����Ѵ�.
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
//� ��ư�� ������ Ŭ������ ȣ��ǵ��� ���ο��� ���־�� ��.
	public static void main(String[] args) {
		new Book();

	}

}
