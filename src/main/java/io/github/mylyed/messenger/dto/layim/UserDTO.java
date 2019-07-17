package io.github.mylyed.messenger.dto.layim;

import lombok.Data;

/**
 * @author lilei
 * created at 2019/7/17
 */
@Data
public class UserDTO {
    private String id;            //我的ID,即userId
    private String username;   //我的真是姓名，即ucName
    private LineStatus status;     //在线状态 online：在线、hide：隐身
    private String sign;       //我的签名
    private String avatar;     //我的头像


}
