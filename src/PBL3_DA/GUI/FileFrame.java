package PBL3_DA.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import PBL3_DA.BLL.BLL_Timviec;
import PBL3_DA.DAL.DBHelper;
import PBL3_DA.DTO.BangCap;
import PBL3_DA.DTO.HoSo;
import PBL3_DA.DTO.KiNang;
import PBL3_DA.DTO.NN_TH;
import PBL3_DA.DTO.TaiKhoan;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;

public class FileFrame {

	private JFrame frameHS;
	private JTextField txtHoten;
	private JTextField txtSdt;
	private JDateChooser datechooserNS;
	private JComboBox cbbGioitinh;
	private JComboBox cbbThanhpho;
	private JTextField txtDiachi;
	private JComboBox cbbKinhnghiem;
	private JComboBox cbbNoilamviec_panel3;
	private JComboBox cbbVitrihientai;
	private JComboBox cbbVitrimongmuon;
	private JComboBox cbbMucluong_p2;
	private JComboBox cbbNoilamviec;
	private JDateChooser dateTu_panel3;
	private JDateChooser dateDen_panel3;
	private JComboBox cbbMucLuong;
	private JTextArea txareaMuctieu;
	private JTextField txtDoanhnghiep;
	private JComboBox cbbTrinhdo_p4;
	private JTextField txtDonvidaotao;
	private JTextField txtChuyennganh;
	private JTextArea txtareaMotaCV;
	private JDateChooser dateTu_panel4;
	private JDateChooser dateDen_panel4;
	private JComboBox cbbLoaitotnghiep;
	private JComboBox cbbNgoaingu;
	private JComboBox cbbTrinhdo;
	private JTextField txtBangcap;
	private JCheckBox chckboxMsWord;
	private JCheckBox chckbxMsExcel;
	private JCheckBox chckbxMsPowerPoint;
	private JCheckBox chckbxMsOutlook;
	private JTextArea txtareaPhanmemkhac;
	private JCheckBox chckbxLanhdao;
	private JCheckBox chckbxGiaiquyetvande;
	private JCheckBox chckbxQuanlythoigian;
	private JCheckBox chckbxLamviecnhom;
	private JCheckBox chckbxQuanlynhanluc;
	private JCheckBox chckbxQuanlyduan;
	private JCheckBox chckbxChienluoc;
	private JCheckBox chckbxGiaotiep;
	private JCheckBox chckbxSangtao;
	private JTextArea txtareaSothich;
	private JTextArea txtareaKynang;
	private JButton btnLuu;
	private JButton btnXoa;
	private static int iddangdung;

	public FileFrame(int idhs) {
		iddangdung = idhs;
		initialize();
		DefaultCbb();
		LoadFrame(iddangdung);
	}

	public void LoadFrame(int Id)
	{
		if(BLL_Timviec.Instance().CheckHoSoById(Id) == true)
		{
			BangCap bc = BLL_Timviec.Instance().GetBangCapByIdHS(Id);
			NN_TH nt = BLL_Timviec.Instance().GetNN_THByIdHoSo(Id);
			KiNang kn = BLL_Timviec.Instance().GetKiNangByIdHoSo(Id);
			TaiKhoan tk = BLL_Timviec.Instance().GetTaiKhoanById(Id);
			HoSo hs = BLL_Timviec.Instance().GetHoSoById(Id);
			
			txtHoten.setText(hs.getFullname());
			txtSdt.setText("0"+String.valueOf(tk.getSDT()));
			datechooserNS.setDate(hs.getNgaySinh());
			if(hs.getGioiTinh() == true)
			{
				cbbGioitinh.setSelectedItem("Nam");
			}
			else
			{
				cbbGioitinh.setSelectedItem("Nữ");
			}
			cbbThanhpho.setSelectedItem(hs.getTinh());
			txtDiachi.setText(hs.getDCCT());
			cbbKinhnghiem.setSelectedItem(hs.getKinhNghiem());
			cbbVitrihientai.setSelectedItem(hs.getViTriHienTai());
			cbbVitrimongmuon.setSelectedItem(hs.getViTriMongMuon());
			cbbMucluong_p2.setSelectedItem(hs.getMucLuongMongMuon());
			cbbNoilamviec.setSelectedItem(hs.getNoiLamViec());
			txareaMuctieu.setText(hs.getMucTieuCV());
			txtDoanhnghiep.setText(hs.getTenCongTyDangLam());
			cbbNoilamviec_panel3.setSelectedItem(hs.getNoiLamViec());
			dateTu_panel3.setDate(hs.getThoiGianBatDauLam());
			dateDen_panel3.setDate(hs.getThoiGianKetThucLam());
			cbbMucLuong.setSelectedItem(hs.getMucLuong());
			txtareaMotaCV.setText(hs.getMoTaCV());
			cbbTrinhdo_p4.setSelectedItem(bc.getTrinhDo());
			txtDonvidaotao.setText(bc.getDonViDaoTao());
			dateTu_panel4.setDate(bc.getThoiGianBatDau());
			dateDen_panel4.setDate(bc.getThoiGianKetThuc());
			txtChuyennganh.setText(bc.getChuyenNganh());
			cbbLoaitotnghiep.setSelectedItem(bc.getLoaiTotNghiep());
			cbbNgoaingu.setSelectedItem(nt.getLoaiNgonNgu());
			cbbTrinhdo.setSelectedItem(nt.getTrinhDo());
			txtBangcap.setText(nt.getBangCap());
			chckboxMsWord.setSelected(nt.isWord());
			chckbxMsExcel.setSelected(nt.isExcel());
			chckbxMsPowerPoint.setSelected(nt.isPowerPoint());
			chckbxMsOutlook.setSelected(nt.isOutLook());
			txtareaPhanmemkhac.setText(nt.getPhanMemKhac());
			chckbxLanhdao.setSelected(kn.isLanhDao());
			chckbxLamviecnhom.setSelected(kn.isLamViecNhom());
			chckbxChienluoc.setSelected(kn.isRaChienLuoc());
			chckbxGiaiquyetvande.setSelected(kn.isGiaiQuyetVD());
			chckbxQuanlynhanluc.setSelected(kn.isQuanLyNhanLuc());
			chckbxGiaotiep.setSelected(kn.isGiaoTiep());
			chckbxQuanlythoigian.setSelected(kn.isQuanLyThoiGian());
			chckbxQuanlyduan.setSelected(kn.isQuanLyDuAn());
			chckbxSangtao.setSelected(kn.isSangTao());
			txtareaSothich.setText(kn.getSoThich());
			txtareaKynang.setText(kn.getKyNangKhac());
		}
		else
		{
			TaiKhoan tk = BLL_Timviec.Instance().GetTaiKhoanById(Id);
			txtHoten.setText(tk.getUserName());
			txtSdt.setText("0"+String.valueOf(tk.getSDT()));
		}
	}
	
	public void DefaultCbb()
	{
		cbbGioitinh.setSelectedItem(null);
		cbbThanhpho.setSelectedItem(null);
		cbbKinhnghiem.setSelectedItem(null);
		cbbVitrihientai.setSelectedItem(null);
		cbbVitrimongmuon.setSelectedItem(null);
		cbbNoilamviec.setSelectedItem(null);
		cbbNoilamviec_panel3.setSelectedItem(null);
		cbbMucLuong.setSelectedItem(null);
		cbbMucluong_p2.setSelectedItem(null);
		cbbLoaitotnghiep.setSelectedItem(null);
		cbbNgoaingu.setSelectedItem(null);
		cbbTrinhdo.setSelectedItem(null);
		cbbTrinhdo_p4.setSelectedItem(null);
	}
	
	public void HideButton()
	{
		btnLuu.hide();
		btnXoa.hide();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameHS = new JFrame();
		frameHS.setTitle("H\u1ED2 S\u01A0");
		frameHS.setVisible(true);
		frameHS.setResizable(false);
		frameHS.setBounds(0,0,630,498);
		frameHS.getContentPane().setLayout(null);
		//frameHS.setDefaultCloseOperation(3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 180, 461);
		frameHS.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(179, 0, 435, 461);
		frameHS.getContentPane().add(layeredPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 434, 460);
		layeredPane.add(panel_1);
		
		JLabel lb1_panel1 = new JLabel("Th\u00F4ng tin t\u00E0i kho\u1EA3n");
		lb1_panel1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb1_panel1.setBounds(145, 11, 142, 35);
		panel_1.add(lb1_panel1);
		
		JLabel lb2_panel1 = new JLabel("H\u1ECD t\u00EAn");
		lb2_panel1.setHorizontalAlignment(SwingConstants.RIGHT);
		lb2_panel1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb2_panel1.setBounds(10, 80, 100, 25);
		panel_1.add(lb2_panel1);
		
		JLabel lb3_panel1 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lb3_panel1.setHorizontalAlignment(SwingConstants.RIGHT);
		lb3_panel1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb3_panel1.setBounds(10, 130, 100, 25);
		panel_1.add(lb3_panel1);
		
		JLabel lb4_panel1 = new JLabel("Ng\u00E0y sinh");
		lb4_panel1.setHorizontalAlignment(SwingConstants.RIGHT);
		lb4_panel1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb4_panel1.setBounds(10, 180, 100, 25);
		panel_1.add(lb4_panel1);
		
		JLabel lb6_panel1 = new JLabel("Gi\u1EDBi t\u00EDnh");
		lb6_panel1.setHorizontalAlignment(SwingConstants.RIGHT);
		lb6_panel1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb6_panel1.setBounds(10, 230, 100, 25);
		panel_1.add(lb6_panel1);
		
		JLabel lb7_panel1 = new JLabel("T\u1EC9nh/Th\u00E0nh ph\u1ED1");
		lb7_panel1.setHorizontalAlignment(SwingConstants.RIGHT);
		lb7_panel1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb7_panel1.setBounds(10, 280, 100, 25);
		panel_1.add(lb7_panel1);
		
		JLabel lb8_panel1 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lb8_panel1.setHorizontalAlignment(SwingConstants.RIGHT);
		lb8_panel1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb8_panel1.setBounds(10, 330, 100, 25);
		panel_1.add(lb8_panel1);
		
		txtHoten = new JTextField();
		txtHoten.setColumns(10);
		txtHoten.setBorder(null);
		txtHoten.setBounds(145, 83, 250, 20);
		panel_1.add(txtHoten);
		
		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBorder(null);
		txtSdt.setBounds(145, 133, 250, 20);
		panel_1.add(txtSdt);
		
		datechooserNS = new JDateChooser();
		datechooserNS.setBounds(145, 180, 250, 20);
		panel_1.add(datechooserNS);
		
		cbbGioitinh = new JComboBox();
		cbbGioitinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "N\u1EEF"}));
		cbbGioitinh.setBounds(145, 232, 250, 22);
		panel_1.add(cbbGioitinh);
		
		cbbThanhpho = new JComboBox();
		cbbThanhpho.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội", "TP Hồ Chí Minh", "An Giang", "Bà Rịa - Vũng Tàu", "Bắc Cạn", "Bắc Giang", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Dương", "Bình Phước", "Bình Thuận", "Bình Định", "Cà Mau", "Cần Thơ", "Cao Bằng", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơ La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái", "Đà Nẵng", "Đắk Lắk", "Điện Biên", "Đồng Nai", "Đồng Tháp"}));
		cbbThanhpho.setBounds(145, 282, 250, 22);
		panel_1.add(cbbThanhpho);
		
		txtDiachi = new JTextField();
		txtDiachi.setColumns(10);
		txtDiachi.setBorder(null);
		txtDiachi.setBounds(145, 333, 250, 20);
		panel_1.add(txtDiachi);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 0, 434, 460);
		layeredPane.add(panel_2);
		
		JLabel lblThngTinChung = new JLabel("Th\u00F4ng tin chung");
		lblThngTinChung.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThngTinChung.setBounds(145, 11, 142, 35);
		panel_2.add(lblThngTinChung);
		
		JLabel lb1_panel2 = new JLabel("Kinh nghi\u1EC7m");
		lb1_panel2.setHorizontalAlignment(SwingConstants.RIGHT);
		lb1_panel2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb1_panel2.setBounds(10, 80, 140, 25);
		panel_2.add(lb1_panel2);
		
		JLabel lb2_panel2 = new JLabel("V\u1ECB tr\u00ED hi\u1EC7n t\u1EA1i");
		lb2_panel2.setHorizontalAlignment(SwingConstants.RIGHT);
		lb2_panel2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb2_panel2.setBounds(10, 130, 140, 25);
		panel_2.add(lb2_panel2);
		
		JLabel lb3_panel2 = new JLabel("V\u1ECB tr\u00ED mong mu\u1ED1n");
		lb3_panel2.setHorizontalAlignment(SwingConstants.RIGHT);
		lb3_panel2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb3_panel2.setBounds(10, 180, 140, 25);
		panel_2.add(lb3_panel2);
		
		JLabel lb4_panel2 = new JLabel("M\u1EE9c l\u01B0\u01A1ng mong mu\u1ED1n");
		lb4_panel2.setHorizontalAlignment(SwingConstants.RIGHT);
		lb4_panel2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb4_panel2.setBounds(0, 230, 150, 25);
		panel_2.add(lb4_panel2);
		
		JLabel lb5_panel2 = new JLabel("N\u01A1i l\u00E0m vi\u1EC7c");
		lb5_panel2.setHorizontalAlignment(SwingConstants.RIGHT);
		lb5_panel2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb5_panel2.setBounds(10, 280, 140, 25);
		panel_2.add(lb5_panel2);
		
		JLabel lb6_panel2 = new JLabel("M\u1EE5c ti\u00EAu c\u00F4ng vi\u1EC7c");
		lb6_panel2.setHorizontalAlignment(SwingConstants.RIGHT);
		lb6_panel2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb6_panel2.setBounds(10, 330, 140, 25);
		panel_2.add(lb6_panel2);
		
		cbbKinhnghiem = new JComboBox();
		cbbKinhnghiem.setModel(new DefaultComboBoxModel(new String[] {"Dưới 1 năm", "Trên 1 năm", "Trên 2 năm", "Trên 3 năm", "Trên 4 năm", "Trên 5 năm"}));
		cbbKinhnghiem.setBounds(160, 82, 250, 22);
		panel_2.add(cbbKinhnghiem);
		
		cbbVitrihientai = new JComboBox();
		cbbVitrihientai.setModel(new DefaultComboBoxModel(new String[] {"Nh\u00E2n vi\u00EAn", "CTV", "Tr\u01B0\u1EDDng ph\u00F2ng", "Chuy\u00EAn gia", "Tr\u01B0\u1EDFng ph\u00F3 ph\u00F2ng", "Qu\u1EA3n l\u00FD c\u1EA5p cao"}));
		cbbVitrihientai.setBounds(160, 132, 250, 22);
		panel_2.add(cbbVitrihientai);
		
		cbbVitrimongmuon = new JComboBox();
		cbbVitrimongmuon.setModel(new DefaultComboBoxModel(new String[] {"Nh\u00E2n vi\u00EAn", "CTV", "Tr\u01B0\u1EDDng ph\u00F2ng", "Chuy\u00EAn gia", "Tr\u01B0\u1EDFng ph\u00F3 ph\u00F2ng", "Qu\u1EA3n l\u00FD c\u1EA5p cao"}));
		cbbVitrimongmuon.setBounds(160, 182, 250, 22);
		panel_2.add(cbbVitrimongmuon);
		
		cbbMucluong_p2 = new JComboBox();
		cbbMucluong_p2.setModel(new DefaultComboBoxModel(new String[] {"0 - 3 tri\u1EC7u", "3 - 5 tri\u1EC7u", "5 - 7 tri\u1EC7u", "7 - 10 tri\u1EC7u", "10 - 12 tri\u1EC7u", "12 - 15 tri\u1EC7u", "15 - 20 tri\u1EC7u", "20 - 25 tri\u1EC7u", "25 - 30 tri\u1EC7u", "30 - 40 tri\u1EC7u", "40 - 50 tri\u1EC7u ", "Tr\u00EAn 50 tri\u1EC7u"}));
		//txtMucluong.setColumns(10);
		cbbMucluong_p2.setBounds(160, 233, 250, 20);
		panel_2.add(cbbMucluong_p2);
		
		cbbNoilamviec = new JComboBox();
		cbbNoilamviec.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội", "TP Hồ Chí Minh", "An Giang", "Bà Rịa - Vũng Tàu", "Bắc Cạn", "Bắc Giang", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Dương", "Bình Phước", "Bình Thuận", "Bình Định", "Cà Mau", "Cần Thơ", "Cao Bằng", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơ La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái", "Đà Nẵng", "Đắk Lắk", "Điện Biên", "Đồng Nai", "Đồng Tháp"}));
		cbbNoilamviec.setBounds(160, 282, 250, 22);
		panel_2.add(cbbNoilamviec);
		
		JScrollPane scrollPane_panel2 = new JScrollPane();
		scrollPane_panel2.setBounds(160, 330, 250, 49);
		panel_2.add(scrollPane_panel2);
		
		txareaMuctieu = new JTextArea();
		scrollPane_panel2.setViewportView(txareaMuctieu);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(0, 0, 434, 460);
		layeredPane.add(panel_3);
		
		JLabel lb_panel3 = new JLabel("Kinh nghi\u1EC7m");
		lb_panel3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_panel3.setBounds(145, 11, 148, 35);
		panel_3.add(lb_panel3);
		
		JLabel lb1_panel3 = new JLabel("Doanh nghi\u1EC7p");
		lb1_panel3.setHorizontalAlignment(SwingConstants.RIGHT);
		lb1_panel3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb1_panel3.setBounds(10, 80, 100, 25);
		panel_3.add(lb1_panel3);
		
		JLabel lb2_panel3 = new JLabel("N\u01A1i l\u00E0m vi\u1EC7c");
		lb2_panel3.setHorizontalAlignment(SwingConstants.RIGHT);
		lb2_panel3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb2_panel3.setBounds(10, 130, 100, 25);
		panel_3.add(lb2_panel3);
		
		JLabel lb3_panel3 = new JLabel("Th\u1EDDi gian l\u00E0m vi\u1EC7c");
		lb3_panel3.setHorizontalAlignment(SwingConstants.RIGHT);
		lb3_panel3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb3_panel3.setBounds(0, 180, 110, 25);
		panel_3.add(lb3_panel3);
		
		JLabel lb4_panel3 = new JLabel("M\u1EE9c l\u01B0\u01A1ng");
		lb4_panel3.setHorizontalAlignment(SwingConstants.RIGHT);
		lb4_panel3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb4_panel3.setBounds(10, 230, 100, 25);
		panel_3.add(lb4_panel3);
		
		JLabel lb5_panel3 = new JLabel("M\u00F4 t\u1EA3 c\u00F4ng vi\u1EC7c");
		lb5_panel3.setHorizontalAlignment(SwingConstants.RIGHT);
		lb5_panel3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb5_panel3.setBounds(10, 280, 100, 25);
		panel_3.add(lb5_panel3);
		
		JLabel lb6_panel3 = new JLabel("T\u1EEB");
		lb6_panel3.setBounds(145, 186, 22, 14);
		panel_3.add(lb6_panel3);
		
		dateTu_panel3 = new JDateChooser();
		dateTu_panel3.setBounds(166, 182, 68, 22);
		panel_3.add(dateTu_panel3);
		
		JLabel lb7_panel3 = new JLabel("\u0110\u1EBFn");
		lb7_panel3.setBounds(271, 186, 25, 14);
		panel_3.add(lb7_panel3);
		
		dateDen_panel3 = new JDateChooser();
		dateDen_panel3.setBounds(300, 182, 68, 22);
		panel_3.add(dateDen_panel3);
		
		JLabel lb8_panel3 = new JLabel("M\u00F4 t\u1EA3 nh\u1EEFng c\u00F4ng vi\u1EC7c, nhi\u1EC7m v\u1EE5 b\u1EA1n t\u1EEBng l\u00E0m");
		lb8_panel3.setBounds(82, 57, 231, 14);
		panel_3.add(lb8_panel3);
		
		JScrollPane scrollPane_panel3 = new JScrollPane();
		scrollPane_panel3.setBounds(145, 280, 250, 43);
		panel_3.add(scrollPane_panel3);
		
		txtareaMotaCV = new JTextArea();
		scrollPane_panel3.setViewportView(txtareaMotaCV);
		
		cbbMucLuong = new JComboBox();
		cbbMucLuong.setModel(new DefaultComboBoxModel(new String[] {"0 - 3 tri\u1EC7u", "3 - 5 tri\u1EC7u", "5 - 7 tri\u1EC7u", "7 - 10 tri\u1EC7u", "10 - 12 tri\u1EC7u", "12 - 15 tri\u1EC7u", "15 - 20 tri\u1EC7u", "20 - 25 tri\u1EC7u", "25 - 30 tri\u1EC7u", "30 - 40 tri\u1EC7u", "40 - 50 tri\u1EC7u ", "Tr\u00EAn 50 tri\u1EC7u"}));
		cbbMucLuong.setBounds(145, 232, 250, 22);
		panel_3.add(cbbMucLuong);
		
		txtDoanhnghiep = new JTextField();
		txtDoanhnghiep.setColumns(10);
		txtDoanhnghiep.setBorder(null);
		txtDoanhnghiep.setBounds(145, 83, 250, 20);
		panel_3.add(txtDoanhnghiep);
		
		cbbNoilamviec_panel3 = new JComboBox();
		cbbNoilamviec_panel3.setModel(new DefaultComboBoxModel(new String[] {"Hà Nội", "TP Hồ Chí Minh", "An Giang", "Bà Rịa - Vũng Tàu", "Bắc Cạn", "Bắc Giang", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Dương", "Bình Phước", "Bình Thuận", "Bình Định", "Cà Mau", "Cần Thơ", "Cao Bằng", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơ La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái", "Đà Nẵng", "Đắk Lắk", "Điện Biên", "Đồng Nai", "Đồng Tháp"}));
		cbbNoilamviec_panel3.setBounds(145, 132, 250, 22);
		panel_3.add(cbbNoilamviec_panel3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(0, 0, 434, 460);
		layeredPane.add(panel_4);
		
		JLabel lb_panel4 = new JLabel("Tr\u00ECnh \u0111\u1ED9 & B\u1EB1ng c\u1EA5p");
		lb_panel4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_panel4.setBounds(145, 11, 148, 35);
		panel_4.add(lb_panel4);
		
		JLabel lb1_panel4 = new JLabel("Tr\u00ECnh \u0111\u1ED9");
		lb1_panel4.setHorizontalAlignment(SwingConstants.RIGHT);
		lb1_panel4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb1_panel4.setBounds(10, 80, 100, 25);
		panel_4.add(lb1_panel4);
		
		JLabel lb2_panel4 = new JLabel("\u0110\u01A1n v\u1ECB \u0111\u00E0o t\u1EA1o");
		lb2_panel4.setHorizontalAlignment(SwingConstants.RIGHT);
		lb2_panel4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb2_panel4.setBounds(10, 130, 100, 25);
		panel_4.add(lb2_panel4);
		
		JLabel lb3_panel4 = new JLabel("Th\u1EDDi gian");
		lb3_panel4.setHorizontalAlignment(SwingConstants.RIGHT);
		lb3_panel4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb3_panel4.setBounds(10, 180, 100, 25);
		panel_4.add(lb3_panel4);
		
		JLabel lb4_panel4 = new JLabel("Chuy\u00EAn ng\u00E0nh");
		lb4_panel4.setHorizontalAlignment(SwingConstants.RIGHT);
		lb4_panel4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb4_panel4.setBounds(10, 230, 100, 25);
		panel_4.add(lb4_panel4);
		
		JLabel lb5_panel4 = new JLabel("Lo\u1EA1i t\u1ED1t nghi\u1EC7p");
		lb5_panel4.setHorizontalAlignment(SwingConstants.RIGHT);
		lb5_panel4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb5_panel4.setBounds(10, 280, 100, 25);
		panel_4.add(lb5_panel4);
		
		cbbTrinhdo_p4 = new JComboBox();
		cbbTrinhdo_p4.setModel(new DefaultComboBoxModel(new String[] {"Trung học cơ sở", "Trung học phổ thông", "Cao đẳng", "Đại học", "Cao học"}));
		//cbbTrinhdo_p4.setColumns(10);
		cbbTrinhdo_p4.setBorder(null);
		cbbTrinhdo_p4.setBounds(145, 83, 250, 20);
		panel_4.add(cbbTrinhdo_p4);
		
		txtDonvidaotao = new JTextField();
		txtDonvidaotao.setColumns(10);
		txtDonvidaotao.setBorder(null);
		txtDonvidaotao.setBounds(145, 133, 250, 20);
		panel_4.add(txtDonvidaotao);
		
		JLabel lb6_panel4 = new JLabel("T\u1EEB");
		lb6_panel4.setBounds(145, 186, 22, 14);
		panel_4.add(lb6_panel4);
		
		dateTu_panel4 = new JDateChooser();
		dateTu_panel4.setBounds(166, 182, 68, 22);
		panel_4.add(dateTu_panel4);
		
		JLabel lb7_panel4 = new JLabel("\u0110\u1EBFn");
		lb7_panel4.setBounds(271, 186, 25, 14);
		panel_4.add(lb7_panel4);
		
		dateDen_panel4 = new JDateChooser();
		dateDen_panel4.setBounds(300, 182, 68, 22);
		panel_4.add(dateDen_panel4);
		
		txtChuyennganh = new JTextField();
		txtChuyennganh.setColumns(10);
		txtChuyennganh.setBorder(null);
		txtChuyennganh.setBounds(145, 233, 250, 20);
		panel_4.add(txtChuyennganh);
		
		cbbLoaitotnghiep = new JComboBox();
		cbbLoaitotnghiep.setModel(new DefaultComboBoxModel(new String[] {"Trung bình", "Khá", "Giỏi", "Xuất sắc"}));
		cbbLoaitotnghiep.setBounds(145, 282, 250, 22);
		panel_4.add(cbbLoaitotnghiep);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(0, 0, 434, 460);
		layeredPane.add(panel_5);
		
		JLabel lb1_panel5 = new JLabel("Ngo\u1EA1i ng\u1EEF & Tin h\u1ECDc");
		lb1_panel5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb1_panel5.setBounds(145, 11, 149, 35);
		panel_5.add(lb1_panel5);
		
		JLabel lb2_panel5 = new JLabel("Ngo\u1EA1i ng\u1EEF");
		lb2_panel5.setHorizontalAlignment(SwingConstants.RIGHT);
		lb2_panel5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb2_panel5.setBounds(10, 80, 100, 25);
		panel_5.add(lb2_panel5);
		
		JLabel lb3_panel5 = new JLabel("Tr\u00ECnh \u0111\u1ED9");
		lb3_panel5.setHorizontalAlignment(SwingConstants.RIGHT);
		lb3_panel5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb3_panel5.setBounds(10, 130, 100, 25);
		panel_5.add(lb3_panel5);
		
		JLabel lb4_panel5 = new JLabel("B\u1EB1ng c\u1EA5p");
		lb4_panel5.setHorizontalAlignment(SwingConstants.RIGHT);
		lb4_panel5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb4_panel5.setBounds(10, 180, 100, 25);
		panel_5.add(lb4_panel5);
		
		txtBangcap = new JTextField();
		txtBangcap.setColumns(10);
		txtBangcap.setBounds(145, 182, 250, 22);
		panel_5.add(txtBangcap);
		
		JLabel lbNgngu = new JLabel("Ngo\u1EA1i ng\u1EEF");
		lbNgngu.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lbNgngu.setBounds(20, 55, 90, 14);
		panel_5.add(lbNgngu);
		
		JLabel lblTinHc = new JLabel("Tin h\u1ECDc");
		lblTinHc.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblTinHc.setBounds(20, 231, 90, 14);
		panel_5.add(lblTinHc);
		
		JLabel lb6_panel5 = new JLabel("Tin h\u1ECDc v\u0103n ph\u00F2ng");
		lb6_panel5.setBounds(10, 256, 120, 14);
		panel_5.add(lb6_panel5);
		
		JLabel lb7_panel5 = new JLabel("Ph\u1EA7n m\u1EC1m kh\u00E1c");
		lb7_panel5.setHorizontalAlignment(SwingConstants.RIGHT);
		lb7_panel5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb7_panel5.setBounds(10, 357, 100, 25);
		panel_5.add(lb7_panel5);
		
		JScrollPane scrollPane_Panel5 = new JScrollPane();
		scrollPane_Panel5.setBounds(145, 357, 250, 47);
		panel_5.add(scrollPane_Panel5);
		
		txtareaPhanmemkhac = new JTextArea();
		scrollPane_Panel5.setViewportView(txtareaPhanmemkhac);
		
		chckboxMsWord = new JCheckBox("MS Word");
		chckboxMsWord.setBounds(20, 286, 120, 23);
		panel_5.add(chckboxMsWord);
		
		chckbxMsExcel = new JCheckBox("MS Excel");
		chckbxMsExcel.setBounds(160, 286, 120, 23);
		panel_5.add(chckbxMsExcel);
		
		chckbxMsPowerPoint = new JCheckBox("MS Power Point");
		chckbxMsPowerPoint.setBounds(20, 312, 120, 23);
		panel_5.add(chckbxMsPowerPoint);
		
		 chckbxMsOutlook = new JCheckBox("MS Outlook");
		chckbxMsOutlook.setBounds(160, 312, 120, 23);
		panel_5.add(chckbxMsOutlook);
		
		cbbNgoaingu = new JComboBox();
		cbbNgoaingu.setModel(new DefaultComboBoxModel(new String[] {"Tiếng Anh", "Tiếng Nhật", "Tiếng Pháp", "Tiếng Trung", "Tiếng Nga", "Tiếng Hàn", "Tiếng Đức", "Tiếng Ý", "Tiếng Ả Rập"}));
		cbbNgoaingu.setBounds(145, 82, 250, 22);
		panel_5.add(cbbNgoaingu);
		
		cbbTrinhdo = new JComboBox();
		cbbTrinhdo.setModel(new DefaultComboBoxModel(new String[] {"Trung Bình", "Khá", "Giỏi", "Xuất sắc"}));
		cbbTrinhdo.setBounds(145, 132, 250, 22);
		panel_5.add(cbbTrinhdo);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(0, 0, 434, 460);
		layeredPane.add(panel_6);
		
		JLabel lb_panel6 = new JLabel("K\u1EF9 n\u0103ng c\u00E1 nh\u00E2n");
		lb_panel6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_panel6.setBounds(145, 11, 149, 35);
		panel_6.add(lb_panel6);
		
		JLabel lb1_panel6 = new JLabel("K\u1EF9 n\u0103ng/S\u1EDF tr\u01B0\u1EDDng");
		lb1_panel6.setHorizontalAlignment(SwingConstants.RIGHT);
		lb1_panel6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb1_panel6.setBounds(0, 80, 130, 25);
		panel_6.add(lb1_panel6);
		
		JLabel lb2_panel6 = new JLabel("S\u1EDF th\u00EDch");
		lb2_panel6.setHorizontalAlignment(SwingConstants.RIGHT);
		lb2_panel6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lb2_panel6.setBounds(10, 212, 100, 25);
		panel_6.add(lb2_panel6);
		
		chckbxLanhdao = new JCheckBox("L\u00E3nh \u0111\u1EA1o");
		chckbxLanhdao.setBounds(33, 112, 120, 23);
		panel_6.add(chckbxLanhdao);
		
		chckbxGiaiquyetvande = new JCheckBox("Gi\u1EA3i quy\u1EBFt v\u1EA5n \u0111\u1EC1");
		chckbxGiaiquyetvande.setBounds(33, 138, 120, 23);
		panel_6.add(chckbxGiaiquyetvande);
		
		chckbxQuanlythoigian = new JCheckBox("Qu\u1EA3n l\u00FD th\u1EDDi gian");
		chckbxQuanlythoigian.setBounds(33, 164, 120, 23);
		panel_6.add(chckbxQuanlythoigian);
		
		chckbxLamviecnhom = new JCheckBox("L\u00E0m vi\u1EC7c nh\u00F3m");
		chckbxLamviecnhom.setBounds(165, 112, 120, 23);
		panel_6.add(chckbxLamviecnhom);
		
		chckbxQuanlynhanluc = new JCheckBox("Qu\u1EA3n l\u00FD nh\u00E2n l\u1EF1c");
		chckbxQuanlynhanluc.setBounds(165, 138, 120, 23);
		panel_6.add(chckbxQuanlynhanluc);
		
		chckbxQuanlyduan = new JCheckBox("Qu\u1EA3n l\u00FD d\u1EF1 \u00E1n");
		chckbxQuanlyduan.setBounds(165, 164, 120, 23);
		panel_6.add(chckbxQuanlyduan);
		
		chckbxChienluoc = new JCheckBox("Ra chi\u1EBFn l\u01B0\u1EE3c");
		chckbxChienluoc.setBounds(295, 112, 120, 23);
		panel_6.add(chckbxChienluoc);
		
		chckbxGiaotiep = new JCheckBox("Giao ti\u1EBFp");
		chckbxGiaotiep.setBounds(295, 138, 120, 23);
		panel_6.add(chckbxGiaotiep);
		
		chckbxSangtao = new JCheckBox("S\u00E1ng t\u1EA1o");
		chckbxSangtao.setBounds(295, 164, 120, 23);
		panel_6.add(chckbxSangtao);
		
		JScrollPane scrollPane_panel6 = new JScrollPane();
		scrollPane_panel6.setBounds(145, 212, 240, 59);
		panel_6.add(scrollPane_panel6);
		
		txtareaSothich = new JTextArea();
		scrollPane_panel6.setViewportView(txtareaSothich);
		
		JLabel panel3_panel6 = new JLabel("K\u1EF9 n\u0103ng kh\u00E1c");
		panel3_panel6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel3_panel6.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel3_panel6.setBounds(10, 306, 100, 25);
		panel_6.add(panel3_panel6);
		
		JScrollPane scrollPane1_panel6 = new JScrollPane();
		scrollPane1_panel6.setBounds(145, 306, 240, 59);
		panel_6.add(scrollPane1_panel6);
		
		txtareaKynang = new JTextArea();
		scrollPane1_panel6.setViewportView(txtareaKynang);
		
		JButton btnThongtinTaikhoan = new JButton("Th\u00F4ng tin t\u00E0i kho\u1EA3n");
		btnThongtinTaikhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
			}
		});
		btnThongtinTaikhoan.setBackground(new Color(30, 144, 255));
		btnThongtinTaikhoan.setBorder(null);
		btnThongtinTaikhoan.setForeground(new Color(255, 255, 255));
		btnThongtinTaikhoan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThongtinTaikhoan.setBounds(0, 0, 180, 54);
		panel.add(btnThongtinTaikhoan);
		
		JButton btnThongtinchung = new JButton("Th\u00F4ng tin chung");
		btnThongtinchung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
			}
		});
		btnThongtinchung.setForeground(Color.WHITE);
		btnThongtinchung.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThongtinchung.setBorder(null);
		btnThongtinchung.setBackground(new Color(30, 144, 255));
		btnThongtinchung.setBounds(0, 65, 180, 54);
		panel.add(btnThongtinchung);
		
		JButton btnKinhnghiem = new JButton("Kinh nghi\u1EC7m");
		btnKinhnghiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(true);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
			}
		});
		btnKinhnghiem.setForeground(Color.WHITE);
		btnKinhnghiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnKinhnghiem.setBorder(null);
		btnKinhnghiem.setBackground(new Color(30, 144, 255));
		btnKinhnghiem.setBounds(0, 130, 180, 54);
		panel.add(btnKinhnghiem);
		
		JButton btnTrinhdoBangcap = new JButton("Tr\u00ECnh \u0111\u1ED9 & B\u1EB1ng c\u1EA5p");
		btnTrinhdoBangcap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(true);
				panel_5.setVisible(false);
				panel_6.setVisible(false);
			}
		});
		btnTrinhdoBangcap.setForeground(Color.WHITE);
		btnTrinhdoBangcap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTrinhdoBangcap.setBorder(null);
		btnTrinhdoBangcap.setBackground(new Color(30, 144, 255));
		btnTrinhdoBangcap.setBounds(0, 195, 180, 54);
		panel.add(btnTrinhdoBangcap);
		
		JButton btnNgoainguTinhoc = new JButton("Ngo\u1EA1i ng\u1EEF & Tin h\u1ECDc");
		btnNgoainguTinhoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(true);
				panel_6.setVisible(false);
			}
		});
		btnNgoainguTinhoc.setForeground(Color.WHITE);
		btnNgoainguTinhoc.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNgoainguTinhoc.setBorder(null);
		btnNgoainguTinhoc.setBackground(new Color(30, 144, 255));
		btnNgoainguTinhoc.setBounds(0, 260, 180, 54);
		panel.add(btnNgoainguTinhoc);
		
		JButton btnKynangcanhan = new JButton("K\u1EF9 n\u0103ng c\u00E1 nh\u00E2n");
		btnKynangcanhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_4.setVisible(false);
				panel_5.setVisible(false);
				panel_6.setVisible(true);
			}
		});
		btnKynangcanhan.setForeground(Color.WHITE);
		btnKynangcanhan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnKynangcanhan.setBorder(null);
		btnKynangcanhan.setBackground(new Color(30, 144, 255));
		btnKynangcanhan.setBounds(0, 325, 180, 54);
		panel.add(btnKynangcanhan);
		
		btnLuu = new JButton("L\u01B0u");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					HoSo hs = new HoSo();
					BangCap bc = new BangCap();
					KiNang kn = new KiNang();
					NN_TH nt = new NN_TH();
					TaiKhoan tk = new TaiKhoan();
					
					hs.setId(iddangdung);
					hs.setFullname(txtHoten.getText().trim());
					if(datechooserNS.getDate() == null)
					{
						JOptionPane.showMessageDialog(frameHS, "Bạn chưa nhập ngày sinh");
						throw new Exception();
					}
					Date dateNs = new Date(datechooserNS.getDate().getTime());
					hs.setNgaySinh(dateNs);
					if((String)cbbGioitinh.getSelectedItem() == "Nam")
					{
						hs.setGioiTinh(true);
					}
					else
					{
						hs.setGioiTinh(false);
					}
					hs.setKinhNghiem((String)cbbKinhnghiem.getSelectedItem());
					hs.setViTriHienTai((String)cbbVitrihientai.getSelectedItem());
					hs.setViTriMongMuon((String)cbbVitrimongmuon.getSelectedItem());
					hs.setMucLuongMongMuon((String)cbbMucluong_p2.getSelectedItem());
					hs.setNoiLamViec((String)cbbNoilamviec.getSelectedItem());
					hs.setMucTieuCV(txareaMuctieu.getText());
					hs.setTenCongTyDangLam(txtDoanhnghiep.getText());
					if(dateTu_panel3.getDate() != null)
					{
						Date dateBatdaulam = new Date(dateTu_panel3.getDate().getTime());
						hs.setThoiGianBatDauLam(dateBatdaulam);
					}
					if(dateDen_panel3.getDate() != null)
					{
						Date dateKetthuclam = new Date(dateDen_panel3.getDate().getTime());
						hs.setThoiGianKetThucLam(dateKetthuclam);
					}
					hs.setMucLuong((String)cbbMucLuong.getSelectedItem());
					hs.setMoTaCV(txtareaMotaCV.getText());
					if(cbbThanhpho.getSelectedItem() == null || txtDiachi.getText().trim() == "")
					{
						JOptionPane.showMessageDialog(frameHS, "Bạn chưa nhập đầy đủ thông tin địa chỉ");
					}
					hs.setTinh((String)cbbThanhpho.getSelectedItem());
					hs.setDCCT(txtDiachi.getText());
					
					if(cbbTrinhdo_p4.getSelectedIndex() == -1 || txtDonvidaotao.getText() == "" || txtChuyennganh.getText() == "" || cbbLoaitotnghiep.getSelectedIndex() == -1)
					{
						JOptionPane.showMessageDialog(frameHS, "Bạn chưa nhập đầy đủ thông tin bằng cấp");
						throw new Exception();
					}
					bc.setTrinhDo((String)cbbTrinhdo_p4.getSelectedItem());
					bc.setDonViDaoTao(txtDonvidaotao.getText());
					if(dateTu_panel4.getDate() != null)
					{
						Date datebatdauhoc = new Date(dateTu_panel4.getDate().getTime());
						bc.setThoiGianBatDau(datebatdauhoc);
					}
					if(dateDen_panel4.getDate() != null)
					{
						Date dateketthuchoc = new Date(dateDen_panel4.getDate().getTime());
						bc.setThoiGianKetThuc(dateketthuchoc);
					}
					bc.setChuyenNganh(txtChuyennganh.getText());
					bc.setLoaiTotNghiep((String)cbbLoaitotnghiep.getSelectedItem());
					bc.setIdHoSo(iddangdung);
					
					kn.setLanhDao(chckbxLanhdao.isSelected());
					kn.setLamViecNhom(chckbxLamviecnhom.isSelected());
					kn.setRaChienLuoc(chckbxChienluoc.isSelected());
					kn.setGiaiQuyetVD(chckbxGiaiquyetvande.isSelected());
					kn.setQuanLyNhanLuc(chckbxQuanlynhanluc.isSelected());
					kn.setGiaoTiep(chckbxGiaotiep.isSelected());
					kn.setQuanLyThoiGian(chckbxQuanlythoigian.isSelected());
					kn.setQuanLyDuAn(chckbxQuanlyduan.isSelected());
					kn.setSangTao(chckbxSangtao.isSelected());
					kn.setSoThich(txtareaSothich.getText());
					kn.setKyNangKhac(txtareaKynang.getText());
					kn.setIdHoSo(iddangdung);
					
					if(cbbNgoaingu.getSelectedIndex() == -1 || cbbTrinhdo.getSelectedIndex() == -1 || txtBangcap.getText() == "")
					{
						JOptionPane.showMessageDialog(frameHS, "Bạn chưa nhập đầy đủ thông tin ngoại ngữ & tin học");
						throw new Exception();
					}
					nt.setLoaiNgonNgu((String)cbbNgoaingu.getSelectedItem());
					nt.setTrinhDo((String)cbbTrinhdo.getSelectedItem());
					nt.setBangCap(txtBangcap.getText());
					nt.setWord(chckboxMsWord.isSelected());
					nt.setExcel(chckbxMsExcel.isSelected());
					nt.setPowerPoint(chckbxMsPowerPoint.isSelected());
					nt.setOutLook(chckbxMsOutlook.isSelected());
					nt.setPhanMemKhac(txtareaPhanmemkhac.getText());
					nt.setIdHoSo(iddangdung);
					
					if(BLL_Timviec.Instance().Isnumber(txtSdt.getText()) == false)
					{
						JOptionPane.showMessageDialog(frameHS, "Số điện thoại không hợp lệ");
						throw new Exception();
					}
					tk.setId(iddangdung);
					tk.setSDT(Integer.parseInt(txtSdt.getText()));
					
					if(BLL_Timviec.Instance().CheckHoSoById(iddangdung) == true)
					{
						BLL_Timviec.Instance().UpdateHoSo(hs, bc, kn, nt,tk);
						JOptionPane.showMessageDialog(frameHS, "Cập nhật hồ sơ thành công", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
					BLL_Timviec.Instance().AddHoSo(hs, bc, kn, nt, tk);
					JOptionPane.showMessageDialog(frameHS, "Thêm hồ sơ thành công", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e2) 
				{
					JOptionPane.showMessageDialog(frameHS, "Errorr");
				}
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLuu.setBorder(null);
		btnLuu.setBackground(new Color(220, 20, 60));
		btnLuu.setBounds(10, 402, 74, 35);
		panel.add(btnLuu);
		
		btnXoa = new JButton("X\u00F3a");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(frameHS, "Bạn có chắc muốn xóa hồ sơ", "XÁC NHẬN", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION)
				{
					BLL_Timviec.Instance().DeleteHoSo(iddangdung);
					frameHS.dispose();
				}
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoa.setBorder(null);
		btnXoa.setBackground(new Color(220, 20, 60));
		btnXoa.setBounds(96, 402, 74, 35);
		panel.add(btnXoa);
		panel_1.setVisible(true);
		panel_2.setVisible(false);
		panel_3.setVisible(false);
		panel_4.setVisible(false);
		panel_5.setVisible(false);
		panel_6.setVisible(false);
	}
}
