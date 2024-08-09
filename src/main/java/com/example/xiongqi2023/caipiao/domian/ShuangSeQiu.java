package com.example.xiongqi2023.caipiao.domian;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName shuang_se_qiu
 */
@TableName(value ="shuang_se_qiu")
public class ShuangSeQiu implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer issue;

    /**
     * 开奖时间
     */
    private Date openTime;

    /**
     * 红球
     */
    private String redBall;

    /**
     * 蓝球
     */
    private Integer blackBall;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public Integer getIssue() {
        return issue;
    }

    /**
     * 
     */
    public void setIssue(Integer issue) {
        this.issue = issue;
    }

    /**
     * 开奖时间
     */
    public Date getOpenTime() {
        return openTime;
    }

    /**
     * 开奖时间
     */
    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    /**
     * 红球
     */
    public String getRedBall() {
        return redBall;
    }

    /**
     * 红球
     */
    public void setRedBall(String redBall) {
        this.redBall = redBall;
    }

    /**
     * 蓝球
     */
    public Integer getBlackBall() {
        return blackBall;
    }

    /**
     * 蓝球
     */
    public void setBlackBall(Integer blackBall) {
        this.blackBall = blackBall;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ShuangSeQiu other = (ShuangSeQiu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIssue() == null ? other.getIssue() == null : this.getIssue().equals(other.getIssue()))
            && (this.getOpenTime() == null ? other.getOpenTime() == null : this.getOpenTime().equals(other.getOpenTime()))
            && (this.getRedBall() == null ? other.getRedBall() == null : this.getRedBall().equals(other.getRedBall()))
            && (this.getBlackBall() == null ? other.getBlackBall() == null : this.getBlackBall().equals(other.getBlackBall()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIssue() == null) ? 0 : getIssue().hashCode());
        result = prime * result + ((getOpenTime() == null) ? 0 : getOpenTime().hashCode());
        result = prime * result + ((getRedBall() == null) ? 0 : getRedBall().hashCode());
        result = prime * result + ((getBlackBall() == null) ? 0 : getBlackBall().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", issue=").append(issue);
        sb.append(", openTime=").append(openTime);
        sb.append(", redBall=").append(redBall);
        sb.append(", blackBall=").append(blackBall);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}