package com.cn.service;

import com.cn.common.utils.Provider;
import com.cn.domain.entity.*;
import com.cn.domain.mapper.SysMenuRoleMapper;
import com.cn.page.AjaxResponse;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import com.cn.domain.mapper.SysMenuMapper;
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
 * @mbg.generated do_not_delete_during_merge
 */
@Service
public class SysMenuService extends CrudService<SysMenuMapper, SysMenu, SysMenuExample, java.lang.String> {
    public static final String key = "menus";
    @Autowired
    Provider provider;
    @Autowired
    private CacheService cacheService;
    @Autowired
    private SysMenuRoleMapper sysMenuRoleMapper;
    @Autowired
    private SysRoleService sysRoleService;

    public List<SysMenu> getMenuByUserID(String userId) {
        if(provider.isAdmin(userId)){
             return dao.selectByExample(new SysMenuExample());
        }else {
            List<SysMenu> list = (List<SysMenu>) cacheService.getListHashMapByKey(key, userId, List.class);
            if (list == null || list.size() == 0) {
                dao.selectMenusByUserID(userId);
            }
            return list;
        }
    }

    @Transactional
    public void insertRoleMenu(String roleId, String... meunId) {
        for (String id : meunId) {
            SysMenuRole sysMenuRole = new SysMenuRole();
            sysMenuRole.setMenuId(id);
            sysMenuRole.setRoleId(roleId);
            sysMenuRole.preInsert();
            sysMenuRoleMapper.insert(sysMenuRole);
        }
    }
}
