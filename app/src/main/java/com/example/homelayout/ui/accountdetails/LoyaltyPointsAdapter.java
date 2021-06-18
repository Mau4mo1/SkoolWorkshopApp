package com.example.homelayout.ui.accountdetails;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homelayout.R;
import com.example.homelayout.domain.LoyaltyPointsObject;
import com.example.homelayout.repositories.TinyDB;
import com.example.homelayout.ui.shoppingcart.ShoppingCartWorkshopAdapter;
import com.example.homelayout.ui.workshops.WorkshopsFragment;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class LoyaltyPointsAdapter extends RecyclerView.Adapter<LoyaltyPointsAdapter.LoyaltyPointsViewHolder> implements Serializable{
    private ArrayList<Object> loyaltyPointsData = new ArrayList<>();
    private TinyDB tinyDB;

    public LoyaltyPointsAdapter(ArrayList<Object> loyaltyPointsData) {
        this.loyaltyPointsData = loyaltyPointsData;
    }

    @Override
    public LoyaltyPointsAdapter.LoyaltyPointsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        tinyDB = new TinyDB(context);
        int layoutIdForListItem = R.layout.fragment_loyalty_points_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, false);
        return new LoyaltyPointsAdapter.LoyaltyPointsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoyaltyPointsAdapter.LoyaltyPointsViewHolder holder, int position) {
        LoyaltyPointsObject LoyaltyPointsObject = (LoyaltyPointsObject) loyaltyPointsData.get(position);
        holder.mDate.setText(String.valueOf(LoyaltyPointsObject.getDate()));
        holder.mAction.setText(String.valueOf(LoyaltyPointsObject.getAction()));
        holder.mOrderNumber.setText(String.valueOf("#" + LoyaltyPointsObject.getOrderNumber()));
        holder.mLoyaltyPoints.setText(String.valueOf(LoyaltyPointsObject.getLoyaltyPoints()));
    }

    public class LoyaltyPointsViewHolder extends RecyclerView.ViewHolder {
        private TextView mDate;
        private TextView mAction;
        private TextView mOrderNumber;
        private TextView mLoyaltyPoints;
        public LoyaltyPointsViewHolder(@NonNull View view) {
            super(view);
            mDate = (TextView) itemView.findViewById(R.id.loyalty_points_date);
            mAction = (TextView) itemView.findViewById(R.id.loyalty_points_action);
            mOrderNumber = (TextView) itemView.findViewById(R.id.loyalty_points_order_number);
            mLoyaltyPoints = (TextView) itemView.findViewById(R.id.loyalty_points_points);
        }
    }

    @Override
        public int getItemCount() {
            if (loyaltyPointsData == null) {
            return 0;
            }
            return loyaltyPointsData.size();
        }
}
