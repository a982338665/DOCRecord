package pers.lish.girl.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * create by lishengbo on 2017-12-20 15:30
 * api接口测试（模拟浏览器发送请求）
 */
@RunWith(SpringRunner.class)//底层junit单元测试
@SpringBootTest             //表示将启动整个工程
@AutoConfigureMockMvc       //
public class GirlControllerTest {

    @Autowired
    private MockMvc mvc;
    @Test
    public void getgirw4() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/pppu?id=5")).andExpect(MockMvcResultMatchers.status().isOk());
//        mvc.perform(MockMvcRequestBuilders.get("/pppud=5")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}