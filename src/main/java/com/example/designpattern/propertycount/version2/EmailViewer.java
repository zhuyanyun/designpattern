package com.example.designpattern.propertycount.version2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zyy on 20/2/16.
 */
public class EmailViewer implements StatViewer {

    private EmailSender emailSender;
    private List toAddresses = new ArrayList<>();
    public EmailViewer() {
        this.emailSender = new EmailSender(/*省略参数*/);
    }
    public EmailViewer(EmailSender emailSender) { this.emailSender = emailSender; }
    public void addToAddress(String address) { toAddresses.add(address); }


    @Override
    public void output(Map requestStats, long startTimeInMillis, long endTimeInMills) {

    }
}
