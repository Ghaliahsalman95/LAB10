package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.APIResponse;
import com.example.lab10.Model.JobApplication;
import com.example.lab10.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor@RestController@RequestMapping("api/v1/job-app")
public class JobApplicationsController {
    private final JobApplicationService jobApplicationService;

    @GetMapping("/get-all")
    public ResponseEntity getAll() {
        if (!jobApplicationService.getJobApp().isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(jobApplicationService.getJobApp());
        return ResponseEntity.status(400).body(new APIResponse("Empty List of jobApplication"));
    }

    @PostMapping("/add-job-app")
    public ResponseEntity addjobapp(@RequestBody @Valid JobApplication jobApplication, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
       if(jobApplicationService.addJobApp(jobApplication))
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("JobApplication ID " + jobApplication.getID()+" is added successfully"));

        return ResponseEntity.status(400).body(new APIResponse("JobApplication ID " + jobApplication.getID()+" is failed "));
    }
    @PutMapping("/update-job-app/{ID}")
    public ResponseEntity update(@PathVariable Integer ID, @RequestBody @Valid JobApplication jobApplication, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (jobApplicationService.update(ID,jobApplication))
            return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Updated successfully"));
        return ResponseEntity.status(400).body(new APIResponse("Updated failed"));
    }@DeleteMapping("/delete-job-app/{ID}")
    public ResponseEntity delete(@PathVariable Integer ID){
        if (jobApplicationService.delete(ID))
            return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Deleted successfully"));
        return ResponseEntity.status(400).body(new APIResponse("Deleted failed"));

    }

}
