package com.xcn.springboottest;

import com.sun.media.jfxmedia.logging.Logger;
import com.xcn.springboottest.bsi.controller.BizController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * 使用mock测试需要在pom中添加powermock-api-mockito2,如需要junit支持,需要引入junit包和powermock-module-junit4
 * @author: xupeng.guo
 * @date: 2019/10/18
 * @description
 */
@SpringBootTest
@Slf4j
public class MockTest1 {

    private MockMvc mockmvc;

    @Before
    public void setUp(){
        mockmvc = MockMvcBuilders.standaloneSetup(new BizController()).build();
    }

    /**
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        MvcResult result = mockmvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET,"/biz/home"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        log.info(result.getResponse().getContentAsString());
    }
}
