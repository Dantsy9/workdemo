package com.example.domain;

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

public class MenuDTO extends Menu{

    private Long id;

    private String menuName;

    private Long parentId;


    @Getter
    private List<MenuDTO> childrenList;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getMenuName() {
        return menuName;
    }

    @Override
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public Long getParentId() {
        return parentId;
    }

    @Override
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
