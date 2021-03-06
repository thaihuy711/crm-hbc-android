package bys.crm.hbc.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import bys.crm.hbc.R
import bys.crm.hbc.models.NoteItem
import com.theironingboard.material.widget.FloatingActionButton

class NoteAdapter(internal var mContext: Context, internal var mData: List<NoteItem>) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
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
                .inflate(R.layout.note_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menu = mData.get(position)
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
        holder.itemView.setOnClickListener { }

    }


    override fun getItemCount(): Int {
        return mData.size
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //        public var tvName: TextView
//        public var imvImage: ImageView
//        public var menuGroup: View
        public lateinit var tvNote: TextView
        public lateinit var tvDate: TextView
        public lateinit var tvTime: TextView


        init {
//            tvName = view.findViewById(R.id.tv_item) as TextView
//            tvName.isSelected = true
//            imvImage = view.findViewById(R.id.imv_item) as ImageView
//            menuGroup = view.findViewById(R.id.menu_group)
            tvNote = view.findViewById(R.id.note)
            tvDate = view.findViewById(R.id.date)
            tvTime = view.findViewById(R.id.time)



        }
    }


    interface IOnMenuItemClicklistener//        void onItemClick(MainActivity.MENU_ITEM menuId);

}