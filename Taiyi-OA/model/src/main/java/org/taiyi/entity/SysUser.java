package org.taiyi.entity;

import java.util.Date;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;


/**
 * 用户表(SysUser)实体类
 *
 * @author makejava
 * @since 2023-06-13 11:04:36
 */
@Data
public class SysUser implements Serializable {
        /**
     * 会员id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机
     */
    private String phone;
    /**
     * 头像地址
     */
    private String headUrl;
    /**
     * 部门id
     */
    private Long deptId;
    /**
     * 岗位id
     */
    private Long postId;
    /**
     * 微信openId
     */
    private String openId;
    /**
     * 描述
     */
    private String description;
    /**
     * 状态（1：正常 0：停用）
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


