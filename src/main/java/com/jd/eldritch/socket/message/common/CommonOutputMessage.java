package com.jd.eldritch.socket.message.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonOutputMessage {
    private String type;
    private String[] values;
    private String result;
}
