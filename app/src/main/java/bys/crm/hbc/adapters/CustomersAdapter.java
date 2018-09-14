package bys.crm.hbc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bys.crm.hbc.R;
import bys.crm.hbc.models.Customer;
import bys.crm.hbc.models.User;
import bys.crm.hbc.utils.StringUtils;

public class CustomersAdapter extends RecyclerView.Adapter<CustomersAdapter.ViewHolder> {
    private List<Customer> mData;
    private Context mContext;
    private IOnItemClicklistener mOnClickListener;

    public CustomersAdapter(Context context, List<Customer> data) {
        this.mData = data;
        this.mContext = context;
    }

    public void setItemListener(IOnItemClicklistener listener) {
        mOnClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Customer customer = mData.get(position);
//        holder.tvName.setText(customer.getCustomerName());
//        holder.tvContent.setText(mContext.getString(R.string.txt_customer_infor, StringUtils.getString(mContext, customer.getCustomerEmail1()), StringUtils.getString(mContext, customer.getEmployee() != null ? customer.getEmployee().getEmployeeName() : "")));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnClickListener != null) {
                    mOnClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imvAvatar;
        TextView tvName, tvContent;


        public ViewHolder(View view) {
            super(view);
            imvAvatar = view.findViewById(R.id.imv_avatar);
            tvName = view.findViewById(R.id.tv_name);
            tvContent = view.findViewById(R.id.tv_content);
        }
    }


    public interface IOnItemClicklistener {
        void onItemClick(int position);
    }
}
