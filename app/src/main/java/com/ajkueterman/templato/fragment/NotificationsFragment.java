package com.ajkueterman.templato.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ajkueterman.templato.R;
import com.ajkueterman.templato.adapter.NotificationsRecyclerViewAdapter;
import com.ajkueterman.templato.model.Notification;
import com.ajkueterman.templato.viewmodel.MainViewModel;

import java.util.List;

/**
 * Created by AJ Kueterman on 2/15/18.
 *
 * Notifications screen.
 */

public class NotificationsFragment extends Fragment
        implements NotificationsRecyclerViewAdapter.NotificationRecyclerViewCallback {

    private TextView notificationsHeaderBarTitle;
    private RecyclerView recyclerView;
    private NotificationsRecyclerViewAdapter adapter;

    private MainViewModel viewModel;

    public static NotificationsFragment newInstance() {
        Bundle args = new Bundle();
        NotificationsFragment fragment = new NotificationsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupViewModel();
        setupObservers();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_notifications, container, false);
        recyclerView = inflatedView.findViewById(R.id.recyclerView);
        notificationsHeaderBarTitle = inflatedView.findViewById(R.id.notificationsHeaderBarTitle);
        setupRecyclerView();
        setupHeaderBarTitle();
        return inflatedView;
    }

    private void setupHeaderBarTitle() {
        if (notificationsHeaderBarTitle != null && viewModel.getCurrentFragmentTitle().getValue() != null) {
            notificationsHeaderBarTitle.setText(viewModel.getCurrentFragmentTitle().getValue());
        }
    }

    private void setupRecyclerView() {
        if (getContext() == null) { return; }
        adapter = new NotificationsRecyclerViewAdapter(viewModel.getNotifications().getValue(), getContext(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    private void setupViewModel() {
        if (getActivity() == null) { return; }
        viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
    }

    private void setupObservers() {
        if (getActivity() == null) { return; }
        viewModel.getCurrentFragmentTitle().observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String fragmentTitle) {
                if (fragmentTitle != null && notificationsHeaderBarTitle != null) {
                    notificationsHeaderBarTitle.setText(fragmentTitle);
                }
            }
        });
        viewModel.getNotifications().observe(getActivity(), new Observer<List<Notification>>() {
            @Override
            public void onChanged(@Nullable List<Notification> notifications) {
                if (notifications != null && adapter != null) {
                    adapter.setNotifications(notifications);
                }
            }
        });
    }

    @Override
    public void onNotificationRowTapped(int index) {
        /*
         * todo
         * You can alter this callback in any way to pass back the data you need from the
         * RecyclerView adapter.
         */
    }
}
