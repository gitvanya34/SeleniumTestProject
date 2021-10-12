package ru.qa.ui.ApiQase;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@JsonAutoDetect
@Data
public class StepRequest {
    @JsonProperty("position")
    private String position;
    @JsonProperty("status")
    private String status;
    @JsonProperty("comment")
    private String comment;
    @JsonProperty("attachments")
    private ArrayList<String> attachments;


    public StepRequest(String position, String status, String comment) {
        this.position = position;
        this.status = status;
        this.comment = comment;
    }
    public StepRequest(String position, String status, String comment,ArrayList<String> attachment) {
        this.position = position;
        this.status = status;
        this.comment = comment;
        this.attachments=attachment;
       // this.attachments.add(attachment);
    }


}
