package io.github.mylyed.messenger.mapstruct;

import io.github.mylyed.messenger.dto.layim.LineStatus;
import io.github.mylyed.messenger.dto.layim.UserDTO;
import io.github.mylyed.messenger.persist.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserConverter extends MapStructBasicConverter<User, UserDTO> {

    @Mappings({
            @Mapping(source = "nickName", target = "username")
    }
    )
    @Override
    UserDTO to(User user);

    default Integer toInt(LineStatus test) {
        return test.value;
    }

    default LineStatus toEnum(Integer code) {
        return LineStatus.values()[code];
    }
}