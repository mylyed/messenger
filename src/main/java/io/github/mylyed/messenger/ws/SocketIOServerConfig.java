package io.github.mylyed.messenger.ws;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import io.github.mylyed.messenger.dto.layim.MessagePlayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lilei
 * created at 2019/7/17
 */
@Configuration
@Slf4j
public class SocketIOServerConfig {

    @Autowired
    IMAuthorizationListener imAuthorizationListener;


    @Autowired
    ConnectListener connectListener;
    @Autowired
    DisconnectListener disconnectListener;

    @Autowired
    MessagePlayloadListener messagePlayloadListener;


    @Bean(destroyMethod = "stop")
    public SocketIOServer socketIOServer() {

        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
//        config.setHostname("localhost");
        config.setPort(9092);
        config.setAuthorizationListener(imAuthorizationListener);
        SocketIOServer socketIOServer = new SocketIOServer(config);
        socketIOServer.addConnectListener(connectListener);
        socketIOServer.addDisconnectListener(disconnectListener);
        socketIOServer.addEventListener(SocketEventName.DEFAULT_SOCKET_EVENT_NAME, MessagePlayload.class, messagePlayloadListener);

        return socketIOServer;
    }
}
