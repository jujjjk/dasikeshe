package com.nj.wsh_85230132;

import com.nj.wsh_85230132.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.awt.Desktop;
import java.net.URI;

@SpringBootApplication
public class Wsh85230132Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(Wsh85230132Application.class, args);
        System.out.println("bean-> " + context.getBean(UserController.class));

        // 启动完成后，用默认浏览器自动打开接口地址（端口从配置动态读取）
        String url = "http://localhost:" + context.getEnvironment().getProperty("server.port") + "/book/prop";
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI(url));
        }
    }

}
