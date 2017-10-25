package vaadin8.grails3.demo

import java.time.LocalDate

class BootStrap {

    CustomerService customerService

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
        def statuses = Customer.CustomerStatus.values()
        for (int i = 0; i < 100; i++) {
            String firstName = fnames[r.nextInt(fnames.size())]
            String lastName = lnames[r.nextInt(fnames.size())]
            String email = "${firstName.toLowerCase()}@${lastName.toLowerCase()}.com"
            String phone = "+ 358 555 " + (100 + r.nextInt(900))
            LocalDate birthDate = new LocalDate(1930 + r.nextInt(70), 1 + r.nextInt(11),1 + r.nextInt(27))

            Customer.CustomerStatus status = statuses[r.nextInt(statuses.size())]

            customerService.save(firstName, lastName, phone, email, status, birthDate)
        }
    }
    def destroy = {
    }
}
