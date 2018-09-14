package bys.crm.hbc.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Customer implements Serializable{
    @SerializedName("id")
    private int id;
    @SerializedName("customerName")
    private String customerName;
    @SerializedName("customerNo")
    private String customerNo;
    @SerializedName("customerDesc")
    private String customerDesc;
    @SerializedName("customerWebsite")
    private String customerWebsite;
    @SerializedName("customerFaxNumber")
    private String customerFaxNumber;
    @SerializedName("customerPhone1")
    private String customerPhone1;
    @SerializedName("customerTaxNumber")
    private String customerTaxNumber;
    @SerializedName("customerEmail1")
    private String customerEmail1;
    @SerializedName("employee")
    private User employee;
    @SerializedName("customerEmail2")
    private String customerEmail2;

    @SerializedName("customerPhone2")
    private String customerPhone2;
    @SerializedName("customerClassify")
    private KeyValue customerClassify;
    @SerializedName("customerEvaluate")
    private int customerEvaluate;
    @SerializedName("customerTypeCombo")
    private KeyValue customerTypeCombo;
    @SerializedName("customerRevenueDueYear")
    private String customerRevenueDueYear;
    @SerializedName("customerGroup")
    private KeyValue customerGroup;
    @SerializedName("customerCompanyEstablishmentDay")
    private long customerCompanyEstablishmentDay;
    @SerializedName("customerAddress")
    private String customerAddress;
    @SerializedName("customerContactInformation")
    private String customerContactInformation;
    @SerializedName("customerStockCode")
    private String customerStockCode;
    @SerializedName("customerBusiness")
    private String customerBusiness;
    @SerializedName("customerIdNumber")
    private String customerIdNumber;


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

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerDesc() {
        return customerDesc;
    }

    public void setCustomerDesc(String customerDesc) {
        this.customerDesc = customerDesc;
    }

    public String getCustomerWebsite() {
        return customerWebsite;
    }

    public void setCustomerWebsite(String customerWebsite) {
        this.customerWebsite = customerWebsite;
    }

    public String getCustomerFaxNumber() {
        return customerFaxNumber;
    }

    public void setCustomerFaxNumber(String customerFaxNumber) {
        this.customerFaxNumber = customerFaxNumber;
    }

    public String getCustomerPhone2() {
        return customerPhone2;
    }

    public void setCustomerPhone2(String customerPhone2) {
        this.customerPhone2 = customerPhone2;
    }

    public String getCustomerTaxNumber() {
        return customerTaxNumber;
    }

    public void setCustomerTaxNumber(String customerTaxNumber) {
        this.customerTaxNumber = customerTaxNumber;
    }

    public String getCustomerEmail2() {
        return customerEmail2;
    }

    public void setCustomerEmail2(String customerEmail2) {
        this.customerEmail2 = customerEmail2;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public String getCustomerEmail1() {
        return customerEmail1;
    }

    public void setCustomerEmail1(String customerEmail1) {
        this.customerEmail1 = customerEmail1;
    }


    public String getCustomerPhone1() {
        return customerPhone1;
    }

    public void setCustomerPhone1(String customerPhone1) {
        this.customerPhone1 = customerPhone1;
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

    public KeyValue getCustomerClassify() {
        return customerClassify;
    }

    public void setCustomerClassify(KeyValue customerClassify) {
        this.customerClassify = customerClassify;
    }

    public KeyValue getCustomerTypeCombo() {
        return customerTypeCombo;
    }

    public void setCustomerTypeCombo(KeyValue customerTypeCombo) {
        this.customerTypeCombo = customerTypeCombo;
    }

    public KeyValue getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(KeyValue customerGroup) {
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

    public String getCustomerContactInformation() {
        return customerContactInformation;
    }

    public void setCustomerContactInformation(String customerContactInformation) {
        this.customerContactInformation = customerContactInformation;
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
}
