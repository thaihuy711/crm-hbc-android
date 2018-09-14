package bys.crm.hbc.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import bys.crm.hbc.R
import bys.crm.hbc.models.Customer

class TimelinelAdapter(private val mContext: Context, private val mData: List<Customer>) : RecyclerView.Adapter<TimelinelAdapter.ViewHolder>() {
    private var mOnClickListener: IOnItemClicklistener? = null

    fun setItemListener(listener: IOnItemClicklistener) {
        mOnClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.timeline_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val customer = mData[position]
        //        holder.tvName.setText(customer.getCustomerName());
        //        holder.tvContent.setText(mContext.getString(R.string.txt_customer_infor, StringUtils.getString(mContext, customer.getCustomerEmail1()), StringUtils.getString(mContext, customer.getEmployee() != null ? customer.getEmployee().getEmployeeName() : "")));
        holder.itemView.setOnClickListener {
            if (mOnClickListener != null) {
                mOnClickListener!!.onItemClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        init {

        }
    }


    interface IOnItemClicklistener {
        fun onItemClick(position: Int)
    }
}
