package PBL3_DA.DTO;

import java.sql.Date;

public class HoSo 
{
	int id;
	String Fullname;
	Date NgaySinh;
	boolean GioiTinh;
	String KinhNghiem;
	String ViTriHienTai;
	String ViTriMongMuon;
	String MucLuongMongMuon;
	String NoiLamViec;
	String MucTieuCV;
	String TenCongTyDangLam;
	Date ThoiGianBatDauLam;
	Date ThoiGianKetThucLam;
	String MucLuong;
	String MoTaCV;
	int id_BC;
	int idNN_TH;
	int id_KN;
	private String Tinh;
	private String DCCT;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public boolean getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getKinhNghiem() {
		return KinhNghiem;
	}
	public void setKinhNghiem(String kinhNghiem) {
		KinhNghiem = kinhNghiem;
	}
	public String getViTriHienTai() {
		return ViTriHienTai;
	}
	public void setViTriHienTai(String viTriHienTai) {
		ViTriHienTai = viTriHienTai;
	}
	public String getViTriMongMuon() {
		return ViTriMongMuon;
	}
	public void setViTriMongMuon(String viTriMongMuon) {
		ViTriMongMuon = viTriMongMuon;
	}
	public String getMucLuongMongMuon() {
		return MucLuongMongMuon;
	}
	public void setMucLuongMongMuon(String mucLuongMongMuon) {
		MucLuongMongMuon = mucLuongMongMuon;
	}
	public String getNoiLamViec() {
		return NoiLamViec;
	}
	public void setNoiLamViec(String noiLamViec) {
		NoiLamViec = noiLamViec;
	}
	public String getMucTieuCV() {
		return MucTieuCV;
	}
	public void setMucTieuCV(String mucTieuCV) {
		MucTieuCV = mucTieuCV;
	}
	public String getTenCongTyDangLam() {
		return TenCongTyDangLam;
	}
	public void setTenCongTyDangLam(String tenCongTyDangLam) {
		TenCongTyDangLam = tenCongTyDangLam;
	}
	public Date getThoiGianBatDauLam() {
		return ThoiGianBatDauLam;
	}
	public void setThoiGianBatDauLam(Date thoiGianBatDauLam) {
		ThoiGianBatDauLam = thoiGianBatDauLam;
	}
	public Date getThoiGianKetThucLam() {
		return ThoiGianKetThucLam;
	}
	public void setThoiGianKetThucLam(Date thoiGianKetThucLam) {
		ThoiGianKetThucLam = thoiGianKetThucLam;
	}
	public String getMucLuong() {
		return MucLuong;
	}
	public void setMucLuong(String mucLuong) {
		MucLuong = mucLuong;
	}
	public String getMoTaCV() {
		return MoTaCV;
	}
	public void setMoTaCV(String moTaCV) {
		MoTaCV = moTaCV;
	}
	public int getId_BC() {
		return id_BC;
	}
	public void setId_BC(int id_BC) {
		this.id_BC = id_BC;
	}
	public int getIdNN_TH() {
		return idNN_TH;
	}
	public void setIdNN_TH(int idNN_TH) {
		this.idNN_TH = idNN_TH;
	}
	public int getId_KN() {
		return id_KN;
	}
	public void setId_KN(int id_KN) {
		this.id_KN = id_KN;
	}
	public String getTinh()
	{
		return Tinh;
	}
	public void setTinh(String tinh)
	{
		this.Tinh = tinh;
	}
	public String getDCCT()
	{
		return DCCT;
	}
	public void setDCCT(String dcct)
	{
		this.DCCT = dcct;
	}
	public void SetHoSo(HoSo h)
	{
		this.setId(h.getId());
		this.setFullname(h.getFullname());
		this.setNgaySinh(h.getNgaySinh());
		this.setGioiTinh(h.getGioiTinh());
		this.setKinhNghiem(h.getKinhNghiem());
		this.setViTriHienTai(h.getViTriHienTai());
		this.setViTriMongMuon(h.getViTriMongMuon());
		this.setMucLuongMongMuon(h.getMucLuongMongMuon());
		this.setNoiLamViec(h.getNoiLamViec());
		this.setMucTieuCV(h.getMucTieuCV());
		this.setTenCongTyDangLam(h.getTenCongTyDangLam());
		this.setThoiGianBatDauLam(h.getThoiGianBatDauLam());
		this.setThoiGianKetThucLam(h.getThoiGianKetThucLam());
		this.setMucLuong(h.getMucLuong());
		this.setMoTaCV(h.getMoTaCV());
		this.setId_BC(h.getId_BC());
		this.setIdNN_TH(h.getIdNN_TH());
		this.setId_KN(h.getId_KN());
		this.setTinh(h.getTinh());
		this.setDCCT(h.getDCCT());
	}
}
