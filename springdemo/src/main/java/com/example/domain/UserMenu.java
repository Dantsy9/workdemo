package com.example.domain;

import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户和菜单关联表
 * </p>
 *
 * @author WH
 * @since 2023-08-03
 */
public class UserMenu{

    private static final long serialVersionUID = 1L;

    /**
     * 用户权限ID
     */
    private Long userId;

    /**
     * 菜单ID
     */
    private Long menuId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
    // StringBuild

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserMenu{");
        sb.append("userId=").append(userId);
        sb.append(", menuId=").append(menuId);
        sb.append('}');
        return sb.toString();
    }
}
