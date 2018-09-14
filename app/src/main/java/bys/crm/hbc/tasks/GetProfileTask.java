package bys.crm.hbc.tasks;

import android.content.Context;

import bys.crm.hbc.api.ApiListener;
import bys.crm.hbc.api.models.GetProfileOutput;

/**
 * Created by dcmen
 */
public class GetProfileTask extends BaseTask<GetProfileOutput> {

    public GetProfileTask(Context context, ApiListener<GetProfileOutput> listener) {
        super(context, listener);
    }

    @Override
    protected GetProfileOutput callApiMethod() throws Exception {
        return mApi.getProfile();
    }
}
