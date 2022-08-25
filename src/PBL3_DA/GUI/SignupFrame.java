package PBL3_DA.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import PBL3_DA.BLL.BLL_Timviec;
import PBL3_DA.DTO.TaiKhoan;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignupFrame {

	private JFrame SignupFrame;
	private JTextField txtEmail;
	private JTextField txtHoten;
	private JTextField txtSdt;
	private JPasswordField pass;
	private JPasswordField nhaplaipass;
	/**
	 * Create the application.
	 */
	public SignupFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		SignupFrame = new JFrame();
		SignupFrame.setTitle("\u0110\u0102NG K\u00DD");
		SignupFrame.setResizable(false);
		SignupFrame.setBounds(100, 100, 500, 600);
		//SignupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SignupFrame.setVisible(true);
		SignupFrame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(0, 0, 484, 561);
		SignupFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbDangky = new JLabel("\u0110\u0103ng k\u00FD t\u00E0i kho\u1EA3n");
		lbDangky.setBounds(157, 112, 154, 35);
		lbDangky.setFont(new Font("Calibri", Font.BOLD, 21));
		panel.add(lbDangky);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 250));
		panel_1.setBounds(28, 186, 427, 154);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lbEmail.setFont(new Font("Calibri", Font.BOLD, 12));
		lbEmail.setBounds(10, 22, 95, 22);
		panel_1.add(lbEmail);
		
		JLabel lbMatkhau = new JLabel("M\u1EADt kh\u1EA9u");
		lbMatkhau.setHorizontalAlignment(SwingConstants.RIGHT);
		lbMatkhau.setFont(new Font("Calibri", Font.BOLD, 12));
		lbMatkhau.setBounds(10, 64, 95, 22);
		panel_1.add(lbMatkhau);
		
		JLabel lbNhaplaimk = new JLabel("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u");
		lbNhaplaimk.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNhaplaimk.setFont(new Font("Calibri", Font.BOLD, 12));
		lbNhaplaimk.setBounds(10, 106, 95, 22);
		panel_1.add(lbNhaplaimk);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(133, 16, 261, 30);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(133, 58, 261, 30);
		panel_1.add(pass);
		
		nhaplaipass = new JPasswordField();
		nhaplaipass.setBounds(133, 99, 261, 30);
		panel_1.add(nhaplaipass);
		
		JLabel lbThongtintk = new JLabel("Th\u00F4ng tin t\u00E0i kho\u1EA3n");
		lbThongtintk.setBounds(73, 166, 128, 25);
		lbThongtintk.setFont(new Font("Calibri", Font.BOLD, 15));
		panel.add(lbThongtintk);
		
		JPanel panel_line = new JPanel();
		panel_line.setBounds(195, 175, 255, 1);
		panel.add(panel_line);
		
		JPanel panel_line1 = new JPanel();
		panel_line1.setBounds(20, 175, 50, 1);
		panel.add(panel_line1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Th\u00F4ng tin c\u00E1 nh\u00E2n");
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(73, 351, 128, 25);
		panel.add(lblNewLabel_1_1);
		
		JPanel panel_line3 = new JPanel();
		panel_line3.setBounds(185, 361, 270, 1);
		panel.add(panel_line3);
		
		JPanel panel_line2 = new JPanel();
		panel_line2.setBounds(20, 361, 50, 1);
		panel.add(panel_line2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(135, 206, 250));
		panel_2.setBounds(28, 371, 427, 103);
		panel.add(panel_2);
		
		JLabel lbHoten = new JLabel("H\u1ECD t\u00EAn");
		lbHoten.setHorizontalAlignment(SwingConstants.RIGHT);
		lbHoten.setFont(new Font("Calibri", Font.BOLD, 12));
		lbHoten.setBounds(10, 22, 95, 22);
		panel_2.add(lbHoten);
		
		JLabel lbSdt = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lbSdt.setHorizontalAlignment(SwingConstants.RIGHT);
		lbSdt.setFont(new Font("Calibri", Font.BOLD, 12));
		lbSdt.setBounds(10, 64, 95, 22);
		panel_2.add(lbSdt);
		
		txtHoten = new JTextField();
		txtHoten.setColumns(10);
		txtHoten.setBounds(133, 16, 261, 30);
		panel_2.add(txtHoten);
		
		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBounds(133, 58, 261, 30);
		panel_2.add(txtSdt);
		
		JButton btnDangky = new JButton("\u0110\u0103ng k\u00FD");
		btnDangky.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					TaiKhoan tk = new TaiKhoan();
					tk.setEmail(txtEmail.getText());
					tk.setPass(pass.getText());
					tk.setUserName(txtHoten.getText());
					tk.setSDT(Integer.valueOf(txtSdt.getText()));
					tk.setType(0);
					if(txtEmail.getText().trim() == "" || pass.getText().trim() == "" || txtHoten.getText().trim() == "" || 
						BLL_Timviec.Instance().Isnumber(txtSdt.getText().trim()) == false || txtSdt.getText().trim().length() < 10 || txtSdt.getText().trim().length() > 12)
					{
						throw new Exception();
					}
					if(BLL_Timviec.Instance().CheckTaiKhoanByEmail(tk.getEmail()) == false)
					{
						if(nhaplaipass.getText().equals(pass.getText()))
						{
							BLL_Timviec.Instance().AddTaiKhoan(tk);
							JOptionPane.showMessageDialog(SignupFrame, "Đăng ký thành công");
							int id = BLL_Timviec.Instance().GetIdTaiKhoanByEmail(tk.getEmail());
							MainFrame MF = new MainFrame(id);
							SignupFrame.setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog(SignupFrame, "Mật khẩu nhập lại không khớp");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(SignupFrame, "Email đã tồn tại");
					}
				} catch (Exception e2) 
				{
					JOptionPane.showMessageDialog(SignupFrame, "Error");
				}
			}
		});
		btnDangky.setForeground(SystemColor.desktop);
		btnDangky.setBackground(new Color(220, 20, 60));
		btnDangky.setBorder(null);
		btnDangky.setFont(new Font("Calibri", Font.BOLD, 21));
		btnDangky.setBounds(157, 492, 154, 35);
		panel.add(btnDangky);
		
		ImageIcon SigninIcon = new ImageIcon("C:\\Users\\minht\\Java\\PBL3_DA\\src\\PBL3_DA\\IMAGE\\registration_80px.png");
		JLabel lbIcon = new JLabel(SigninIcon);
		lbIcon.setBounds(172, 11, 142, 90);
		panel.add(lbIcon);
		SignupFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
			{
				OverviewFrame OF = new OverviewFrame();
				OF.Open();
				SignupFrame.setVisible(false);
			}
		});
	}
}
