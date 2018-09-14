package bys.crm.hbc.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;

import org.json.JSONException;

import java.io.IOException;

import bys.crm.hbc.api.ApiListener;
import bys.crm.hbc.api.TaskApi;
import bys.crm.hbc.api.exception.ApiException;
import bys.crm.hbc.utils.Constants;
import bys.crm.hbc.utils.SharedPreferenceHelper;

/**
 * Created by dcmen on 08/31/16.
 * This class is parent of any subclass which call api
 */
public abstract class BaseTask<Output> extends AsyncTask<Void,Exception, Output> {
    protected TaskApi mApi;
    private ApiListener<Output> mListener;
    private Exception mException = null;

    public BaseTask(Context context, @Nullable ApiListener<Output> listener) {
        mListener = listener;
        mApi = new TaskApi(context);
        if(SharedPreferenceHelper.getInstance(context).get(Constants.PREF_SESSION_ID) != null && SharedPreferenceHelper.getInstance(context).get(Constants.PREF_SESSION_ID).length() > 0) {
            mApi.setCredentials(SharedPreferenceHelper.getInstance(context).get(Constants.PREF_SESSION_ID));
        }
    }

    @Override
    @MainThread
    final protected void onPreExecute() {
        if (mListener != null) mListener.onConnectionOpen(this);
    }

    @Override
    final protected Output doInBackground(Void... params) {
        try {
            return callApiMethod();
        } catch (Exception e) {
            mException = e;
            return null;
        }
    }

    @Override
    @MainThread
    final protected void onPostExecute(Output output) {
        if (mListener != null && mException != null)
            mListener.onConnectionError(this, mException);
        else if (mListener != null)
            mListener.onConnectionSuccess(this, output);
    }

    /**
     * Override it with api method in YsApi which we want to execute
     *
     * @return
     * @throws ApiException
     * @throws JSONException
     * @throws IOException
     */
    protected abstract Output callApiMethod()
            throws ApiException, JSONException, IOException, Exception;

}
