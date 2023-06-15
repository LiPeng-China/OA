package org.taiyi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.taiyi.mapper.SysMenuMapper;
import org.taiyi.entity.SysMenu;
import org.taiyi.service.SysMenuService;
import org.springframework.stereotype.Service;

/**
 * 菜单表(SysMenu)表服务实现类
 *
 * @author makejava
 * @since 2023-06-13 21:41:31
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

}

