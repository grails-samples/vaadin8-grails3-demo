package vaadin8.grails3.demo

import grails.gorm.services.Service
import grails.gorm.services.Where

@Service(Customer)
abstract class CustomerService {

    List<Customer> findAllByNames(String name) {
        if(!name) {
            return list()
        }

        searchByName name
    }

    @Where({ firstName =~ "%${name}%" || lastName =~ "%${name}%"})
    abstract List<Customer> searchByName(String name)

    abstract List<Customer> list()

    abstract Customer save(Customer contact)
}
