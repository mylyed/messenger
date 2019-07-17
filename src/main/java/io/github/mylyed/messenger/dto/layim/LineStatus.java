package io.github.mylyed.messenger.dto.layim;

/**
 * @author lilei
 * created at 2019/7/17
 */
public enum LineStatus {
    //离线 //在线 //隐身
    offline(0), online(1), hide(2);

    public final int value;

    LineStatus(int value) {
        this.value = value;
    }
}
