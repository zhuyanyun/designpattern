package com.example.designpattern.bridge;

/**
 * Created by zyy on 20/2/24.
 */
public class SevereNotification extends  Notification {

    public SevereNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {

    }
}
