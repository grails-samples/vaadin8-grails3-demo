package vaadin8.grails3.demo

import java.time.LocalDate

class BootStrap {

    def init = { servletContext ->

        final fnames = [ "Peter", "Alice", "John", "Mike", "Olivia",
            "Nina", "Alex", "Rita", "Dan", "Umberto", "Henrik", "Rene", "Lisa",
            "Linda", "Timothy", "Daniel", "Brian", "George", "Scott",
            "Jennifer" ]
        final lnames = [ "Smith", "Johnson", "Williams", "Jones",
            "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor",
            "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin",
            "Thompson", "Young", "King", "Robinson" ]

        Random r = new Random(0);
        for (int i = 0; i < 100; i++) {
            Customer customer = new Customer();

            customer.firstName = fnames[r.nextInt(fnames.size())]
            customer.lastName = lnames[r.nextInt(fnames.size())]
            customer.email = "${customer.firstName.toLowerCase()}@${customer.lastName.toLowerCase()}.com"
            customer.phone = "+ 358 555 " + (100 + r.nextInt(900))
            customer.birthDate = new LocalDate(1930 + r.nextInt(70), 1 + r.nextInt(11),1 + r.nextInt(27))

            def statuses = Customer.CustomerStatus.values()
            customer.status = statuses[r.nextInt(statuses.size())]
            customer.save()
        }
    }
    def destroy = {
    }
}
