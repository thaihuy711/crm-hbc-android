package bys.crm.hbc.fragments.active.event

import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import bys.crm.hbc.R
import bys.crm.hbc.adapters.EventAdapter
import bys.crm.hbc.fragments.BaseFragment
import bys.crm.hbc.models.EventItem
import kotlinx.android.synthetic.main.fragment_active_event.*

class ActiveEventFragment : BaseFragment() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var mAdapter: EventAdapter
    val mData: ArrayList<EventItem> = ArrayList<EventItem>()
    override fun initLayout(): Int {
        return R.layout.fragment_active_event
    }

    override fun initComponents() {
        linearLayoutManager = LinearLayoutManager(context)
        mData.add(EventItem("Lopes ispum zoho", "27/09/2018", "29/08/2018"))
        mData.add(EventItem("Lopes ispum zoho", "27/09/2018", "29/08/2018"))
        mData.add(EventItem("Lopes ispum zoho", "27/09/2018", "29/08/2018"))
        mData.add(EventItem("Lopes ispum zoho", "27/09/2018", "29/08/2018"))
        mData.add(EventItem("Lopes ispum zoho", "27/09/2018", "29/08/2018"))
        mAdapter = EventAdapter(context, mData);
        rcEvent.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        rcEvent.adapter = mAdapter
    }

    override fun addListener() {
        btnAddEvent.setOnClickListener {
            addFragmentChild(AddEventFragment(EventItem(), false))
        }
        mAdapter.setItemListener(object : EventAdapter.IOnMenuItemClicklistener{
            override fun onItemClick(position: Int) {
                addFragmentChild(AddEventFragment(mData.get(position), true))
            }
        })
    }
}
