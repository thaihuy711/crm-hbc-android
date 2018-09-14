package bys.crm.hbc.tasks;

import android.content.Context;

import bys.crm.hbc.api.ApiListener;
import bys.crm.hbc.api.models.BaseOutput;
import bys.crm.hbc.api.models.LoginOutput;
import bys.crm.hbc.api.objects.AddCustomerInput;
/**
 * Created by dcmen on 13-Apr-17.
 */
public class AddOrEditCustomerTask extends BaseTask<BaseOutput> {
    private AddCustomerInput mInput;
    private boolean mIsAddNew;
    public AddOrEditCustomerTask(Context context, AddCustomerInput input, boolean isAddNew, ApiListener<BaseOutput> listener) {
        super(context, listener);
        this.mInput = input;
        this.mIsAddNew = isAddNew;
    }

    @Override
    protected BaseOutput callApiMethod() throws Exception {
        return mApi.addOrEditCustomer(this.mInput, this.mIsAddNew);
    }
}
