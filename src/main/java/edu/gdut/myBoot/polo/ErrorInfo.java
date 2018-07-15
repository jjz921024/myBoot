package edu.gdut.myBoot.polo;

/**
 * Created by Jun on 2018/7/13.
 */
public class ErrorInfo {
    private int status;
    private String error;
    private String desc;

    public ErrorInfo(int status, String error, String desc) {
        this.status = status;
        this.error = error;
        this.desc = desc;
    }

    public ErrorInfo() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
