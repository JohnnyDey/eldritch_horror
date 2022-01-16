package com.jd.eldritch.socket.message.game;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputMessage {
    String senderUid;
    String value;
}
