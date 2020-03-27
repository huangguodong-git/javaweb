package com.hgd.struts;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

/**
 * @auther 黄国栋
 * @data 2020-03-27 20:29
 * @since
 */
public class DemoAction extends ActionSupport {

    public String save(){
        Object o=ServletActionContext.getRequest().getSession().getAttribute("黄国栋");
        if (o==null){
            return LOGIN;
        }
        System.out.println("save...");
        return SUCCESS;
    }

    public String list(){
        Object o=ServletActionContext.getRequest().getSession().getAttribute("黄国栋");
        if (o==null){
            return LOGIN;
        }
        System.out.println("list...");
        return SUCCESS;
    }

}
