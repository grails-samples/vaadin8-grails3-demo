package vaadin8.grails3.demo

import groovy.transform.EqualsAndHashCode

import java.time.LocalDate

@EqualsAndHashCode
class Customer {
    String firstName
    String lastName
    String phone
    String email
    CustomerStatus status
    LocalDate birthDate

    static constraints = {

    }

    enum CustomerStatus {
        ImportedLead, NotContacted, Contacted, Customer, ClosedLost
    }
}
