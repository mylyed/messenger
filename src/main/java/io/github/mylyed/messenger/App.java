package io.github.mylyed.messenger;

import com.corundumstudio.socketio.SocketIOServer;
import io.github.mylyed.messenger.util.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author lilei
 * created at 2019/7/16
 */
@SpringBootApplication
@MapperScan("io.github.mylyed.messenger.persist")
@Slf4j
@EnableAsync
public class App {


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        SpringContextUtils.getBean(SocketIOServer.class).start();
    }


}
