package com.example.homelayout.ui.workshops;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homelayout.R;
import com.example.homelayout.domain.TranslationsObject;
import com.example.homelayout.domain.WorkshopPictureObject;
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.domain.WorkshopsObject;
import com.example.homelayout.repositories.TinyDB;
import com.example.homelayout.ui.shoppingcart.ShoppingCartWorkshopAdapter;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkshopCategoryAdapter extends RecyclerView.Adapter<WorkshopCategoryAdapter.WorkshopCategoryHolder> implements Serializable {
    private List<WorkshopsObject> workshopsObjectList;

    public WorkshopCategoryAdapter(List<WorkshopsObject> workshopsObjectList) {
        this.workshopsObjectList = workshopsObjectList;
    }

    @Override
    public WorkshopCategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.fragment_single_workshop;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);
        return new WorkshopCategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(WorkshopCategoryHolder holder, int position) {
        WorkshopsObject workshopsObject = workshopsObjectList.get(position);
        List<TranslationsObject> translationsObjects = workshopsObject.getTranslationsObjects();
        WorkshopPictureObject[] workshopPictureObject = workshopsObject.getPictureObject();
            try {
                Log.d("onBindViewHolder : ", workshopsObject.getPictureObject().toString());
                if (workshopPictureObject[0].getBlob() != null) {
                    holder.mImageWorkshop.setImageBitmap(workshopPictureObject[0]
                            .getBlob()
                            .convertBlobIntoImage());
                }
                if (workshopsObject.getCodeName() != null) {
                    holder.mTitleWorkshop.setText(workshopsObject.getCodeName().split("Skool")[1]);
                }
                if (translationsObjects.get(1).getTranslation() != null) {
                    holder.mDescriptionWorkshop.setText((translationsObjects.get(1).getTranslation()));
                }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        if (workshopsObjectList == null) {
            return 0;
        }
        return workshopsObjectList.size();
    }

    public class WorkshopCategoryHolder extends RecyclerView.ViewHolder {
        private ImageView mImageWorkshop;
        private TextView mTitleWorkshop;
        private TextView mDescriptionWorkshop;

        public WorkshopCategoryHolder(@NonNull View view) {
            super(view);
            mImageWorkshop = view.findViewById(R.id.iv_workshop_image_workshop);
            mTitleWorkshop = view.findViewById(R.id.tv_workshop_title_workshop);
            mDescriptionWorkshop = view.findViewById(R.id.tv_workhop_description);
        }
    }

    public void getNameRight(){

    }
}
