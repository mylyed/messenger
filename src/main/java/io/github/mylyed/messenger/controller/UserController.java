package io.github.mylyed.messenger.controller;

import io.github.mylyed.messenger.dto.layim.*;
import io.github.mylyed.messenger.mapstruct.UserConverter;
import io.github.mylyed.messenger.persist.entity.*;
import io.github.mylyed.messenger.persist.mapper.FriendGroupMapper;
import io.github.mylyed.messenger.persist.mapper.FriendMapper;
import io.github.mylyed.messenger.persist.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lilei
 * created at 2019/7/16
 */
@RestController
public class UserController {

    @Resource
    UserMapper userMapper;

    @Resource
    FriendGroupMapper friendGroupMapper;

    @Resource
    FriendMapper friendMapper;


    @Autowired
    UserConverter userConverter;

    @GetMapping("groupInfo")
    public Result<GroupInfoData> groupInfo() throws IOException {
        Result<GroupInfoData> result = new Result();
        GroupInfoData groupInfoData = new GroupInfoData();
        result.setData(groupInfoData);
        return result;
    }

    @GetMapping("userInfo")
    public Result<UserInfoData> userInfo(@RequestParam Integer userid) {

        Assert.notNull(userid, "userid为空");

        Result<UserInfoData> result = new Result();
        UserInfoData userInfoData = new UserInfoData();
        result.setData(userInfoData);


        User mine = userMapper.selectByPrimaryKey(userid);

        FriendGroupExample fge = new FriendGroupExample();

        fge.createCriteria().andUserIdEqualTo(userid);

        List<FriendGroup> friendGroups = friendGroupMapper.selectByExample(fge);

        List<FriendGroupDTO> friendGroupDTOS = friendGroups.stream().map(friendGroup -> {
            FriendGroupDTO friendGroupDTO = new FriendGroupDTO();
            FriendExample friendExample = new FriendExample();

            friendGroupDTO.setId(friendGroup.getId());
            friendGroupDTO.setGroupname(friendGroup.getGroupName());

            friendExample.createCriteria().andUserIdEqualTo(userid).andFriendGroupIdEqualTo(friendGroup.getId());
            List<Friend> friends = friendMapper.selectByExample(friendExample);

            List<UserDTO> list = friends.stream().map(friend -> {
                User user = userMapper.selectByPrimaryKey(friend
                        .getFriendId());


                return userConverter.to(user);

            }).collect(Collectors.toList());
            friendGroupDTO.setList(list);

            return friendGroupDTO;
        }).collect(Collectors.toList());

        userInfoData.setMine(userConverter.to(mine));
        userInfoData.setFriend(friendGroupDTOS);


        return result;
    }
}
