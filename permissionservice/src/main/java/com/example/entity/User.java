package com.example.entity;

import java.util.Date;
import lombok.*;
import java.io.Serializable;


/**
 * (User)实体类
 *
 * @author wangmingyi
 * @since 2020-06-05 10:45:49
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = -33032336693039360L;
    /**
    * 会员id
    */
    private Integer id;
    /**
    * 会员名
    */
    private String userName;
    /**
    * 密码
    */
    private String password;
    /**
    * 电子邮箱
    */
    private String email;
    /**
    * 性别 1男0女
    */
    private Integer sex;
    /**
    * 手机号
    */
    private String mobile;
    /**
    * 出生日
    */
    private Date birthday;
    /**
    * 注册日期
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;


}