package PBL3_DA.GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.ComponentOrientation;
import javax.swing.JScrollBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import PBL3_DA.BLL.BLL_Timviec;
import PBL3_DA.DAL.DBHelper;
import PBL3_DA.DTO.ViecLam;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.Icon;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.DefaultComboBoxModel;


public class MainFrame {

	private JFrame MainFrame;
	private JTextField txtTimkiemNC;
	private DefaultTableModel model;
	private JTable table;
	private static int iddangdung;
	/**
	 * Create the application.
	 */
	public MainFrame(int id) 
	{
		iddangdung = id;
		//System.out.println(iddangdung);
		initialize();
		model = (DefaultTableModel) table.getModel();
		ShowViecLam(BLL_Timviec.Instance().GetListViecLam(1));
	}
	
	public void ShowViecLam(ArrayList<ViecLam> l)
	{
		try 
		{
			model.getDataVector().removeAllElements();
			model.fireTableDataChanged();
			for (ViecLam i : l) 
			{
				model.addRow(new Object[] {
						i.GetId(), i.GetTieuDe(), i.GetHinhThuc(), i.GetNganhNghe(), i.GetGioiTinhTuyen(), i.GetKinhNghiemTuyen(), i.GetLuongCoBan(), i.GetTinh(), i.GetNgayHetHan(), i.GetTenCT() 
				});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MainFrame = new JFrame("Finding Job Application");
		MainFrame.getContentPane().setBackground(new Color(230, 230, 250));
		MainFrame.setBounds(100, 100, 1080, 697);
		MainFrame.setVisible(true);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Panel1
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 204));
		
		ImageIcon HotlineIcon = new ImageIcon("C:\\Users\\minht\\Java\\PBL3_DA\\src\\PBL3_DA\\IMAGE\\phone_26px.png");
		JLabel lbHotLine = new JLabel("Hotline:", HotlineIcon, SwingConstants.LEFT);
		lbHotLine.setForeground(Color.WHITE);
		lbHotLine.setFont(new Font("Calibri", Font.BOLD, 15));
		// End Panel1
		
		// Panel2
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		
		JLabel lbKinhdoanh = new JLabel("Kinh doanh");
		lbKinhdoanh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbKinhdoanh.setForeground(Color.WHITE);
		
		JLabel lbBanhang = new JLabel("B\u00E1n h\u00E0ng");
		lbBanhang.setForeground(Color.WHITE);
		lbBanhang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lbLaodong = new JLabel("Lao \u0111\u1ED9ng ");
		lbLaodong.setForeground(Color.WHITE);
		lbLaodong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lbTaichinhNH = new JLabel("T\u00E0i ch\u00EDnh/Ng\u00E2n h\u00E0ng");
		lbTaichinhNH.setForeground(Color.WHITE);
		lbTaichinhNH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lbCNTT = new JLabel("C\u00F4ng ngh\u1EC7 th\u00F4ng tin");
		lbCNTT.setForeground(Color.WHITE);
		lbCNTT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lbCoKhiKT = new JLabel("C\u01A1 kh\u00ED/K\u1EF9 thu\u1EADt");
		lbCoKhiKT.setForeground(Color.WHITE);
		lbCoKhiKT.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lbAllNganhnghe = new JLabel("T\u1EA5t c\u1EA3 ng\u00E0nh ngh\u1EC1 kh\u00E1c");
		lbAllNganhnghe.setForeground(Color.WHITE);
		lbAllNganhnghe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lbIcon1_2 = new JLabel(">>");
		lbIcon1_2.setForeground(Color.WHITE);
		lbIcon1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lbIcon1_3 = new JLabel(">>");
		lbIcon1_3.setForeground(Color.WHITE);
		lbIcon1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lbIcon1_4 = new JLabel(">>");
		lbIcon1_4.setForeground(Color.WHITE);
		lbIcon1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lbIcon1_5 = new JLabel(">>");
		lbIcon1_5.setForeground(Color.WHITE);
		lbIcon1_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lbIcon1_6 = new JLabel(">>");
		lbIcon1_6.setForeground(Color.WHITE);
		lbIcon1_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lbIcon1_1 = new JLabel(">>");
		lbIcon1_1.setForeground(Color.WHITE);
		lbIcon1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		//panel_2
		
		ImageIcon Job = new ImageIcon("C:\\Users\\minht\\Java\\PBL3\\src\\PBL3\\image\\job_seeker_100px.png");
		JLabel lbIcon = new JLabel(Job,JLabel.CENTER);
		
		JLabel lbTitle = new JLabel("VN FIND JOB\r\n");
		lbTitle.setForeground(Color.WHITE);
		lbTitle.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		lbTitle.setToolTipText("VN Find Job\r\nFor goodlife");
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(35)
					.addComponent(lbKinhdoanh, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lbIcon1_1, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addGap(6)
					.addComponent(lbBanhang, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lbIcon1_2, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lbLaodong, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lbIcon1_3, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lbTaichinhNH, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
					.addGap(13)
					.addComponent(lbIcon1_4, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(6)
					.addComponent(lbCNTT, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lbIcon1_5, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lbCoKhiKT, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
					.addGap(8)
					.addComponent(lbIcon1_6, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addGap(6)
					.addComponent(lbAllNganhnghe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(41))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lbKinhdoanh, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(12)
					.addComponent(lbIcon1_1))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lbBanhang, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(12)
					.addComponent(lbIcon1_2))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lbLaodong, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(12)
					.addComponent(lbIcon1_3))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lbTaichinhNH, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(12)
					.addComponent(lbIcon1_4))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lbCNTT, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(12)
					.addComponent(lbIcon1_5))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lbCoKhiKT, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(12)
					.addComponent(lbIcon1_6))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lbAllNganhnghe, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(230, 230, 250));
		panel_5.setAlignmentY(1.0f);
		panel_5.setAlignmentX(1.0f);
		scrollPane.setViewportView(panel_5);
		
		ImageIcon TaoHoSoIcon = new ImageIcon("C:\\Users\\minht\\Java\\PBL3_DA\\src\\PBL3_DA\\IMAGE\\red_file_50px.png");
		JButton btnTaohs = new JButton("T\u1EA1o h\u1ED3 s\u01A1", TaoHoSoIcon);
		btnTaohs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileFrame FF = new FileFrame(iddangdung);
			}
		});
		btnTaohs.setBackground(new Color(51, 102, 204));
		btnTaohs.setBorder(null);
		btnTaohs.setForeground(Color.WHITE);
		btnTaohs.setFont(new Font("Calibri", Font.BOLD, 21));
		
		ImageIcon DangTinTDIcon = new ImageIcon("C:\\Users\\minht\\Java\\PBL3_DA\\src\\PBL3_DA\\IMAGE\\paper_plane_50px.png");
		JButton btnDangTin = new JButton("\u0110\u0103ng tin \r\ntuy\u1EC3n d\u1EE5ng", DangTinTDIcon);
		btnDangTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PostFrame PF = new PostFrame(iddangdung);
			}
		});
		btnDangTin.setBackground(new Color(51, 102, 204));
		btnDangTin.setBorder(null);
		btnDangTin.setForeground(new Color(255, 255, 255));
		btnDangTin.setFont(new Font("Calibri", Font.BOLD, 21));
		
		ImageIcon DangNhapIcon = new ImageIcon("C:\\Users\\minht\\Java\\PBL3_DA\\src\\PBL3_DA\\IMAGE\\enter_30px.png");
		JButton btnDangXuat = new JButton("\u0110\u0103ng xu\u1EA5t", DangNhapIcon);
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OverviewFrame OF = new OverviewFrame();
				OF.Open();
				MainFrame.dispose();
			}
		});
		btnDangXuat.setBackground(new Color(51, 102, 204));
		btnDangXuat.setBorder(null);
		btnDangXuat.setForeground(new Color(255, 255, 255));
		btnDangXuat.setFont(new Font("Calibri", Font.BOLD, 18));
		
		ImageIcon DangKyIcon = new ImageIcon("C:\\Users\\minht\\Java\\PBL3_DA\\src\\PBL3_DA\\IMAGE\\registration_30px.png");
		JButton btnTaikhoancn = new JButton("T\u00E0i kho\u1EA3n", DangKyIcon);
		btnTaikhoancn.setBackground(new Color(51, 102, 204));
		btnTaikhoancn.setBorder(null);
		btnTaikhoancn.setForeground(new Color(255, 255, 255));
		btnTaikhoancn.setFont(new Font("Calibri", Font.BOLD, 18));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 250));
		
		ImageIcon TuhosoIcon = new ImageIcon("C:\\Users\\minht\\Java\\PBL3_DA\\src\\PBL3_DA\\IMAGE\\document_28px.png");
		JButton btnTuhs = new JButton("T\u1EE7 h\u1ED3 s\u01A1", TuhosoIcon);
		btnTuhs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileFrame FF = new FileFrame(iddangdung);
			}
		});
		btnTuhs.setBounds(0, 0, 121, 45);
		btnTuhs.setFont(new Font("Calibri", Font.BOLD, 15));
		btnTuhs.setBorder(null);
		btnTuhs.setBackground(new Color(135, 206, 250));
		
		ImageIcon DaluuIcon = new ImageIcon("C:\\Users\\minht\\Java\\PBL3_DA\\src\\PBL3_DA\\IMAGE\\download_30px.png");
		JButton btnVLDaluu = new JButton("Vi\u1EC7c l\u00E0m \u0111\u00E3 l\u01B0u", DaluuIcon);
		btnVLDaluu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveFrame save = new SaveFrame(iddangdung);
				save.setVisible(true);
			}
		});
		btnVLDaluu.setBounds(396, 0, 170, 45);
		btnVLDaluu.setFont(new Font("Calibri", Font.BOLD, 15));
		btnVLDaluu.setBorder(null);
		btnVLDaluu.setBackground(new Color(135, 206, 250));
		
		ImageIcon UngtuyenIcon = new ImageIcon("C:\\Users\\minht\\Java\\PBL3_DA\\src\\PBL3_DA\\IMAGE\\set_as_resume_27px.png");
		
		
		ImageIcon TaikhoanIcon = new ImageIcon("C:\\Users\\minht\\Java\\PBL3_DA\\src\\PBL3_DA\\IMAGE\\user_30px.png");
		JButton btnTaikhoan = new JButton("T\u00E0i kho\u1EA3n", TaikhoanIcon);
		btnTaikhoan.setBounds(265, 0, 121, 45);
		btnTaikhoan.setFont(new Font("Calibri", Font.BOLD, 15));
		btnTaikhoan.setBorder(null);
		btnTaikhoan.setBackground(new Color(135, 206, 250));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(230, 230, 250));
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(70, 130, 180));
		
		JComboBox cbbHinhThuc = new JComboBox();
		cbbHinhThuc.setModel(new DefaultComboBoxModel(new String[] {"", "Gi??? h??nh ch??nh", "Vi???c l??m thu nh???p cao", "Vi???c l??m th??m/L??m vi???c ngo??i gi???", "Th???u d??? ??n/Freelance/Vi???c l??m t??? do", "Vi???c l??m online", "Kinh doanh m???ng l?????i", "Gi??p vi???c gia ????nh", "H???p t??c lao ?????ng n?????c ngo??i", "Vi???c l??m ng?????i khuy???t t???t", "Vi???c l??m theo ca/?????i ca", "Vi???c l??m cho tri th???c l???n tu???i (tr??n 50 tu???i)"}));
		cbbHinhThuc.setBounds(46, 97, 266, 32);
		
		JComboBox cbbNganhNghe = new JComboBox();
		cbbNganhNghe.setModel(new DefaultComboBoxModel(new String[] {"", "B??n h??ng", "T?? v???n b???o hi???m", "B??o ch??/Bi??n t???p vi??n", "B???t ?????ng s???n", "Bi??n d???ch/Phi??n d???ch", "B??u ch??nh vi???n th??ng ", "C?? kh??/K?? thu???t ???ng d???ng", "C??ng ngh??? th??ng tin", "D???u kh??/?????a ch???t", "D???t may", "B???o v???/V??? s??/An ninh", "Ch??m s??c kh??ch h??ng", "??i???n/??i???n t???/??i???n l???nh", "Du l???ch/Nh?? h??ng/Kh??ch s???n", "D?????c/H??a ch???t/Sinh h??a", "Gi???i tr??/Vui ch??i", "Gi??o d???c/????o t???o/Th?? vi???n", "Giao th??ng/V???n t???i/Th???y l???i/C???u ???????ng", "Gi??y da/Thu???c gia", "H??nh ch??nh/Th?? k??/Tr??? l??", "Kho v???n/V???t t??/Thu mua", "Ki???n tr??c/N???i th???t", "Kinh doanh", "Lao ?????ng ph??? th??ng", "Lu???t/Ph??p l??", "M??i tr?????ng/X??? l?? ch???t th???i", "M??? ph???m/Th???i trang/Trang s???c", "Ng??n h??ng/Ch???ng kho??ng/?????u t??", "Ngh??? thu???t/??i???n ???nh", "Nh??n s???", "N??ng/L??m/Ng?? nghi???p", "Quan h??? ?????i ngo???i", "Th???m ?????nh/Gi??m ?????nh/Qu???n l?? ch???t l?????ng", "Qu???n l?? ??i???u h??nh", "Qu???ng c??o/Marketing/PR", "S???n xu???t/V???n h??nh s???n xu???t", "T??i ch??nh/K??? to??n/Ki???m to??n", "Th??? d???c/Th??? thao", "Thi???t k???/M??? thu???t", "Th???i v???/B??n th???i gian", "Th???c ph???m/D???ch v??? an u???ng", "X??y d???ng", "Xu???t - Nh???p kh???u/Ngo???i th????ng", "Y t???", "Ngo???i ng???", "Khu ch??? xu???t/Khu c??ng nghi???p", "L??m ?????p/Th??? l???c/Spa", "T??i x???/L??i xe/Giao nh???n", "Trang thi???t b??? c??ng nghi???p", "Trang thi???t b??? gia d???ng", "Trang thi???t b??? v??n ph??ng", "PG/PB/L??? t??n", "Ph??t tri???n th??? tr?????ng", "Ph???c v???/T???p v???/Gi??p vi???c"}));
		cbbNganhNghe.setBounds(46, 140, 266, 32);
		
		JComboBox cbbGioiTinh = new JComboBox();
		cbbGioiTinh.setModel(new DefaultComboBoxModel(new String[] {"", "Kh??ng y??u c???u", "Nam", "N???"}));
		cbbGioiTinh.setBounds(46, 183, 266, 32);
		
		JComboBox cbbKinhNghiem = new JComboBox();
		cbbKinhNghiem.setModel(new DefaultComboBoxModel(new String[] {"", "Kh??ng y??u c???u", "D?????i 1 n??m", "Tr??n 1 n??m", "Tr??n 2 n??m", "Tr??n 3 n??m", "Tr??n 4 n??m", "Tr??n 5 n??m"}));
		cbbKinhNghiem.setBounds(46, 226, 266, 32);
		
		JComboBox cbbLuong = new JComboBox();
		cbbLuong.setModel(new DefaultComboBoxModel(new String[] {"", "0 - 3 tri???u", "3 - 5 tri???u", "5 - 7 tri???u", "7 - 10 tri???u", "10 - 12 tri???u", "12 - 15 tri???u", "15 - 20 tri???u", "20 - 25 tri???u", "25 - 30 tri???u", "30 - 40 tri???u", "40 - 50 tri???u ", "Tr??n 50 tri???u"}));
		cbbLuong.setBounds(46, 269, 266, 32);
		
		JComboBox cbbTinh = new JComboBox();
		cbbTinh.setModel(new DefaultComboBoxModel(new String[] {"", "H?? N???i", "TP H??? Ch?? Minh", "An Giang", "B?? R???a - V??ng T??u", "B???c C???n", "B???c Giang", "B???c Li??u", "B???c Ninh", "B???n Tre", "B??nh D????ng", "B??nh Ph?????c", "B??nh Thu???n", "B??nh ?????nh", "C?? Mau", "C???n Th??", "Cao B???ng", "Gia Lai", "H?? Giang", "H?? Nam", "H?? T??nh", "H???i D????ng", "H???i Ph??ng", "H???u Giang", "H??a B??nh", "H??ng Y??n", "Kh??nh H??a", "Ki??n Giang", "Kon Tum", "Lai Ch??u", "L??m ?????ng", "L???ng S??n", "L??o Cai", "Long An", "Nam ?????nh", "Ngh??? An", "Ninh B??nh", "Ninh Thu???n", "Ph?? Th???", "Ph?? Y??n", "Qu???ng B??nh", "Qu???ng Nam", "Qu???ng Ng??i", "Qu???ng Ninh", "Qu???ng Tr???", "S??c Tr??ng", "S?? La", "T??y Ninh", "Th??i B??nh", "Th??i Nguy??n", "Thanh H??a", "Th???a Thi??n Hu???", "Ti???n Giang", "Tr?? Vinh", "Tuy??n Quang", "V??nh Long", "V??nh Ph??c", "Y??n B??i", "???? N??ng", "?????k L???k", "??i???n Bi??n", "?????ng Nai", "?????ng Th??p"}));
		cbbTinh.setBounds(46, 312, 266, 32);
		
		txtTimkiemNC = new JTextField();
		txtTimkiemNC.setBounds(46, 54, 266, 32);
		txtTimkiemNC.setColumns(10);
		
		JLabel lbTimkiemNC = new JLabel("T\u00CCM KI\u1EBEM N\u00C2NG CAO");
		lbTimkiemNC.setBounds(76, 11, 215, 32);
		lbTimkiemNC.setFont(new Font("Calibri", Font.BOLD, 21));
		
		JButton btTimKiem = new JButton("T\u00ECm ki\u1EBFm");
		btTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ShowViecLam(BLL_Timviec.Instance().ListViecLam(txtTimkiemNC.getText(), 
						(String)cbbHinhThuc.getSelectedItem(), (String)cbbNganhNghe.getSelectedItem(), 
						(String)cbbGioiTinh.getSelectedItem(), (String)cbbKinhNghiem.getSelectedItem(), 
						(String)cbbLuong.getSelectedItem(), (String)cbbTinh.getSelectedItem(), 1));
				
			}
		});
		btTimKiem.setBounds(99, 405, 167, 40);
		btTimKiem.setForeground(Color.WHITE);
		btTimKiem.setFont(new Font("Calibri", Font.BOLD, 19));
		btTimKiem.setBorder(null);
		btTimKiem.setBackground(Color.RED);
		
		JButton btnTimkiemhs = new JButton("T\u00ECm h\u1ED3 s\u01A1", null);
		btnTimkiemhs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindFileFrame FF = new FindFileFrame();
				FF.setVisible(true);
			}
		});
		btnTimkiemhs.setBounds(131, 0, 121, 45);
		btnTimkiemhs.setFont(new Font("Calibri", Font.BOLD, 15));
		btnTimkiemhs.setBorder(null);
		btnTimkiemhs.setBackground(new Color(135, 206, 250));
		
		JComboBox cbbSXPhobien = new JComboBox();
		cbbSXPhobien.setModel(new DefaultComboBoxModel(new String[] {"T??ng d???n", "Gi???m d???n"}));
		cbbSXPhobien.setBounds(272, 11, 140, 22);
		
		JComboBox cbbSXLuong = new JComboBox();
		cbbSXLuong.setModel(new DefaultComboBoxModel(new String[] {"Ti??u ?????", "H??nh th???c", "Ng??nh ngh???", "L????ng", "Kinh nghi???m", "Ng??y h???t h???n"}));
		cbbSXLuong.setBounds(122, 11, 140, 22);
		
		JButton btnSapxep = new JButton("S\u1EAFp x\u1EBFp");
		btnSapxep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cv = cbbSXLuong.getSelectedIndex();
				if(cbbSXPhobien.getSelectedIndex() == 0)
				{
					ShowViecLam(BLL_Timviec.Instance().Sort(cv, txtTimkiemNC.getText(), 
							(String)cbbHinhThuc.getSelectedItem(), (String)cbbNganhNghe.getSelectedItem(), 
							(String)cbbGioiTinh.getSelectedItem(), (String)cbbKinhNghiem.getSelectedItem(), 
							(String)cbbLuong.getSelectedItem(), (String)cbbTinh.getSelectedItem(), 1));
				}
				else
				{
					ArrayList<ViecLam> l = BLL_Timviec.Instance().Sort(cv, txtTimkiemNC.getText(), 
							(String)cbbHinhThuc.getSelectedItem(), (String)cbbNganhNghe.getSelectedItem(), 
							(String)cbbGioiTinh.getSelectedItem(), (String)cbbKinhNghiem.getSelectedItem(), 
							(String)cbbLuong.getSelectedItem(), (String)cbbTinh.getSelectedItem(), 1);
					Collections.reverse(l);
					ShowViecLam(l);
				}
			}
		});
		btnSapxep.setBounds(10, 1, 102, 44);
		btnSapxep.setForeground(SystemColor.desktop);
		btnSapxep.setBackground(new Color(220, 20, 60));
		btnSapxep.setBorder(null);
		btnSapxep.setFont(new Font("Calibri", Font.BOLD, 19));
		panel_3.setLayout(null);
		panel_3.add(cbbSXPhobien);
		panel_3.add(cbbSXLuong);
		panel_3.add(btnSapxep);
		panel_3_1.setLayout(null);
		panel_3_1.add(cbbHinhThuc);
		panel_3_1.add(cbbNganhNghe);
		panel_3_1.add(cbbGioiTinh);
		panel_3_1.add(cbbKinhNghiem);
		panel_3_1.add(cbbLuong);
		panel_3_1.add(cbbTinh);
		panel_3_1.add(txtTimkiemNC);
		panel_3_1.add(lbTimkiemNC);
		panel_3_1.add(btTimKiem);
		panel_2.setLayout(null);
		panel_2.add(btnTuhs);
		panel_2.add(btnVLDaluu);
		panel_2.add(btnTaikhoan);
		panel_2.add(btnTimkiemhs);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addComponent(btnTaohs, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(btnDangTin, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
							.addGap(19)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_5.createSequentialGroup()
									.addGap(152)
									.addComponent(btnTaikhoancn, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnDangXuat, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
							.addGap(133))
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
								.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE))
							.addGap(33)
							.addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)))
					.addGap(26))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(btnTaohs, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDangTin, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTaikhoancn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDangXuat, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
						.addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)))
		);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
table.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e)
			{
				if(e.getClickCount() == 2)
				{
					int id = (int) table.getValueAt(table.getSelectedRow(), 0);
					DetailFrame dt = new DetailFrame(iddangdung, id, 1);
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Ti\u00EAu \u0111\u1EC1", "H\u00ECnh th\u1EE9c", "Ng\u00E0nh ngh\u1EC1", "Gi\u01A1i t\u00EDnh", "Kinh nghi\u1EC7m", "L\u01B0\u01A1ng", "\u0110\u1ECBa ch\u1EC9", "Ng\u00E0y h\u1EBFt h\u1EA1n", "T\u00EAn c\u00F4ng ty"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(215);
		table.getColumnModel().getColumn(2).setPreferredWidth(128);
		table.getColumnModel().getColumn(3).setPreferredWidth(133);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(129);
		table.getColumnModel().getColumn(6).setPreferredWidth(123);
		table.getColumnModel().getColumn(7).setPreferredWidth(114);
		table.getColumnModel().getColumn(8).setPreferredWidth(90);
		table.getColumnModel().getColumn(9).setPreferredWidth(205);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowViecLam(BLL_Timviec.Instance().GetListViecLam(1));
			}
		});
		btnRefresh.setBounds(483, 1, 112, 44);
		panel_3.add(btnRefresh);
		btnRefresh.setForeground(Color.BLACK);
		btnRefresh.setFont(new Font("Calibri", Font.BOLD, 19));
		btnRefresh.setBorder(null);
		btnRefresh.setBackground(new Color(220, 20, 60));
		panel_5.setLayout(gl_panel_5);
		GroupLayout groupLayout = new GroupLayout(MainFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(65)
					.addComponent(lbIcon, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbTitle, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addGap(570)
					.addComponent(lbHotLine, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lbHotLine))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lbTitle, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbIcon, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		MainFrame.getContentPane().setLayout(groupLayout);
	}
}
