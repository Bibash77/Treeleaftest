package org.example.solution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
import java.util.Date;
/**
 * @author Bibash Bogati
 * @created 2024-12-11 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProfile {
    private Integer customerId; // Existing 4-byte customer id
    private UUID newCustomerId; // New 128-bit UUID
    private String customerName;
    private String address;
    private String rfidNumber;
    private Date customerJoinedDate;

    // Method to create a new CustomerProfile with updated UUID
    public CustomerProfile withNewCustomerId(UUID newCustomerId) {
        return new CustomerProfile(this.customerId, newCustomerId, this.customerName, 
                                   this.address, this.rfidNumber, this.customerJoinedDate);
    }
}
