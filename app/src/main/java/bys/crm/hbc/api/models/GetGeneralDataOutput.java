package bys.crm.hbc.api.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

import bys.crm.hbc.models.KeyValueData;

/**
 * Created by Admin on 4/13/2017.
 */

public class GetGeneralDataOutput extends BaseOutput {
    @SerializedName("result")
    public Result result;

    public class Result implements Serializable {
        @SerializedName("customerGroups")
        public ArrayList<KeyValueData> customerGroups;
        @SerializedName("customerTypeCombos")
        public ArrayList<KeyValueData> customerTypeCombos;
        @SerializedName("customerClassifys")
        public ArrayList<KeyValueData> customerClassifys;
    }
}
