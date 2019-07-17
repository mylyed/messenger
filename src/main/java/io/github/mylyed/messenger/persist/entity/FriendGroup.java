package io.github.mylyed.messenger.persist.entity;

import java.io.Serializable;
import java.util.Date;

public class FriendGroup implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friend_group.id
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friend_group.group_name
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    private String groupName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friend_group.user_id
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friend_group.is_default
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    private Integer isDefault;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friend_group.create_time
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column friend_group.update_time
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table friend_group
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friend_group.id
     *
     * @return the value of friend_group.id
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friend_group.id
     *
     * @param id the value for friend_group.id
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friend_group.group_name
     *
     * @return the value of friend_group.group_name
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friend_group.group_name
     *
     * @param groupName the value for friend_group.group_name
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friend_group.user_id
     *
     * @return the value of friend_group.user_id
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friend_group.user_id
     *
     * @param userId the value for friend_group.user_id
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friend_group.is_default
     *
     * @return the value of friend_group.is_default
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    public Integer getIsDefault() {
        return isDefault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friend_group.is_default
     *
     * @param isDefault the value for friend_group.is_default
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friend_group.create_time
     *
     * @return the value of friend_group.create_time
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friend_group.create_time
     *
     * @param createTime the value for friend_group.create_time
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column friend_group.update_time
     *
     * @return the value of friend_group.update_time
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column friend_group.update_time
     *
     * @param updateTime the value for friend_group.update_time
     *
     * @mbg.generated Wed Jul 17 17:31:59 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}