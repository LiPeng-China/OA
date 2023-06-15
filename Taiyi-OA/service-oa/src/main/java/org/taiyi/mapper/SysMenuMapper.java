package org.taiyi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.taiyi.entity.SysMenu;

/**
 * 菜单表(SysMenu)表数据库访问层
 *
 * @author makejava
 * @since 2023-06-13 21:41:31
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

}

