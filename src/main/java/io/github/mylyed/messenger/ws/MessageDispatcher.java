package io.github.mylyed.messenger.ws;

import com.corundumstudio.socketio.SocketIOServer;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.github.mylyed.messenger.dto.layim.MessagePlayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 消息分发器
 *
 * @author lilei
 * created at 2019/7/17
 */
@Component
@Slf4j
public class MessageDispatcher extends IMContextHolder {


    @Autowired
    @Lazy
    volatile SocketIOServer socketIOServer;

    @Async
    public void dispatch(MessagePlayload messagePlayload) {
        log.debug("分发消息");
        ObjectNode node = JsonNodeFactory.instance.objectNode();

        node.put("username", messagePlayload.getMine().getUsername());
        node.put("avatar", messagePlayload.getMine().getAvatar());
        node.put("id", messagePlayload.getMine().getId());
        node.put("content", messagePlayload.getMine().getContent());
        node.put("type", messagePlayload.getTo().getType().name());

        if (MessagePlayload.Type.friend.equals(messagePlayload.getTo().getType())) {
            String toUserid = messagePlayload.getTo().getId();
            if (USERID_SESSIONID.containsKey(toUserid)) {
                UUID uuid = USERID_SESSIONID.get(toUserid);
                socketIOServer.getClient(uuid).sendEvent(SocketEventName.DEFAULT_SOCKET_EVENT_NAME, node);
            } else {
                //离线
                log.debug("对方离线了");
            }

        }

    }
}
