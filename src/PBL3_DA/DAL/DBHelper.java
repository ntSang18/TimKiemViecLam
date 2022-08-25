package PBL3_DA.DAL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.net.httpserver.Authenticator.Result;

import PBL3_DA.DTO.BangCap;
import PBL3_DA.DTO.HoSo;
import PBL3_DA.DTO.KiNang;
import PBL3_DA.DTO.NN_TH;
import PBL3_DA.DTO.TaiKhoan;
import PBL3_DA.DTO.ViecLam;
import PBL3_DA.GUI.OverviewFrame;

public class DBHelper {
	private Connection conn;
	private static DBHelper _Instance;
	public static DBHelper Instance()
	{
		if(_Instance == null) _Instance = new DBHelper();
		return _Instance;
	}
	public DBHelper() 
	{
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://103.95.197.121:9696;databaseName=TimKiemViecLam;";
			conn = DriverManager.getConnection(url, "DACNPM", "khoa19@itf");
			System.out.println("Ket noi thanh cong");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean AddTaiKhoan(TaiKhoan tk)
	{
		String sql = "INSERT INTO TAI_KHOAN(Email, Pass, Username, SDT, Type) "
				+ "VALUES(?, ?, ?, ?, ?)";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, tk.getEmail());
			ps.setString(2, tk.getPass());
			ps.setString(3, tk.getUserName());
			ps.setInt(4, tk.getSDT());
			ps.setInt(5, tk.getType());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean UpdateTaiKhoan(TaiKhoan tk)
	{
		String sqp = "update TAI_KHOAN set Sdt = ? where id = ?";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sqp);
			ps.setInt(1, tk.getSDT());
			ps.setInt(2, tk.getId());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<TaiKhoan> GetListTaiKhoan()
	{
		ArrayList<TaiKhoan> l = new ArrayList<TaiKhoan>();
		String sql = "Select * from TAI_KHOAN";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
				TaiKhoan tk = new TaiKhoan();
				tk.setId(rs.getInt("Id"));
				tk.setEmail(rs.getString("Email").trim());
				tk.setPass(rs.getString("Pass").trim());
				tk.setUserName(rs.getString("Username").trim());
				tk.setSDT(rs.getInt("Sdt"));
				tk.setType(rs.getInt("Type"));
				
				l.add(tk);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return l;
	}
	//Su ly ho so
	public boolean AddBangCap(BangCap bc)
	{
		String sql = "insert into BANG_CAP(TrinhDo ,DonViDaoTao ,ThoiGianBatDau ,ThoiGianKetThuc ,ChuyenNganh ,LoaiTotNghiep, IdHoSo) "
				+ "values (? , ? , ? , ? , ? , ?, ?) ";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bc.getTrinhDo());
			ps.setString(2, bc.getDonViDaoTao());
			ps.setDate(3, bc.getThoiGianBatDau());
			ps.setDate(4, bc.getThoiGianKetThuc());
			ps.setString(5, bc.getChuyenNganh());
			ps.setString(6, bc.getLoaiTotNghiep());
			ps.setInt(7, bc.getIdHoSo());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean DeleteBangCap(int idbc)
	{
		String sql = "delete from BANG_CAP where id = ?";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idbc);
			return ps.executeUpdate() > 0;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean AddKiNang(KiNang kn)
	{
		String sql = "insert into KI_NANG(LanhDao, LamViecNhom, RaChienLuoc, GiaiQuyetVD, QuanLyNhanLuc, GiaoTiep, QuanLyThoiGian, QuanLyDuAn,"
				+ "SangTao, SoThich, KyNangKhac, IdHoSo) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, kn.isLanhDao());
			ps.setBoolean(2, kn.isLamViecNhom());
			ps.setBoolean(3, kn.isRaChienLuoc());
			ps.setBoolean(4, kn.isGiaiQuyetVD());
			ps.setBoolean(5, kn.isQuanLyNhanLuc());
			ps.setBoolean(6, kn.isGiaoTiep());
			ps.setBoolean(7, kn.isQuanLyThoiGian());
			ps.setBoolean(8, kn.isQuanLyDuAn());
			ps.setBoolean(9, kn.isSangTao());
			ps.setString(10, kn.getSoThich());
			ps.setString(11, kn.getKyNangKhac());
			ps.setInt(12, kn.getIdHoSo());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
 
	public boolean DeleteKiNang(int idkn)
	{
		String sql = "delete from KI_NANG where id = ?";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idkn);
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean AddNN_TH(NN_TH nnth)
	{
		String sql = "insert into NN_TH(LoaiNgonNgu, TrinhDo, BangCap, Word, Excel, PowerPoint, Outlook, PhanMemKhac, IdHoSo) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nnth.getLoaiNgonNgu());
			ps.setString(2, nnth.getTrinhDo());
			ps.setString(3, nnth.getBangCap());
			ps.setBoolean(4, nnth.isWord());
			ps.setBoolean(5, nnth.isExcel());
			ps.setBoolean(6, nnth.isPowerPoint());
			ps.setBoolean(7, nnth.isOutLook());
			ps.setString(8, nnth.getPhanMemKhac());
			ps.setInt(9, nnth.getIdHoSo());
			
			return ps.executeUpdate() > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean DeleteNN_TH(int idnt)
	{
		String sql = "delete from NN_TH where id = ?";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idnt);
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean AddHoSo(HoSo hs) 
	{
		String sql = "INSERT INTO dbo.HO_SO(Id, Fullname, NgaySinh, GioiTinh, KinhNghiem, ViTriHienTai, ViTriMongMuon, MucLuongMongMuon, NoiLamViec,"
				+ "MucTieuCV, TenCongTyDangLam, ThoiGianBatDauLam, ThoiGianKetThucLam, MucLuong, MoTaCV, IdBC, IdNN_TH, IdKN, Tinh, DiaChiChiTiet)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try 
		{
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setInt(1, hs.getId());
			ps.setString(2, hs.getFullname());
			ps.setDate(3, hs.getNgaySinh());
			ps.setBoolean(4, hs.getGioiTinh());
			ps.setString(5, hs.getKinhNghiem());
			ps.setString(6, hs.getViTriHienTai());
			ps.setString(7, hs.getViTriMongMuon());
			ps.setString(8, hs.getMucLuong());
			ps.setString(9, hs.getNoiLamViec());
			ps.setString(10, hs.getMucTieuCV());
			ps.setString(11, hs.getTenCongTyDangLam());
			ps.setDate(12, hs.getThoiGianBatDauLam());
			ps.setDate(13, hs.getThoiGianKetThucLam());
			ps.setString(14, hs.getMucLuong());
			ps.setString(15, hs.getMoTaCV());
			ps.setInt(16, hs.getId_BC());
			ps.setInt(17, hs.getIdNN_TH());
			ps.setInt(18, hs.getId_KN());
			ps.setString(19, hs.getTinh());
			ps.setString(20, hs.getDCCT());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<BangCap> GetAllListBangCap()
	{
		ArrayList<BangCap> l = new ArrayList<BangCap>();
		String sql = "Select * from BANG_CAP";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
				BangCap bc = new BangCap();
				bc.setId(rs.getInt("Id"));
				bc.setTrinhDo(rs.getString("TrinhDo"));
				bc.setDonViDaoTao(rs.getString("DonViDaoTao"));
				bc.setThoiGianBatDau(rs.getDate("ThoiGianBatDau"));
				bc.setThoiGianKetThuc(rs.getDate("ThoiGianKetThuc"));
				bc.setChuyenNganh(rs.getString("ChuyenNganh"));
				bc.setLoaiTotNghiep(rs.getString("LoaiTotNghiep"));
				bc.setIdHoSo(rs.getInt("IdHoSo"));
				
				l.add(bc);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return l;
	}

	public ArrayList<KiNang> GetAllListKiNang()
	{
		ArrayList<KiNang> l = new ArrayList<KiNang>();
		String sql = "Select * from KI_NANG";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
				KiNang kn = new KiNang();
				kn.setId(rs.getInt("Id"));
				kn.setLanhDao(rs.getBoolean("LanhDao"));
				kn.setLamViecNhom(rs.getBoolean("LamViecNhom"));
				kn.setRaChienLuoc(rs.getBoolean("RaChienLuoc"));
				kn.setGiaiQuyetVD(rs.getBoolean("GiaiQuyetVD"));
				kn.setQuanLyNhanLuc(rs.getBoolean("QuanLyNhanLuc"));
				kn.setGiaoTiep(rs.getBoolean("GiaoTiep"));
				kn.setQuanLyThoiGian(rs.getBoolean("QuanLyThoiGian"));
				kn.setQuanLyDuAn(rs.getBoolean("QuanLyDuAn"));
				kn.setSangTao(rs.getBoolean("SangTao"));
				kn.setSoThich(rs.getString("SoThich"));
				kn.setKyNangKhac(rs.getString("KyNangKhac"));
				kn.setIdHoSo(rs.getInt("IdHoSo"));
				
				l.add(kn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public ArrayList<NN_TH> GetAllListNN_TH()
	{
		ArrayList<NN_TH> l = new ArrayList<NN_TH>();
		String sql = "SELECT * FROM NN_TH";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
				NN_TH nt = new NN_TH();
				nt.setId(rs.getInt("Id"));
				nt.setLoaiNgonNgu(rs.getString("LoaiNgonNgu"));
				nt.setTrinhDo(rs.getString("TrinhDo"));
				nt.setBangCap(rs.getString("BangCap"));
				nt.setWord(rs.getBoolean("Word"));
				nt.setExcel(rs.getBoolean("Excel"));
				nt.setPowerPoint(rs.getBoolean("PowerPoint"));
				nt.setOutLook(rs.getBoolean("Outlook"));
				nt.setPhanMemKhac(rs.getString("PhanMemKhac"));
				nt.setIdHoSo(rs.getInt("IdHoSo"));
				
				l.add(nt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public ArrayList<HoSo> GetAllListHoSo()
	{
		ArrayList<HoSo> l = new ArrayList<HoSo>();
		String sql = "Select * From HO_SO";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
				HoSo hs = new HoSo();
				hs.setId(rs.getInt("Id"));
				hs.setFullname(rs.getString("Fullname"));
				hs.setNgaySinh(rs.getDate("NgaySinh"));
				hs.setGioiTinh(rs.getBoolean("GioiTinh"));
				hs.setKinhNghiem(rs.getString("KinhNghiem"));
				hs.setViTriHienTai(rs.getString("ViTriHienTai"));
				hs.setViTriMongMuon(rs.getString("ViTriMongMuon"));
				hs.setMucLuongMongMuon(rs.getString("MucLuongMongMuon"));
				hs.setNoiLamViec(rs.getString("NoiLamViec"));
				hs.setMucTieuCV(rs.getString("MucTieuCV"));
				hs.setTenCongTyDangLam(rs.getString("TenCongTyDangLam"));
				hs.setThoiGianBatDauLam(rs.getDate("ThoiGianBatDauLam"));
				hs.setThoiGianKetThucLam(rs.getDate("ThoiGianKetThucLam"));
				hs.setMucLuong(rs.getString("MucLuong"));
				hs.setMoTaCV(rs.getString("MoTaCV"));
				hs.setId_BC(rs.getInt("IdBC"));
				hs.setIdNN_TH(rs.getInt("IdNN_TH"));
				hs.setId_KN(rs.getInt("IdKN"));
				hs.setTinh(rs.getString("Tinh"));
				hs.setDCCT(rs.getString("DiaChiChiTiet"));
				
				l.add(hs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public boolean UpdateBangCap(BangCap bc)
	{
		String sql = "update BANG_CAP set TrinhDo = ?, DonViDaoTao = ?, ThoiGianBatDau = ?, ThoiGianKetThuc = ?, ChuyenNganh = ?, LoaiTotNghiep = ? "
				+ "where Id = ?";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bc.getTrinhDo());
			ps.setString(2, bc.getDonViDaoTao());
			ps.setDate(3, bc.getThoiGianBatDau());
			ps.setDate(4, bc.getThoiGianKetThuc());
			ps.setString(5, bc.getChuyenNganh());
			ps.setString(6, bc.getLoaiTotNghiep());
			ps.setInt(7, bc.getId()); 
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean UpdateKiNang(KiNang kn)
	{
		String sql = "update KI_NANG set LanhDao = ?, LamViecNhom = ?, RaChienLuoc = ?, GiaiQuyetVD = ?, QuanLyNhanLuc = ?, GiaoTiep = ?,"
				+ "QuanLyThoiGian = ?, QuanLyDuAn = ?, SangTao = ?, SoThich = ?, KyNangKhac = ? where id = ?";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBoolean(1, kn.isLanhDao());
			ps.setBoolean(2, kn.isLamViecNhom());
			ps.setBoolean(3, kn.isRaChienLuoc());
			ps.setBoolean(4, kn.isGiaiQuyetVD());
			ps.setBoolean(5, kn.isQuanLyNhanLuc());
			ps.setBoolean(6, kn.isGiaoTiep());
			ps.setBoolean(7, kn.isQuanLyThoiGian());
			ps.setBoolean(8, kn.isQuanLyDuAn());
			ps.setBoolean(9, kn.isSangTao());
			ps.setString(10, kn.getSoThich());
			ps.setString(11, kn.getKyNangKhac());
			ps.setInt(12, kn.getId());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean UpdateNN_TH(NN_TH nt)
	{
		String sql = "update NN_TH set LoaiNgonNgu = ?, TrinhDo = ?, BangCap = ?, Word = ?, Excel = ?, PowerPoint = ?, Outlook = ?, PhanMemKhac = ? "
				+ "where id = ?";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nt.getLoaiNgonNgu());
			ps.setString(2, nt.getTrinhDo());
			ps.setString(3, nt.getBangCap());
			ps.setBoolean(4, nt.isWord());
			ps.setBoolean(5, nt.isExcel());
			ps.setBoolean(6, nt.isPowerPoint());
			ps.setBoolean(7, nt.isOutLook());
			ps.setString(8, nt.getPhanMemKhac());
			ps.setInt(9, nt.getId());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean UpdateHoSo(HoSo hs)
	{
		String sql = "update HO_SO set Fullname = ?, NgaySinh = ?, GioiTinh = ?, KinhNghiem = ?, ViTriHienTai = ?, ViTriMongMuon = ?, "
				+ "MucLuongMongMuon = ?, NoiLamViec = ?, MucTieuCV = ?,"
				+ "TenCongTyDangLam = ?, ThoiGianBatDauLam = ?, ThoiGianKetThucLam = ?, MucLuong = ?, MoTaCV = ? "
				+ "where id = ?";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, hs.getFullname());
			ps.setDate(2, hs.getNgaySinh());
			ps.setBoolean(3, hs.getGioiTinh());
			ps.setString(4, hs.getKinhNghiem());
			ps.setString(5, hs.getViTriHienTai());
			ps.setString(6, hs.getViTriMongMuon());
			ps.setString(7, hs.getMucLuongMongMuon());
			ps.setString(8, hs.getNoiLamViec());
			ps.setString(9, hs.getMucTieuCV());
			ps.setString(10, hs.getTenCongTyDangLam());
			ps.setDate(11, hs.getThoiGianBatDauLam());
			ps.setDate(12, hs.getThoiGianKetThucLam());
			ps.setString(13, hs.getMucLuong());
			ps.setString(14, hs.getMoTaCV());
			ps.setInt(15, hs.getId());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean DeleteHoSo(int idhs)
	{
		String sql = "delete from HO_SO where id = ?";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idhs);
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	//Su ly viec lam
	public boolean AddViecLam(ViecLam s)
	{
		String sql = "INSERT INTO CONG_VIEC(IdUser, TieuDe, SoLuongTuyen, GioiTinhTuyen, MoTaCV, YeuCauCV, HinhThuc, "
				+ "KinhNghiemTuyen, TGThuViec, QuyenLoi, NganhNghe, LuongCoBan, NgayHetHan, TenCongTy, "
				+ "SDT, QuyMoNhanSu, LinhVucHoatDong, SoLuocCT, TrangThai, TrinhDo, Tinh, DiaChiChiTiet)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, s.GetIdUser());
			ps.setString(2, s.GetTieuDe());
			ps.setInt(3, s.GetSoLuongTuyen());
			ps.setString(4, s.GetGioiTinhTuyen());
			ps.setString(5, s.GetMoTaCV());
			ps.setString(6, s.GetYeuCauCV());
			ps.setString(7, s.GetHinhThuc());
			ps.setString(8, s.GetKinhNghiemTuyen());
			ps.setString(9, s.GetTGThuViec());
			ps.setString(10, s.GetQuyenLoi());
			ps.setString(11, s.GetNganhNghe());
			ps.setString(12, s.GetLuongCoBan());
			ps.setDate(13, new Date(s.GetNgayHetHan().getTime()));
			ps.setString(14, s.GetTenCT());
			ps.setInt(15, s.GetSDT());
			ps.setString(16, s.GetQuyMoNhanSu());
			ps.setString(17, s.GetLinhVucHD());
			ps.setString(18, s.GetSoLuocCT());
			ps.setBoolean(19, false);
			ps.setString(20, s.GetTrinhDo());
			ps.setString(21, s.GetTinh());
			ps.setString(22, s.GetDCCT());
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean AddViecLamLuu(int iduser, int idcv)
	{
		String sql = "INSERT INTO CONG_VIEC_LUU(IdUser, IdCongViec) "
				+ "VALUES(?, ?)";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, iduser);
			ps.setInt(2, idcv);
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<ViecLam> GetListViecLam(int trangthai)
	{
		ArrayList<ViecLam> list = new ArrayList<>();
		String sql = "SELECT * FROM CONG_VIEC WHERE TrangThai = ?";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, trangthai);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				ViecLam v = new ViecLam();
				v.SetId(rs.getInt("Id"));
				v.SetIdUser(rs.getInt("IdUser"));
				v.SetTieuDe(rs.getString("TieuDe"));
				v.SetSoLuongTuyen(rs.getInt("SoLuongTuyen"));
				v.SetGioiTinhTuyen(rs.getString("GioiTinhTuyen"));
				v.SetMoTaCV(rs.getString("MoTaCV"));
				v.SetYeuCauCV(rs.getString("YeuCauCV"));
				v.SetHinhThuc(rs.getString("HinhThuc"));
				v.SetKinhNghiemTuyen(rs.getString("KinhNghiemTuyen"));
				v.SetTGThuViec(rs.getString("TGThuViec"));
				v.SetQuyenLoi(rs.getString("QuyenLoi"));
				v.SetNganhNghe(rs.getString("NganhNghe"));
				v.SetLuongCoBan(rs.getString("LuongCoBan"));
				v.SetNgayHetHan(rs.getDate("NgayHetHan"));
				v.SetTenCT(rs.getString("TenCongTy"));
				v.SetSDT(rs.getInt("SDT"));
				v.SetQuyMoNhanSu(rs.getString("QuyMoNhanSu"));
				v.SetLinhVucHD(rs.getString("LinhVucHoatDong"));
				v.SetSoLuocCT(rs.getString("SoLuocCT"));
				v.SetTrangThai(rs.getBoolean("TrangThai"));
				v.SetTrinhDo(rs.getString("TrinhDo"));
				v.SetTinh(rs.getString("Tinh"));
				v.SetDCCT(rs.getString("DiaChiChiTiet"));
				
				list.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<ViecLam> GetListViecLamLuu(int iduser)
	{
		ArrayList<ViecLam> l = new ArrayList<ViecLam>();
		String sql = "SELECT CONG_VIEC.Id, CONG_VIEC.IdUser, CONG_VIEC.TieuDe, CONG_VIEC.SoLuongTuyen, CONG_VIEC.GioiTinhTuyen, CONG_VIEC.MoTaCV, "
				+ "CONG_VIEC.YeuCauCV, CONG_VIEC.HinhThuc,CONG_VIEC.KinhNghiemTuyen, CONG_VIEC.TGThuViec, CONG_VIEC.QuyenLoi, CONG_VIEC.NganhNghe, "
				+ "CONG_VIEC.LuongCoBan, CONG_VIEC.NgayHetHan, CONG_VIEC.TenCongTy,CONG_VIEC.SDT, CONG_VIEC.QuyMoNhanSu, "
				+ "CONG_VIEC.LinhVucHoatDong, CONG_VIEC.SoLuocCT, CONG_VIEC.TrangThai, CONG_VIEC.TrinhDo, CONG_VIEC.Tinh, CONG_VIEC.DiaChiChiTiet "
				+ "FROM dbo.CONG_VIEC, dbo.CONG_VIEC_LUU "
				+ "WHERE dbo.CONG_VIEC.Id = dbo.CONG_VIEC_LUU.IdCongViec AND dbo.CONG_VIEC_LUU.IdUser = ?";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, iduser);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				ViecLam v = new ViecLam();
				v.SetId(rs.getInt("Id"));
				v.SetIdUser(rs.getInt("IdUser"));
				v.SetTieuDe(rs.getString("TieuDe"));
				v.SetSoLuongTuyen(rs.getInt("SoLuongTuyen"));
				v.SetGioiTinhTuyen(rs.getString("GioiTinhTuyen"));
				v.SetMoTaCV(rs.getString("MoTaCV"));
				v.SetYeuCauCV(rs.getString("YeuCauCV"));
				v.SetHinhThuc(rs.getString("HinhThuc"));
				v.SetKinhNghiemTuyen(rs.getString("KinhNghiemTuyen"));
				v.SetTGThuViec(rs.getString("TGThuViec"));
				v.SetQuyenLoi(rs.getString("QuyenLoi"));
				v.SetNganhNghe(rs.getString("NganhNghe"));
				v.SetLuongCoBan(rs.getString("LuongCoBan"));
				v.SetNgayHetHan(rs.getDate("NgayHetHan"));
				v.SetTenCT(rs.getString("TenCongTy"));
				v.SetSDT(rs.getInt("SDT"));
				v.SetQuyMoNhanSu(rs.getString("QuyMoNhanSu"));
				v.SetLinhVucHD(rs.getString("LinhVucHoatDong"));
				v.SetSoLuocCT(rs.getString("SoLuocCT"));
				v.SetTrangThai(rs.getBoolean("TrangThai"));
				v.SetTrinhDo(rs.getString("TrinhDo"));
				v.SetTinh(rs.getString("Tinh"));
				v.SetDCCT(rs.getString("DiaChiChiTiet"));
				
				l.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	public boolean DeleteViecLamLuu(int iduser, int idcv)
	{
		String sql = "DELETE dbo.CONG_VIEC_LUU WHERE IdUser = ? AND IdCongViec = ?";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, iduser);
			ps.setInt(2, idcv);
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean UpdateDuyetViecLam(int idcv)
	{
		String sql = "UPDATE dbo.CONG_VIEC SET TrangThai = 1 WHERE Id = ?";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idcv);
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean DeleteViecLamByIdcv(int idcv)
	{
		String sql = "DELETE dbo.CONG_VIEC WHERE Id = ?";
		try
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, idcv);
			
			return ps.executeUpdate() > 0;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean DeleteViecLamQuaHan()
	{
		String sql = "DELETE dbo.CONG_VIEC WHERE NgayHetHan < GETDATE()";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			return ps.executeUpdate() > 0;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
		return false;
	}
	
	public int GetCountViecLam(int trangthai)
	{
		int count = 0;
		String sql = "SELECT COUNT(*) FROM dbo.CONG_VIEC WHERE TrangThai = ?";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, trangthai);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public int GetCountUser()
	{
		int count = 0;
		String sql = "SELECT COUNT(*) FROM dbo.TAI_KHOAN WHERE Type = 0";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
