package com.home.entityInterface;
	
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.home.entity.User;
	
	/**
	 * 此类是：映射关系接口
	 * @author hpc
	 * @2017年1月11日下午7:09:20
	 */
	public interface UserMapperInterface{
		/**
		 * 获取指定id的User
		 *  当我们调用这个方法的时候就会去执行这一条sql语句，
		 *  这里面要注意点的是:
		 *  	传进来的参数是以对象的形式传进来的，
		 *  	所以取的时候要以对象属性来取，否则将会报错.
		 */
		@Select("select * from users where user_id=#{user_id}")
		public User loadUser(User user);
		
		/**
		 * 更新user
		 */
		@Update("update users set user_name=#{user_name},user_pwd=#{user_pwd} where user_id=#{user_id}")
		public int updateUser(User user);
		/**
		 * 删除user
		 */
		@Delete("delete from users where user_id=#{user_id}")
		public int deleteUser(User user);
		/**
		 * 插入user
		 */
		@Insert("insert into users(user_name,user_pwd) values(#{user_name},#{user_pwd}) ")
		public int insertUser(User user);
	}
