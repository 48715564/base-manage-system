package com.cn.service;
import com.cn.common.utils.Provider;
import com.cn.domain.entity.SysUserRole;
import com.cn.domain.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.domain.entity.SysRole;
import com.cn.domain.entity.SysRoleExample;
import com.cn.domain.mapper.SysRoleMapper;
import com.cn.common.service.CrudService;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class SysRoleService extends CrudService<SysRoleMapper,SysRole,SysRoleExample,java.lang.String> {
    public static final String key = "roles";
    @Autowired
    private CacheService cacheService;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private Provider provider;

    public List<SysRole> getRoleByUserId(String userId) {
        if(provider.isAdmin(userId)){
            return dao.selectByExample(new SysRoleExample());
        }else {
            List<SysRole> list = (List<SysRole>) cacheService.getListHashMapByKey(key, userId, SysRole.class);
            if (list == null || list.size() == 0) {
                list = dao.selectRolesByUserID(userId);
                cacheService.saveHashMapCache(key, userId, list);
            } else {
                return list;
            }
            return list;
        }
    }

    @Transactional
    public void insertUserRole(String userId, String... roleId) {
        for (String id : roleId) {
            SysUserRole userRole = new SysUserRole();
            userRole.setRoleId(id);
            userRole.setUserId(userId);
            userRole.preInsert();
            sysUserRoleMapper.insert(userRole);
        }
        cacheService.removeHashMapCache(key,userId);
    }
}
