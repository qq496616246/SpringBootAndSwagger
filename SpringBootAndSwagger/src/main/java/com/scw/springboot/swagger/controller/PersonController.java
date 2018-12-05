package com.scw.springboot.swagger.controller;
import com.scw.springboot.swagger.model.Person;
import com.scw.springboot.swagger.service.PersonService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author scw
 * @create 2018-01-03 10:31
 * @desc swagger的牛刀小试
 **/
@Controller
@Api(value = "swagger牛刀小试")
public class PersonController {

    @Autowired
    public PersonService personService;

    /**
     * 根据ID查询数据
     * @param id
     * @return 返回字符串
     */
    @ApiOperation(value = "测试根据id获取用户信息的方法(1)" ,notes="测试查询方法", tags = {"query"})
    @ApiImplicitParam(paramType = "query", name = "id",
                 value = "用户Id", required = true, dataType = "Integer")
    @RequestMapping(value = "person/getperson1", method = RequestMethod.GET)
    @ResponseBody
    public String queryPerson1(@RequestParam Integer id ){
        Person person = personService.getPersonById(id);
        return "hello";
    }

    /**
     * 根据ID查询数据
     * @param id
     * @return 返回实体的json格式
     */
    @ApiOperation(value = "测试根据id获取用户信息的方法(2)" ,notes="测试查询方法", tags = {"query"})
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户Id", required = true, dataType = "int")
    @RequestMapping(value = "person/getperson2", method = RequestMethod.GET)
    @ResponseBody
    public Object queryPerson2(@RequestParam Integer id , Model model){
        Person person = personService.getPersonById(id);
        model.addAttribute("person" , person);
        return person;
    }

    /**
     * 根据id获取用户信息
     * @param id
     * @param model
     * @return 返回页面
     */
    @ApiOperation(value = "测试根据id获取用户信息的方法(3)" ,notes="测试查询方法", tags = {"query"})
    @ApiImplicitParam(paramType = "query", name = "id", value = "用户Id", required = true, dataType = "int")
    @RequestMapping(value = "person/getperson3", method = RequestMethod.GET)
    public Object queryPerson3(@RequestParam Integer id , Model model){
        Person person = personService.getPersonById(id);
        model.addAttribute("person" , person);
        return "ok";
    }

    /**
     *  接受的参数是person实体（这种情况用得最多，比如form表单提交）
     * @param person
     * @return
     */
    @ApiOperation(value = "测试接受参数为对象实体(4)" ,notes="2222", tags = {"query"})
    @RequestMapping(value = "person/getperson4", method = RequestMethod.POST)
    @ResponseBody
    public String queryPerson4(@RequestBody Person person){
        return "成功";
    }

    /**
     *  多个参数的形式，利用
     * @param userName
     * @param id
     * @return
     */
    @ApiOperation(value = "测试多个参数(5)" ,notes="测试查询方法", tags = {"query"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "用户Id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "userName", value = "用户名", required = true, dataType = "String"),
    })
    @RequestMapping(value = "person/getperson5", method = RequestMethod.GET)
    @ResponseBody
    public Object queryPerson5( @RequestParam String userName,
                                @RequestParam Integer id ){
        return "success";
    }
    /**
     * 利用@ApiParam注解来设置参数(之前都是用的@ApiImplicitParam)
     * @param id
     * @return
     */
    @ApiOperation(value = "测试根据id获取用户信息的方法(6)" ,notes="测试查询方法", tags = {"query"})
    @RequestMapping(value = "person/getperson6", method = RequestMethod.GET)
    @ResponseBody
    public Object queryPerson6( @ApiParam(name = "id",required = true,value = "用户ID")
                                       @RequestParam Integer id ){
        Person person = personService.getPersonById(id);
        return "person";
    }
}
