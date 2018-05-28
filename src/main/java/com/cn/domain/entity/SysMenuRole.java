package com.cn.domain.entity;

import com.cn.common.persistence.BaseEntity;

public class SysMenuRole extends BaseEntity {
    private String roleId;

    private String menuId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }
}