package com.zhangkuo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhangkuo.entity.Collection;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月25日 下午7:39:57 

*/
public interface CollectionMapper {

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM cms_collect WHERE id=#{value} ")
	Collection get(int id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Delete("DELETE  FROM cms_collect WHERE id=#{value} ")
	int delete(int id);

	/**
	 * 
	 * @param collect
	 * @return
	 */
	@Update("UPDATE cms_collect set url=#{url},name=#{name} "
			+ "	WHERE id=#{id}")
	int update(Collection collect);

	/**
	 * 
	 * @param collect
	 * @return
	 */
	@Insert("INSERT INTO cms_collect (userId,url,name,created) "
			+ " VALUES(#{userId},#{url},#{name},now())")
	int add(Collection collect);

	/**
	 * 
	 * @param userId 
	 * @return
	 */
	@Select("SELECT * FROM cms_collect "
			+ " WHERE userId=#{userId} "
			+ " ORDER BY created DESC")
	List<Collection> list(Integer userId);

}
