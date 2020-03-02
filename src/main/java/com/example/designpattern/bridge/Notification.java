package com.example.designpattern.bridge;

/**
 * Created by zyy on 20/2/24.
 */
public abstract class Notification {

    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract void notify(String message);

}
