package com.hgd.shop.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 黄国栋
 * @since 2020-03-27
 */
public class Product implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer pid;

    private String pname;

    private String author;

    private Double price;

    private String description;

    private String filename;

    private String path;

    private Integer cid;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", filename='" + filename + '\'' +
                ", path='" + path + '\'' +
                ", cid=" + cid +
                '}';
    }
}
