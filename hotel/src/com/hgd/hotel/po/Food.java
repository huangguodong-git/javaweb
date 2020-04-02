package com.hgd.hotel.po;

import java.util.Date;

public class Food {

	private int id;// INT PRIMARY KEY AUTO_INCREMENT, -- ����
	private String foodName;// VARCHAR(20), -- ������
	private int foodTypeId;// INT, -- ������ϵ, ����ֶ�
	private double price;// DOUBLE, -- �۸�
	private double discount;//�ۿ�
	private String remark;// VARCHAR(200), -- ���
	private String img;// VARCHAR(100) -- ͼƬ
	private Integer buyNum;//����������ֻ����¼���� �����浽���ݿ�
	
	private Date createDate;
	private Date updateDate;
	private Integer disabled;
	
	private FoodType foodType;
	public Food() {
	}
	public Food(String foodName, int foodTypeId, double price, double discount, String remark, String img,
			Integer disabled) {
		super();
		this.foodName = foodName;
		this.foodTypeId = foodTypeId;
		this.price = price;
		this.discount = discount;
		this.remark = remark;
		this.img = img;
		this.disabled = disabled;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	public int getFoodTypeId() {
		return foodTypeId;
	}
	public void setFoodTypeId(int foodTypeId) {
		this.foodTypeId = foodTypeId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getDisabled() {
		return disabled;
	}
	public void setDisabled(Integer disabled) {
		this.disabled = disabled;
	}
	public Integer getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}
	
	public FoodType getFoodType() {
		return foodType;
	}
	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", foodName=" + foodName + ", foodTypeId=" + foodTypeId + ", price=" + price
				+ ", discount=" + discount + ", remark=" + remark + ", img=" + img + ", buyNum=" + buyNum
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", disabled=" + disabled + ", foodType="
				+ foodType + "]";
	}
	
}
