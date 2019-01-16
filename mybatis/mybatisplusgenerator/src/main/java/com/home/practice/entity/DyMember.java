package com.home.practice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author HPC
 * @since 2019-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DyMember对象", description="用户表")
public class DyMember implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "头像")
    private String picture;

    @ApiModelProperty(value = "微信")
    private String wechat;

    @ApiModelProperty(value = "简介")
    private String summary;

    @ApiModelProperty(value = "邀请人ID")
    private Long inviteUser;

    @ApiModelProperty(value = "状态。0-正常；1-冻结；2-删除")
    private String status;

    @ApiModelProperty(value = "是否作者 0-否 1-是")
    private Integer isAuthor;

    @ApiModelProperty(value = "创建时间")
    private Date ctime;

    @ApiModelProperty(value = "最后更新时间")
    private Date mtime;

    @ApiModelProperty(value = "YOYOW账号")
    private String yoyow;

    @ApiModelProperty(value = "个推app客户端编号")
    private String appClientId;

    @ApiModelProperty(value = "终端类型。0-pc;1-ios;2-android;")
    private String platformType;


}
