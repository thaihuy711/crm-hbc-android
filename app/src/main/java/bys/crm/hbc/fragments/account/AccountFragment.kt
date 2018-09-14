package bys.crm.hbc.fragments.account

import android.view.View
import bys.crm.hbc.R
import bys.crm.hbc.api.ApiListener
import bys.crm.hbc.fragments.BaseFragment
import bys.crm.hbc.tasks.BaseTask
import java.lang.Exception

class AccountFragment : BaseFragment(), View.OnClickListener, ApiListener<Any>{


    override fun initLayout(): Int {
        return R.layout.fragment_account
    }

    override fun initComponents() {

    }

    override fun addListener() {

    }

    override fun onClick(p0: View?) {

    }

    override fun onConnectionOpen(task: BaseTask<*>?) {
    }

    override fun onConnectionSuccess(task: BaseTask<*>?, data: Any?) {
    }

    override fun onConnectionError(task: BaseTask<*>?, exception: Exception?) {
    }

}
