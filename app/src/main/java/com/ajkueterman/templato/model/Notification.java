package com.ajkueterman.templato.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by AJ Kueterman on 2/15/18.
 *
 * A dummy Notification object
 */

public class Notification implements Serializable {

    private String subject;
    private String message;
    private String from;
    private Date timeStamp;
    private boolean read;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
