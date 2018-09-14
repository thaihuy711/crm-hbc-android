package bys.crm.hbc.fragments.active.event

import android.annotation.SuppressLint
import android.view.View
import android.widget.Toast
import bys.crm.hbc.R
import bys.crm.hbc.fragments.BaseFragment
import bys.crm.hbc.models.EventItem
import kotlinx.android.synthetic.main.detail_event_item.*

@SuppressLint("ValidFragment")
class AddEventFragment(internal var mEvent: EventItem, internal var mCheck: Boolean) : BaseFragment() {
    override fun initLayout(): Int {
        return R.layout.detail_event_item
    }

    override fun initComponents() {
        if (mCheck) {

        } else {
            btnDelete.setVisibility(View.GONE)
        }
        tvTitle.setText(mEvent.title)
        tvStart.setText(mEvent.start)
        tvEnd.setText(mEvent.end)
    }

    override fun addListener() {
        btnBack.setOnClickListener {
            backFragment()
        }
        btnDelete.setOnClickListener {
            Toast.makeText(context, "Delete", Toast.LENGTH_LONG).show()
        }
        btnSave.setOnClickListener {
            Toast.makeText(context, "Save", Toast.LENGTH_LONG).show()
        }
    }
}
