package com.ajkueterman.templato.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.ajkueterman.templato.R;
import com.ajkueterman.templato.model.Notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AJ Kueterman on 2/15/18.
 *
 * The Recycler View Adapter for Notifications
 */

public class NotificationsRecyclerViewAdapter extends RecyclerView.Adapter {

    private List<Notification> notifications;
    private NotificationRecyclerViewCallback callback;

    public NotificationsRecyclerViewAdapter(@Nullable List<Notification> notifications,
                                            @NonNull NotificationRecyclerViewCallback callback) {
        if (notifications != null) {
            this.notifications = notifications;
        } else {
            this.notifications = new ArrayList<>();
        }
        this.callback = callback;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_notification_row, parent, false);
        return new NotificationsViewHolder(rowLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final int pos = position;
        if (holder instanceof NotificationsViewHolder && notifications != null && notifications.get(pos) != null) {
            NotificationsViewHolder notificationsViewHolder = (NotificationsViewHolder) holder;
            Notification notification = notifications.get(pos);

            notificationsViewHolder.getSubject().setText(notification.getSubject());
            notificationsViewHolder.getMessage().setText(notification.getMessage());
            notificationsViewHolder.getFrom().setText(notification.getFrom());
            notificationsViewHolder.getTimeStamp().setText(notification.getTimeStamp().toString());

            if (notification.isRead()) {
                notificationsViewHolder.getRead().setChecked(true);
            } else {
                notificationsViewHolder.getRead().setChecked(false);
            }

            notificationsViewHolder.getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    handleRecyclerItemClicked(pos);
                }
            });
        }
    }

    private void handleRecyclerItemClicked(int index) {
        if (notifications.get(index) != null) {
            notifications.get(index).setRead(!notifications.get(index).isRead());
            callback.onNotificationRowTapped(index);
            this.notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
        this.notifyDataSetChanged();
    }

    /**
     *
     * Recycler View Interaction Callback
     */
    public interface NotificationRecyclerViewCallback {
        void onNotificationRowTapped(int index);
    }

    /**
     *
     * Notification ViewHolder
     */
    class NotificationsViewHolder extends RecyclerView.ViewHolder {

        private TextView subject;
        private TextView message;
        private TextView from;
        private TextView timeStamp;
        private CheckBox read;

        NotificationsViewHolder(View itemView) {
            super(itemView);

            subject = itemView.findViewById(R.id.subject);
            message = itemView.findViewById(R.id.message);
            from = itemView.findViewById(R.id.from);
            timeStamp = itemView.findViewById(R.id.timeStamp);
            read = itemView.findViewById(R.id.read);
        }

        View getItemView() {
            return itemView;
        }

        TextView getSubject() {
            return subject;
        }

        TextView getMessage() {
            return message;
        }

        TextView getFrom() {
            return from;
        }

        TextView getTimeStamp() {
            return timeStamp;
        }

        CheckBox getRead() {
            return read;
        }
    }
}
