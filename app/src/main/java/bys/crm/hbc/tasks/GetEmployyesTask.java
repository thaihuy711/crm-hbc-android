package bys.crm.hbc.tasks;

import android.content.Context;

import bys.crm.hbc.api.ApiListener;
import bys.crm.hbc.api.models.GetEmployyesOutput;

/**
 * Created by dcmen
 */
public class GetEmployyesTask extends BaseTask<GetEmployyesOutput> {
    private int mStart;
    private int mLimit;

    public GetEmployyesTask(Context context, int start, int limit, ApiListener<GetEmployyesOutput> listener) {
        super(context, listener);
        this.mStart = start;
        this.mLimit = limit;
    }

    @Override
    protected GetEmployyesOutput callApiMethod() throws Exception {
        return mApi.getEmplooyes(this.mStart, this.mLimit);
    }
}
