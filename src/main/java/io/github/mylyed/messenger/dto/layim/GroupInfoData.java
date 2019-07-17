package io.github.mylyed.messenger.dto.layim;

import lombok.Data;

import java.util.List;

/**
 * @author lilei
 * created at 2019/7/17
 */
@Data
public class GroupInfoData extends InfoData {
    //群创建人
    private UserDTO owner;

    //群成员
    private List<Group> list;


    //群成员数量
    private Integer members = this.list == null ? 0 : this.list.size();
}
