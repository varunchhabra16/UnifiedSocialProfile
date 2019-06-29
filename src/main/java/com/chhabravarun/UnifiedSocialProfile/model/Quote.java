package com.chhabravarun.UnifiedSocialProfile.model;

import com.chhabravarun.UnifiedSocialProfile.model.CFUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    private String status;
    private CFUser result;

    public Quote(){}

    public String getStatus(){
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CFUser getResult() {
        return result;
    }

    public void setResult(CFUser result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "status='" + status + '\'' +
                ", result=" + result +
                '}';
    }
}
