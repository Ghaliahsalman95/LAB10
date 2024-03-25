package com.example.lab10.Service;

import com.example.lab10.Model.JobApplication;
import com.example.lab10.Repository.JobApplicationRepository;
import com.example.lab10.Repository.JobPostRepository;
import com.example.lab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final JobPostRepository jobPostRepository;
    private final UserRepository userRepository;


    public List<JobApplication> getJobApp() {
    return jobApplicationRepository.findAll();}
    public Boolean addJobApp(JobApplication jobApplication) {
        if (jobPostRepository.existsById(jobApplication.getJob_postID()) ){
        if(userRepository.existsById(jobApplication.getUser_id())) {
            //Note: Verify that the job post and the user exists.
            jobApplicationRepository.save(jobApplication);
            return true;        }

    }return false;
    }

    public Boolean delete(Integer ID) {
        if (jobApplicationRepository.existsById(ID)) {
            jobApplicationRepository.delete(jobApplicationRepository.getById(ID));
            return true;
        }
        return false;
    }

    public Boolean update(Integer ID, JobApplication jobApplication) {
        if (jobApplicationRepository.existsById(ID)) {
            if (jobPostRepository.existsById(jobApplication.getJob_postID()) ){
                if(userRepository.existsById(jobApplication.getUser_id())) {
                    JobApplication retriveJobApplication = jobApplicationRepository.getById(ID);
                        retriveJobApplication.setJob_postID(jobApplication.getJob_postID());
                        retriveJobApplication.setUser_id(jobApplication.getUser_id());
                        jobApplicationRepository.save(retriveJobApplication);
                        return true;
                    }

            }

        return false;}
    return false;}}