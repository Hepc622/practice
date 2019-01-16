package com.home.mybatisplus;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author hpc
 * @Description: TODO
 * @date 2019/1/723:04
 */
@Data
@TableName("dy_member")
public class Member {
    private Long id;
    private String nickname;
    private String mobile;
    private String picture;
    private String wechat;
    private String summary;
    private Long inviteUser;
    private String status;
    private Integer isAuthor;
    private Date ctime;
    private Date mtime;
    private String yoyow;
    private String appClientId;
    private String platformType;
}
