package com.hengtiansoft;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api("测试接口")
public class TestController {

    @ApiOperation(value = "获取数据")
    @RequestMapping(value = "/getWarnMessage",method = RequestMethod.GET)
    public List<WarnMessage> getWarnMessage(){
        return new WarnMessageProcess().getWranMessage();
    }
}
