package com.practice.management.bean.entity;

import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private Long id;
    private String type;
    private int query;
    private int save;
    private int del;
    private int upd;
    private String en;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuery() {
        return query;
    }

    public void setQuery(int query) {
        this.query = query;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    public int getUpd() {
        return upd;
    }

    public void setUpd(int upd) {
        this.upd = upd;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }


    public List<String> getAuthorities() {
        List<String> list = new ArrayList<>();
        if (query == 1) list.add(RequestMethod.GET.name());
        if (save == 1) list.add(RequestMethod.POST.name());
        if (del == 1) list.add(RequestMethod.DELETE.name());
        if (upd == 1) list.add(RequestMethod.PUT.name());

        return list;
    }

}
