package com.xy.lesson.mbg.mapper;

import com.xy.lesson.mbg.model.Arrange;
import com.xy.lesson.mbg.model.ArrangeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArrangeMapper {
    int countByExample(ArrangeExample example);

    int deleteByExample(ArrangeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Arrange record);

    int insertSelective(Arrange record);

    List<Arrange> selectByExample(ArrangeExample example);

    Arrange selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Arrange record, @Param("example") ArrangeExample example);

    int updateByExample(@Param("record") Arrange record, @Param("example") ArrangeExample example);

    int updateByPrimaryKeySelective(Arrange record);

    int updateByPrimaryKey(Arrange record);
}