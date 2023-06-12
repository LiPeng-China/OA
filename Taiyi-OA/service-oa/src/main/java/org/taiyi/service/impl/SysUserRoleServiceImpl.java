package org.taiyi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.taiyi.mapper.SysUserRoleMapper;
import org.taiyi.entity.SysUserRole;
import org.taiyi.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户角色(SysUserRole)表服务实现类
 *
 * @author makejava
 * @since 2023-06-13 16:19:06
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

}

