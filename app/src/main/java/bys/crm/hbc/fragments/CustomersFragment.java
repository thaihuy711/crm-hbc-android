package bys.crm.hbc.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import bys.crm.hbc.R;
import bys.crm.hbc.activities.AddEditCustomerActivity;
import bys.crm.hbc.activities.DetailCustomerActivity;
import bys.crm.hbc.adapters.CustomersAdapter;
import bys.crm.hbc.api.ApiListener;
import bys.crm.hbc.api.models.GetCustomerOutput;
import bys.crm.hbc.models.Customer;
import bys.crm.hbc.tasks.BaseTask;
import bys.crm.hbc.tasks.GetCustomersTask;
import bys.crm.hbc.utils.Constants;

/**
 * Created by Admin on 3/12/2018.
 */

public class CustomersFragment extends BaseFragment implements View.OnClickListener, ApiListener {
    public static int RQ_ADD_CUSTOMER = 2224;
    private RecyclerView mRcCustomers;
    private LinearLayoutManager mLinearLayoutManager;
    private CustomersAdapter mCustomerAdapter;
    private ArrayList<Customer> mData = new ArrayList<>();
    private GetCustomersTask mGetCustomersTask;
    private int mStart = 0;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private TextView mTvNoData;
    private boolean isLoading;
    private boolean mIsLoadMore;
    private int pastVisiblesItems, visibleItemCount, totalItemCount;
    private Button mBtnAddCustomer;

    public static CustomersFragment newInstance() {
        CustomersFragment fragment = new CustomersFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_customers;
    }

    @Override
    protected void initComponents() {
        mTvNoData = (TextView) getMView().findViewById(R.id.tv_no_data);
        mSwipeRefreshLayout = (SwipeRefreshLayout) getMView().findViewById(R.id.swipeRefreshLayout);
        mRcCustomers = getMView().findViewById(R.id.rc_contact);
        mBtnAddCustomer = getMView().findViewById(R.id.btn_add_customer);

        mCustomerAdapter = new CustomersAdapter(getMContext(), mData);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mLinearLayoutManager.setAutoMeasureEnabled(true);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRcCustomers.setLayoutManager(mLinearLayoutManager);

        mRcCustomers.addItemDecoration(new DividerItemDecoration(getActivity(), 0));
        mRcCustomers.setAdapter(mCustomerAdapter);

        loadData();

    }

    public void loadData() {
        showLoading(true);
        mGetCustomersTask = new GetCustomersTask(getMContext(), mStart, Constants.LIMIT_ITEMS, this);
        mGetCustomersTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }

    @Override
    protected void addListener() {
        mCustomerAdapter.setItemListener(new CustomersAdapter.IOnItemClicklistener() {
            @Override
            public void onItemClick(int position) {
                Intent i = new Intent(getMContext(), DetailCustomerActivity.class);
                i.putExtra(Constants.PREF_CUSTOMER, mData.get(position));
                startActivityForResult(i, RQ_ADD_CUSTOMER);
            }
        });
        mBtnAddCustomer.setOnClickListener(this);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.setRefreshing(false);
                mStart = 0;
                loadData();
            }
        });

        mRcCustomers.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) //check for scroll down
                {
                    visibleItemCount = mLinearLayoutManager.getChildCount();
                    totalItemCount = mLinearLayoutManager.getItemCount();
                    pastVisiblesItems = mLinearLayoutManager.findFirstVisibleItemPosition();

                    if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                        if (mData.size() > 0 && mIsLoadMore && !isLoading) {
                            showLoading(true);
                            mStart++;
                            loadData();
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_customer:
                Intent i = new Intent(getMContext(), AddEditCustomerActivity.class);
                startActivityForResult(i, RQ_ADD_CUSTOMER);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RQ_ADD_CUSTOMER && resultCode == Activity.RESULT_OK){
            mStart = 0;
            loadData();
        }
    }

    @Override
    public void onConnectionOpen(BaseTask task) {

    }

    @Override
    public void onConnectionSuccess(BaseTask task, Object data) {
        if (task instanceof GetCustomersTask) {
            isLoading = false;
            showLoading(false);
            GetCustomerOutput output = (GetCustomerOutput) data;
            if (output.success) {
                mIsLoadMore = output.result.hasNextPage;
                if (mStart == 0) {
                    mData.clear();
                }
                for (Customer item : output.result.items) {
                    mData.add(item);
                }
                mCustomerAdapter.notifyDataSetChanged();
                if (mData.size() > 0) {
                    mTvNoData.setVisibility(View.GONE);
                } else {
                    mTvNoData.setVisibility(View.VISIBLE);
                }
            } else {
                showAlert(getString(R.string.err_unexpected_exception));
            }
        }
    }

    @Override
    public void onConnectionError(BaseTask task, Exception exception) {
        if (task instanceof GetCustomersTask) {
            isLoading = false;
            showLoading(false);
            showAlert(exception);
        }
    }
}
