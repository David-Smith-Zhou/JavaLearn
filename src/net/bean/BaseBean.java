package net.bean;

import com.google.gson.annotations.SerializedName;

public class BaseBean<T> {
    @SerializedName("resp_status")
    private String resp_status;
    @SerializedName("resp_data")
    private T resp_data;
    @SerializedName("error_code")
    private String error_code;
    @SerializedName("error_desc")
    private String error_desc;

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public void setError_desc(String error_desc) {
        this.error_desc = error_desc;
    }

    public void setResp_data(T resp_data) {
        this.resp_data = resp_data;
    }

    public void setResp_status(String resp_status) {
        this.resp_status = resp_status;
    }

    public String getError_code() {
        return error_code;
    }

    public String getError_desc() {
        return error_desc;
    }

    public T getResp_data() {
        return resp_data;
    }

    public String getResp_status() {
        return resp_status;
    }
}
