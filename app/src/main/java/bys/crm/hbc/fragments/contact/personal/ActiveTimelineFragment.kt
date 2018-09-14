package bys.crm.hbc.fragments.contact.personal

import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.widget.LinearLayout
import bys.crm.hbc.R
import bys.crm.hbc.adapters.TimelinelAdapter
import bys.crm.hbc.fragments.BaseFragment
import bys.crm.hbc.models.Customer
import kotlinx.android.synthetic.main.nav_fragment_add.*

class ActiveTimelineFragment : BaseFragment() {
  private lateinit var linearLayoutManager: LinearLayoutManager
  private lateinit var mAdapter: TimelinelAdapter
  val mData: ArrayList<Customer> = ArrayList<Customer>()
  override fun initLayout(): Int {
    return R.layout.nav_fragment_add
  }

  override fun initComponents() {
    btnAddPersonal.setVisibility(GONE)
    linearLayoutManager = LinearLayoutManager(context)
    mData.add(Customer())
    mData.add(Customer())
    mData.add(Customer())
    mData.add(Customer())
    mData.add(Customer())
    mAdapter = TimelinelAdapter(context, mData);
    rcMain.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
    rcMain.adapter = mAdapter
  }

  override fun addListener() {

  }
}