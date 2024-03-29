package com.ssm.service;
/**
 * 共用接口方法（基础接口类）--被个性化接口所继承（常用于Dao）
 * @param <T>
 */
public interface BaseService<T> {
	   //添加单个对象  
    public int insert(T entity);  
      
    //修改单个对象  
    public int update(T entity);  
      
    //删除单个对象  
    public int delete(T entity);  
      
    //查询单个对象  
    public T select(T entity);  
}
