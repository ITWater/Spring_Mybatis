package com.sunhui.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sunhui.ssm.pojo.Admin;
import com.sunhui.ssm.pojo.AdminExample;

public interface AdminMapper {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);
    
    //新增的接口
    Admin selectByAdmin (@Param("A_username") String username, @Param("A_password") String password) ;

    Admin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}