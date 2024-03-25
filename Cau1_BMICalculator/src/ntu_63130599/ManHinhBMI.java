package ntu_63130599;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManHinhBMI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Label status;


	public ManHinhBMI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("App Tính Chỉ Số BMI");
		setBounds(100, 100, 683, 798);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		Panel panel = new Panel();
		panel.setBounds(-125, 0, 794, 97);
		panel.setBackground(new Color(235, 220, 84));
		contentPane.add(panel);
		panel.setLayout(null);
		
		Label label = new Label("BODY MASS INDEX");
		label.setBounds(345, 32, 301, 43);
		label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(-19, 103, 688, 330);
		panel_1.setBackground(new Color(235, 220, 84));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Height(m):");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(123, 20, 124, 48);
		panel_1.add(lblNewLabel);
		
		JLabel lblWeightm = new JLabel("Weight(kg):");
		lblWeightm.setHorizontalAlignment(SwingConstants.LEFT);
		lblWeightm.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblWeightm.setBounds(123, 90, 124, 48);
		panel_1.add(lblWeightm);
		
		JLabel lblBmi = new JLabel("BMI");
		lblBmi.setHorizontalAlignment(SwingConstants.LEFT);
		lblBmi.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblBmi.setBounds(123, 168, 124, 48);
		panel_1.add(lblBmi);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		textField.setBounds(271, 20, 341, 43);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(271, 97, 341, 43);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(271, 175, 171, 44);
		panel_1.add(textField_2);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code xử lý tính BMI
				HamXuLyBMI();
			}
		});
		btnCalculate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnCalculate.setBounds(123, 261, 124, 48);
		panel_1.add(btnCalculate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code xử lý Xóa
				HamXuLyXoa();
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnClear.setBounds(310, 261, 124, 48);
		panel_1.add(btnClear);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code Thoát
				HamXuLyThoat();
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnExit.setBounds(488, 261, 124, 48);
		panel_1.add(btnExit);
		
		Label status = new Label("");
		status.setBounds(473, 175, 139, 41);
		panel_1.add(status);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(-9, 301, 678, 460);
		contentPane.add(lblNewLabel_1);
		//Them anh vao JLable
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dell G15\\Desktop\\Screenshot 2024-03-23 210115 copy.png"));
		
	}
	void HamXuLyBMI()
	{
		String height = textField.getText(); 
		String weight = textField_1.getText();
		//Chuyển kiểu dữ liệu 
		double h = Double.parseDouble(height);
		double w = Double.parseDouble(weight);

		//Tính bmi
		double bmi = w / (h * h);
		//định dạng kết quả vào Cal ở dạng chuỗi
		String Cal = String.format("%.2f", bmi);
		//In ra kết quả từ cal
		textField_2.setText(Cal);
		
		//Xét nhiều trường hợp
		if(bmi <= 18.5)
		{
			textField_2.setOpaque(true);
			textField_2.setBackground(Color.blue);
			//setting cho nền của tình trạng có màu
			status.setForeground(Color.blue);
			//In ra cảnh báo tình trạng
			status.setText("UnderWeight");
		}
		if(bmi <= 24.9)
		{
			textField_2.setOpaque(true);
			textField_2.setBackground(Color.green);
			//setting cho nền của tình trạng có màu
			status.setForeground(Color.green);
			//In ra cảnh báo tình trạng
			status.setText("Normal Weight");
		}
		if(bmi <= 29.9)
		{
			textField_2.setOpaque(true);
			textField_2.setBackground(Color.yellow);
			//setting cho nền của tình trạng có màu
			status.setForeground(Color.yellow);
			//In ra cảnh báo tình trạng
			status.setText("OverWeight");
		}
		if(bmi <= 34.9)
		{
			textField_2.setOpaque(true);
			textField_2.setBackground(Color.orange);
			//setting cho nền của tình trạng có màu
			status.setForeground(Color.orange);
			//In ra cảnh báo tình trạng
			status.setText("Obese");
		}
		if(bmi >= 35)
		{
			textField_2.setOpaque(true);
			textField_2.setBackground(Color.red);
			//setting cho nền của tình trạng có màu
			status.setForeground(Color.red);
			//In ra cảnh báo tình trạng
			status.setText("Extremely Obese");
		}
	}
	
	void HamXuLyXoa()
	{
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_2.setOpaque(true);
		textField_2.setBackground(null);
		status.setText("");

	}
	
	void HamXuLyThoat()
	{
		System.exit(0);
	}
}
