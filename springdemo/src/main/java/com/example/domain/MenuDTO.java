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
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuDTO{
    //TODO

    //菜单ID
    private Long id;

    //菜单名称
    private String menuName;
    //父级菜单Id
    private Long parentId;

    //子菜单列表
    private List<MenuDTO> childrenList;

    public void setId(Long id) {
        this.id = id;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

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
