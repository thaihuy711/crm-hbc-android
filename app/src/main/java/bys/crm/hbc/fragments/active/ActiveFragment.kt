package bys.crm.hbc.fragments.active

import android.view.View
import bys.crm.hbc.R
import bys.crm.hbc.api.ApiListener
import bys.crm.hbc.fragments.BaseFragment
import bys.crm.hbc.fragments.active.event.ActiveEventFragment
import bys.crm.hbc.fragments.active.note.ActiveNoteFragment
import bys.crm.hbc.fragments.active.work.ActiveWorkFragment
import bys.crm.hbc.tasks.BaseTask
import kotlinx.android.synthetic.main.fragment_active.*
import java.lang.Exception

class ActiveFragment : BaseFragment(), View.OnClickListener, ApiListener<Any> {

    private lateinit var mCurrentTab: View

    override fun initLayout(): Int {
        return R.layout.fragment_active
    }

    override fun initComponents() {
        mCurrentTab = btn_tab_note
        mCurrentTab.isSelected = true
        setNewPageChild(ActiveNoteFragment())
    }

    override fun addListener() {
        btn_tab_event.setOnClickListener(this)
        btn_tab_note.setOnClickListener(this)
        btn_tab_work.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when (p0) {
            btn_tab_note -> {
                mCurrentTab.isSelected = false
                mCurrentTab = p0
                mCurrentTab.isSelected = true
                setNewPageChild(ActiveNoteFragment())
            }
            btn_tab_event -> {
                mCurrentTab.isSelected = false
                mCurrentTab = p0
                mCurrentTab.isSelected = true
                setNewPageChild(ActiveEventFragment())
            }
            btn_tab_work -> {
                mCurrentTab.isSelected = false
                mCurrentTab = p0
                mCurrentTab.isSelected = true
                setNewPageChild(ActiveWorkFragment())
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
