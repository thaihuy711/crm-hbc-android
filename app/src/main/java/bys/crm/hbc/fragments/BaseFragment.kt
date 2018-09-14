package bys.crm.hbc.fragments

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.InflateException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.afollestad.materialdialogs.MaterialDialog

import java.io.IOException

import bys.crm.hbc.R
import bys.crm.hbc.api.exception.ApiException

/**
 * Created by Admin on 3/22/2017.
 */

abstract class BaseFragment : Fragment() {
    protected var mFragment: Fragment? = null
    protected var mView: View? = null
    protected var mViewId: Int = 0
    protected var mContext: Context? = null
    protected var mProgressDialog: ProgressDialog? = null
    private var mAlertDialog: MaterialDialog? = null

    protected abstract fun initLayout(): Int

    protected abstract fun initComponents()

    protected abstract fun addListener()

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mView != null) {
            val parent = mView!!.parent as ViewGroup
            parent?.removeView(mView)
        }
        val layoutId = initLayout()
        if (layoutId != 0) {
            mViewId = layoutId
        }
        try {
            mView = LayoutInflater.from(activity).inflate(mViewId, container, false)
        } catch (e: InflateException) {
            /* map is already there, just return view as it is */
        }

        return mView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mProgressDialog = ProgressDialog(mContext)
        mProgressDialog!!.setCancelable(false)
        mProgressDialog!!.setMessage(getString(R.string.txt_waiting))
        initComponents()
        addListener()
    }

    fun toast(message: String) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
    }

    fun toast(messageId: Int) {
        Toast.makeText(mContext, getString(messageId), Toast.LENGTH_SHORT).show()
    }

    fun showLoading(isShow: Boolean) {
        if (isShow) {
            mProgressDialog!!.show()
        } else {
            if (mProgressDialog!!.isShowing) {
                mProgressDialog!!.dismiss()
            }
        }
    }

    fun showAlert(e: Exception) {
        if (e is ApiException)
            showAlert(e.getMessage(mContext))
        else if (e is IOException)
            showAlert(R.string.err_network_available)
        else
            showAlert(R.string.err_unexpected_exception)
    }

    fun showAlert(messageId: Int) {
        showAlert(getString(messageId))
    }

    fun showAlert(message: String) {
        if (mAlertDialog != null && mAlertDialog!!.isShowing) {
            mAlertDialog!!.dismiss()
        }

        mAlertDialog = MaterialDialog.Builder(mContext!!)
                .content(message)
                .positiveText(getString(R.string.txt_ok))
                .cancelable(false)
                .build()
        mAlertDialog!!.show()
    }

    fun setNewPageChild(fragment: Fragment) {
        try {
            if (childFragmentManager.backStackEntryCount > 0) {
                for (i in 0 until childFragmentManager.backStackEntryCount) {
                    childFragmentManager.popBackStackImmediate()
                }
            }
            val transaction = childFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_main, fragment, "currentFragment")
            transaction.commitAllowingStateLoss()
            if (mFragment != null)
                transaction.remove(mFragment)
            mFragment = fragment
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun addFragmentChild(fragment: Fragment) {
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.trans_right_to_left_in, R.anim.trans_right_to_left_out,
                        R.anim.trans_left_to_right_in, R.anim.trans_left_to_right_out)
                .add(R.id.frame_main, fragment)
                .addToBackStack(fragment.javaClass.name)
                .commit()
    }


    fun replaceFragmentChild(fragment: Fragment) {

        childFragmentManager.popBackStackImmediate(R.id.frame_main, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        childFragmentManager.beginTransaction()
                .replace(R.id.frame_main, fragment)
                .commit()
    }

    fun backFragment(){
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStackImmediate()
        }
    }
}
