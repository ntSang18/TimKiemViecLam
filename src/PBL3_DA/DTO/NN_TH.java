package PBL3_DA.DTO;

public class NN_TH {
	private int id;
	private String loaiNgonNgu;
	private String trinhDo;
	private String bangCap;
	private boolean word;
	private boolean excel;
	private boolean powerPoint;
	private boolean outLook;
	private String phanMemKhac;
	private int IdHoSo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoaiNgonNgu() {
		return loaiNgonNgu;
	}

	public void setLoaiNgonNgu(String loaiNgonNgu) {
		this.loaiNgonNgu = loaiNgonNgu;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public String getBangCap() {
		return bangCap;
	}

	public void setBangCap(String bangCap) {
		this.bangCap = bangCap;
	}

	public boolean isWord() {
		return word;
	}

	public void setWord(boolean word) {
		this.word = word;
	}

	public boolean isExcel() {
		return excel;
	}

	public void setExcel(boolean excel) {
		this.excel = excel;
	}

	public boolean isPowerPoint() {
		return powerPoint;
	}

	public void setPowerPoint(boolean powerPoint) {
		this.powerPoint = powerPoint;
	}

	public boolean isOutLook() {
		return outLook;
	}

	public void setOutLook(boolean outLook) {
		this.outLook = outLook;
	}

	public String getPhanMemKhac() {
		return phanMemKhac;
	}

	public void setPhanMemKhac(String phanMemKhac) {
		this.phanMemKhac = phanMemKhac;
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
