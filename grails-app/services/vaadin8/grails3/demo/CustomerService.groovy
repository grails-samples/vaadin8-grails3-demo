package vaadin8.grails3.demo

import grails.gorm.services.Service
import grails.gorm.services.Where

import java.time.LocalDate

@Service(Customer)
interface CustomerService {

    @Where({
        if(name) {
            firstName =~ "%${name}%" || lastName =~ "%${name}%"
        }
    })
    List<Customer> findAllByNames(String name)

    Customer save(Customer contact)

    Customer save(String firstName, String lastName, String phone, String email, Customer.CustomerStatus status, LocalDate birthDate)
}
