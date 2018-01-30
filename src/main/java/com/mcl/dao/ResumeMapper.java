package com.mcl.dao;

import com.mcl.pojo.Resume;
import com.mcl.vo.ResumeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResumeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Resume record);

    int insertSelective(Resume record);

    Resume selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Resume record);

    int updateByPrimaryKey(Resume record);

    int checkResumeExist(@Param("id") Integer id);

    List<Resume> selectList(String openid);

    List<Resume> getResumeBox(@Param("companyid") String companyid);

    List<Resume> getResumeByReIdList(@Param("idlist") List idlist);

    int checkResumeCanGet(@Param("id") Integer id,@Param("companyid") String companyid);
}