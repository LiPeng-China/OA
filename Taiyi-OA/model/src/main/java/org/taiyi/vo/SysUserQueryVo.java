package org.taiyi.vo;

import lombok.Data;

@Data
public class SysUserQueryVo {

    private static final long serialVersionUID = 1L;

    private String keyword;

    private String createTimeBegin;
    private String createTimeEnd;

    private Long roleId;
    private Long postId;
    private Long deptId;
}
