package com.example.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;

import java.util.List;

/**
 * <p>
 * 子菜单实体类
 * </p>
 *
 * @author zmc
 * @since 2023-08-07
 */
//TODO 这个注解的作用？

public class MenuDTO{
    //TODO

    //菜单ID
    private Long id;

    //菜单名称
    private String menuName;
    //父级菜单Id
    private Long parentId;

    //子菜单列表
    @Getter
    private List<MenuDTO> childrenList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<MenuDTO> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<MenuDTO> childrenList) {
        this.childrenList = childrenList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MenuDTO{");
        sb.append("id=").append(id);
        sb.append(", menuName='").append(menuName).append('\'');
        sb.append(", parentId=").append(parentId);
        sb.append(", childrenList=").append(childrenList);
        sb.append('}');
        return sb.toString();
    }
}
