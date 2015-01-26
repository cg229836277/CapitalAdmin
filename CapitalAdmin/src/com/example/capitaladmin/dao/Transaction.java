package com.example.capitaladmin.dao;

public interface Transaction {
	/**
	 * 开始事务
	 * @date 2013-12-27下午2:49:16
	 * @author zhang_jinhua@safeye.com.cn
	 */
	public void beginTransaction();
	
	/**
	 * 提交事务
	 * 
	 * @date 2013-12-27下午2:49:22
	 * @author zhang_jinhua@safeye.com.cn
	 */
	public void commit();
	
	/**
	 * 结束事务
	 * 数据操作完成后，必须调用此方法把事务结束掉
	 * @date 2013-12-27下午2:49:28
	 * @author zhang_jinhua@safeye.com.cn
	 */
	public void endTransaction();
	
	
	
}
