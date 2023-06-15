package org.taiyi.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taiyi.service.SysMenuService;

import javax.annotation.Resource;

/**
 * 菜单表(SysMenu)表控制层
 *
 * @author makejava
 * @since 2023-06-13 21:41:31
 */
@RestController
@RequestMapping("sysMenu")
public class SysMenuController {
    /**
     * 服务对象
     */
    @Resource
    private SysMenuService sysMenuService;

}

