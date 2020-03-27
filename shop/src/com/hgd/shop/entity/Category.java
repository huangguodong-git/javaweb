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
public class Category implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer cid;

    private String cname;

    private String cdesc;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cdesc='" + cdesc + '\'' +
                '}';
    }
}
