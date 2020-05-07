package com.example.managemoney.UI.Adapter;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.managemoney.Data.Entity.FinancialActivity;
import com.example.managemoney.R;
import com.example.managemoney.ViewModel.FinancialActivityViewModel;

import java.util.List;


public class MyListFinancialActivityRecyclerViewAdapter extends RecyclerView.Adapter<MyListFinancialActivityRecyclerViewAdapter.ViewHolder> {

    private final List<FinancialActivity> mValues;
    private FinancialActivityViewModel financialActivityViewModel;
    private Context mCtx;

    public MyListFinancialActivityRecyclerViewAdapter(Context ctx, List<FinancialActivity> items) {
        mValues = items;
        mCtx = ctx;
        financialActivityViewModel = new ViewModelProvider((FragmentActivity) mCtx).get(FinancialActivityViewModel.class);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_list_financial_activity_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.mDate.setText(holder.mItem.getDate());
        holder.mValue.setText("$ " + holder.mItem.getValue());
        holder.mDescription.setText(holder.mItem.getDescription());
        if(holder.mItem.isEntry()){
            holder.mContainer.setBackgroundColor(Color.GREEN);
        }else{
            holder.mContainer.setBackgroundColor(Color.RED);
            holder.mDate.setTextColor(Color.WHITE);
            holder.mValue.setTextColor(Color.WHITE);
            holder.mDescription.setTextColor(Color.WHITE);
        }

        // add listener to delete
        holder.mDelete.setOnClickListener(view -> {
            financialActivityViewModel.deleteFinancialActivity(holder.mItem);
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public FinancialActivity mItem;

        public final TextView mDate, mValue, mDescription;
        public final ImageView mDelete;
        public final ConstraintLayout mContainer;


        public ViewHolder(View view) {
            super(view);
            mView = view;

            mDate = view.findViewById(R.id.textViewDate);
            mValue = view.findViewById(R.id.textViewValue);
            mDelete = view.findViewById(R.id.imageViewDelete);
            mContainer = view.findViewById(R.id.financialActivityContainer);
            mDescription = view.findViewById(R.id.textViewDescription);
        }

    }
}
