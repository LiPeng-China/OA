package org.taiyi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.taiyi.entity.SysUser;

/**
 * 用户表(SysUser)表服务接口
 *
 * @author makejava
 * @since 2023-06-13 11:27:38
 */
public interface SysUserService extends IService<SysUser> {

    void updateStatus(Long id, Integer status);
}

