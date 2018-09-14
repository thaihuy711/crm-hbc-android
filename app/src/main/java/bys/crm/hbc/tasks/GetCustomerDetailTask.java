package bys.crm.hbc.tasks;

import android.content.Context;

import bys.crm.hbc.api.ApiListener;
import bys.crm.hbc.api.models.CustomerDetailOutput;

/**
 * Created by dcmen
 */
public class GetCustomerDetailTask extends BaseTask<CustomerDetailOutput> {
    private String mCustomerId;

    public GetCustomerDetailTask(Context context, String customerId, ApiListener<CustomerDetailOutput> listener) {
        super(context, listener);
        this.mCustomerId = customerId;
    }

    @Override
    protected CustomerDetailOutput callApiMethod() throws Exception {
        return mApi.getCustomerDetail(this.mCustomerId);
    }
}
