package cmc.model;

import java.util.Vector;

public class Cart {
	public static Cart instance()
    {
        return new Cart();
    }
	private Vector<CartSach> vtSach;
	
	public Cart() {
        vtSach = new Vector<CartSach>();
    }

	public Vector<CartSach> getVtSach() {
		return vtSach;
	}

	public void setVtSach(Vector<CartSach> vtSach) {
		this.vtSach = vtSach;
	}
	
	public void changeNumber(int soluong,int ma) {
		for(CartSach itemInCart:vtSach)
        {
            if(itemInCart.getSh().getMa()==ma)
            {
                itemInCart.setSoluong(soluong); ;
                break;
            }
        } 
	}
	 public void deleteCartSach(int ma)
	    {
	       for(CartSach itemInCart:vtSach)
	        {
	            if(itemInCart.getSh().getMa()==ma)
	            {
	                vtSach.remove(itemInCart);
	                break;
	            }
	        } 
	    }
	    public void addSachtoCart(Sach item)
	    {
	        boolean isSachExistedInCart = false;
	        for(CartSach itemInCart:vtSach)
	        {
	            if(itemInCart.getSh().getMa()==item.getMa())
	            {
	                itemInCart.increaseSoLuong();
	                isSachExistedInCart = true;
	                break;
	            }
	        }
	        //neu san pham khong ton tai trong cart
	        if(!isSachExistedInCart)
	        {
	            CartSach cs = new CartSach();
	            cs.setSh(item);
	            cs.setSoluong(1);
	            //add vao vector
	            vtSach.add(cs);
	        }
	    }
}
