package org.taiyi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.taiyi.entity.SysUser;

/**
 * 用户表(SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-13 11:29:01
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}

