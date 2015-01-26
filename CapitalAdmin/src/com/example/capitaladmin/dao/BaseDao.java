package com.example.capitaladmin.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T, ID> {
	/**
	 * 事务
	 * 
	 * @date 2013-12-27下午3:47:08
	 * @author zhang_jinhua@safeye.com.cn
	 * @return
	 */
	public Transaction getTransaction();

	/**
	 * 按id查找
	 * 
	 * @param id
	 * @return
	 */
	public T queryForId(ID id);

	/**
	 * 按id集合查找
	 * 
	 * @param ids
	 * @return
	 */
	public List<T> queryForIds(List<ID> ids);

	/**
	 * 查找全部
	 * 
	 * @return
	 */
	public List<T> queryForAll();

	/**
	 * 按指定字段查找
	 * 
	 * @param fieldName
	 * @param value
	 * @return
	 */
	public List<T> queryForEq(String fieldName, Object value);

	/**
	 * 多字段查找
	 * 
	 * @param values
	 * @return
	 */
	public List<T> queryForFieldValues(Map<String, Object> values);

	/**
	 * 新增
	 * 
	 * @param data
	 * @return
	 */
	public int save(T data);

	/**
	 * 新增或更新
	 * 
	 * @param data
	 * @return
	 */
	public int saveOrUpdate(T data);

	/**
	 * 更新
	 * 
	 * @param data
	 * @return
	 */
	public int update(T data);

	/**
	 * 删除list
	 * 
	 * @date 2013-11-28下午7:47:27
	 * @author zhang_jinhua@safeye.com.cn
	 * @param data
	 * @return
	 */
	public int delete(List<T> data);

	/**
	 * 按id删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(ID id);

	/**
	 * 保存更新list
	 * 
	 * @date 2013-11-11上午10:55:22
	 * @author hx
	 * @param data
	 * @return
	 */
	public int saveOrUpdate(List<T> data);

	/**
	 * 更新list
	 * 
	 * @date 2013-11-11上午10:55:36
	 * @author hx
	 * @param data
	 * @return
	 */
	public int update(List<T> data);

	/**
	 * 保存list
	 * 
	 * @date 2013-11-11上午10:56:59
	 * @author hx
	 * @param data
	 * @return
	 */
	public int save(List<T> data);

	/**
	 * 参数为空删除所有行（清空表）
	 * 
	 * 
	 * @date 2013-12-5下午3:35:14
	 * @author hx
	 * @param fieldName
	 * @param value
	 * @return
	 */
	public int deleteAll(String fieldName, Object value);
	/**
	 * 删除符合条件的记录
	 * @date 2014-8-25下午3:33:16
	 * @author Hex(382903916@qq.com)
	 * @param fieldName
	 * @param value
	 * @return
	 */
	public int deleteInAll(String fieldName, Object... value);

	/**
	 * 清除缓存
	 * @date 2014-5-12下午5:57:49
	 * @author hx
	 */
	public void clearObjectCache();

	public	boolean tabIsExist();

}
