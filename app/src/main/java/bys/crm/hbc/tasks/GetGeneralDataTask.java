package bys.crm.hbc.tasks;

import android.content.Context;
import bys.crm.hbc.api.ApiListener;

/**
 * Created by dcmen
 */
public class GetGeneralDataTask extends BaseTask<Object> {
    public GetGeneralDataTask(Context context, ApiListener<Object> listener) {
        super(context, listener);
    }

    @Override
    protected String callApiMethod() throws Exception {
        return mApi.getGeneralData();
    }
}
