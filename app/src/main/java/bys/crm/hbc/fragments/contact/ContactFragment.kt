package bys.crm.hbc.fragments.contact

import android.view.View
import bys.crm.hbc.R
import bys.crm.hbc.api.ApiListener
import bys.crm.hbc.fragments.BaseFragment
import bys.crm.hbc.fragments.contact.company.ActiveCompanyFragment
import bys.crm.hbc.fragments.contact.personal.ActivePersonalFragment
import bys.crm.hbc.tasks.BaseTask
import kotlinx.android.synthetic.main.fragment_contact.*
import java.lang.Exception

class ContactFragment : BaseFragment(), View.OnClickListener, ApiListener<Any>{
    private lateinit var mCurrentTab: View

    override fun initLayout(): Int {
        return R.layout.fragment_contact
    }

    override fun initComponents() {
        mCurrentTab = btnPersonal
        mCurrentTab.isSelected = true
        setNewPageChild(ActivePersonalFragment())
    }

    override fun addListener() {
        btnPersonal.setOnClickListener(this)
        btnCompany.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when (p0) {
            btnPersonal -> {
                mCurrentTab.isSelected = false
                mCurrentTab = p0
                mCurrentTab.isSelected = true
                setNewPageChild(ActivePersonalFragment())
            }
            btnCompany -> {
                mCurrentTab.isSelected = false
                mCurrentTab = p0
                mCurrentTab.isSelected = true
                setNewPageChild(ActiveCompanyFragment())
            }
        }
    }

    override fun onConnectionOpen(task: BaseTask<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onConnectionSuccess(task: BaseTask<*>?, data: Any?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onConnectionError(task: BaseTask<*>?, exception: Exception?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
