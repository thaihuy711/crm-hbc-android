package bys.crm.hbc.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import bys.crm.hbc.models.Customer;

/**
 * Created by Admin on 4/13/2017.
 */

public class CustomerDetailOutput extends BaseOutput {
    @SerializedName("result")
    public Customer customer;
}
