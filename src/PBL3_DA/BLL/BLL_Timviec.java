package PBL3_DA.BLL;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import PBL3_DA.DAL.DBHelper;
import PBL3_DA.DTO.DiaChi;
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
	
	public DiaChi GetDiaChi(String tinh, String dcct)
	{
		DiaChi s = new DiaChi();
		for (DiaChi i : DBHelper.Instance().GetListDiaChi()) 
		{
			if(i.GetTinh().toString().trim().equals(tinh) == true && i.GetDCCT().toString().trim().equals(dcct) == true)
			{
				s.SetId(i.GetId());
				s.SetTinh(i.GetTinh());
				s.SetDCCT(i.GetDCCT());
			}
		}
		return s;
	}
	
	public DiaChi GetDiaChiById(int iddc)
	{
		DiaChi s = new DiaChi();
		for (DiaChi i : DBHelper.Instance().GetListDiaChi()) 
		{
			if(i.GetId() == iddc)
			{
				s.SetId(i.GetId());
				s.SetTinh(i.GetTinh());
				s.SetDCCT(i.GetDCCT());
			}
		}
		return s;
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
	
	public boolean AddDiaChi(DiaChi s)
	{
		return DBHelper.Instance().AddDiaChi(s);
	}
	
	public ArrayList<ViecLam> ListViecLam(String txt, String ht, String nn, String gt, String kn, String luong, String dc, int trangthai)
	{
		String txtb = txt.trim();
		ArrayList<ViecLam> l = new ArrayList<ViecLam>();
		for (ViecLam i : GetListViecLam(trangthai)) 
		{
			DiaChi a = GetDiaChiById(i.GetIdDC());
			if(txtb == "")
			{
				if(i.GetHinhThuc().contains(ht) && i.GetNganhNghe().contains(nn) && i.GetGioiTinhTuyen().contains(gt) &&
						i.GetKinhNghiemTuyen().contains(kn) && i.GetLuongCoBan().contains(luong) && a.GetTinh().contains(dc)) 
				{
					l.add(i);
				}
			}
			else
			{
				if((i.GetTieuDe().contains(txtb) || i.GetHinhThuc().contains(txtb) || i.GetNganhNghe().contains(txtb) || 
						i.GetGioiTinhTuyen().contains(txtb) || i.GetKinhNghiemTuyen().contains(txtb) || 
						i.GetLuongCoBan().contains(txtb) || a.GetTinh().contains(txtb)) && i.GetHinhThuc().contains(ht) && i.GetNganhNghe().contains(nn) && i.GetGioiTinhTuyen().contains(gt) &&
						i.GetKinhNghiemTuyen().contains(kn) && i.GetLuongCoBan().contains(luong) && a.GetTinh().contains(dc))
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
			DiaChi a = GetDiaChiById(i.GetIdDC());
			if(txtb == "")
			{
				if(i.GetNganhNghe().contains(nn) && a.GetTinh().contains(tt))
				{
					l.add(i);
				}
			}
			else
			{
				if((i.GetTieuDe().contains(txtb) || i.GetHinhThuc().contains(txtb) || i.GetNganhNghe().contains(txtb) || 
						i.GetGioiTinhTuyen().contains(txtb) || i.GetKinhNghiemTuyen().contains(txtb) || 
						i.GetLuongCoBan().contains(txtb) || a.GetTinh().contains(txtb)) && 
						i.GetNganhNghe().contains(nn) && a.GetTinh().contains(tt))
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
			DiaChi a = GetDiaChiById(i.GetIdDC());
			if(txtb == "")
			{
					l = GetListViecLamLuu(iduser);
			}
			else
			{
				if((i.GetTieuDe().contains(txtb) || i.GetHinhThuc().contains(txtb) || i.GetNganhNghe().contains(txtb) || 
						i.GetGioiTinhTuyen().contains(txtb) || i.GetKinhNghiemTuyen().contains(txtb) || 
						i.GetLuongCoBan().contains(txtb) || a.GetTinh().contains(txtb)))
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
			DiaChi a = GetDiaChiById(i.GetIdDC());
			if(txtb == "")
			{
					l = GetListViecLam(0);
			}
			else
			{
				if((i.GetTieuDe().contains(txtb) || i.GetHinhThuc().contains(txtb) || i.GetNganhNghe().contains(txtb) || 
						i.GetGioiTinhTuyen().contains(txtb) || i.GetKinhNghiemTuyen().contains(txtb) || 
						i.GetLuongCoBan().contains(txtb) || a.GetTinh().contains(txtb)))
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
	
	
	
	
	
	
	
	
	
}

