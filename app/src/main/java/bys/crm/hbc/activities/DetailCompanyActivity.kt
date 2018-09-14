package bys.crm.hbc.activities

import android.content.Intent
import android.view.View
import bys.crm.hbc.R
import bys.crm.hbc.fragments.contact.company.ActiveInfoCompanyFragment
import bys.crm.hbc.fragments.contact.company.ActiveTimelineCompany
import bys.crm.hbc.fragments.contact.personal.ActiveInfoFragment
import bys.crm.hbc.fragments.contact.personal.ActiveTimelineFragment
import kotlinx.android.synthetic.main.activity_detail_customer.*

class DetailCompanyActivity: BaseActivity(), View.OnClickListener {
    private lateinit var mCurrentTab: View
    override fun initLayout(): Int {
        return R.layout.activity_detail_customer
    }

    override fun initComponents() {
        mCurrentTab = btnTimeline
        mCurrentTab.isSelected = true
        setNewPage(ActiveTimelineFragment())
    }

    override fun addListener() {
        imvBack.setOnClickListener{
            finish()
        }
        btnTimeline.setOnClickListener(this)
        btnInfo.setOnClickListener(this)
        imv_edit.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when (p0) {
            btnTimeline -> {
                mCurrentTab.isSelected = false
                mCurrentTab = p0
                mCurrentTab.isSelected = true
                setNewPage(ActiveTimelineCompany())
            }
            btnInfo -> {
                mCurrentTab.isSelected = false
                mCurrentTab = p0
                mCurrentTab.isSelected = true
                setNewPage(ActiveInfoCompanyFragment())
            }
            imv_edit -> {
                val i = Intent(this, AddEditCompanyActivity::class.java)
                startActivity(i)
            }
        }
    }

}