package io.github.mylyed.messenger.dto.layim;

import lombok.Data;

/**
 * @author lilei
 * created at 2019/7/17
 */
@Data
public class Result<T extends InfoData> {

    //code=0 表示成功，其余表示失败
    private Integer code = 0;
    // 失败信息,成功则为空
    private String msg;

    private T data;
}
