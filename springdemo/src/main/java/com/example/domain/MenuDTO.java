package com.example.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuDTO extends Menu{
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
