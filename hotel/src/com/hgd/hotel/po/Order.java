package com.hgd.hotel.po;

import java.util.Date;
import java.util.List;

public class Order {
	private Integer id;
	private String orderCode;//�������
	private Integer tableId;//��������һ������
	private Double totalPrice;//�����ܽ��
	private Integer orderStatus;//������״̬ 0��ʾδ����  1��ʾ�Ѹ���
	private Date orderDate;//�µ����ύ���ﳵ������
	private Date payDate;//�����ʱ��
	private Date updateDate;//�����µ�ʱ�䣬��Ʒ��Ϣ���ĵ�ʱ��
	private Integer disabled;
	
	
	private DinnerTable dinnerTable;
	private List<OrderDetail> orderDetails;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
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
	public DinnerTable getDinnerTable() {
		return dinnerTable;
	}
	public void setDinnerTable(DinnerTable dinnerTable) {
		this.dinnerTable = dinnerTable;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderCode=" + orderCode + ", tableId=" + tableId + ", totalPrice=" + totalPrice
				+ ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", payDate=" + payDate + ", updateDate="
				+ updateDate + ", disabled=" + disabled + ", dinnerTable=" + dinnerTable + ", orderDetails="
				+ orderDetails + "]";
	}
	
}
