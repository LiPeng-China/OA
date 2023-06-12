package org.taiyi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.taiyi.entity.SysRole;

/**
 * 角色(SysRole)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-07 14:29:32
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

}

