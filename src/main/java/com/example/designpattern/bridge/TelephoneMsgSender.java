package com.example.designpattern.bridge;

import java.util.List;

/**
 * Created by zyy on 20/2/24.
 */
public class TelephoneMsgSender implements MsgSender {

    private List telephones;

    public TelephoneMsgSender(List telephones) { this.telephones = telephones; }


    @Override
    public void send(String message) {

    }
}
