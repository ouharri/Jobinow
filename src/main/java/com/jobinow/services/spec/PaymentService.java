package com.jobinow.services.spec;

/**
 * Service interface for handling payments in the system.
 * The payment can be made through bank transfer or using Stripe/PayPal.
 */
public interface PaymentService {

    /**
     * Process a payment using bank transfer.
     *
     * @param amount      The amount to be paid.
     * @param accountInfo The bank account information for the transfer.
     * @return A confirmation or response related to the bank transfer payment.
     */
    String processBankTransferPayment(double amount, String accountInfo);

    /**
     * Process a payment using Stripe.
     *
     * @param amount         The amount to be paid.
     * @param stripeToken    The token representing the payment details in Stripe.
     * @param customerEmail  The email address of the customer.
     * @return A confirmation or response related to the Stripe payment.
     */
    String processStripePayment(double amount, String stripeToken, String customerEmail);

    /**
     * Process a payment using PayPal.
     *
     * @param amount         The amount to be paid.
     * @param paypalUsername The username associated with the PayPal account.
     * @return A confirmation or response related to the PayPal payment.
     */
    String processPayPalPayment(double amount, String paypalUsername);

}