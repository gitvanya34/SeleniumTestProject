package ru.qa.ui.ApiQase;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

//@JsonAutoDetect
@Data
public class  BodyRequest {
    @JsonProperty("case_id")
    private String case_id;

    @JsonProperty("time")
    private String time;

    @JsonProperty("status")
    private String status;

    @JsonProperty("member_id")
    private String member_id;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("defect")
    private String defect;

    @JsonProperty("steps")
    private ArrayList<StepRequest> steps = new ArrayList<StepRequest>();

    @JsonProperty("attachments")
    private ArrayList<String> attachments = new ArrayList<String>();

    private int counterStep= 1;

   public  BodyRequest() {
        this.case_id = "1";
        this.status="failed";
        this.member_id="1";
       // this.member_id=Request.get
//        this.time = time;
//        this.status = status;
//        this.member_id = member_id;
//        this.comment = comment;
//        this.defect = defect;
//        StepRequest steps = new StepRequest(positionStep,statusStep,commentStep);
//        this.steps.add(steps);
         // return this;
      //  FillSteps();
   }

    public void AddStep(String positionStep,String statusStep,String commentStep){
        this.steps.add(new StepRequest(positionStep,statusStep,commentStep));
    }
    public void AddStep(String positionStep,String statusStep,String commentStep,ArrayList<String> attach){
        this.steps.add(new StepRequest(positionStep,statusStep,commentStep,attach));
    }
//    public void AddStep(String positionStep,String statusStep,String commentStep,ArrayList<String> attachment){
//        this.steps.add(new StepRequest(positionStep,statusStep,commentStep,attachment));
//    }


//    public void StepPassed() {
//       ArrayList<String> test =  new ArrayList<String>();
//
//      // test.add(""); //33bf1e031bc885223e0aacaca6bd664087ee7713
//       //  AddStep( String.valueOf(counterStep), "passed", "" );
//
//    //    AddStep( String.valueOf(counterStep), "passed", "");
//        AddStep( String.valueOf(counterStep), "passed", "",test);
//        counterStep++;
//    }
//    public void StepFailed() {
//     //   AddStep( String.valueOf(counterStep), "failed", "",GetHashAddAttachment("image.png"));
//        AddStep( String.valueOf(counterStep), "failed", "");
//        counterStep++;
//    }

}
