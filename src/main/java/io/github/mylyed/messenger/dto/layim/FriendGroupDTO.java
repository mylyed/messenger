package io.github.mylyed.messenger.dto.layim;

import lombok.Data;

import java.util.List;

/**
 * 还有分组信息
 *
 * @author lilei
 * created at 2019/7/17
 */
@Data
public class FriendGroupDTO {
    private String groupname;
    private Integer id;
    //在线人数
    private Integer online;
    private List<UserDTO> list;
}
