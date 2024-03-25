package com.example.lab10.Service;

import com.example.lab10.Model.JobPost;
import com.example.lab10.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {

    private final JobPostRepository jobPostRepository;

    public List<JobPost> getJobPostRepository() {
        return jobPostRepository.findAll();
    }

    public void addJobPost(JobPost jobPost) {
        jobPostRepository.save(jobPost);
    }

    public Boolean updateJobPost(Integer ID, JobPost jobPost) {
        if (jobPostRepository.existsById(ID)) {//Note: Verify that the job post exists.
            JobPost retriveJobPost = jobPostRepository.getById(ID);
            retriveJobPost.setPostingDate(jobPost.getPostingDate());
            retriveJobPost.setDescription(jobPost.getDescription());
            retriveJobPost.setTitle(jobPost.getTitle());
            retriveJobPost.setSalary(jobPost.getSalary());
            retriveJobPost.setLocation(jobPost.getLocation());
            jobPostRepository.save(retriveJobPost);
            return true;
        }
        return false;
    }

    public Boolean delete(Integer ID) {
        if (jobPostRepository.existsById(ID)) {//Note: Verify that the job post exists.
            jobPostRepository.save(jobPostRepository.getById(ID));
            return true;
        }
        return false;
    }

}
