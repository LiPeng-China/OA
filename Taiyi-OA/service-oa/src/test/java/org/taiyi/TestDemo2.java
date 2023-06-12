package org.taiyi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.taiyi.entity.SysRole;
import org.taiyi.service.SysRoleService;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestDemo2 {

    @Resource
    private SysRoleService roleService;

    @Test
    public void select() {
        List<SysRole> list = roleService.list();
        System.out.println(list);
    }
}
