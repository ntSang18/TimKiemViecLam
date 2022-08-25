package PBL3_DA.BLL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import PBL3_DA.DAL.DBHelper;
import PBL3_DA.DTO.BangCap;
import PBL3_DA.DTO.HoSo;
import PBL3_DA.DTO.KiNang;
import PBL3_DA.DTO.NN_TH;
import PBL3_DA.DTO.TaiKhoan;
import PBL3_DA.DTO.ViecLam;

public class BLL_Timviec 
{
	private static BLL_Timviec _Instance;
	
	public static BLL_Timviec Instance()
	{
		if(_Instance == null) _Instance = new BLL_Timviec();
		return _Instance;
	}
	
	public ArrayList<ViecLam> GetListViecLam(int trangthai)
	{
		return DBHelper.Instance().GetListViecLam(trangthai);
	}
	
	public ArrayList<ViecLam> GetListViecLamLuu(int iduser)
	{
		return DBHelper.Instance().GetListViecLamLuu(iduser);
	}
	
	public ViecLam GetViecLamById(int id, int trangthai)
	{
		ViecLam v = new ViecLam();
		for (ViecLam i : GetListViecLam(trangthai)) 
		{
			if(i.GetId() == id)
			{
				v.SetViecLam(i);
			}
		}
		return v;
	}
	
	public boolean AddViecLam(ViecLam s)
	{
		return DBHelper.Instance().AddViecLam(s);
	}
	
	public boolean AddViecLamLuu(int iduser, int idcv)
	{
		for (ViecLam i : DBHelper.Instance().GetListViecLamLuu(iduser)) 
		{
			if(i.GetId() == idcv)
			{
				return false;
			}
		}
		return DBHelper.Instance().AddViecLamLuu(iduser, idcv);
	}
	
	public ArrayList<ViecLam> Sort(int cv, String txtb, String ht, String nn, String gt, String kn, String luong, String dc, int trangthai)
	{
		ArrayList<ViecLam> l = ListViecLam(txtb, ht, nn, gt, kn, luong, dc, trangthai);
		switch (cv) {
		case 0:
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					return v1.GetTieuDe().compareTo(v2.GetTieuDe());
				}
			});
			break;
		case 1:
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					return v1.GetHinhThuc().compareTo(v2.GetHinhThuc());
				}
			});
			break;
		case 2:
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					return v1.GetNganhNghe().compareTo(v2.GetNganhNghe());
				}
			});
			break;
		case 3: 
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					if(v1.GetLuongCoBan().length() == v2.GetLuongCoBan().length())
					{
						if(v1.GetLuongCoBan().compareTo(v2.GetLuongCoBan()) >= 0)
						{
							return 1;
						}
					}
					else if(v1.GetLuongCoBan().length() > v2.GetLuongCoBan().length())
					{
						return 1;
					}
					return -1;
				}	
			});
			break;
		case 4:
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					if(v1.GetKinhNghiemTuyen().length() < v2.GetKinhNghiemTuyen().length())
					{
						return 1;
					}
					else if(v1.GetKinhNghiemTuyen().length() == v2.GetKinhNghiemTuyen().length())
					{
						return v1.GetKinhNghiemTuyen().compareTo(v2.GetKinhNghiemTuyen());
					}
					else
					{
						return v1.GetKinhNghiemTuyen().compareTo(v2.GetKinhNghiemTuyen());
					}
				}
			});
			break;
		case 5:
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					return v1.GetNgayHetHan().compareTo(v2.GetNgayHetHan());
				}
			});
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + cv);
		}
		return l;
	}
	
	public ArrayList<ViecLam> ListViecLam(String txt, String ht, String nn, String gt, String kn, String luong, String dc, int trangthai)
	{
		String txtb = txt.trim();
		ArrayList<ViecLam> l = new ArrayList<ViecLam>();
		for (ViecLam i : GetListViecLam(trangthai)) 
		{
			if(txtb == "")
			{
				if(i.GetHinhThuc().contains(ht) && i.GetNganhNghe().contains(nn) && i.GetGioiTinhTuyen().contains(gt) &&
						i.GetKinhNghiemTuyen().contains(kn) && i.GetLuongCoBan().contains(luong) && i.GetTinh().contains(dc)) 
				{
					l.add(i);
				}
			}
			else
			{
				if((i.GetTieuDe().contains(txtb) || i.GetHinhThuc().contains(txtb) || i.GetNganhNghe().contains(txtb) || 
						i.GetGioiTinhTuyen().contains(txtb) || i.GetKinhNghiemTuyen().contains(txtb) || 
						i.GetLuongCoBan().contains(txtb) || i.GetTinh().contains(txtb)) && i.GetHinhThuc().contains(ht) && i.GetNganhNghe().contains(nn) && i.GetGioiTinhTuyen().contains(gt) &&
						i.GetKinhNghiemTuyen().contains(kn) && i.GetLuongCoBan().contains(luong) && i.GetTinh().contains(dc))
				{
					l.add(i);
				}
			}
		}
		return l;
	}
	
	public ArrayList<ViecLam> SearchSimp(String txt, String nn, String tt, int trangthai)
	{
		ArrayList<ViecLam> l = new ArrayList<ViecLam>();
		String txtb = txt.trim();
		for (ViecLam i : GetListViecLam(trangthai)) 
		{
			if(txtb == "")
			{
				if(i.GetNganhNghe().contains(nn) && i.GetTinh().contains(tt))
				{
					l.add(i);
				}
			}
			else
			{
				if((i.GetTieuDe().contains(txtb) || i.GetHinhThuc().contains(txtb) || i.GetNganhNghe().contains(txtb) || 
						i.GetGioiTinhTuyen().contains(txtb) || i.GetKinhNghiemTuyen().contains(txtb) || 
						i.GetLuongCoBan().contains(txtb) || i.GetTinh().contains(txtb)) && 
						i.GetNganhNghe().contains(nn) && i.GetTinh().contains(tt))
				{
					l.add(i);
				}
			}
		}
		return l;
	}
	
	public boolean Isnumber(String s)
	{
		for(int i = 0; i < s.length(); i++)
		{
			if(Character.isDigit(s.charAt(i)) == false)
			{
				return false;
			}
		}
		return true;
	}
	//Dùng trong form việc làm đã lưu
	public ArrayList<ViecLam> SearchByTxtUser(String txt, int iduser)
	{
		ArrayList<ViecLam> l = new ArrayList<ViecLam>();
		String txtb = txt.trim();
		for (ViecLam i : GetListViecLamLuu(iduser)) 
		{
			if(txtb == "")
			{
					l = GetListViecLamLuu(iduser);
			}
			else
			{
				if((i.GetTieuDe().contains(txtb) || i.GetHinhThuc().contains(txtb) || i.GetNganhNghe().contains(txtb) || 
						i.GetGioiTinhTuyen().contains(txtb) || i.GetKinhNghiemTuyen().contains(txtb) || 
						i.GetLuongCoBan().contains(txtb) || i.GetTinh().contains(txtb)))
				{
					l.add(i);
				}
			}
		}
		return l;
	}
	// Dùng trong form quản lý việc làm đã lưu
	public ArrayList<ViecLam> SortByTxtUser(int cv, String txt, int iduser)
	{
		ArrayList<ViecLam> l = SearchByTxtUser(txt, iduser);
		switch (cv) {
		case 0:
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					return v1.GetTieuDe().compareTo(v2.GetTieuDe());
				}
			});
			break;
		case 1:
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					return v1.GetHinhThuc().compareTo(v2.GetHinhThuc());
				}
			});
			break;
		case 2:
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					return v1.GetNganhNghe().compareTo(v2.GetNganhNghe());
				}
			});
			break;
		case 3: 
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					if(v1.GetLuongCoBan().length() == v2.GetLuongCoBan().length())
					{
						if(v1.GetLuongCoBan().compareTo(v2.GetLuongCoBan()) >= 0)
						{
							return 1;
						}
					}
					else if(v1.GetLuongCoBan().length() > v2.GetLuongCoBan().length())
					{
						return 1;
					}
					return -1;
				}	
			});
			break;
		case 4:
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					if(v1.GetKinhNghiemTuyen().length() < v2.GetKinhNghiemTuyen().length())
					{
						return 1;
					}
					else if(v1.GetKinhNghiemTuyen().length() == v2.GetKinhNghiemTuyen().length())
					{
						return v1.GetKinhNghiemTuyen().compareTo(v2.GetKinhNghiemTuyen());
					}
					else
					{
						return v1.GetKinhNghiemTuyen().compareTo(v2.GetKinhNghiemTuyen());
					}
				}
			});
			break;
		case 5:
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					return v1.GetNgayHetHan().compareTo(v2.GetNgayHetHan());
				}
			});
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + cv);
		}
		return l;
	}
	
	public boolean DeleteViecLamLuu(int iduser, int idcv)
	{
		return DBHelper.Instance().DeleteViecLamLuu(iduser, idcv);
	}
	//Dùng trong form quản lý việc làm của admin
	public ArrayList<ViecLam> SearchByTxtAdmin(String txt)
	{
		ArrayList<ViecLam> l = new ArrayList<ViecLam>();
		String txtb = txt.trim();
		for (ViecLam i : GetListViecLam(0))
		{
			if(txtb == "")
			{
					l = GetListViecLam(0);
			}
			else
			{
				if((i.GetTieuDe().contains(txtb) || i.GetHinhThuc().contains(txtb) || i.GetNganhNghe().contains(txtb) || 
						i.GetGioiTinhTuyen().contains(txtb) || i.GetKinhNghiemTuyen().contains(txtb) || 
						i.GetLuongCoBan().contains(txtb) || i.GetTinh().contains(txtb)))
				{
					l.add(i);
				}
			}
		}
		return l;
	}
	
	public ArrayList<ViecLam> SortByTxtAdmin(int cv, String txt)
	{
		ArrayList<ViecLam> l = SearchByTxtAdmin(txt);
		switch (cv) {
		case 0:
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					return v1.GetTieuDe().compareTo(v2.GetTieuDe());
				}
			});
			break;
		case 1:
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					return v1.GetHinhThuc().compareTo(v2.GetHinhThuc());
				}
			});
			break;
		case 2:
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					return v1.GetNganhNghe().compareTo(v2.GetNganhNghe());
				}
			});
			break;
		case 3: 
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					if(v1.GetLuongCoBan().length() == v2.GetLuongCoBan().length())
					{
						if(v1.GetLuongCoBan().compareTo(v2.GetLuongCoBan()) >= 0)
						{
							return 1;
						}
					}
					else if(v1.GetLuongCoBan().length() > v2.GetLuongCoBan().length())
					{
						return 1;
					}
					return -1;
				}	
			});
			break;
		case 4:
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					if(v1.GetKinhNghiemTuyen().length() < v2.GetKinhNghiemTuyen().length())
					{
						return 1;
					}
					else if(v1.GetKinhNghiemTuyen().length() == v2.GetKinhNghiemTuyen().length())
					{
						return v1.GetKinhNghiemTuyen().compareTo(v2.GetKinhNghiemTuyen());
					}
					else
					{
						return v1.GetKinhNghiemTuyen().compareTo(v2.GetKinhNghiemTuyen());
					}
				}
			});
			break;
		case 5:
			Collections.sort(l, new Comparator<ViecLam>() {
				public int compare(ViecLam v1, ViecLam v2)
				{
					return v1.GetNgayHetHan().compareTo(v2.GetNgayHetHan());
				}
			});
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + cv);
		}
		return l;
	}
	
	public boolean UpdateDuyet(int idcv)
	{
		return DBHelper.Instance().UpdateDuyetViecLam(idcv);
	}
	
	public boolean DeleteVieclLamById(int idcv)
	{
		return DBHelper.Instance().DeleteViecLamByIdcv(idcv);
	}
	
	public boolean DeleteViecLamHetHan()
	{
		return DBHelper.Instance().DeleteViecLamQuaHan();
	}
	
	public int GetCountViecLam(int trangthai)
	{
		return DBHelper.Instance().GetCountViecLam(trangthai);
	}
	
	public int GetCountUser()
	{
		return DBHelper.Instance().GetCountUser();
	}
	
	public boolean AddTaiKhoan(TaiKhoan tk)
	{
		return DBHelper.Instance().AddTaiKhoan(tk);
	}

	public ArrayList<TaiKhoan> GetListTaiKhoan()
	{
		return DBHelper.Instance().GetListTaiKhoan();
	}
	//Kiem tra xem da co email nay trong Table TAI_KHOAN chua
	public boolean CheckTaiKhoanByEmail(String email)
	{
		for (TaiKhoan i : GetListTaiKhoan()) 
		{
			if(i.getEmail().equals(email.trim()))
			{
				return true;
			}
		}
		return false;
	}
	//Kiem tra xem Email va mat khau co dung khong
	public boolean CheckTaiKhoan(String email, String pass)
	{
		for (TaiKhoan i : GetListTaiKhoan()) 
		{
			if(i.getEmail().equals(email.trim()) && i.getPass().equals(pass.trim()))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean CheckTaiKhoanType(String email, String pass)
	{
		for (TaiKhoan i : GetListTaiKhoan()) 
		{
			if(i.getEmail().equals(email.trim()) && i.getPass().equals(pass.trim()))
			{
				if(i.getType() == 1)
				{
					return true;
				}
			}
		}
		return false;
	}

	public int GetIdTaiKhoanByEmail(String email)
	{
		int id = 0;
		for (TaiKhoan i : GetListTaiKhoan()) 
		{
			if(i.getEmail().equals(email.trim()))
			{
				id = i.getId();
			}
		}
		return id;
	}
	
	public TaiKhoan GetTaiKhoanById(int id)
	{
		TaiKhoan tk = new TaiKhoan();
		for (TaiKhoan i : GetListTaiKhoan()) 
		{
			if(i.getId() == id)
			{
				tk.setId(i.getId());
				tk.setEmail(i.getEmail());
				tk.setPass(i.getPass());
				tk.setUserName(i.getUserName());
				tk.setSDT(i.getSDT());
				tk.setType(i.getType());
			}
		}
		return tk;
	}
	
	public ArrayList<KiNang> GetAllListKiNang()
	{
		return DBHelper.Instance().GetAllListKiNang();
	}
	
	public ArrayList<BangCap> GetAllListBangCap()
	{
		return DBHelper.Instance().GetAllListBangCap();
	}
	
	public ArrayList<NN_TH> GetAllListNN_TH()
	{
		return DBHelper.Instance().GetAllListNN_TH();
	}
	
	public ArrayList<HoSo> GetAllListHoSo()
	{
		return DBHelper.Instance().GetAllListHoSo();
	}
	
	public BangCap GetBangCapByIdHS(int idhs)
	{
		BangCap bc = new BangCap();
		for (BangCap i : GetAllListBangCap()) 
		{
			if(i.getIdHoSo() == idhs)
			{
				bc.setId(i.getId());
				bc.setTrinhDo(i.getTrinhDo());
				bc.setDonViDaoTao(i.getDonViDaoTao());
				bc.setThoiGianBatDau(i.getThoiGianBatDau());
				bc.setThoiGianKetThuc(i.getThoiGianKetThuc());
				bc.setChuyenNganh(i.getChuyenNganh());
				bc.setLoaiTotNghiep(i.getLoaiTotNghiep());
			}
		}
		return bc;
	}
	
	public KiNang GetKiNangByIdHoSo(int idhs)
	{
		KiNang kn = new KiNang();
		for (KiNang i : GetAllListKiNang()) 
		{
			if(i.getIdHoSo() == idhs)
			{
				kn.setId(i.getId());
				kn.setLanhDao(i.isLanhDao());
				kn.setLamViecNhom(i.isLamViecNhom());
				kn.setRaChienLuoc(i.isRaChienLuoc());
				kn.setGiaiQuyetVD(i.isGiaiQuyetVD());
				kn.setQuanLyNhanLuc(i.isQuanLyNhanLuc());
				kn.setGiaoTiep(i.isGiaoTiep());
				kn.setQuanLyThoiGian(i.isQuanLyThoiGian());
				kn.setQuanLyDuAn(i.isQuanLyDuAn());
				kn.setSangTao(i.isSangTao());
				kn.setSoThich(i.getSoThich());
				kn.setKyNangKhac(i.getKyNangKhac());
			}
		}
		return kn;
	}
	
	public NN_TH GetNN_THByIdHoSo(int idhs)
	{
		NN_TH nt = new NN_TH();
		for (NN_TH i : GetAllListNN_TH()) 
		{
			if(i.getIdHoSo() == idhs)
			{
				nt.setId(i.getId());
				nt.setLoaiNgonNgu(i.getLoaiNgonNgu());
				nt.setTrinhDo(i.getTrinhDo());
				nt.setBangCap(i.getBangCap());
				nt.setWord(i.isWord());
				nt.setExcel(i.isExcel());
				nt.setPowerPoint(i.isPowerPoint());
				nt.setOutLook(i.isOutLook());
				nt.setPhanMemKhac(i.getPhanMemKhac());
			}
		}
		return nt;
	}
	
	public boolean AddHoSo(HoSo hs, BangCap bc, KiNang kn, NN_TH nt, TaiKhoan tk)
	{
		DBHelper.Instance().UpdateTaiKhoan(tk);
		DBHelper.Instance().AddBangCap(bc);
		DBHelper.Instance().AddKiNang(kn);
		DBHelper.Instance().AddNN_TH(nt);
		int idbc = GetBangCapByIdHS(hs.getId()).getId();
		int idkn = GetKiNangByIdHoSo(hs.getId()).getId();
		int idnt = GetNN_THByIdHoSo(hs.getId()).getId();
		hs.setId_BC(idbc);
		hs.setId_KN(idkn);
		hs.setIdNN_TH(idnt);
		return DBHelper.Instance().AddHoSo(hs);
	}

	public HoSo GetHoSoById(int id)
	{
		HoSo hs = new HoSo();
		for (HoSo i : GetAllListHoSo()) 
		{
			if(i.getId() == id)
			{
				hs.SetHoSo(i);
			}
		}
		return hs;
	}
	
	public boolean CheckHoSoById(int id)
	{
		for (HoSo i : GetAllListHoSo()) 
		{
			if(i.getId() == id)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean UpdateHoSo(HoSo hs, BangCap bc, KiNang kn, NN_TH nt, TaiKhoan tk)
	{
		int idbc = GetHoSoById(hs.getId()).getId_BC();
		int idkn = GetHoSoById(hs.getId()).getId_KN();
		int idnt = GetHoSoById(hs.getId()).getIdNN_TH();
		bc.setId(idbc);
		kn.setId(idkn);
		nt.setId(idnt);
		DBHelper.Instance().UpdateBangCap(bc);
		DBHelper.Instance().UpdateKiNang(kn);
		DBHelper.Instance().UpdateNN_TH(nt);
		DBHelper.Instance().UpdateTaiKhoan(tk);
		return DBHelper.Instance().UpdateHoSo(hs);
	}
	
	public void DeleteHoSo(int idhs)
	{
		HoSo hs = GetHoSoById(idhs);
		int idbc = hs.getId_BC();
		int idnt = hs.getIdNN_TH();
		int idkn = hs.getId_KN();
		DBHelper.Instance().DeleteHoSo(idhs);
		DBHelper.Instance().DeleteBangCap(idbc);
		DBHelper.Instance().DeleteKiNang(idkn);
		DBHelper.Instance().DeleteNN_TH(idnt);
	}
	
	public ArrayList<HoSo> SearchHoSo(String name, String tdhv, String loaitotnghiep, String ngoaingu, String trinhdonn, String tinh)
	{
		ArrayList<HoSo> l = new ArrayList<HoSo>();
		for (HoSo i : GetAllListHoSo()) 
		{
			BangCap bc = GetBangCapByIdHS(i.getId());
			NN_TH nt = GetNN_THByIdHoSo(i.getId());
			if(i.getFullname().contains(name.trim()) && bc.getTrinhDo().contains(tdhv) && bc.getLoaiTotNghiep().contains(loaitotnghiep) && nt.getLoaiNgonNgu().contains(ngoaingu) && 
					nt.getTrinhDo().contains(trinhdonn) && i.getTinh().contains(tinh))
			{
				l.add(i);
			}
		}
		return l;
	}

}

