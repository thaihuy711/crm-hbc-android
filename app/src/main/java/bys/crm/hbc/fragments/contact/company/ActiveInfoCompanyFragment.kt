package bys.crm.hbc.fragments.contact.company

import android.view.View
import bys.crm.hbc.R
import bys.crm.hbc.fragments.BaseFragment
import kotlinx.android.synthetic.main.info_company_fragment.*

class ActiveInfoCompanyFragment : BaseFragment(), View.OnClickListener {
  override fun initLayout(): Int {
    return R.layout.info_company_fragment
  }

  override fun initComponents() {
  }

  override fun addListener() {

    btnExpand.setOnClickListener {
      btnExpand.setVisibility(View.GONE)
      btnCollapse.setVisibility(View.VISIBLE)
      layout_id.setVisibility(View.VISIBLE)
      layout_contact.setVisibility(View.VISIBLE)
      layout_revenue.setVisibility(View.VISIBLE)
      layout_room.setVisibility(View.VISIBLE)
      layout_below_city.setVisibility(View.VISIBLE)
      line_below_city.setVisibility(View.VISIBLE)
    }
    btnCollapse.setOnClickListener {
      btnExpand.setVisibility(View.VISIBLE)
      btnCollapse.setVisibility(View.GONE)
      layout_id.setVisibility(View.GONE)
      layout_contact.setVisibility(View.GONE)
      layout_revenue.setVisibility(View.GONE)
      layout_room.setVisibility(View.GONE)
      layout_below_city.setVisibility(View.GONE)
      line_below_city.setVisibility(View.GONE)
    }

  }

  override fun onClick(p0: View?) {
  }

}