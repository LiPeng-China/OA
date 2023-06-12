package org.taiyi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.taiyi.entity.SysUserRole;

/**
 * 用户角色(SysUserRole)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-13 16:19:06
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

}

