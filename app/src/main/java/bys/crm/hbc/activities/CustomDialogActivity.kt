package bys.crm.hbc.activities

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.View
import bys.crm.hbc.R
import kotlinx.android.synthetic.main.add_note_dialog.*

class CustomDialogActivity(var a: Activity) : Dialog(a), View.OnClickListener {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.add_note_dialog)

    tab_done.setOnClickListener(this)
    tab_cancel.setOnClickListener(this)
  }

  override fun onClick(p0: View?) {
    when (p0) {
      tab_done -> {
        dismiss()
      }
      tab_cancel -> {
        dismiss()
      }
    }
    dismiss()
  }
}