package bys.crm.hbc.activities

import android.view.View
import bys.crm.hbc.R
import kotlinx.android.synthetic.main.activity_edit_customer.*

class NewCustomerActivity : BaseActivity(), View.OnClickListener {
  override fun initLayout(): Int {
    return R.layout.activity_edit_customer
  }

  override fun initComponents() {
  }

  override fun addListener() {
    imv_back.setOnClickListener {
      finish()

    }
    btnDelete.setVisibility(View.GONE)

    btnExpand.setOnClickListener {
      btnExpand.setVisibility(View.GONE)
      btnCollapse.setVisibility(View.VISIBLE)
      group_assigner.setVisibility(View.VISIBLE)
      layout_below_city.setVisibility(View.VISIBLE)
      line_below_city.setVisibility(View.VISIBLE)
    }
    btnCollapse.setOnClickListener {
      btnExpand.setVisibility(View.VISIBLE)
      btnCollapse.setVisibility(View.GONE)
      group_assigner.setVisibility(View.GONE)
      layout_below_city.setVisibility(View.GONE)
      line_below_city.setVisibility(View.GONE)
    }
  }

  override fun onClick(p0: View?) {
  }

}