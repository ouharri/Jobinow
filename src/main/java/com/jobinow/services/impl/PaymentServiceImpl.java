package com.jobinow.services.impl;

import com.jobinow.services.spec.PaymentService;

/**
 * Implementation class for the PaymentService interface.
 * This class provides methods for handling payment functionality, including bank transfers
 * and payment processing with Stripe/PayPal.
 */
public class PaymentServiceImpl implements PaymentService {


    /**
     * Process a payment using bank transfer.
     *
     * @param amount      The amount to be paid.
     * @param accountInfo The bank account information for the transfer.
     * @return A confirmation or response related to the bank transfer payment.
     */
    @Override
    public String processBankTransferPayment(double amount, String accountInfo) {
        return null;
    }

    /**
     * Process a payment using Stripe.
     *
     * @param amount        The amount to be paid.
     * @param stripeToken   The token representing the payment details in Stripe.
     * @param customerEmail The email address of the customer.
     * @return A confirmation or response related to the Stripe payment.
     */
    @Override
    public String processStripePayment(double amount, String stripeToken, String customerEmail) {
        return null;
    }

    /**
     * Process a payment using PayPal.
     *
     * @param amount         The amount to be paid.
     * @param paypalUsername The username associated with the PayPal account.
     * @return A confirmation or response related to the PayPal payment.
     */
    @Override
    public String processPayPalPayment(double amount, String paypalUsername) {
        return null;
    }
}