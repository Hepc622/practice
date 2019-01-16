package com.home.mybatisplus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hpc
 * @Description: TODO
 * @date 2019/1/723:03
 */
@Mapper
@Repository
public interface MemberMapper extends BaseMapper<Member> {
    @Select("select * from dy_member where is_author=1")
    List<Member> getMember();
}
