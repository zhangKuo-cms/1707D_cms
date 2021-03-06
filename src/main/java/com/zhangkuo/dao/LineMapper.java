package com.zhangkuo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhangkuo.entity.Line;

/** 

* @author 作者 zk: 

* @version 创建时间：2019年11月25日 下午7:33:04 

*/
public interface LineMapper {

	/**
	 * 
	 * @return
	 */
	@Select("SELECT * FROM cms_link ORDER BY created DESC")
	List<Line> list();

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM cms_link WHERE id=#{value} ")
	Line get(int id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Delete("DELETE  FROM cms_link WHERE id=#{value} ")
	int delete(int id);

	/**
	 * 
	 * @param link
	 * @return
	 */
	@Update("UPDATE cms_link set url=#{url},name=#{name} "
			+ "	WHERE id=#{id}")
	int update(Line link);

	/**
	 * 
	 * @param link
	 * @return
	 */
	@Insert("INSERT INTO cms_link (url,name,created) "
			+ " VALUES(#{url},#{name},now())")
	int add(Line link);

}
