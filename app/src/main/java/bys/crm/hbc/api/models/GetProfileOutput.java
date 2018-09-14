package bys.crm.hbc.api.models;

import com.google.gson.annotations.SerializedName;

import bys.crm.hbc.models.User;

/**
 * Created by Admin on 3/13/2018.
 */

public class GetProfileOutput extends BaseOutput{
    @SerializedName("result")
    public User result;

}
