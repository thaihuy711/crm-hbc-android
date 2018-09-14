package bys.crm.hbc.activities

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.google.gson.Gson
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.assist.ImageScaleType

import java.util.ArrayList

import bys.crm.hbc.R
import bys.crm.hbc.adapters.MenuItemAdapter
import bys.crm.hbc.api.ApiListener
import bys.crm.hbc.api.models.BaseOutput
import bys.crm.hbc.fragments.CustomersFragment
import bys.crm.hbc.fragments.account.AccountFragment
import bys.crm.hbc.fragments.active.ActiveFragment
import bys.crm.hbc.fragments.contact.ContactFragment
import bys.crm.hbc.models.MenuItem
import bys.crm.hbc.models.User
import bys.crm.hbc.tasks.BaseTask
import bys.crm.hbc.tasks.GetGeneralDataTask
import bys.crm.hbc.tasks.LogoutTask
import bys.crm.hbc.utils.Constants
import bys.crm.hbc.utils.SharedPreferenceHelper
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.navigation_header_layout.*

class MainActivity : BaseActivity(), MenuItemAdapter.IOnMenuItemClicklistener, DrawerLayout.DrawerListener, View.OnClickListener, ApiListener<Any> {
    private var mCurrentMenu: MENU_ITEM? = null
    private var mMenuBefore: MENU_ITEM? = null
    private var mDrawerLayout: DrawerLayout? = null
    private var mLayoutSlideMenu: View? = null
    private var mRecyclerViewMenu: RecyclerView? = null
    private var mTvFullname: TextView? = null
    private var mImvAvatar: ImageView? = null
    private val options = DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true)
            .considerExifParams(true)
            .showImageForEmptyUri(R.drawable.ic_profile_menu).showImageOnFail(R.drawable.ic_profile_menu)
            .showImageOnLoading(R.drawable.ic_profile_menu).bitmapConfig(Bitmap.Config.RGB_565)
            .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2).build()
    private var mCurrentFragment: Fragment? = null
    private lateinit var currentTab: View

    enum class MENU_ITEM {
        MENU_CUSTOMER, MENU_LOGOUT
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mTvFullname = findViewById(R.id.tv_fullname)
        mImvAvatar = findViewById(R.id.imv_avatar)
        mDrawerLayout = findViewById(R.id.drawer_layout)
        mLayoutSlideMenu = findViewById(R.id.layout_left_menu)
        mRecyclerViewMenu = findViewById(R.id.recyclerview_menu)
        mRecyclerViewMenu!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val menuItems = ArrayList<MenuItem>()
        menuItems.add(MenuItem(MENU_ITEM.MENU_CUSTOMER, R.drawable.ic_customer, getString(R.string.txt_customer)))
        menuItems.add(MenuItem(MENU_ITEM.MENU_LOGOUT, R.drawable.ic_logout, getString(R.string.txt_manage_logout)))
        val menuAdapter = MenuItemAdapter(this, menuItems)
        menuAdapter.setItemListener(this)
        mRecyclerViewMenu!!.adapter = menuAdapter

        mCurrentMenu = MENU_ITEM.MENU_CUSTOMER
        menuAdapter.setItemSelected(MENU_ITEM.MENU_CUSTOMER)

        mDrawerLayout!!.addDrawerListener(this)


        currentTab = tab_active
        currentTab.isSelected = true;
        setTitle(getString(R.string.txt_active))
        setNewPage(ActiveFragment())

        addListener()
    }

    override fun addListener() {
        tab_active.setOnClickListener(this)
        tab_contact.setOnClickListener(this)
        tab_account.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        loadProfile()
        if (SharedPreferenceHelper.getInstance(this).get(Constants.PREF_GENERAL_DATA) == null) {
            GetGeneralDataTask(this, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
        }
    }

    fun loadProfile() {
        val userJson = SharedPreferenceHelper.getInstance(this).get(Constants.PREF_USER_PROFILE)
        if (userJson != null && userJson.length > 0) {
            val user = Gson().fromJson(userJson, User::class.java)
            if (user != null) {
                mTvFullname!!.text = user.employeeName
            }
        }
    }

    override fun onItemClick(menuId: MENU_ITEM, currentMenu: MENU_ITEM) {
        if (currentMenu == MENU_ITEM.MENU_LOGOUT) {
            mMenuBefore = null
            showPopupLogout()
        } else {
            mCurrentMenu = menuId
            mMenuBefore = menuId
        }
        mDrawerLayout!!.closeDrawer(mLayoutSlideMenu)
    }

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {

    }

    override fun onDrawerOpened(drawerView: View) {

    }

    override fun onDrawerClosed(drawerView: View) {
        if (mCurrentMenu == null || mMenuBefore == null) {
            return
        }
        mMenuBefore = null
        when (mCurrentMenu) {
            MainActivity.MENU_ITEM.MENU_CUSTOMER -> {
                setTitle(getString(R.string.txt_customer))
                mCurrentFragment = CustomersFragment.newInstance()
                setNewPage(mCurrentFragment)
            }
        }
    }

    private fun showPopupLogout() {
        val builder: AlertDialog.Builder
        builder = AlertDialog.Builder(this@MainActivity)
        builder.setMessage(getString(R.string.txt_are_you_sure_logout))
                .setPositiveButton(R.string.txt_yes) { dialog, which ->
                    showLoading(true)
                    LogoutTask(this@MainActivity, this@MainActivity).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
                }
                .setNegativeButton(R.string.txt_no) { dialog, which -> }
                .show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onDrawerStateChanged(newState: Int) {

    }

    override fun initLayout(): Int {
        return R.layout.activity_main
    }

    override fun initComponents() {
//        showNavLeft(R.drawable.ic_menu) {
//            if (mDrawerLayout!!.isDrawerOpen(mLayoutSlideMenu!!)) {
//                mDrawerLayout!!.closeDrawer(mLayoutSlideMenu)
//            } else {
//                hideKeyBoard()
//                mDrawerLayout!!.openDrawer(mLayoutSlideMenu)
//            }
//        }
        imv_nav_left.setVisibility(View.GONE)
    }

    override fun onBackPressed() {
        if (mDrawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onClick(v: View) {
        when(v){
            tab_active -> {
                currentTab.isSelected = false
                currentTab = v
                currentTab.isSelected = true
                setTitle(getString(R.string.txt_active))
                setNewPage(ActiveFragment())
            }
            tab_contact -> {
                currentTab.isSelected = false
                currentTab = v
                currentTab.isSelected = true
                setTitle(getString(R.string.txt_contact))
                setNewPage(ContactFragment())
            }
            tab_account -> {
                currentTab.isSelected = false
                currentTab = v
                currentTab.isSelected = true
                setTitle(getString(R.string.txt_account))
                setNewPage(AccountFragment())
            }
        }
    }

    override fun onConnectionOpen(task: BaseTask<*>) {

    }

    override fun onConnectionSuccess(task: BaseTask<*>?, data: Any?) {
        if (task is LogoutTask) {
            showLoading(false)
            val output = data as BaseOutput?
            if (output!!.success) {
                SharedPreferenceHelper.getInstance(this).clearSharePrefs()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                showAlert(getString(R.string.err_unexpected_exception))
            }
        } else if (task is GetGeneralDataTask) {
            if (data != null && data is String) {
                SharedPreferenceHelper.getInstance(this).set(Constants.PREF_GENERAL_DATA, data as String?)
            }
        }
    }
    override fun onConnectionError(task: BaseTask<*>, exception: Exception) {
        if (task is LogoutTask) {
            showLoading(false)
            showAlert(exception)
        }
    }
}
