package io.github.mylyed.messenger.ws;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lilei
 * created at 2019/7/17
 */
//@Slf4j
////@Component
//public class SocketIOStarter {
//
//
//    final SocketIOServer socketIOServer;
//
//    @Autowired
//    public SocketIOStarter(SocketIOServer socketIOServer) {
//        this.socketIOServer = socketIOServer;
//    }
//
//    public synchronized void start() {
//        log.info("启动SocketIOServer");
//        socketIOServer.start();
//    }
//
//    public synchronized void stop() {
//        log.info("关闭SocketIOServer");
//        //待解决分部署问题
//        socketIOServer.stop();
//    }
//
//}
