package com.datasource.bean;


import java.io.Serializable;
import java.util.Date;

public class MsXxjsdy implements Serializable {
    private Integer id;

    private Integer xxlxid;

    private Integer sfck;

    private String mbb;

    private String ckjkm;

    private Integer sffb;

    private Integer fbpl;

    private Date cjsj;

    private Date xgsj;
    

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getXxlxid() {
        return xxlxid;
    }

    public void setXxlxid(Integer xxlxid) {
        this.xxlxid = xxlxid;
    }

    public Integer getSfck() {
        return sfck;
    }

    public void setSfck(Integer sfck) {
        this.sfck = sfck;
    }

    public String getMbb() {
        return mbb;
    }

    public void setMbb(String mbb) {
        this.mbb = mbb == null ? null : mbb.trim();
    }

    public String getCkjkm() {
        return ckjkm;
    }

    public void setCkjkm(String ckjkm) {
        this.ckjkm = ckjkm == null ? null : ckjkm.trim();
    }

    public Integer getSffb() {
        return sffb;
    }

    public void setSffb(Integer sffb) {
        this.sffb = sffb;
    }

    public Integer getFbpl() {
        return fbpl;
    }

    public void setFbpl(Integer fbpl) {
        this.fbpl = fbpl;
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }
    
    
}