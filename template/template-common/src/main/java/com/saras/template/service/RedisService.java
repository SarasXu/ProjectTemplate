package com.saras.template.service;

/**
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved.
 */

import java.util.List;

/**
 * 修订记录： spolang@yiji.com ${date} ${time} 创建
 */
public interface RedisService {
	public boolean put(String key, String value);
	
	public String get(String key);
	
	public boolean expire(String key, long expire);
	
	public <T> boolean setList(String key, List<T> list);
	
	public <T> List<T> getList(String key, Class<T> clz);
	
	public long lpush(String key, Object obj);
	
	public long rpush(String key, Object obj);
	
	public String lpop(String key);
}
