package org.taiyi.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;


/**
 * 角色(SysRole)实体类
 *
 * @author makejava
 * @since 2023-06-07 10:44:48
 */
@Data
public class SysRole implements Serializable {
    /**
     * 角色id
     */
    private Long id;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色编码
     */
    private String roleCode;
    /**
     * 描述
     */
    private String description;
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

