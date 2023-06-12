package org.taiyi.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.taiyi.entity.SysRole;
import org.taiyi.result.Result;
import org.taiyi.service.SysRoleService;
import org.taiyi.vo.AssignRoleVo;
import org.taiyi.vo.SysRoleQueryVo;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {

    // 注入 service
    @Resource
    private SysRoleService roleService;

    // 1、查询所有角色 和当前用户所属角色
    @ApiOperation("获取角色")
    @GetMapping("toAssign/{userId}")
    public Result toAssign(@PathVariable Long userId){
        Map<String, Object> map = roleService.findRoleDataByUserId(userId);
        return Result.ok(map);
    }
    // 2、为用户分配角色
    @ApiOperation("为用户分配角色")
    @PostMapping("doAssign")
    public Result doAssign(@RequestBody AssignRoleVo assignRoleVo){
        roleService.doAssign(assignRoleVo);
        return Result.ok();
    }

    @ApiOperation("查询所有角色")
    @GetMapping("findAll")
    public Result findAll() {
        // 调用 service 的方法
        List<SysRole> list = roleService.list();
        return Result.ok(list);
    }

    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")       // page:当前页 limit:每页记录数 sysRoleQueryVo: 条件对象
    public Result pageQueryRole(@PathVariable Long page,
                                @PathVariable Long limit,
                                SysRoleQueryVo sysRoleQueryVo) {
        // 1、创建Page 对象，传递分页相关参数
        Page<SysRole> pageParam = new Page<>(page, limit);

        // 2、封装条件（判断条件是否为空）
        LambdaQueryWrapper<SysRole> wrapper = new LambdaQueryWrapper<>();
        String roleName = sysRoleQueryVo.getRoleName();
        if (!StringUtils.isEmpty(roleName)) {
            wrapper.like(SysRole::getRoleName, roleName);
        }

        // 3、调用service 层的方法
        Page<SysRole> pageRes = roleService.page(pageParam, wrapper);

        return Result.ok(pageRes);
    }

    @ApiOperation("添加角色")
    @PostMapping("save")
    public Result save(@RequestBody SysRole role) {
        boolean isSuccess = roleService.save(role);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("根据id查询用户")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SysRole role = roleService.getById(id);
        return Result.ok(role);
    }

    @ApiOperation("修改角色")
    @PostMapping("update")
    public Result update(@RequestBody SysRole role) {
        return roleService.updateById(role) ? Result.ok() : Result.fail();
    }

    @ApiOperation("根据id删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        return roleService.removeById(id) ? Result.ok() : Result.fail();
    }

    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        return roleService.removeBatchByIds(idList) ? Result.ok() : Result.fail();
    }
}
