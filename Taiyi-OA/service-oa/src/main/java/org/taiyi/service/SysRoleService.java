package org.taiyi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.taiyi.entity.SysRole;
import org.taiyi.vo.AssignRoleVo;

import java.util.Map;
import java.util.Objects;

/**
 * 角色(SysRole)表服务接口
 *
 * @author makejava
 * @since 2023-06-07 15:30:04
 */
public interface SysRoleService extends IService<SysRole> {
    // 1、查询所有角色 和当前用户所属角色
    Map<String, Object> findRoleDataByUserId(Long userId);

    // 2、为用户分配角色
    void doAssign(AssignRoleVo assignRoleVo);

}

