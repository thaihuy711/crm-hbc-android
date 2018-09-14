package bys.crm.hbc.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import bys.crm.hbc.R
import bys.crm.hbc.models.EventItem
import bys.crm.hbc.models.NoteItem

class
EventAdapter(internal var mContext: Context, internal var mData: List<EventItem>) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {
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
                .inflate(R.layout.event_item, parent, false))
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
            if(mOnClickListener != null){
                mOnClickListener!!.onItemClick(position)
            }
        }

        holder.tvTitle.setText(menu.title)
        holder.tvStart.setText(menu.start)
        holder.tvEnd.setText(menu.end)
    }

    override fun getItemCount(): Int {
        return mData.size
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //        public var tvName: TextView
//        public var imvImage: ImageView
//        public var menuGroup: View
        public lateinit var tvStatus: TextView
        public lateinit var tvTitle: TextView
        public lateinit var tvStart: TextView
        public lateinit var tvEnd: TextView


        init {
//            tvName = view.findViewById(R.id.tv_item) as TextView
//            tvName.isSelected = true
//            imvImage = view.findViewById(R.id.imv_item) as ImageView
//            menuGroup = view.findViewById(R.id.menu_group)
            tvStatus = view.findViewById(R.id.tvStatus)
            tvTitle = view.findViewById(R.id.tvTitle)
            tvStart = view.findViewById(R.id.tvStart)
            tvEnd = view.findViewById(R.id.tvEnd)
        }
    }

    //        void onItemClick(MainActivity.MENU_ITEM menuId);
    interface IOnMenuItemClicklistener {
        fun onItemClick(position: Int)
    }
}
