package ru.eremin.enterprise.view;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ViewScoped
@ManagedBean
@URLMapping(id = "adminHome", pattern = "/adminHome", viewId = "/WEB-INF/pages/admin/admin-home.xhtml")
public class MenuView implements Serializable {

    @Getter
    @Setter
    private String page;

    @PostConstruct
    public void init() {
        page = "empty-page";
    }
}