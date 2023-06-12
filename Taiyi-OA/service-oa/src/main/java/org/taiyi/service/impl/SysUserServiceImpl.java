package org.taiyi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.taiyi.mapper.SysUserMapper;
import org.taiyi.entity.SysUser;
import org.taiyi.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2023-06-13 11:27:38
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public void updateStatus(Long id, Integer status) {
        // 1. 根据 userId 查询用户 id 信息
        SysUser sysUser = baseMapper.selectById(id);
        // 2. 设置修改状态值
        // TODO 状态值 status 的 0|1 判断
        sysUser.setStatus(status);
        // 3. 调用方法进行修改
        baseMapper.updateById(sysUser);
    }
}

