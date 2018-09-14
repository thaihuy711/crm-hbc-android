package bys.crm.hbc.activities

import android.view.View
import bys.crm.hbc.R
import kotlinx.android.synthetic.main.activity_edit_company.*

class AddEditCompanyActivity : BaseActivity(), View.OnClickListener {
  override fun initLayout(): Int {
    return R.layout.activity_edit_company
  }

  override fun initComponents() {
  }

  override fun addListener() {
    imv_back.setOnClickListener {
      finish()
    }
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