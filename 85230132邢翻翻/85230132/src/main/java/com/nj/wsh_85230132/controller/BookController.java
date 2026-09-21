package com.nj.wsh_85230132.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {

    @Value("${lesson}")
    private String lesson;

    @Value("${server.port}")
    private Integer port;

    @Value("${enterprise.name}")
    private String name;

    @Value("${enterprise.subject[1]}")
    private String subject1;

    @Value("${center.dataDir}")
    private String dataDir;
    @Value("${center.tmpDir}")
    private String tmpDir;
    @Value("${center.logDir}")
    private String logDir;
    @Value("${center.msgDir}")
    private String msgDir;

    @GetMapping("/dir")
    public Map getDir() {
        Map map = new HashMap<>();
        map.put("dataDir", dataDir);
        map.put("tmpDir", tmpDir);
        map.put("logDir", logDir);
        map.put("msgDir", msgDir);
        return map;
    }

    //通过Environment对象全部加载所有参数
    @Autowired
    private Environment env;

    //通过@ConfigurationProperties整体加载enterprise配置
    @Autowired
    private Enterprise enterprise;

    @GetMapping("/enter")
    public Map getEnterprise() {
        Map map = new HashMap<>();
        map.put("name", enterprise.getName());
        map.put("tel", enterprise.getTel());
        map.put("age", enterprise.getAge());
        map.put("subjectList", enterprise.getSubject());
        return map;
    }

    @GetMapping("/allProp")
    public Map getAllProperties() {
        String port = env.getProperty("server.port");
        String mode = env.getProperty("spring.main.banner-mode");
        String loggingLevel = env.getProperty("logging.level.root");
        String lesson = env.getProperty("lesson");
        String tel = env.getProperty("enterprise.tel");
        String subject2 = env.getProperty("enterprise.subject[2]");
        Map map = new HashMap<>();
        map.put("port", port);
        map.put("mode", mode);
        map.put("loggingLevel", loggingLevel);
        map.put("lesson", lesson);
        map.put("tel", tel);
        map.put("subject2", subject2);
        return map;
    }

    @RequestMapping("/prop")
    public Map getProperties(){
        Map map = new HashMap<>();
        map.put("lesson", lesson);
        map.put("port", port);
        map.put("name", name);
        map.put("subject1", subject1);
        return map;
    }

}
