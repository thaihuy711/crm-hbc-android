package bys.crm.hbc.activities;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import bys.crm.hbc.R;
import bys.crm.hbc.api.ApiListener;
import bys.crm.hbc.api.models.BaseOutput;
import bys.crm.hbc.api.models.CustomerDetailOutput;
import bys.crm.hbc.models.Customer;
import bys.crm.hbc.tasks.BaseTask;
import bys.crm.hbc.tasks.DeleteCustomerTask;
import bys.crm.hbc.tasks.GetCustomerDetailTask;
import bys.crm.hbc.utils.Constants;
import bys.crm.hbc.utils.StringUtils;

/**
 * Created by sdc on 20/08/2018.
 */

public class InfoCompanyActivity extends BaseActivity implements View.OnClickListener, ApiListener {
    public static int RQ_EDIT = 2356;
    private boolean isChangedInfor;
    private Customer mCurrentCustomer;
    private View mViewEmail, mViewCall, mViewSms;
    private TextView mTvCompanyEstablish;
    private TextView mTvCustomerName, mTvMainEmail, mTvSubEmail, mTvMainPhone, mTvSubPhone, mTvAddress, mTvWebsite, mTvFax, mTvStockCode, mTvTaxCode, mTvCareer,
            mTvRevenue, mTvCmnd, mTvDiscussDetail;
    private TextView mTvAssigner, mTvCustomerType, mTvClassify, mTvGroup;
    private ImageView mImvBack, mImvEdit, mImvDelete;
    private TextView mTvFullname;

    @Override
    protected int initLayout() {
        return R.layout.activity_info_company;
    }

    @Override
    protected void initComponents() {
        mCurrentCustomer = (Customer) getIntent().getSerializableExtra(Constants.PREF_CUSTOMER);

        mTvFullname = findViewById(R.id.tv_fullname);
        mImvBack = findViewById(R.id.imv_back);
        mImvEdit = findViewById(R.id.imv_edit);
        mImvDelete = findViewById(R.id.imv_delete);
        mTvCustomerName = findViewById(R.id.tv_customer_name);
        mTvMainEmail = findViewById(R.id.tv_main_email);
        mTvSubEmail = findViewById(R.id.tv_sub_email);
        mTvMainPhone = findViewById(R.id.tv_main_phone);
        mTvSubPhone = findViewById(R.id.tv_sub_phone);
        mTvAddress = findViewById(R.id.tv_address);
        mTvWebsite = findViewById(R.id.tv_website);
        mTvFax = findViewById(R.id.tv_fax);
        mTvStockCode = findViewById(R.id.tv_stock_code);
        mTvTaxCode = findViewById(R.id.tv_tax_code);
        mTvCustomerType = findViewById(R.id.tv_customer_type);
        mTvCareer = findViewById(R.id.tv_career);
        mTvGroup = findViewById(R.id.tv_group);
        mTvClassify = findViewById(R.id.tv_classify);
        mTvRevenue = findViewById(R.id.tv_revenue);
        mTvCmnd = findViewById(R.id.tv_cmnd);
        mTvDiscussDetail = findViewById(R.id.tv_discuss_detail);


        mViewEmail = findViewById(R.id.view_email);
        mViewCall = findViewById(R.id.view_call);
        mViewSms = findViewById(R.id.view_sms);
        mTvAssigner = findViewById(R.id.tv_assigner);
        mTvCompanyEstablish = findViewById(R.id.tv_company_establish);

        if(mCurrentCustomer != null) {
            showLoading(true);
            new GetCustomerDetailTask(this, mCurrentCustomer.getId() + "", this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
    }

    public void loadData() {
        if (mCurrentCustomer != null) {
            mTvFullname.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerName()));
            mTvCustomerName.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerName()));
            mTvMainEmail.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerEmail1()));
            mTvSubEmail.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerEmail2()));
            mTvMainPhone.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerPhone1()));
            mTvSubPhone.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerPhone2()));
            mTvAddress.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerAddress()));
            mTvWebsite.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerWebsite()));
            mTvFax.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerFaxNumber()));
            mTvStockCode.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerStockCode()));
            mTvTaxCode.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerTaxNumber()));
            mTvCustomerType.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerTypeCombo() != null ? mCurrentCustomer.getCustomerTypeCombo().getValue() : ""));
            mTvCareer.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerBusiness()));
            mTvGroup.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerGroup() != null ? mCurrentCustomer.getCustomerGroup().getValue() : ""));
            mTvClassify.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerClassify() != null ? mCurrentCustomer.getCustomerClassify().getValue() : ""));
            mTvRevenue.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerRevenueDueYear()));
            mTvCmnd.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerIdNumber()));
            mTvCompanyEstablish.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerCompanyEstablishmentDay() > 0 ? StringUtils.getDateStringFromTimestamp(mCurrentCustomer.getCustomerCompanyEstablishmentDay() * 1000) : ""));
            mTvAssigner.setText(StringUtils.getString(this, mCurrentCustomer.getEmployee() != null ? mCurrentCustomer.getEmployee().getEmployeeName() : ""));
            mTvDiscussDetail.setText(StringUtils.getString(this, mCurrentCustomer.getCustomerContactInformation()));
        }
    }

    @Override
    protected void addListener() {
        mViewEmail.setOnClickListener(this);
        mViewCall.setOnClickListener(this);
        mViewSms.setOnClickListener(this);
        mImvBack.setOnClickListener(this);
        mImvEdit.setOnClickListener(this);
        mImvDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.view_email:
                if(mCurrentCustomer != null) {
                    String email = null;
                    if (mCurrentCustomer.getCustomerEmail1() != null) {
                        email = mCurrentCustomer.getCustomerEmail1();
                    } else if (mCurrentCustomer.getCustomerEmail2() != null) {
                        email = mCurrentCustomer.getCustomerEmail2();
                    }
                    if (email != null && email.trim().length() > 0) {
                        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                                "mailto", email, null));
//                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                        startActivity(Intent.createChooser(emailIntent, "Send email..."));
                    } else {
                        toast(getString(R.string.txt_not_have_email));
                    }
                }
                break;
            case R.id.view_call:
                if(mCurrentCustomer != null) {
                    String phone = null;
                    if (mCurrentCustomer.getCustomerPhone1() != null) {
                        phone = mCurrentCustomer.getCustomerPhone1();
                    } else if (mCurrentCustomer.getCustomerPhone2() != null) {
                        phone = mCurrentCustomer.getCustomerPhone2();
                    }
                    if (phone != null && phone.trim().length() > 0) {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:" + phone));
                        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            return;
                        }
                        startActivity(callIntent);
                    } else {
                        toast(getString(R.string.txt_not_have_phone));
                    }
                }
                break;
            case R.id.view_sms:
                if(mCurrentCustomer != null) {
                    String sms = null;
                    if (mCurrentCustomer.getCustomerPhone1() != null) {
                        sms = mCurrentCustomer.getCustomerPhone1();
                    } else if (mCurrentCustomer.getCustomerPhone2() != null) {
                        sms = mCurrentCustomer.getCustomerPhone2();
                    }
                    if (sms != null && sms.trim().length() > 0) {
                        try {
                            Uri uri = Uri.parse("smsto:" + sms);
                            Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
                            startActivity(smsIntent);
                        } catch (Exception e) {
                        }
                    } else {
                        toast(getString(R.string.txt_not_have_phone));
                    }
                }
                break;
            case R.id.imv_back:
                onBackPressed();
                break;
            case R.id.imv_edit:
                Intent i = new Intent(this, AddEditCustomerActivity.class);
                i.putExtra(Constants.PREF_CUSTOMER, mCurrentCustomer);
                startActivityForResult(i, RQ_EDIT);
                break;
            case R.id.imv_delete:
                if(mCurrentCustomer != null) {
                    AlertDialog.Builder builder;
                    builder = new AlertDialog.Builder(InfoCompanyActivity.this);
                    builder.setMessage(getString(R.string.txt_are_you_sure_delete_customer))
                            .setPositiveButton(R.string.txt_yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    showLoading(true);
                                    new DeleteCustomerTask(InfoCompanyActivity.this, mCurrentCustomer.getId() + "", InfoCompanyActivity.this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                                }
                            })
                            .setNegativeButton(R.string.txt_no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            })
                            .show();
                }
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == RQ_EDIT){
            isChangedInfor = true;
            showLoading(true);
            new GetCustomerDetailTask(this, mCurrentCustomer.getId() + "", this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
    }

    @Override
    public void onBackPressed() {
        if(isChangedInfor){
            setResult(RESULT_OK);
        }
        finish();
    }

    @Override
    public void onConnectionOpen(BaseTask task) {

    }

    @Override
    public void onConnectionSuccess(BaseTask task, Object data) {
        if (task instanceof DeleteCustomerTask) {
            BaseOutput output = (BaseOutput) data;
            showLoading(false);
            if (output.success) {
                toast(getString(R.string.txt_delete_customer_success));
                setResult(RESULT_OK);
                finish();
            } else {
                showAlert(getString(R.string.err_unexpected_exception));
            }
        } else if (task instanceof GetCustomerDetailTask) {
            CustomerDetailOutput output = (CustomerDetailOutput) data;
            showLoading(false);
            if (output.success) {
                mCurrentCustomer = output.customer;
                loadData();
            } else {
                showAlert(getString(R.string.err_unexpected_exception));
            }
        }
    }

    @Override
    public void onConnectionError(BaseTask task, Exception exception) {
        if (task instanceof DeleteCustomerTask) {
            showLoading(false);
            showAlert(exception);
        }
    }
}