package bys.crm.hbc.tasks;

import android.content.Context;
import bys.crm.hbc.api.ApiListener;
import bys.crm.hbc.api.models.BaseOutput;

/**
 * Created by dcmen on 13-Apr-17.
 */
public class DeleteCustomerTask extends BaseTask<BaseOutput> {
    private String mCustomerId;

    public DeleteCustomerTask(Context context, String customerId, ApiListener<BaseOutput> listener) {
        super(context, listener);
        this.mCustomerId = customerId;
    }

    @Override
    protected BaseOutput callApiMethod() throws Exception {
        return mApi.deleteCustomer(this.mCustomerId);
    }
}
