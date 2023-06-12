package org.taiyi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.taiyi.entity.SysRole;
import org.taiyi.entity.SysUserRole;
import org.taiyi.mapper.SysRoleMapper;
import org.taiyi.service.SysRoleService;
import org.taiyi.service.SysUserRoleService;
import org.taiyi.vo.AssignRoleVo;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 角色(SysRole)表服务实现类
 *
 * @author makejava
 * @since 2023-06-07 15:30:06
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Resource
    private SysUserRoleService sysUserRoleService;

    @Override
    public Map<String, Object> findRoleDataByUserId(Long userId) {
        // 1. 查询所有角色，返回一个 List 集合
        List<SysRole> allRoleList = baseMapper.selectList(null);
        // 2. 根据 userId 查询 SysUserRole 用户角色关系表，查询到 userId 对应的所有roleIds
        LambdaQueryWrapper<SysUserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUserRole::getUserId, userId);
        List<SysUserRole> existUserRoleList = sysUserRoleService.list(wrapper);
        List<Long> existUserRoleIdList = existUserRoleList.stream().map(SysUserRole::getRoleId)
                .collect(Collectors.toList());
        // 3. 根据 roleIds 找到对应的 角色信息
        List<SysRole> assignRoleList = new ArrayList<>();
        for (SysRole sysRole : allRoleList) {
            if (existUserRoleIdList.contains(sysRole.getId())) {
                assignRoleList.add(sysRole);
            }
        }
        // 4. 把得到的两部分数据封装 map 集合，返回
        Map<String, Object> roleMap = new HashMap<>();
        roleMap.put("assignRoleList", assignRoleList);
        roleMap.put("allRoleList", allRoleList);
        return roleMap;
    }

    @Override
    public void doAssign(AssignRoleVo assignRoleVo) {
        // 1. 根据 userId 删除用户角色关系表里的数据
        LambdaQueryWrapper<SysUserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUserRole::getUserId, assignRoleVo.getUserId());
        sysUserRoleService.remove(wrapper);
        // 2. 重新进行分配
        List<Long> roleIdList = assignRoleVo.getRoleIdList();
        for (Long roleId : roleIdList) {
            if (StringUtils.isEmpty(roleId)) {
                continue;
            }
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(assignRoleVo.getUserId());
            sysUserRole.setRoleId(roleId);
            sysUserRoleService.save(sysUserRole);
        }

    }
}

