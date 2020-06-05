package com.example.entity;

import java.util.Date;
import lombok.*;
import java.io.Serializable;


/**
 * (Role)实体类
 *
 * @author wangmingyi
 * @since 2020-06-05 10:42:16
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role implements Serializable {
    private static final long serialVersionUID = -25773980341592332L;
    /**
    * 角色id
    */
    private Integer id;
    /**
    * 角色名称
    */
    private String roleName;
    /**
    * 是否有效 1是 0否
    */
    private Integer valid;
    /**
    * 创建日期
    */
    private Date createtime;
    /**
    * 更新日期
    */
    private Date updatetime;


}