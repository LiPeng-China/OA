package org.taiyi.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.taiyi.entity.SysUser;
import org.taiyi.result.Result;
import org.taiyi.service.SysUserService;
import org.taiyi.vo.SysUserQueryVo;

import javax.annotation.Resource;

/**
 * 用户表(SysUser)表控制层
 *
 * @author makejava
 * @since 2023-06-13 11:27:38
 */
@Api(tags = "用户管理接口")
@RestController
@RequestMapping("/admin/system/sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @ApiOperation("更新状态")
    @GetMapping("updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable Long id, @PathVariable Integer status){
        sysUserService.updateStatus(id, status);
        return Result.ok();
    }

    @ApiOperation("用户条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result index(@PathVariable Long page,
                        @PathVariable Long limit,
                        SysUserQueryVo sysUserQueryVo){

        // 1、封装条件
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        String keyword = sysUserQueryVo.getKeyword();
        String createTimeBegin = sysUserQueryVo.getCreateTimeBegin();
        String createTimeEnd = sysUserQueryVo.getCreateTimeEnd();
        if (StringUtils.hasLength(keyword)){
            wrapper.like(SysUser::getUsername, keyword);
        }
        if (StringUtils.hasLength(createTimeBegin)){
            wrapper.ge(SysUser::getCreateTime, createTimeBegin);
        }
        if (StringUtils.hasLength(createTimeEnd)){
            wrapper.le(SysUser::getCreateTime, createTimeEnd);
        }
        // 2、调用service 层方法
        IPage<SysUser> userPage = sysUserService.page(new Page<>(page, limit), wrapper);

        // 3、返回结果
        return Result.ok(userPage);
    }


    @ApiOperation("添加用户")
    @PostMapping("save")
    public Result save(@RequestBody SysUser sysUser) {
        return sysUserService.save(sysUser)? Result.ok(): Result.fail();
    }

    @ApiOperation("根据id查询用户")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SysUser sysUser = sysUserService.getById(id);
        return Result.ok(sysUser);
    }

    @ApiOperation("修改用户")
    @PostMapping("update")
    public Result update(@RequestBody SysUser sysUser) {
        return sysUserService.updateById(sysUser) ? Result.ok() : Result.fail();
    }

    @ApiOperation("根据id删除用户")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        return sysUserService.removeById(id) ? Result.ok() : Result.fail();
    }
}

