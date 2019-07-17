package io.github.mylyed.messenger.ws;

import com.corundumstudio.socketio.AuthorizationListener;
import com.corundumstudio.socketio.HandshakeData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 连接授权验证
 *
 * @author lilei
 * created at 2019/7/17
 */
@Component
@Slf4j
public class IMAuthorizationListener implements AuthorizationListener {
    @Override
    public boolean isAuthorized(HandshakeData data) {
        log.debug("认证连接");
        return true;
    }
}
