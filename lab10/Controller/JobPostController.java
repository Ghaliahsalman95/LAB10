package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.APIResponse;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Model.User;
import com.example.lab10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor@RestController@RequestMapping("api/v1/job-post")
public class JobPostController {

    private final JobPostService jobPostService;

    @GetMapping("/get-all")
    public ResponseEntity getAll() {
        if (!jobPostService.getJobPostRepository().isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(jobPostService.getJobPostRepository());
        return ResponseEntity.status(400).body(new APIResponse("Empty List of JobPost"));
    }

    @PostMapping("/add-job-post")
    public ResponseEntity addjobpost(@RequestBody @Valid JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        jobPostService.addJobPost(jobPost);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("JobPost ID " + jobPost.getID() + " Title " + jobPost.getTitle()+ " is added successfully"));
    }
    @PutMapping("/update-job-post/{ID}")
    public ResponseEntity update(@PathVariable Integer ID, @RequestBody @Valid JobPost jobPost, Errors errors){
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        if (jobPostService.updateJobPost(ID,jobPost))
            return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Updated successfully"));
        return ResponseEntity.status(400).body(new APIResponse("Updated failed"));
    }@DeleteMapping("/delete-job-post/{ID}")
    public ResponseEntity delete(@PathVariable Integer ID){
        if (jobPostService.delete(ID))
            return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Deleted successfully"));
        return ResponseEntity.status(400).body(new APIResponse("Deleted failed"));

    }
    
    
}
