package io.github.mylyed.messenger.ws;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DisconnectListener;
import org.springframework.stereotype.Component;

/**
 * @author lilei
 * created at 2019/7/17
 */
@Component
public class IMDisconnectListener extends IMContextHolder implements DisconnectListener {
    @Override
    public void onDisconnect(SocketIOClient client) {
        USERID_SESSIONID.remove(parseUserid(client.getHandshakeData()));
    }
}
