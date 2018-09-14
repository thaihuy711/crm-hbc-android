package bys.crm.hbc.fragments.contact.personal

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import bys.crm.hbc.R
import bys.crm.hbc.activities.DetailCustomerActivity
import bys.crm.hbc.activities.NewCustomerActivity
import bys.crm.hbc.adapters.CustomerAdapterKt
import bys.crm.hbc.fragments.BaseFragment
import bys.crm.hbc.models.Customer
import bys.crm.hbc.utils.Constants
import kotlinx.android.synthetic.main.nav_fragment_add.*

class ActivePersonalFragment : BaseFragment(), View.OnClickListener {

  var RQ_ADD_CUSTOMER = 2224

  private lateinit var linearLayoutManager: LinearLayoutManager
  private lateinit var mAdapter: CustomerAdapterKt
  val mData: ArrayList<Customer> = ArrayList<Customer>()
  override fun initLayout(): Int {
    return R.layout.nav_fragment_add
  }

  override fun initComponents() {
    linearLayoutManager = LinearLayoutManager(context)
    mData.add(Customer())
    mData.add(Customer())
    mData.add(Customer())
    mData.add(Customer())
    mData.add(Customer())
    mAdapter = CustomerAdapterKt(context, mData);
    rcMain.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
    rcMain.adapter = mAdapter
  }

  override fun addListener() {
//        btnAddEvent.setOnClickListener {
//            addFragmentChild(AddEventFragment(EventItem(), false))
//        }
    mAdapter.setItemListener(object : CustomerAdapterKt.IOnMenuItemClicklistener {
      override fun onItemClick(position: Int) {
        val i = Intent(mContext, DetailCustomerActivity::class.java)
        i.putExtra(Constants.PREF_CUSTOMER, mData.get(position))
        startActivity(i)
      }
    })
    btnAddPersonal.setOnClickListener {
      if (btnAddPersonal.isOpened) {
        btnAddPersonal.close(true)
      }
    }
    btnNewContactPersonal.setOnClickListener(this)
    btnScanPersonal.setOnClickListener(this)
    btnNewDirectoryPersonal.setOnClickListener(this)
  }

  override fun onClick(p0: View?) {
    if (p0 == btnNewContactPersonal) {
      val i = Intent(mContext, NewCustomerActivity::class.java)
      startActivity(i)
    } else if (p0 == btnScanPersonal) {
      Toast.makeText(context, "Scan", Toast.LENGTH_LONG).show()
    } else {
      Toast.makeText(context, "Scan", Toast.LENGTH_LONG).show()
    }
    btnAddPersonal.close(true)
  }
}
