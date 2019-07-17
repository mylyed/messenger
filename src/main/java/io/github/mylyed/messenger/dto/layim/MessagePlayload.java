package io.github.mylyed.messenger.dto.layim;

import lombok.Data;

/**
 * 消息发送载体
 *
 * @author lilei
 * created at 2019/7/17
 */

@Data
public class MessagePlayload {
    private From mine;
    private To to;

    @Data
    public static class From {
        private String avatar;
        private String content;
        private String id;
        private String mine;
        private String username;
    }

    @Data
    public static class To {
        private String avatar;
        private String id;
        private String name;
        private String sign;
        private String status;
        private Type type;
        private String username;
    }

    public enum Type {
        friend, group;
    }


}
