package vaadin8.grails3.demo

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@Transactional
class CustomerService {


    @ReadOnly
    def findAllByNames(String name) {
        if(!name) {
            return Customer.findAll()
        }

        return Customer.findAllByFirstNameIlikeOrLastNameIlike("%${name}%", "%${name}%")
    }


    def save(Customer contact) {
        contact.save()
    }

    def delete(Customer customer) {
        customer.delete()
    }
}
