package bys.crm.hbc.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import bys.crm.hbc.models.Customer;

/**
 * Created by Admin on 4/13/2017.
 */

public class GetCustomerOutput extends BaseOutput {
    @SerializedName("result")
    public Result result;

    public class Result {
        @SerializedName("pageIndex")
        public int pageIndex;
        @SerializedName("pageSize")
        public int pageSize;
        @SerializedName("totalCount")
        public int totalCount;
        @SerializedName("totalPages")
        public int totalPages;
        @SerializedName("items")
        public ArrayList<Customer> items;
        @SerializedName("hasPreviousPage")
        public boolean hasPreviousPage;
        @SerializedName("hasNextPage")
        public boolean hasNextPage;
        @SerializedName("extraData")
        public String extraData;
    }
}
