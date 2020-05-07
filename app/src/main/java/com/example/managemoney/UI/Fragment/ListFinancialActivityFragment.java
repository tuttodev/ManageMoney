package com.example.managemoney.UI.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.managemoney.R;
import com.example.managemoney.UI.Adapter.MyListFinancialActivityRecyclerViewAdapter;
import com.example.managemoney.ViewModel.FinancialActivityViewModel;


public class ListFinancialActivityFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private MyListFinancialActivityRecyclerViewAdapter mAdapter;
    private  RecyclerView recyclerView;
    private Context context;
    private FinancialActivityViewModel financialActivityViewModel;

    public ListFinancialActivityFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ListFinancialActivityFragment newInstance(int columnCount) {
        ListFinancialActivityFragment fragment = new ListFinancialActivityFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_financial_activity_list, container, false);
        financialActivityViewModel = new ViewModelProvider(getActivity()).get(FinancialActivityViewModel.class);

        // Set the adapter
        if (view instanceof RecyclerView) {
            context = view.getContext();
            recyclerView = view.findViewById(R.id.list);

            financialActivityViewModel.getAllFinancialActivities().observe(getActivity(), financialActivitiesList -> {

                mAdapter = new MyListFinancialActivityRecyclerViewAdapter(context, financialActivitiesList);
                recyclerView.setAdapter(mAdapter);

            });


        }
        return view;
    }

}
