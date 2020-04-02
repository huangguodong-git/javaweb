package com.hgd.hotel.po;


public class OrderDetail {
	private Integer id;
	private Integer orderId;
	private Integer foodId;
	private Integer buyNum;
	private Double discount;//��ʱ�ͻ����ۿ�
	private Integer disabled;//��Ʒ�Ƿ����µ�����ɾ�� 1ɾ�� 0δɾ��
	
	private Food food;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getFoodId() {
		return foodId;
	}
	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	public Integer getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}
	
	public Food getFoods() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Integer getDisabled() {
		return disabled;
	}
	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}
	public Food getFood() {
		return food;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", orderId=" + orderId + ", foodId=" + foodId + ", buyNum=" + buyNum
				+ ", discount=" + discount + ", disabled=" + disabled + ", food=" + food + "]";
	}
	
}
