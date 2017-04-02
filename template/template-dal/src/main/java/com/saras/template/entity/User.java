package com.saras.template.entity;

import com.saras.template.utils.ToString;

public class User {
	/**
	 * 物理主键
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	private Long id;
	
	/**
	 * 用户ID
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	private String user_id;
	
	/**
	 * 用户名
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	private String user_name;
	
	/**
	 * 密码
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	private String pwd;
	
	/**
	 * 描述
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	private String memo;
	
	/**
	 * yyy
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	private String ddd;
	
	/**
	 * 获取 物理主键
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 设置 物理主键
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * 获取 用户ID
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	public String getUser_id() {
		return user_id;
	}
	
	/**
	 * 设置 用户ID
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	/**
	 * 获取 用户名
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	public String getUser_name() {
		return user_name;
	}
	
	/**
	 * 设置 用户名
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	/**
	 * 获取 密码
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	public String getPwd() {
		return pwd;
	}
	
	/**
	 * 设置 密码
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	/**
	 * 获取 描述
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	public String getMemo() {
		return memo;
	}
	
	/**
	 * 设置 描述
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	/**
	 * 获取 yyy
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	public String getDdd() {
		return ddd;
	}
	
	/**
	 * 设置 yyy
	 *
	 * @mbggenerated 2017-04-02 12:17:02
	 */
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	
	@Override
	public String toString() {
		return ToString.toString(this);
	}
}