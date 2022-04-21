package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
	private List<Product>items;
	public Cart() {
		items=new ArrayList<>();
	}
	public void add(Product ci) {
		for(Product x:items) {
			if(ci.getId()==x.getId()) {
				x.setNumber(x.getNumber()+1);
				return;
			}
		}
			items.add(ci);
				
	}

	public void remove(int id) {
		Iterator<Product> itrt = items.iterator();
	       while(itrt.hasNext()){
	           Product x = itrt.next();
	           if(x.getId()==id) {
					itrt.remove();
				}
	       }
		for(Product x:items) {
			if(x.getId()==id) {
				items.remove(x);
			}
		}
	}
	public double getAmount() {
		double s=0;
		for(Product x:items) {
			s+=x.getPrice()*x.getNumber();
		}
		return s;
	}
	public List<Product>getItems(){
		return items;
	}
	public int size() {
		int i=0;
		for(Product x:items) {
			i++;
		}
		return i;
	}
	
}
