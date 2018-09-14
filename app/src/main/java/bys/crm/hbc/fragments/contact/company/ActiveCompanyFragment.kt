package bys.crm.hbc.fragments.contact.company

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import bys.crm.hbc.R
import bys.crm.hbc.activities.DetailCompanyActivity
import bys.crm.hbc.activities.NewCompanyActivity
import bys.crm.hbc.adapters.CompanyAdapter
import bys.crm.hbc.fragments.BaseFragment
import bys.crm.hbc.models.Customer
import kotlinx.android.synthetic.main.fragment_add_company.*

class ActiveCompanyFragment : BaseFragment(), View.OnClickListener {

  private lateinit var linearLayoutManager: LinearLayoutManager
  private lateinit var mAdapter: CompanyAdapter
  val mData: ArrayList<Customer> = ArrayList<Customer>()
  override fun initLayout(): Int {
    return R.layout.fragment_add_company
  }

  override fun initComponents() {
    linearLayoutManager = LinearLayoutManager(context)
    mData.add(Customer())
    mData.add(Customer())
    mData.add(Customer())
    mData.add(Customer())
    mData.add(Customer())
    mAdapter = CompanyAdapter(context, mData);
    rcMain.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
    rcMain.adapter = mAdapter
  }

  override fun addListener() {
    btnAddCompany.setVisibility(View.VISIBLE)
    btnAddCompany.setOnClickListener {
      if (btnAddCompany.isOpened) {
        btnAddCompany.close(true)
      }
    }
    mAdapter.setItemListener(object : CompanyAdapter.IOnMenuItemClicklistener {
      override fun onItemClick(position: Int) {
        val i = Intent(mContext, DetailCompanyActivity::class.java)
        startActivity(i)
      }
    })
    btnNewContactCompany.setOnClickListener(this)
    btnScanCompany.setOnClickListener(this)
    btnNewDirectoryCompany.setOnClickListener(this)
  }

  override fun onClick(p0: View?) {
    if (p0 == btnNewContactCompany) {
      val i = Intent(mContext, NewCompanyActivity::class.java)
      startActivity(i)
    } else if (p0 == btnScanCompany) {
      Toast.makeText(context, "Scan", Toast.LENGTH_LONG).show()
    } else {
      Toast.makeText(context, "Create Contact", Toast.LENGTH_LONG).show()
    }
    btnAddCompany.close(true)
  }
}
