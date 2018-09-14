package bys.crm.hbc.api.objects;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import bys.crm.hbc.models.KeyValue;
import bys.crm.hbc.models.User;

public class AddCustomerInput implements Serializable{
    @SerializedName("id")
    private int id;
    @SerializedName("customerName")
    private String customerName;
    @SerializedName("customerContactWebsite")
    private String customerContactWebsite;
    @SerializedName("customerContactPhone1")
    private String customerContactPhone1;
    @SerializedName("customerTaxNumber")
    private String customerTaxNumber;
    @SerializedName("customerContactEmail1")
    private String customerContactEmail1;
    @SerializedName("employeeID")
    private String employeeId;
    @SerializedName("customerContactEmail2")
    private String customerContactEmail2;
    @SerializedName("customerFaxNumber")
    private String customerContactFax;

    @SerializedName("customerContactPhone2")
    private String customerContactPhone2;
    @SerializedName("customerClassify")
    private String customerClassify;
    @SerializedName("customerEvaluate")
    private int customerEvaluate;
    @SerializedName("customerTypeCombo")
    private String customerTypeCombo;
    @SerializedName("customerRevenueDueYear")
    private String customerRevenueDueYear;
    @SerializedName("customerGroup")
    private String customerGroup;
    @SerializedName("customerCompanyEstablishmentDay")
    private long customerCompanyEstablishmentDay;
    @SerializedName("customerAddress")
    private String customerAddress;
    @SerializedName("customerStockCode")
    private String customerStockCode;
    @SerializedName("customerBusiness")
    private String customerBusiness;
    @SerializedName("customerIdNumber")
    private String customerIdNumber;
    @SerializedName("customerContactInformation")
    private String customerContactInformation;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerContactWebsite() {
        return customerContactWebsite;
    }

    public void setCustomerContactWebsite(String customerContactWebsite) {
        this.customerContactWebsite = customerContactWebsite;
    }

    public String getCustomerTaxNumber() {
        return customerTaxNumber;
    }

    public void setCustomerTaxNumber(String customerTaxNumber) {
        this.customerTaxNumber = customerTaxNumber;
    }

    public String getCustomerContactEmail1() {
        return customerContactEmail1;
    }

    public void setCustomerContactEmail1(String customerContactEmail1) {
        this.customerContactEmail1 = customerContactEmail1;
    }

    public String getCustomerContactEmail2() {
        return customerContactEmail2;
    }

    public void setCustomerContactEmail2(String customerContactEmail2) {
        this.customerContactEmail2 = customerContactEmail2;
    }

    public String getCustomerContactFax() {
        return customerContactFax;
    }

    public void setCustomerContactFax(String customerContactFax) {
        this.customerContactFax = customerContactFax;
    }

    public String getCustomerContactPhone1() {
        return customerContactPhone1;
    }

    public void setCustomerContactPhone1(String customerContactPhone1) {
        this.customerContactPhone1 = customerContactPhone1;
    }

    public String getCustomerContactPhone2() {
        return customerContactPhone2;
    }

    public void setCustomerContactPhone2(String customerContactPhone2) {
        this.customerContactPhone2 = customerContactPhone2;
    }

    public int getCustomerEvaluate() {
        return customerEvaluate;
    }

    public void setCustomerEvaluate(int customerEvaluate) {
        this.customerEvaluate = customerEvaluate;
    }


    public String getCustomerRevenueDueYear() {
        return customerRevenueDueYear;
    }

    public void setCustomerRevenueDueYear(String customerRevenueDueYear) {
        this.customerRevenueDueYear = customerRevenueDueYear;
    }

    public String getCustomerClassify() {
        return customerClassify;
    }

    public void setCustomerClassify(String customerClassify) {
        this.customerClassify = customerClassify;
    }

    public String getCustomerTypeCombo() {
        return customerTypeCombo;
    }

    public void setCustomerTypeCombo(String customerTypeCombo) {
        this.customerTypeCombo = customerTypeCombo;
    }

    public String getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(String customerGroup) {
        this.customerGroup = customerGroup;
    }

    public long getCustomerCompanyEstablishmentDay() {
        return customerCompanyEstablishmentDay;
    }

    public void setCustomerCompanyEstablishmentDay(long customerCompanyEstablishmentDay) {
        this.customerCompanyEstablishmentDay = customerCompanyEstablishmentDay;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCustomerStockCode() {
        return customerStockCode;
    }

    public void setCustomerStockCode(String customerStockCode) {
        this.customerStockCode = customerStockCode;
    }

    public String getCustomerBusiness() {
        return customerBusiness;
    }

    public void setCustomerBusiness(String customerBusiness) {
        this.customerBusiness = customerBusiness;
    }

    public String getCustomerIdNumber() {
        return customerIdNumber;
    }

    public void setCustomerIdNumber(String customerIdNumber) {
        this.customerIdNumber = customerIdNumber;
    }

    public String getCustomerContactInformation() {
        return customerContactInformation;
    }

    public void setCustomerContactInformation(String customerContactInformation) {
        this.customerContactInformation = customerContactInformation;
    }
}
