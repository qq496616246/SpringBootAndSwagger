package com.scw.springboot.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author scw
 * @create 2018-01-03 10:33
 * @desc 对应数据库中的实体类
 **/
@ApiModel(value = "用户实体模型")
public class Person {
    @ApiModelProperty(value = "用户id", required = true)
    private Integer id;
    @ApiModelProperty(value = "用户名", required = true)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
