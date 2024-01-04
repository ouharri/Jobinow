package com.jobinow.services.impl;

import com.jobinow.model.entities.Apply;
import com.jobinow.model.entities.Company;
import com.jobinow.model.entities.Offre;
import com.jobinow.model.entities.Profil;
import com.jobinow.services.spec.JobSeekerService;

import java.util.List;

/**
 * Implementation of the {@link JobSeekerService} interface for job seeker-related operations.
 */
public class jobSeekerServiceImpl implements JobSeekerService{
    /**
     * Apply to a job by submitting an application for a specific job offer.
     *
     * @param offre The job offer to apply to.
     * @return The application object representing the submitted application.
     */
    @Override
    public Apply applyToJob(Offre offre) {
        return null;
    }

    /**
     * Get a list of job offers to which the job seeker has applied.
     *
     * @return A list of job offers for which the job seeker has submitted applications.
     */
    @Override
    public List<Offre> getAppliedJobs() {
        return null;
    }

    /**
     * Get a list of job offers that the job seeker has saved for future reference.
     *
     * @return A list of saved job offers.
     */
    @Override
    public List<Offre> getSavedJobs() {
        return null;
    }

    /**
     * Get a list of recommended job offers based on the job seeker's profile and preferences.
     *
     * @return A list of recommended job offers.
     */
    @Override
    public List<Offre> getRecommendedJobs() {
        return null;
    }

    /**
     * Get a list of job offers based on the job seeker's profile.
     *
     * @param profil The job seeker's profile.
     * @return A list of job offers that to match the job seeker's profile.
     */
    @Override
    public List<Offre> getJobsByProfile(Profil profil) {
        return null;
    }

    /**
     * Get a list of job offers based on a specific location.
     *
     * @param location The location for which to retrieve a job offers.
     * @return A list of job offers available in the specified location.
     */
    @Override
    public List<Offre> getJobsByLocation(String location) {
        return null;
    }

    /**
     * Get a list of job offers based on a specified salary range.
     *
     * @param salary The salary range for which to retrieve job offers.
     * @return A list of job offers within the specified salary range.
     */
    @Override
    public List<Offre> getJobsBySalary(double salary) {
        return null;
    }

    /**
     * Get a list of job offers based on a specific job title.
     *
     * @param title The job title for which to retrieve job offers.
     * @return A list of job offers with the specified job title.
     */
    @Override
    public List<Offre> getJobsByTitle(String title) {
        return null;
    }

    /**
     * Get a list of job offers associated with a specific company.
     *
     * @param company The company for which to retrieve job offers.
     * @return A list of job offers associated with the specified company.
     */
    @Override
    public List<Offre> getJobsByCompany(Company company) {
        return null;
    }
}
