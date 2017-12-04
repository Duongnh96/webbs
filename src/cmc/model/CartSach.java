package cmc.model;

public class CartSach {
	private Sach sh;
	private int soluong;
	
	public void increaseSoLuong(){
		soluong++;
	}
	
	public Sach getSh() {
		return sh;
	}
	public void setSh(Sach sh) {
		this.sh = sh;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
	

}
