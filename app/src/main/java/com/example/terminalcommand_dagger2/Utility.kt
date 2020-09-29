package com.example.terminalcommand_dagger2

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable

val key = "position"
val TimeOutRead:Long=0
val TimeOutConnect:Long=10


fun showLoadingDialog(context: Context): ProgressDialog {
    var progressDialog: ProgressDialog = ProgressDialog(context)
    if (!(context as Activity).isFinishing) {
        progressDialog.show()
    }
    if (progressDialog.window != null) {
        progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
    progressDialog.setContentView(R.layout.progress_dialog)
    progressDialog.isIndeterminate = true
    progressDialog.setCancelable(false)
    progressDialog.setCanceledOnTouchOutside(false)
    return progressDialog
}

fun hideLoading(progressDialog: ProgressDialog) {
    if (progressDialog != null) {
        if (progressDialog.isShowing) {
            progressDialog.dismiss()

        }
    }
}