package bys.crm.hbc.fragments.contact.personal

import android.view.View.GONE
import android.view.View.VISIBLE
import bys.crm.hbc.R
import bys.crm.hbc.fragments.BaseFragment
import kotlinx.android.synthetic.main.info_personal_layout.*

class ActiveInfoFragment : BaseFragment() {
  override fun initLayout(): Int {
    return R.layout.info_personal_layout
  }

  override fun initComponents() {

  }

  override fun addListener() {
    btnExpand.setOnClickListener {
      btnExpand.setVisibility(GONE)
      btnCollapse.setVisibility(VISIBLE)
      layout_department_room.setVisibility(VISIBLE)
      group_assigner.setVisibility(VISIBLE)
      layout_below_city.setVisibility(VISIBLE)
    }
    btnCollapse.setOnClickListener {
      btnCollapse.setVisibility(GONE)
      btnExpand.setVisibility(VISIBLE)
      layout_department_room.setVisibility(GONE)
      group_assigner.setVisibility(GONE)
      layout_below_city.setVisibility(GONE)
    }
  }
}
