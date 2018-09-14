package bys.crm.hbc.api;

import android.content.Context;
import android.net.Uri;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import bys.crm.hbc.api.exception.ApiException;
import bys.crm.hbc.api.models.BaseOutput;
import bys.crm.hbc.api.models.CustomerDetailOutput;
import bys.crm.hbc.api.models.GetCustomerOutput;
import bys.crm.hbc.api.models.GetEmployyesOutput;
import bys.crm.hbc.api.models.GetProfileOutput;
import bys.crm.hbc.api.models.LoginOutput;
import bys.crm.hbc.api.models.StringOutput;
import bys.crm.hbc.api.models.ValidateCodeOutput;
import bys.crm.hbc.api.objects.AddCustomerInput;
import bys.crm.hbc.api.objects.LoginInput;
import bys.crm.hbc.http.HttpApiWithSessionAuth;

/**
 * Created by dcmen on 08/31/16.
 */
public class TaskApi {
    // URL
    public static final String TASK_WS = "http://115.79.35.119:9006/api/crm/";//DEV api
    public static final String LOGIN_API = "user/login";
    public static final String PROFILE_API = "user/me";
    public static final String EDIT_PROFILE_API = "employee/requesteditemployee";
    public static final String UPLOAD_AVATAR_API = "user/me/updateavatar";
    public static final String LOGOUT_API = "user/logout";
    public static final String FORGOT_PASSWORD_API = "user/password/forgot";
    public static final String FORGOT_ENTER_CODE_API = "user/password/validateactivecode";
    public static final String RESET_PASSWORD_API = "user/password/reset";
    public static final String GET_CUSTOMERS_API = "customers/search/%s/%s";
    public static final String GET_EMPLOYYES_API = "user/%s/%s";
    public static final String GET_GENERAL_DATA_API = "data/customertype";
    public static final String ADD_CUSTOMER_API = "customers/create";
    public static final String EDIT_CUSTOMER_API = "customers/edit";
    public static final String DELETE_CUSTOMER_API = "customers/delete";
    public static final String GET_DETAIL_CUSTOMER_API = "customers/%s";


    private static final Logger LOG = Logger
            .getLogger(TaskApi.class.getCanonicalName());
    private HttpApiWithSessionAuth mHttpApi;
    private String mDomain;
    private Context mContext;
    private Gson mGson;

    public TaskApi(Context context) {
        mContext = context;
        mHttpApi = new HttpApiWithSessionAuth(context);
        mGson = new Gson();
        mDomain = TASK_WS;
    }


    public TaskApi setCredentials(String token) {
        if (token == null || token.length() == 0)
            mHttpApi.clearCredentials();
        else
            mHttpApi.setCredentials(token);
        return this;
    }


    public String getFullUrl(String subUrl) {
        return mDomain + subUrl;
    }

    public LoginOutput loginByEmail(LoginInput input) throws ApiException, JSONException, IOException {
        JSONObject data = mHttpApi.doHttpPost(getFullUrl(LOGIN_API), new Gson().toJson(input));
        LoginOutput output = mGson.fromJson(data.toString(), LoginOutput.class);
        return output;
    }

    public BaseOutput logout() throws ApiException, JSONException, IOException {
        JSONObject data = mHttpApi.doHttpPost(getFullUrl(LOGOUT_API), "");
        BaseOutput output = mGson.fromJson(data.toString(), BaseOutput.class);
        return output;
    }

    public BaseOutput getCodeByEmailInForgotPassword(String email) throws ApiException, JSONException, IOException {
        JSONObject input = new JSONObject();
        input.put("email", email);
        JSONObject data = mHttpApi.doHttpPost(getFullUrl(FORGOT_PASSWORD_API), input.toString());
        BaseOutput output = mGson.fromJson(data.toString(), BaseOutput.class);
        return output;
    }

    public ValidateCodeOutput enterCodeForgotPassword(String email, String code) throws ApiException, JSONException, IOException {
        JSONObject input = new JSONObject();
        input.put("email", email);
        input.put("activeCode", code);
        JSONObject data = mHttpApi.doHttpPost(getFullUrl(FORGOT_ENTER_CODE_API), input.toString());
        ValidateCodeOutput output = mGson.fromJson(data.toString(), ValidateCodeOutput.class);
        return output;
    }

    public BaseOutput createNewPassword(String email, String token, String password) throws ApiException, JSONException, IOException {
        JSONObject input = new JSONObject();
        input.put("email", email);
        input.put("token", token);
        input.put("password", password);
        JSONObject data = mHttpApi.doHttpPost(getFullUrl(RESET_PASSWORD_API), input.toString());
        BaseOutput output = mGson.fromJson(data.toString(), BaseOutput.class);
        return output;
    }

    public GetProfileOutput getProfile() throws ApiException, JSONException, IOException {
        JSONObject data = mHttpApi.doHttpGet(String.format(getFullUrl(PROFILE_API)));
        GetProfileOutput output = mGson.fromJson(data.toString(), GetProfileOutput.class);
        return output;
    }

    public GetCustomerOutput getCustomers(int start, int limit) throws ApiException, JSONException, IOException {
        JSONObject data = mHttpApi.doHttpGetWithHeader(String.format(getFullUrl(GET_CUSTOMERS_API), start + "", limit + ""));
        GetCustomerOutput output = mGson.fromJson(data.toString(), GetCustomerOutput.class);
        return output;
    }

    public GetEmployyesOutput getEmplooyes(int start, int limit) throws ApiException, JSONException, IOException {
        JSONObject data = mHttpApi.doHttpGetWithHeader(String.format(getFullUrl(GET_EMPLOYYES_API), start + "", limit + ""));
        GetEmployyesOutput output = mGson.fromJson(data.toString(), GetEmployyesOutput.class);
        return output;
    }

    public String getGeneralData() throws ApiException, JSONException, IOException {
        JSONObject data = mHttpApi.doHttpGetWithHeader(getFullUrl(GET_GENERAL_DATA_API));
        return data.toString();
    }

    public CustomerDetailOutput getCustomerDetail(String customerId) throws ApiException, JSONException, IOException {
        JSONObject data = mHttpApi.doHttpGetWithHeader(String.format(getFullUrl(GET_DETAIL_CUSTOMER_API), customerId));
        CustomerDetailOutput output = mGson.fromJson(data.toString(), CustomerDetailOutput.class);
        return output;
    }

    public BaseOutput addOrEditCustomer(AddCustomerInput input, boolean isAddNew) throws ApiException, JSONException, IOException {
        JSONObject jsonObject = new JSONObject(new Gson().toJson(input));
        if(isAddNew) {
            jsonObject.remove("id");
        }
        JSONObject data = mHttpApi.doHttpPost(getFullUrl(isAddNew ? ADD_CUSTOMER_API : EDIT_CUSTOMER_API), jsonObject.toString());
        BaseOutput output = mGson.fromJson(data.toString(), BaseOutput.class);
        return output;
    }

    public BaseOutput deleteCustomer(String customerId) throws ApiException, JSONException, IOException {
        JSONObject input = new JSONObject();
        input.put("id", customerId);
        JSONObject data = mHttpApi.doHttpPost(getFullUrl(DELETE_CUSTOMER_API), input.toString());
        BaseOutput output = mGson.fromJson(data.toString(), BaseOutput.class);
        return output;
    }
}
