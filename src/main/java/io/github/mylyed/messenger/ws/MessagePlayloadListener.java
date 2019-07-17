package io.github.mylyed.messenger.ws;


import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DataListener;
import io.github.mylyed.messenger.dto.layim.MessagePlayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessagePlayloadListener implements DataListener<MessagePlayload> {

    /**
     * 懒加载
     */
    @Autowired
    @Lazy
    MessageDispatcher messageDispatcher;


    @Override
    public void onData(SocketIOClient client, MessagePlayload data, AckRequest ackSender) throws Exception {
        log.debug("接收到消息：{}", data);
        messageDispatcher.dispatch(data);

    }
}