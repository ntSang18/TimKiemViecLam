package PBL3_DA.DAL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.net.httpserver.Authenticator.Result;

import PBL3_DA.DTO.DiaChi;
import PBL3_DA.DTO.ViecLam;

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
			String url = "jdbc:sqlserver://DESKTOP-0M6RQB0\\SQLEXPRESS:1433;databaseName=TimKiemViecLam;integratedSecurity=true";
			conn = DriverManager.getConnection(url, "sa", "sang186001");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean AddViecLam(ViecLam s)
	{
		String sql = "INSERT INTO CONG_VIEC(IdUser, TieuDe, SoLuongTuyen, GioiTinhTuyen, MoTaCV, YeuCauCV, HinhThuc, "
				+ "KinhNghiemTuyen, TGThuViec, QuyenLoi, NganhNghe, LuongCoBan, NgayHetHan, TenCongTy, "
				+ "IdDC, SDT, QuyMoNhanSu, LinhVucHoatDong, SoLuocCT, TrangThai, TrinhDo)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			ps.setInt(15, s.GetIdDC());
			ps.setInt(16, s.GetSDT());
			ps.setString(17, s.GetQuyMoNhanSu());
			ps.setString(18, s.GetLinhVucHD());
			ps.setString(19, s.GetSoLuocCT());
			ps.setBoolean(20, false);
			ps.setString(21, s.GetTrinhDo());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean AddDiaChi(DiaChi s)
	{
		String sql = "INSERT INTO DIA_CHI(Tinh, DiaChiChiTiet)"
				+ "VALUES(?, ?)";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.GetTinh());
			ps.setString(2, s.GetDCCT());
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
			ps.setInt(1, 1);
			ps.setInt(2, idcv);
			
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<DiaChi> GetListDiaChi()
	{
		ArrayList<DiaChi> l = new ArrayList<>();
		String sql = "SELECT * FROM DIA_CHI";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
				DiaChi a = new DiaChi();
				a.SetId(rs.getInt("Id"));
				a.SetTinh(rs.getString("Tinh"));
				a.SetDCCT(rs.getString("DiaChiChiTiet"));
				
				l.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
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
				v.SetIdDC(rs.getInt("IdDC"));
				v.SetSDT(rs.getInt("SDT"));
				v.SetQuyMoNhanSu(rs.getString("QuyMoNhanSu"));
				v.SetLinhVucHD(rs.getString("LinhVucHoatDong"));
				v.SetSoLuocCT(rs.getString("SoLuocCT"));
				v.SetTrangThai(rs.getBoolean("TrangThai"));
				v.SetTrinhDo(rs.getString("TrinhDo"));
				
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
				+ "CONG_VIEC.LuongCoBan, CONG_VIEC.NgayHetHan, CONG_VIEC.TenCongTy,CONG_VIEC.IdDC,CONG_VIEC.SDT, CONG_VIEC.QuyMoNhanSu, "
				+ "CONG_VIEC.LinhVucHoatDong, CONG_VIEC.SoLuocCT, CONG_VIEC.TrangThai, CONG_VIEC.TrinhDo "
				+ "FROM dbo.CONG_VIEC, dbo.CONG_VIEC_LUU, dbo.HO_SO "
				+ "WHERE dbo.CONG_VIEC.Id = dbo.CONG_VIEC_LUU.IdCongViec AND dbo.CONG_VIEC_LUU.IdUser = ?";
		try 
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
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
				v.SetIdDC(rs.getInt("IdDC"));
				v.SetSDT(rs.getInt("SDT"));
				v.SetQuyMoNhanSu(rs.getString("QuyMoNhanSu"));
				v.SetLinhVucHD(rs.getString("LinhVucHoatDong"));
				v.SetSoLuocCT(rs.getString("SoLuocCT"));
				v.SetTrangThai(rs.getBoolean("TrangThai"));
				v.SetTrinhDo(rs.getString("TrinhDo"));
				
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
			ps.setInt(1, 1);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		String sql = "SELECT COUNT(*) FROM dbo.TAI_KHOAN";
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
