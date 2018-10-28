package com.hengtiansoft;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarnMessageProcess {

    public List<WarnMessage> getWranMessage(){

        List<WarnMessage> list=new ArrayList<>();
        WarnMessage message=new WarnMessage();
        JSONObject warn=new JSONObject();
        warn.put("id",001);
        warn.put("student","zhangsan");
        message.setWarnType("student");
        message.setWarnContent(warn);
        list.add(message);
        WarnMessage message1=new WarnMessage();
        JSONObject warn1=new JSONObject();
        warn1.put("XXXId",001);
        warn1.put("XXXBAMe","lsui");
        message1.setWarnType("SetData");
        message1.setWarnContent(warn1);
        list.add(message1);
        return list;
    }
}
