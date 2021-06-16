package com.example.homelayout.ui.workshops;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

import com.example.homelayout.domain.WorkshopsObject;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Pattern;

public class WorkshopCategoryAdapter extends RecyclerView.Adapter<WorkshopCategoryAdapter.WorkshopCategoryHolder> implements Serializable {
    private List<WorkshopsObject> workshopsObjectList;
    private Context context;

    public WorkshopCategoryAdapter(List<WorkshopsObject> workshopsObjectList, Context context) {
        this.workshopsObjectList = workshopsObjectList;
        this.context = context;
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
                    Pattern p = Pattern.compile("(?=\\p{Lu})");
                    String codeName = workshopsObject.getCodeName();
                    String[] codeNameWithoutSkool = codeName.split("Skool");
                    String[] rightName = p.split(codeNameWithoutSkool[1]);
                    holder.mTitleWorkshop.setText("Workshop " + rightName[0]);
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
        private ImageButton mInfoImageButton;

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
