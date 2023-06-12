package org.taiyi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.taiyi.entity.SysRole;
import org.taiyi.mapper.SysRoleMapper;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestMPDemo1 {

    @Resource
    private SysRoleMapper sysRoleMapper;

    // 查询所有记录
    @Test
    public void getAll(){
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        System.out.println(sysRoles);
    }

    // 添加一个记录
    @Test
    public void add(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("角色管理员");
        sysRole.setRoleCode("role");
        sysRole.setDescription("角色管理员");

        int insert = sysRoleMapper.insert(sysRole);
        System.out.println(insert);
        getAll();
    }

    // 修改操作
    @Test
    public void update(){
        // 1、根据id 查询
        SysRole sysRole = sysRoleMapper.selectById(1666338674564165633L);

        // 2、设置修改的值
        sysRole.setRoleName("太一·角色管理员");

        // 3、调用方法实现最终的修改
        int i = sysRoleMapper.updateById(sysRole);

        System.out.println(i);
    }

    // 删除操作
    @Test
    public void deleteId(){
        int i = sysRoleMapper.deleteById(1666338674564165633L);
    }
}