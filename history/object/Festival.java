package history.object;


public class Festival {
	private String lanDauToChuc;
	private String nhanVatLienQuan;
	private String viTri;
	private String ngayBatDau;
	private String tenLeHoi;
	public String getLanDauToChuc() {
		return lanDauToChuc;
	}
	public void setLanDauToChuc(String lanDauToChuc) {
		this.lanDauToChuc = lanDauToChuc;
	}
	public String getNhanVatLienQuan() {
		return nhanVatLienQuan;
	}
	public void setNhanVatLienQuan(String nhanVatLienQuan) {
		this.nhanVatLienQuan = nhanVatLienQuan;
	}
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	public String getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public String getTenLeHoi() {
		return tenLeHoi;
	}
	public void setTenLeHoi(String tenLeHoi) {
		this.tenLeHoi = tenLeHoi;
	}
	@Override
	public String toString() {
		return "Lần đầu tổ chức: " + lanDauToChuc + "\nNhân vật liên quan: " + nhanVatLienQuan + "\nVị trí: " + viTri
				+ "\nNgày bắt đầu: " + ngayBatDau + "\nTên lễ hội: " + tenLeHoi;
	}
	public Festival() {
		super();
	}
}

