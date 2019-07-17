package io.github.mylyed.messenger.ws;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.ConnectListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author lilei
 * created at 2019/7/17
 */
@Slf4j
@Component
public class IMConnectListener extends IMContextHolder implements ConnectListener {


    @Override
    public void onConnect(SocketIOClient client) {
        UUID sessionId = client.getSessionId();
        USERID_SESSIONID.put(parseUserid(client.getHandshakeData()), sessionId);
    }


}
