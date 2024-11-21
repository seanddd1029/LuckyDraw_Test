package com.example.test;

import com.example.rpc.IActivityBooth;
import com.alibaba.fastjson.JSON;
import com.example.rpc.IActivityBooth;
import com.example.rpc.req.ActivityReq;
import com.example.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);
    @Reference(interfaceClass = IActivityBooth.class, url = "dubbo://127.0.0.1:20880")
    private IActivityBooth activityBooth;

    @Test
    public void test_rpc(){
        ActivityReq req = new ActivityReq();
        req.setActivityId(10001L);
        ActivityRes res = activityBooth.queryActivityById(req);
        logger.info("测试结果，{}",JSON.toJSONString(res));
    }

}
