package bys.crm.hbc.tasks;

import android.content.Context;

import bys.crm.hbc.api.ApiListener;
import bys.crm.hbc.api.models.BaseOutput;
import bys.crm.hbc.api.models.BaseOutput;

/**
 * Created by dcmen
 */
public class LogoutTask extends BaseTask<Object> {

    public LogoutTask(Context context, ApiListener<Object> listener) {
        super(context, listener);
    }

    @Override
    protected BaseOutput callApiMethod() throws Exception {
        return mApi.logout();
    }
}
