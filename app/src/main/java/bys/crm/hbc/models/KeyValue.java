package bys.crm.hbc.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by DC-MEN on 5/5/2018.
 */

public class KeyValue implements Serializable{
    @SerializedName("key")
    private String keyName;
    @SerializedName("value")
    private String value;

    public KeyValue(String key, String value){
        this.keyName = key;
        this.value = value;
    }

    public String getKeyName() {
        return keyName;
    }

    public String getValue() {
        return value;
    }
}
