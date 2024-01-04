package com.jobinow.services.spec;

import com.jobinow.model.entities.*;

import java.util.List;

/**
 * Service interface for job seeker-related operations in the recruitment application.
 */
public interface JobSeekerService {

    /**
     * Apply to a job by submitting an application for a specific job offer.
     *
     * @param Offer The job offer to apply to.
     * @return The application object representing the submitted application.
     */
    Apply applyToJob(Offer Offer);

    /**
     * Get a list of job offers to which the job seeker has applied.
     *
     * @param  jobSeeker  job seeker who submitted the applications
     * @return A list of job offers for which the job seeker has submitted applications.
     */
    List<Offer> getAppliedJobs(User jobSeeker);

    /**
     * Get a list of job offers that the job seeker has saved for future reference.
     *
     * @return A list of saved job offers.
     */
    List<Offer> getSavedJobs();

    /**
     * Get a list of recommended job offers based on the job seeker's profile and preferences.
     *
     * @return A list of recommended job offers.
     */
    List<Offer> getRecommendedJobs();

    /**
     * Get a list of job offers based on the job seeker's profile.
     *
     * @param profil The job seeker's profile.
     * @return A list of job offers that to match the job seeker's profile.
     */
    List<Offer> getJobsByProfile(Profil profil);

    /**
     * Get a list of job offers based on a specific location.
     *
     * @param location The location for which to retrieve a job offers.
     * @return A list of job offers available in the specified location.
     */
    List<Offer> getJobsByLocation(String location);

    /**
     * Get a list of job offers based on a specified salary range.
     *
     * @param salary The salary range for which to retrieve job offers.
     * @return A list of job offers within the specified salary range.
     */
    List<Offer> getJobsBySalary(double salary);

    /**
     * Get a list of job offers based on a specific job title.
     *
     * @param title The job title for which to retrieve job offers.
     * @return A list of job offers with the specified job title.
     */
    List<Offer> getJobsByTitle(String title);

    /**
     * Get a list of job offers associated with a specific company.
     *
     * @param company The company for which to retrieve job offers.
     * @return A list of job offers associated with the specified company.
     */
    List<Offer> getJobsByCompany(Company company);
}