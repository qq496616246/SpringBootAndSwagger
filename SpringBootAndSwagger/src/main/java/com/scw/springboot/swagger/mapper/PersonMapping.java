package com.scw.springboot.swagger.mapper;
import com.scw.springboot.swagger.model.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * function : 针对Person实体进行的crud操作
 */
@Mapper
public interface PersonMapping {

    /**
     * 根据id查询到person数据
     * @param id
     * @return
     */
    @Select("select * from person where id = #{id}")
    public Person getPersonById(Integer id);
}
