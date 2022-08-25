package PBL3_DA.DTO;

import java.sql.Date;

public class BangCap 
{
	private int id;
	private String trinhDo;
	private String donViDaoTao;
	private Date thoiGianBatDau;
	private Date thoiGianKetThuc;
	private String chuyenNganh;
	private String loaiTotNghiep;
	private int IdHoSo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public String getDonViDaoTao() {
		return donViDaoTao;
	}

	public void setDonViDaoTao(String donViDaoTao) {
		this.donViDaoTao = donViDaoTao;
	}

	public String getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public Date getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(Date thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public Date getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Date thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public String getLoaiTotNghiep() {
		return loaiTotNghiep;
	}

	public void setLoaiTotNghiep(String loaiTotNghiep) {
		this.loaiTotNghiep = loaiTotNghiep;
	}
	
	public int getIdHoSo()
	{
		return IdHoSo;
	}
	
	public void setIdHoSo(int idhs)
	{
		this.IdHoSo = idhs;
	}
}
