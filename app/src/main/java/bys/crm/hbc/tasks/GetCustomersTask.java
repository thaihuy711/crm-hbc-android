package bys.crm.hbc.tasks;

import android.content.Context;

import bys.crm.hbc.api.ApiListener;
import bys.crm.hbc.api.models.GetCustomerOutput;
import bys.crm.hbc.fragments.CustomersFragment;

/**
 * Created by dcmen
 */
public class GetCustomersTask extends BaseTask<GetCustomerOutput> {
    private int mStart;
    private int mLimit;

    public GetCustomersTask(Context context, int start, int limit, ApiListener<GetCustomerOutput> listener) {
        super(context, listener);
        this.mStart = start;
        this.mLimit = limit;
    }

    @Override
    protected GetCustomerOutput callApiMethod() throws Exception {
        return mApi.getCustomers(this.mStart, this.mLimit);
    }
}
