package com.example.homelayout.ui.shoppingcart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homelayout.R;
import com.example.homelayout.domain.WorkshopBooking;
import com.example.homelayout.repositories.TinyDB;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShoppingCartWorkshopAdapter extends RecyclerView.Adapter<ShoppingCartWorkshopAdapter.WorkshopViewHolder> implements Serializable {
    private ArrayList<Object> workshopData = new ArrayList<>();
    private TinyDB tinyDB;

    public ShoppingCartWorkshopAdapter(ArrayList<Object> workshopData) {
        this.workshopData = workshopData;

    }

    @Override
    public WorkshopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        tinyDB = new TinyDB(context);
        int layoutIdForListItem = R.layout.fragment_shopping_cart_workshop;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, false);
        return new WorkshopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkshopViewHolder holder, int position) {
        WorkshopBooking workshopBooking = (WorkshopBooking) workshopData.get(position);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String prijs = decimalFormat.format(workshopBooking.getPrice());
        holder.mService.setText(String.valueOf(workshopBooking.getService()));
        holder.mRounds.setText(String.valueOf(workshopBooking.getRounds()));
        holder.mMinutes.setText(String.valueOf(workshopBooking.getMinutes()));
        holder.mTotalMinutes.setText(String.valueOf(workshopBooking.getTotalMinutes()));
        holder.mTimeTable.setText(String.valueOf(workshopBooking.getTimeTable()));
        holder.mLearningLevel.setText(String.valueOf(workshopBooking.getLearningLevel()));
        holder.mDate.setText(String.valueOf(workshopBooking.getDate()));
        holder.mPrice.setText("€" + prijs);
        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workshopData.remove(workshopData.get(position));
                tinyDB.putListObject("Carditems", workshopData);
                notifyDataSetChanged();

            }
        });
    }

    public class WorkshopViewHolder extends RecyclerView.ViewHolder {
        private TextView mService;
        private TextView mRounds;
        private TextView mMinutes;
        private TextView mTotalMinutes;
        private TextView mTimeTable;
        private TextView mLearningLevel;
        private TextView mDate;
        private TextView mPrice;
        private ImageButton mButton;
        public WorkshopViewHolder(@NonNull View view) {
            super(view);
            mService = (TextView) itemView.findViewById(R.id.shopping_cart_service);
            mRounds = (TextView) itemView.findViewById(R.id.shopping_cart_rounds);
            mMinutes = (TextView) itemView.findViewById(R.id.shopping_cart_minutes);
            mTotalMinutes = (TextView) itemView.findViewById(R.id.shopping_cart_total_minutes);
            mTimeTable = (TextView) itemView.findViewById(R.id.shopping_cart_timetable);
            mLearningLevel = (TextView) itemView.findViewById(R.id.shopping_cart_learninglevel);
            mDate = (TextView) itemView.findViewById(R.id.shopping_cart_date);
            mPrice = (TextView) itemView.findViewById(R.id.shopping_cart_price);
            mButton = (ImageButton) itemView.findViewById(R.id.btn_delete_workshop);
        }
    }

    @Override
        public int getItemCount() {
            if (workshopData == null) {
                return 0;
            }
            return workshopData.size();
        }
}
