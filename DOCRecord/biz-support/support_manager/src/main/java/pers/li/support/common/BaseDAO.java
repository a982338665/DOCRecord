package pers.li.support.common;

/**
 * 所有DAO父类 用超类代替实体类
 * @author guojiaqing
 *
 * @param <T>
 */
public interface BaseDAO<T> {
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(String id);
	/**
	 * 插入一个对象（全部属性）
	 * @param t
	 * @return
	 */
    int insert(T t);
    /**
     * 插入一个对象（根据属性是否为空插入）
     * @param t
     * @return
     */
    int insertSelective(T t);
    /**
     * 根据id查询
     * @param id
     * @return
     */
    T selectByPrimaryKey(Integer id);
    /**
     * 根据id查询
     * @param id
     * @return
     */
    T selectByPrimaryKey(String id);
    /**
     * 根据id修改（判断属性是否为null不为null修改）
     * @param t
     * @return
     */
    int updateByPrimaryKeySelective(T t);
    /**
     * 根据id修改（修改全部属性）
     * @param t
     * @return
     */
    int updateByPrimaryKey(T t);

}
