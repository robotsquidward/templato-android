package com.ajkueterman.templato.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ajkueterman.templato.R;
import com.ajkueterman.templato.viewmodel.MainViewModel;

/**
 * Created by AJ Kueterman on 2/15/18.
 *
 * Dashboard screen
 */

public class DashboardFragment extends Fragment {

    private TextView placeholderText;

    private MainViewModel viewModel;

    public static DashboardFragment newInstance() {
        Bundle args = new Bundle();
        DashboardFragment fragment = new DashboardFragment();
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
        View inflatedView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        placeholderText = inflatedView.findViewById(R.id.message);
        initTextView();
        return inflatedView;
    }

    private void initTextView() {
        if (viewModel != null && viewModel.getCurrentFragmentTitle() != null &&
                viewModel.getCurrentFragmentTitle().getValue() != null) {
            placeholderText.setText(viewModel.getCurrentFragmentTitle().getValue());
        }
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
                if (fragmentTitle != null && placeholderText != null) {
                    placeholderText.setText(fragmentTitle);
                }
            }
        });
    }
}
