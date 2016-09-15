package com.example.tonyjm.ubarodemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tonyjm on 9/6/16.
 */
public class TransactionListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Transaction> mTransactionList;

    public TransactionListAdapter(Context mContext, List<Transaction> mTransactionList) {
        this.mContext = mContext;
        this.mTransactionList = mTransactionList;
    }

    @Override
    public int getCount() {
        return mTransactionList.size();
    }

    @Override
    public Object getItem(int position) {
        return mTransactionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.latest_transactions_list, null);
        TextView tvName = (TextView)v.findViewById(R.id.tvName);
        TextView tvDate = (TextView)v.findViewById(R.id.tvDate);
        TextView tvAmount = (TextView)v.findViewById(R.id.tvAmount);

        tvName.setText(mTransactionList.get(position).getName());
        tvDate.setText("$"+mTransactionList.get(position).getDate());
        tvAmount.setText(mTransactionList.get(position).getAmount());

        v.setTag(mTransactionList.get(position).getId());
        return v;
    }
}
