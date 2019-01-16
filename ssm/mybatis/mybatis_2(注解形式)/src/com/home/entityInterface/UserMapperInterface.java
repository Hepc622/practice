package com.home.entityInterface;
	
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.home.entity.User;
	
	/**
	 * �����ǣ�ӳ���ϵ�ӿ�
	 * @author hpc
	 * @2017��1��11������7:09:20
	 */
	public interface UserMapperInterface{
		/**
		 * ��ȡָ��id��User
		 *  �����ǵ������������ʱ��ͻ�ȥִ����һ��sql��䣬
		 *  ������Ҫע������:
		 *  	�������Ĳ������Զ������ʽ�������ģ�
		 *  	����ȡ��ʱ��Ҫ�Զ���������ȡ�����򽫻ᱨ��.
		 */
		@Select("select * from users where user_id=#{user_id}")
		public User loadUser(User user);
		
		/**
		 * ����user
		 */
		@Update("update users set user_name=#{user_name},user_pwd=#{user_pwd} where user_id=#{user_id}")
		public int updateUser(User user);
		/**
		 * ɾ��user
		 */
		@Delete("delete from users where user_id=#{user_id}")
		public int deleteUser(User user);
		/**
		 * ����user
		 */
		@Insert("insert into users(user_name,user_pwd) values(#{user_name},#{user_pwd}) ")
		public int insertUser(User user);
	}
