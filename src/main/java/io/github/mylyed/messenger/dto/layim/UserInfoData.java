package io.github.mylyed.messenger.dto.layim;

import lombok.Data;

import java.util.List;

/**
 * @author lilei
 * created at 2019/7/17
 */
@Data
public class UserInfoData extends InfoData {
    //自己的信息
    private UserDTO mine;
    //好友
    private List<FriendGroupDTO> friend;
    //群信息
    private List<Group> group;
}
