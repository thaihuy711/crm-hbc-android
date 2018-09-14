package bys.crm.hbc.fragments.active.work

import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import bys.crm.hbc.R
import bys.crm.hbc.adapters.WorkAdapter
import bys.crm.hbc.fragments.BaseFragment
import bys.crm.hbc.models.EventItem
import kotlinx.android.synthetic.main.fragment_active_work.*

class ActiveWorkFragment : BaseFragment() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var mAdapter: WorkAdapter
    val newsList: ArrayList<EventItem> = ArrayList<EventItem>()
    override fun initLayout(): Int {
        return R.layout.fragment_active_work
    }

    override fun initComponents() {
        linearLayoutManager = LinearLayoutManager(context)

        newsList.add(EventItem("Lopes ispum zoho", "27/09/2018", "29/08/2018"))
        newsList.add(EventItem("Lopes ispum zoho", "27/09/2018", "27/09/2018"))
        newsList.add(EventItem("Lopes ispum zoho", "27/09/2018", "29/08/2018"))
        mAdapter = WorkAdapter(context, newsList)
        rcWork.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        rcWork.adapter = mAdapter

    }

    override fun addListener() {
        btnAddWork.setOnClickListener {
            addFragmentChild(AddWorkFragment(EventItem(), false))
        }
        mAdapter.setItemListener(object : WorkAdapter.IOnMenuItemClicklistener {
            override fun onItemClick(position: Int) {
                addFragmentChild(AddWorkFragment(newsList.get(position), true))
            }
        })

    }
}
