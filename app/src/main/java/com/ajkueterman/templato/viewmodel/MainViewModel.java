package com.ajkueterman.templato.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.ajkueterman.templato.model.Notification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by AJ Kueterman on 2/15/18.
 *
 * The Main Activity's {@link ViewModel}
 */

public class MainViewModel extends ViewModel {

    private MutableLiveData<Integer> currentFragmentId;
    private MutableLiveData<String> currentFragmentTitle;
    private MutableLiveData<List<Notification>> notifications;

    public MutableLiveData<Integer> getCurrentFragmentId() {
        if (this.currentFragmentId == null) {
            this.currentFragmentId = new MutableLiveData<>();
        }
        return this.currentFragmentId;
    }

    public void setCurrentFragmentId(int currentFragmentId) {
        getCurrentFragmentId().setValue(currentFragmentId);
    }

    public MutableLiveData<String> getCurrentFragmentTitle() {
        if (this.currentFragmentTitle == null) {
            this.currentFragmentTitle = new MutableLiveData<>();
        }
        return this.currentFragmentTitle;
    }

    public void setCurrentFragmentTitle(String currentFragmentTitle) {
        getCurrentFragmentTitle().setValue(currentFragmentTitle);
    }

    public MutableLiveData<List<Notification>> getNotifications() {
        if (this.notifications == null) {
            this.notifications = new MutableLiveData<>();
        }
        return this.notifications;
    }

    private void setNotifications(List<Notification> notifications) {
        getNotifications().setValue(notifications);
    }

    // Faking out notification data for demo purposes
    public void spoofNotifications() {
        Notification one = new Notification();
        one.setFrom("AJ");
        one.setSubject("Hello World!");
        one.setMessage("Welcome to my sample app!");
        one.setRead(true);
        one.setTimeStamp(new Date());
        Notification two = new Notification();
        two.setFrom("Bruce Banner");
        two.setSubject("Puny App");
        two.setMessage("Is this app the best you got?");
        two.setRead(false);
        two.setTimeStamp(new Date());
        Notification three = new Notification();
        three.setFrom("Darth Vader");
        three.setSubject("Luke...");
        three.setMessage("I am your father!");
        three.setRead(false);
        three.setTimeStamp(new Date());
        Notification four = new Notification();
        four.setFrom("Number Four");
        four.setSubject("The Fourth Notification");
        four.setMessage("I can't think up fake data forever.");
        four.setRead(true);
        four.setTimeStamp(new Date());
        Notification five = new Notification();
        five.setFrom("AJ");
        five.setSubject("Again?");
        five.setMessage("Yes, need enough to scroll!");
        five.setRead(false);
        five.setTimeStamp(new Date());
        List<Notification> notificationList = new ArrayList<>();
        notificationList.add(one);
        notificationList.add(two);
        notificationList.add(three);
        notificationList.add(four);
        notificationList.add(five);
        setNotifications(notificationList);
    }
}
