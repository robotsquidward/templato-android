package com.ajkueterman.templato.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.ajkueterman.templato.model.Notification;

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

    public void setNotifications(List<Notification> notifications) {
        getNotifications().setValue(notifications);
    }
}
