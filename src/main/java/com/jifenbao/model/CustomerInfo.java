/**
 * Copyright 2008 - 2016 Powered by OpenTide <br/>
 * This class was automatically generated with otc framework generator
 *
 */
package com.jifenbao.model;

import java.util.Date;

import com.otc.framework.enums.Setting.DateTimeFormatPattern;
import com.otc.framework.model.BaseEntity;
import com.otc.framework.utils.DateTimeUtil;

/**
 *
 * @ClassName      CustomerInfo
 * @Description
 * CustomerInfo
 *
 * @author      liujing
 * @Date        2016-01-10 22:46:25
 * @version     1.0 
 *
 */
public class CustomerInfo extends BaseEntity<Long> {
    
    
    private static final long serialVersionUID = 1L;
    
    //columns START
    /**
     * 主键       db_column: id 
     */
    private Long id;
    /** id Exclude */
    private Long idEx;
    /**
     * 会员名       db_column: name 
     */
    private String name;
    
    /**
     * 状态       db_column: status 
     */
    private String status;
    
    /**
     * 支付密码     db_column: payPassword 
     */
    private String payPassword;
    
    
    /**
     * 微信openid
     */
    private String openid;
    /**
     * 性别       db_column: sex 
     */
    private Integer sex;
    /**
     * 生日       db_column: birthday 
     */
    private Date birthday;
    /**
     * 真实姓名       db_column: realName 
     */
    private String realName;
    /**
     * 头像       db_column: picture 
     */
    private String picture;
    /**
     * 电子邮件       db_column: email 
     */
    private String email;
    /**
     * 手机       db_column: mobile 
     */
    private String mobile;
    /**
     * 电话       db_column: phone 
     */
    private String phone;
    /**
     * QQ       db_column: qq 
     */
    private String qq;
    /**
     * 微信号       db_column: wechat 
     */
    private String wechat;
    /**
     * 职称       db_column: title 
     */
    private String title;
    /**
     * 最后登录时间       db_column: lastLoginTime 
     */
    private Date lastLoginTime;
    /**
     * 最后登录IP       db_column: lastLoginIp 
     */
    private String lastLoginIp;
    /**
     * 登录次数       db_column: loginCount 
     */
    private Integer loginCount;
    /**
     * 删除标识       db_column: deleteYn 
     */
    private String deleteYn;
    /**
     * 是否启用       db_column: disabledYn 
     */
    private String disabledYn;
    /**
     * 创建用户       db_column: createUser 
     */
    private String createUser;
    /**
     * 创建时间       db_column: createTime 
     */
    private Date createTime;
    /**
     * 修改用户       db_column: updateUser 
     */
    private String updateUser;
    /**
     * 修改时间       db_column: updateTime 
     */
    private Date updateTime;
    /**
     * 积分       db_column: credit1 
     */
    private Integer credit1;
    /**
     * 积分2       db_column: credit2 
     */
    private Double credit2;
    
    /**
     * 会员来源，默认是积分宝用户1，卡册兑换为2，电影注册用户为3       db_column: source 
     */
    private String source;
    
    /**
     * 分销等级id
     */
    private Integer agentLevel;
    
    /**
     * 上线id
     */
    private Long agentId;
    
    /**
     * 是否是分销商
     */
    private String agentYn;
    
    /**
     * 分享链接点击次数
     */
    private Integer clickCount;
    //columns END


    public CustomerInfo() {
    }

    public CustomerInfo(
        Long id
    ) {
        this.id = id;
    }

    

    public CustomerInfo(
        Long id,
        String name,
        String payPassword,
        Integer sex,
        Date birthday,
        String realName,
        String picture,
        String email,
        String mobile,
        String phone,
        String qq,
        String wechat,
        String title,
        Date lastLoginTime,
        String lastLoginIp,
        Integer loginCount,
        String deleteYn,
        String disabledYn,
        String createUser,
        Date createTime,
        String updateUser,
        Date updateTime,
        Integer credit1,
        Double credit2
    ) {
        this.id = id;
        this.name = name;
        this.payPassword = payPassword;
        this.sex = sex;
        this.birthday = birthday;
        this.realName = realName;
        this.picture = picture;
        this.email = email;
        this.mobile = mobile;
        this.phone = phone;
        this.qq = qq;
        this.wechat = wechat;
        this.title = title;
        this.lastLoginTime = lastLoginTime;
        this.lastLoginIp = lastLoginIp;
        this.loginCount = loginCount;
        this.deleteYn = deleteYn;
        this.disabledYn = disabledYn;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.credit1 = credit1;
        this.credit2 = credit2;
    }


    public void setId(Long value) {
        this.id = value;
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setIdEx(Long value) {
        this.idEx = value;
    }
    
    public Long getIdEx() {
        return this.idEx;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String value) {
        this.name = value;
    }
    
    public Integer getSex() {
        return this.sex;
    }
    
    public void setSex(Integer value) {
        this.sex = value;
    }
    
    public String getBirthdayString() {
        return DateTimeUtil.format(getBirthday(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }
    public void setBirthdayString(String value) {
        setBirthday(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }
    
    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date value) {
        this.birthday = value;
    }
    
    public String getRealName() {
        return this.realName;
    }
    
    public void setRealName(String value) {
        this.realName = value;
    }
    
    public String getPicture() {
        return this.picture;
    }
    
    public void setPicture(String value) {
        this.picture = value;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String value) {
        this.email = value;
    }
    
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String value) {
        this.mobile = value;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String value) {
        this.phone = value;
    }
    
    public String getQq() {
        return this.qq;
    }
    
    public void setQq(String value) {
        this.qq = value;
    }
    
    public String getWechat() {
        return this.wechat;
    }
    
    public void setWechat(String value) {
        this.wechat = value;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String value) {
        this.title = value;
    }
    
    public String getLastLoginTimeString() {
        return DateTimeUtil.format(getLastLoginTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }
    public void setLastLoginTimeString(String value) {
        setLastLoginTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }
    
    public Date getLastLoginTime() {
        return this.lastLoginTime;
    }
    
    public void setLastLoginTime(Date value) {
        this.lastLoginTime = value;
    }
    
    public String getLastLoginIp() {
        return this.lastLoginIp;
    }
    
    public void setLastLoginIp(String value) {
        this.lastLoginIp = value;
    }
    
    public Integer getLoginCount() {
        return this.loginCount;
    }
    
    public void setLoginCount(Integer value) {
        this.loginCount = value;
    }
    
    public String getDeleteYn() {
        return this.deleteYn;
    }
    
    public void setDeleteYn(String value) {
        this.deleteYn = value;
    }
    
    public String getDisabledYn() {
        return this.disabledYn;
    }
    
    public void setDisabledYn(String value) {
        this.disabledYn = value;
    }
    
    public String getCreateUser() {
        return this.createUser;
    }
    
    public void setCreateUser(String value) {
        this.createUser = value;
    }
    
    public String getCreateTimeString() {
        return DateTimeUtil.format(getCreateTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }
    public void setCreateTimeString(String value) {
        setCreateTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }
    
    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date value) {
        this.createTime = value;
    }
    
    public String getUpdateUser() {
        return this.updateUser;
    }
    
    public void setUpdateUser(String value) {
        this.updateUser = value;
    }
    
    public String getUpdateTimeString() {
        return DateTimeUtil.format(getUpdateTime(), DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern());
    }
    public void setUpdateTimeString(String value) {
        setUpdateTime(DateTimeUtil.parseDate(value, DateTimeFormatPattern.PATTERN_YYYYMMDD_HH24MMSS_HYPHEN.getPattern()));
    }
    
    public Date getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(Date value) {
        this.updateTime = value;
    }
    
	public String getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Integer getAgentLevel() {
		return agentLevel;
	}

	public void setAgentLevel(Integer agentLevel) {
		this.agentLevel = agentLevel;
	}

	public Long getAgentId() {
		return agentId;
	}

	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	public String getAgentYn() {
		return agentYn;
	}

	public void setAgentYn(String agentYn) {
		this.agentYn = agentYn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getClickCount() {
		return clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	public Integer getCredit1() {
		return credit1;
	}

	public void setCredit1(Integer credit1) {
		this.credit1 = credit1;
	}

	public Double getCredit2() {
		return credit2;
	}

	public void setCredit2(Double credit2) {
		this.credit2 = credit2;
	}

	
   
	
    
}

