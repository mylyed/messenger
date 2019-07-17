package io.github.mylyed.messenger.ws;

import com.corundumstudio.socketio.HandshakeData;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.UUID;

/**
 * @author lilei
 * created at 2019/7/17
 */
@Slf4j
public class IMContextHolder {

    protected volatile static Map<String, UUID> USERID_SESSIONID = Maps.newConcurrentMap();


    /**
     * 解析userid
     *
     * @param handshakeData
     * @return
     */
    String parseUserid(HandshakeData handshakeData) {
        String userid = handshakeData.getSingleUrlParam("userid");
        log.debug("userid = {}", userid);
        return userid;
    }

}
