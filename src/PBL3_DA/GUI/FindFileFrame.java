package PBL3_DA.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import PBL3_DA.BLL.BLL_Timviec;
import PBL3_DA.DTO.BangCap;
import PBL3_DA.DTO.HoSo;
import PBL3_DA.DTO.NN_TH;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FindFileFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtfullname;
	private DefaultTableModel model;
	
	public FindFileFrame() 
	{
		initialize();
		model = (DefaultTableModel) table.getModel();
		ShowHoSo(BLL_Timviec.Instance().GetAllListHoSo());
	}
	
	public void ShowHoSo(ArrayList<HoSo> l)
	{
		try 
		{
			model.getDataVector().removeAllElements();
			model.fireTableDataChanged();
			for (HoSo i : l) 
			{
				BangCap bc = BLL_Timviec.Instance().GetBangCapByIdHS(i.getId());
				NN_TH nt = BLL_Timviec.Instance().GetNN_THByIdHoSo(i.getId());
				String gt;
				if(i.getGioiTinh() == true)
				{
					gt = "Nam";
				}
				else
				{
					gt = "Nữ";
				}
				model.addRow(new Object[]
						{
								i.getId(), i.getFullname(), gt, bc.getTrinhDo(), bc.getLoaiTotNghiep(), nt.getLoaiNgonNgu(), nt.getTrinhDo(), i.getTinh()
						});
			}
		} catch (Exception e) 
		{
			// TODO: handle exception
		}
	}
	
	public void initialize()
	{
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(10, 11, 964, 43);
		contentPane.add(panel);
		
		JLabel lblTmKimH = new JLabel("T\u00CCM KI\u1EBEM H\u1ED2 S\u01A0");
		lblTmKimH.setForeground(Color.WHITE);
		lblTmKimH.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblTmKimH.setBounds(10, 11, 256, 26);
		panel.add(lblTmKimH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 65, 669, 385);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 669, 385);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() 
		{
			public void mousePressed(MouseEvent e)
			{
				if(e.getClickCount() == 2)
				{
					int id = (int) table.getValueAt(table.getSelectedRow(), 0);
					FileFrame FF = new FileFrame(id);
					FF.HideButton();
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "T\u00EAn", "Gi\u1EDBi t\u00EDnh", "Tr\u00ECnh \u0111\u1ED9 h\u1ECDc v\u1EA5n", "Lo\u1EA1i t\u1ED1t nghi\u1EC7p", "Ngo\u1EA1i ng\u1EEF", "Tr\u00ECnh \u0111\u1ED9 ngo\u1EA1i ng\u1EEF", "T\u1EC9nh/Th\u00E0nh ph\u1ED1"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(146);
		table.getColumnModel().getColumn(2).setPreferredWidth(58);
		table.getColumnModel().getColumn(3).setPreferredWidth(97);
		table.getColumnModel().getColumn(4).setPreferredWidth(83);
		table.getColumnModel().getColumn(5).setPreferredWidth(72);
		table.getColumnModel().getColumn(6).setPreferredWidth(101);
		table.getColumnModel().getColumn(7).setPreferredWidth(91);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(70, 130, 180));
		panel_2.setBounds(689, 65, 285, 385);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("L\u1ECCC H\u1ED2 S\u01A0");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(97, 11, 98, 41);
		panel_2.add(lblNewLabel);
		
		txtfullname = new JTextField();
		txtfullname.setBounds(128, 63, 146, 28);
		panel_2.add(txtfullname);
		txtfullname.setColumns(10);
		
		JComboBox cbbTrinhdobc = new JComboBox();
		cbbTrinhdobc.setModel(new DefaultComboBoxModel(new String[] {"", "Trung h\u1ECDc c\u01A1 s\u1EDF", "Trung h\u1ECDc ph\u1ED5 th\u00F4ng", "Cao \u0111\u1EB3ng", "\u0110\u1EA1i h\u1ECDc", "Cao h\u1ECDc"}));
		cbbTrinhdobc.setBounds(128, 102, 146, 29);
		panel_2.add(cbbTrinhdobc);
		
		JComboBox cbbloaitotnghiep = new JComboBox();
		cbbloaitotnghiep.setModel(new DefaultComboBoxModel(new String[] {"", "Trung b\u00ECnh", "Kh\u00E1", "Gi\u1ECFi", "Xu\u1EA5t s\u1EAFc"}));
		cbbloaitotnghiep.setBounds(128, 142, 146, 29);
		panel_2.add(cbbloaitotnghiep);
		
		JComboBox cbbLoaiNn = new JComboBox();
		cbbLoaiNn.setModel(new DefaultComboBoxModel(new String[] {"", "Ti\u1EBFng Anh", "Ti\u1EBFng Nh\u1EADt", "Ti\u1EBFng Ph\u00E1p", "Ti\u1EBFng Trung", "Ti\u1EBFng Nga", "Ti\u1EBFng H\u00E0n", "Ti\u1EBFng \u0110\u1EE9c", "Ti\u1EBFng \u00DD", "Ti\u1EBFng \u1EA2 R\u1EADp"}));
		cbbLoaiNn.setBounds(128, 182, 146, 29);
		panel_2.add(cbbLoaiNn);
		
		JComboBox cbbTrinhdoNn = new JComboBox();
		cbbTrinhdoNn.setModel(new DefaultComboBoxModel(new String[] {"", "Trung B\u00ECnh", "Kh\u00E1", "Gi\u1ECFi", "Xu\u1EA5t s\u1EAFc"}));
		cbbTrinhdoNn.setBounds(128, 222, 146, 29);
		panel_2.add(cbbTrinhdoNn);
		
		JComboBox cbbTinh = new JComboBox();
		cbbTinh.setModel(new DefaultComboBoxModel(new String[] {"", "H\u00E0 N\u1ED9i", "TP H\u1ED3 Ch\u00ED Minh", "An Giang", "B\u00E0 R\u1ECBa - V\u0169ng T\u00E0u", "B\u1EAFc C\u1EA1n", "B\u1EAFc Giang", "B\u1EA1c Li\u00EAu", "B\u1EAFc Ninh", "B\u1EBFn Tre", "B\u00ECnh D\u01B0\u01A1ng", "B\u00ECnh Ph\u01B0\u1EDBc", "B\u00ECnh Thu\u1EADn", "B\u00ECnh \u0110\u1ECBnh", "C\u00E0 Mau", "C\u1EA7n Th\u01A1", "Cao B\u1EB1ng", "Gia Lai", "H\u00E0 Giang", "H\u00E0 Nam", "H\u00E0 T\u0129nh", "H\u1EA3i D\u01B0\u01A1ng", "H\u1EA3i Ph\u00F2ng", "H\u1EADu Giang", "H\u00F2a B\u00ECnh", "H\u01B0ng Y\u00EAn", "Kh\u00E1nh H\u00F2a", "Ki\u00EAn Giang", "Kon Tum", "Lai Ch\u00E2u", "L\u00E2m \u0110\u1ED3ng", "L\u1EA1ng S\u01A1n", "L\u00E0o Cai", "Long An", "Nam \u0110\u1ECBnh", "Ngh\u1EC7 An", "Ninh B\u00ECnh", "Ninh Thu\u1EADn", "Ph\u00FA Th\u1ECD", "Ph\u00FA Y\u00EAn", "Qu\u1EA3ng B\u00ECnh", "Qu\u1EA3ng Nam", "Qu\u1EA3ng Ng\u00E3i", "Qu\u1EA3ng Ninh", "Qu\u1EA3ng Tr\u1ECB", "S\u00F3c Tr\u0103ng", "S\u01A1 La", "T\u00E2y Ninh", "Th\u00E1i B\u00ECnh", "Th\u00E1i Nguy\u00EAn", "Thanh H\u00F3a", "Th\u1EEBa Thi\u00EAn Hu\u1EBF", "Ti\u1EC1n Giang", "Tr\u00E0 Vinh", "Tuy\u00EAn Quang", "V\u0129nh Long", "V\u0129nh Ph\u00FAc", "Y\u00EAn B\u00E1i", "\u0110\u00E0 N\u1EB5ng", "\u0110\u1EAFk L\u1EAFk", "\u0110i\u1EC7n Bi\u00EAn", "\u0110\u1ED3ng Nai", "\u0110\u1ED3ng Th\u00E1p"}));
		cbbTinh.setBounds(128, 262, 146, 29);
		panel_2.add(cbbTinh);
		
		JButton btnNewButton = new JButton("T\u00ECm ki\u1EBFm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowHoSo(BLL_Timviec.Instance().SearchHoSo(txtfullname.getText(), (String)cbbTrinhdobc.getSelectedItem(), (String)cbbloaitotnghiep.getSelectedItem(), 
						(String)cbbLoaiNn.getSelectedItem(), (String)cbbTrinhdoNn.getSelectedItem(), (String)cbbTinh.getSelectedItem()));
			}
		});
		btnNewButton.setBackground(new Color(220, 20, 60));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(153, 323, 98, 36);
		btnNewButton.setBorder(null);
		panel_2.add(btnNewButton);
		
		JButton btnRefresh = new JButton("Refresh ");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtfullname.setText("");
				cbbTrinhdobc.setSelectedIndex(0);
				cbbloaitotnghiep.setSelectedIndex(0);
				cbbTrinhdoNn.setSelectedIndex(0);
				cbbLoaiNn.setSelectedIndex(0);
				cbbTinh.setSelectedIndex(0);
				ShowHoSo(BLL_Timviec.Instance().GetAllListHoSo());
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBorder(null);
		btnRefresh.setBackground(new Color(220, 20, 60));
		btnRefresh.setBounds(33, 323, 98, 36);
		panel_2.add(btnRefresh);
		
		JLabel lblNewLabel_1 = new JLabel("Tên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(7, 70, 90, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Trình độ học vấn:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(10, 109, 98, 14);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Loại tốt nghiệp:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(10, 149, 98, 14);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Ngoại ngữ:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_3.setBounds(10, 189, 98, 14);
		panel_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Trình độ ngoại ngữ:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_4.setBounds(10, 229, 108, 14);
		panel_2.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Tình/Thành phố:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_5.setBounds(10, 269, 97, 14);
		panel_2.add(lblNewLabel_1_5);
	}
}
