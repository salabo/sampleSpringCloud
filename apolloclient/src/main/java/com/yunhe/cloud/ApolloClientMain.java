package com.yunhe.cloud;


import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @description 主启动类
 * @Author zhangbo
 * @Date 2019-06-24 23:19
 */
@EnableApolloConfig
@SpringBootApplication
@RestController
public class ApolloClientMain {

    @Value("${name}")
    private String str;


    @GetMapping("/hi-bo")
    public String s9(){
        return str;
    }

    public static void main(String[] args) {

        SpringApplication.run(ApolloClientMain.class,args);
    }
}
