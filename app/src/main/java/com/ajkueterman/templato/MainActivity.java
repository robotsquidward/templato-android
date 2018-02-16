package com.ajkueterman.templato;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.ajkueterman.templato.fragment.DashboardFragment;
import com.ajkueterman.templato.fragment.HomeFragment;
import com.ajkueterman.templato.fragment.NotificationsFragment;
import com.ajkueterman.templato.model.Notification;
import com.ajkueterman.templato.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by AJ Kueterman on 2/15/18.
 *
 * The Main Activity for the project.
 *
 * This Activity contains the bottom navigation view and controller that
 * swaps between our three fragments.
 */
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String HOME_SCREEN = "home_screen_tag";
    private static final String DASHBOARD_SCREEN = "dashboard_screen_tag";
    private static final String NOTIFICATIONS_SCREEN = "notifications_screen_tag";

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViewModel();
        setupObservers();
        setupBottomNavigation();
        viewModel.setCurrentFragmentId(R.id.navigation_home);
    }

    private void setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.spoofNotifications();
    }

    private void setupObservers() {
        viewModel.getCurrentFragmentId().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer fragmentId) {
                if (fragmentId != null) {
                    switch (fragmentId) {
                        case R.id.navigation_home:
                            moveToHomeFragment();
                            break;
                        case R.id.navigation_dashboard:
                            moveToDashboardFragment();
                            break;
                        case R.id.navigation_notifications:
                            moveToNotificationsFragment();
                            break;
                    }
                }
            }
        });
    }

    private void setupBottomNavigation() {
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Let the ViewModel handle the navigation so it can be exposed to other fragments
        switch (item.getItemId()) {
            case R.id.navigation_home:
            case R.id.navigation_dashboard:
            case R.id.navigation_notifications:
                viewModel.setCurrentFragmentId(item.getItemId());
                return true;
        }
        return false;
    }

    private void moveToHomeFragment() {
        HomeFragment newFragment;
        if (getSupportFragmentManager().findFragmentByTag(HOME_SCREEN) instanceof HomeFragment) {
            newFragment = (HomeFragment) getSupportFragmentManager().findFragmentByTag(HOME_SCREEN);
        } else {
            newFragment = HomeFragment.newInstance();
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, newFragment, HOME_SCREEN);
        transaction.addToBackStack(HOME_SCREEN);
        transaction.commit();
        viewModel.setCurrentFragmentTitle(getString(R.string.title_home));
    }

    private void moveToDashboardFragment() {
        DashboardFragment newFragment;
        if (getSupportFragmentManager().findFragmentByTag(DASHBOARD_SCREEN) instanceof DashboardFragment) {
            newFragment = (DashboardFragment) getSupportFragmentManager().findFragmentByTag(DASHBOARD_SCREEN);
        } else {
            newFragment = DashboardFragment.newInstance();
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, newFragment, DASHBOARD_SCREEN);
        transaction.addToBackStack(DASHBOARD_SCREEN);
        transaction.commit();
        viewModel.setCurrentFragmentTitle(getString(R.string.title_dashboard));
    }

    private void moveToNotificationsFragment() {
        NotificationsFragment newFragment;
        if (getSupportFragmentManager().findFragmentByTag(NOTIFICATIONS_SCREEN) instanceof NotificationsFragment) {
            newFragment = (NotificationsFragment) getSupportFragmentManager().findFragmentByTag(NOTIFICATIONS_SCREEN);
        } else {
            newFragment = NotificationsFragment.newInstance();
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, newFragment, NOTIFICATIONS_SCREEN);
        transaction.addToBackStack(NOTIFICATIONS_SCREEN);
        transaction.commit();
        viewModel.setCurrentFragmentTitle(getString(R.string.title_notifications));
    }

}
