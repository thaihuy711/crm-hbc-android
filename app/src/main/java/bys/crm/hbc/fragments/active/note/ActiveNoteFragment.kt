package bys.crm.hbc.fragments.active.note

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.EditText
import android.widget.LinearLayout
import bys.crm.hbc.R
import bys.crm.hbc.activities.CustomDialogActivity
import bys.crm.hbc.adapters.NoteAdapter
import bys.crm.hbc.fragments.BaseFragment
import bys.crm.hbc.models.NoteItem
import kotlinx.android.synthetic.main.fragment_active_note.*

class ActiveNoteFragment : BaseFragment() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var mAdapter: NoteAdapter

    override fun initLayout(): Int {
        return R.layout.fragment_active_note
    }

    override fun initComponents() {

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        linearLayoutManager = LinearLayoutManager(context)
        val newsList: ArrayList<NoteItem> = ArrayList<NoteItem>()
        newsList.add(NoteItem())
        newsList.add(NoteItem())
        newsList.add(NoteItem())
        newsList.add(NoteItem())
        newsList.add(NoteItem())
        newsList.add(NoteItem())
        mAdapter = NoteAdapter(context, newsList);
        rcMain.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        rcMain.adapter = mAdapter
//        rcEvent.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
//        rcEvent.adapter = mAdapter
    }

    override fun addListener() {
        btnAddNote.setOnClickListener {
//            showNoteDialog()
            showDialog()
        }
    }

    private fun showNoteDialog() {
        val dialogBuilder = AlertDialog.Builder(context)
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.add_note_dialog, null)
        val window: Window

        dialogBuilder.setView(dialogView)

        val editText = dialogView.findViewById<View>(R.id.etNote) as EditText
        val buttonDone = dialogView.findViewById<View>(R.id.tab_done)
        val buttonCancel = dialogView.findViewById<View>(R.id.tab_cancel)

        val b = dialogBuilder.create()
        b.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        b.window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        b.show()



//        setContentView(R.layout.add_note_dialog)
//        val window = this.getWindow()
//        val wlp = window!!.getAttributes()
//        wlp.gravity = Gravity.CENTER
//        wlp.width = WindowManager.LayoutParams.MATCH_PARENT
//        wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_DIM_BEHIND
//        window!!.setAttributes(wlp)
//        getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        this.getWindow()!!.setAttributes(wlp)
    }

    private fun showDialog(){
        val dialog = CustomDialogActivity(activity)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        val window = dialog.window
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT)
    }

}
