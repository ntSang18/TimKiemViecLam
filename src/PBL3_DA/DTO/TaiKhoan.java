package PBL3_DA.DTO;

public class TaiKhoan {
	private int Id;
	private String Email;
	private String Pass;
	private String UserName;
	private int SDT;
	private int Type;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getSDT() {
		return SDT;
	}
	public void setSDT(int sDT) {
		SDT = sDT;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}

}
