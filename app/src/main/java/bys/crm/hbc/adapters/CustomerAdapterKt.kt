package bys.crm.hbc.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import bys.crm.hbc.R
import bys.crm.hbc.models.Customer
import bys.crm.hbc.models.EventItem

class
CustomerAdapterKt(internal var mContext: Context, internal var mData: List<Customer>) : RecyclerView.Adapter<CustomerAdapterKt.ViewHolder>() {
    private var mOnClickListener: IOnMenuItemClicklistener? = null

    fun setItemListener(listener: IOnMenuItemClicklistener) {
        mOnClickListener = listener
    }

    //    public void setItemSelected(MainActivity.MENU_ITEM itemId){
    //        this.mCurrentMenu = itemId;
    //        notifyDataSetChanged();
    //    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.contact_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menu = mData.get(position);
        //        final MenuItem menu = mData.get(position);
        //        holder.tvName.setText(menu.getName());
        //        holder.imvImage.setImageResource(menu.getResId());
        //        if(mCurrentMenu != null && mCurrentMenu == menu.getId()){
        //            holder.menuGroup.setSelected(true);
        //        } else {
        //            holder.menuGroup.setSelected(false);
        //        }
        //        holder.itemView.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View view) {
        //                mCurrentMenu = menu.getId();
        //                if(mOnClickListener != null){
        //                    mOnClickListener.onItemClick(mCurrentMenu);
        //                }
        //                notifyDataSetChanged();
        //            }
        //        });
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

    //        void onItemClick(MainActivity.MENU_ITEM menuId);
    interface IOnMenuItemClicklistener {
        fun onItemClick(position: Int)
    }


}