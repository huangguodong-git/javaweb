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
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer uid;

    private String username;

    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
