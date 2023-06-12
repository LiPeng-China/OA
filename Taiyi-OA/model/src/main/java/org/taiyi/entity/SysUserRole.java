package org.taiyi.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;


/**
 * 用户角色(SysUserRole)实体类
 *
 * @author makejava
 * @since 2023-06-13 16:17:31
 */
@Data
public class SysUserRole implements Serializable {
        /**
     * 主键id
     */
    private Long id;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 用户id
     */
    private Long userId;
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


