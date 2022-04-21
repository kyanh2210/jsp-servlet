package model;

public class ProductOrders {
	private int orderId;
	private int ProductId;
	private int amountProduct;
	private String nameProduct;
	public ProductOrders(int orderId,int ProductId,int amountProduct,String nameProduct) {
		this.setOrderId(orderId);
		this.setProductId(ProductId);
		this.setAmountProduct(amountProduct);
		this.setNameProduct(nameProduct);
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public int getAmountProduct() {
		return amountProduct;
	}
	public void setAmountProduct(int amountProduct) {
		this.amountProduct = amountProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
}

