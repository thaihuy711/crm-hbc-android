package bys.crm.hbc.tasks;

import android.content.Context;

import bys.crm.hbc.api.ApiListener;
import bys.crm.hbc.api.models.LoginOutput;
import bys.crm.hbc.api.objects.LoginInput;

/**
 * Created by dcmen on 13-Apr-17.
 */
public class LoginTask extends BaseTask<LoginOutput> {
    private LoginInput mInput;

    public LoginTask(Context context, LoginInput input, ApiListener<LoginOutput> listener) {
        super(context, listener);
        this.mInput = input;
    }

    @Override
    protected LoginOutput callApiMethod() throws Exception {
        return mApi.loginByEmail(this.mInput);
    }
}
