package org.taiyi.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;


/**
 * 菜单表(SysMenu)实体类
 *
 * @author makejava
 * @since 2023-06-13 21:41:10
 */
@Data
public class SysMenu implements Serializable {
        /**
     * 编号
     */
    private Long id;
    /**
     * 所属上级
     */
    private Long parentId;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型(0:目录,1:菜单,2:按钮)
     */
    private Integer type;
    /**
     * 路由地址
     */
    private String path;
    /**
     * 组件路径
     */
    private String component;
    /**
     * 权限标识
     */
    private String perms;
    /**
     * 图标
     */
    private String icon;
    /**
     * 排序
     */
    private Integer sortValue;
    /**
     * 状态(0:禁止,1:正常)
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标记（0:不可用 1:可用）
     */
    @TableLogic
    private Integer isDeleted;
}


