package org.example.solution;

import java.util.*;
/**
 * @author Bibash Bogati
 * @created 2024-12-11 */
public class CustomerProfileUpdater {

    public static List<CustomerProfile> updateCustomerProfiles(List<CustomerProfile> customerProfiles, Integer customerId) {

        if (customerId == null) {
            return generateNewProfile(customerProfiles);
        }

        // If customerId is not null, find the existing customer and update their profile
        for (int i = 0; i < customerProfiles.size(); i++) {
            CustomerProfile profile = customerProfiles.get(i);
            if (profile.getCustomerId().equals(customerId)) {
                UUID newCustomerId = UUID.randomUUID();
                CustomerProfile updatedProfile = profile.withNewCustomerId(newCustomerId);
                customerProfiles.set(i, updatedProfile);
                return customerProfiles;
            }
        }

        // If the customer does not exist in the collection, you can choose to add a new record
        return customerProfiles;
    }

    private static List<CustomerProfile> generateNewProfile(List<CustomerProfile> customerProfiles) {
        UUID newCustomerId = UUID.randomUUID();
        CustomerProfile newProfile = new CustomerProfile(null, newCustomerId, "New Vai",
                "New Place", "RFID12345", new Date());
        customerProfiles.add(newProfile);
        return customerProfiles;
    }

    public static void main(String[] args) {
        List<CustomerProfile> customerProfiles = new ArrayList<>();
        // uuid is 128 bit / 32 bytes in default
        customerProfiles.add(new CustomerProfile(2, UUID.randomUUID(), "Ram dai", "Kathmandu", "RFID0002", new Date()));
        customerProfiles.add(new CustomerProfile(1, UUID.randomUUID(), "Hari Vai", "Lalitpur", "RFID0001", new Date()));


        // Displaying initial profiles
        System.out.println("Initial Customer Profiles:");
        for (CustomerProfile profile : customerProfiles) {
            System.out.println("Customer ID: " + profile.getCustomerId() + ", New Customer ID: " + profile.getNewCustomerId());
        }

        customerProfiles = updateCustomerProfiles(customerProfiles, 1);

        customerProfiles = updateCustomerProfiles(customerProfiles, null);

        System.out.println("\nUpdated Customer Profiles:");

        // Display the profiles, distinguishing between old and new customers
        for (CustomerProfile profile : customerProfiles) {
            if (profile.getCustomerId() != null) {
                System.out.println("Old Customer - Customer ID: " + profile.getCustomerId()
                        + ", New Customer ID: " + profile.getNewCustomerId());
            } else {
                System.out.println("New Customer - Customer ID: null"
                        + ", New Customer ID: " + profile.getNewCustomerId());
            }
        }
    }
}
