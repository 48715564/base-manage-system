package com.cn.domain.mapper;

import com.cn.domain.entity.SysRole;
import com.cn.domain.entity.SysRoleExample;
import com.cn.common.persistence.CrudMapper;

import java.util.List;

/**
 * @author daocloud
 * @version 0.0.1
 * @date 2018/05/28
 * @time 13:50
 * @function 功能:
 * @describe 版本描述:
 * @modifyLog 修改日志:
 *
 * @mbg.generated do_not_delete_during_merge
 */
public interface SysRoleMapper extends CrudMapper<SysRoleExample,SysRole,java.lang.String> {
    public List<SysRole> selectRolesByUserID(String userId);
}
