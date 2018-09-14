package bys.crm.hbc.activities

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import bys.crm.hbc.R
import kotlinx.android.synthetic.main.activity_edit_customer.*

class AddEditCustomerActivity : BaseActivity(), View.OnClickListener {
  override fun initLayout(): Int {
    return R.layout.activity_edit_customer
  }

  override fun initComponents() {
  }

  override fun addListener() {
    imv_back.setOnClickListener {
      finish()

    }

    btnExpand.setOnClickListener {
      btnExpand.setVisibility(GONE)
      btnCollapse.setVisibility(View.VISIBLE)
      group_assigner.setVisibility(VISIBLE)
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
