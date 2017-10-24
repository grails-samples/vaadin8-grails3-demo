package vaadin8.grails3.demo

import com.vaadin.data.Binder
import com.vaadin.event.ShortcutAction
import com.vaadin.ui.*
import com.vaadin.ui.themes.ValoTheme

/* Create custom UI Components.
 *
 * Create your own Vaadin components by inheritance and composition.
 * This is a form component inherited from VerticalLayout. Use
 * Use BeanFieldGroup to bind data fields from DTO to UI fields.
 * Similarly named field by naming convention or customized
 * with @PropertyId annotation.
 */
class CustomerForm extends FormLayout {

    private TextField firstName = new TextField("First name")
    private TextField lastName = new TextField("Last name")
    private TextField email = new TextField("Email")
    private TextField phone = new TextField("Phone")
    private NativeSelect<Customer.CustomerStatus> status = new NativeSelect<>("Status")
    private DateField birthdate = new DateField("Birthday")
    private Button save = new Button("Save")
    private Button delete = new Button("Delete")
    private GrailsUI myUI
    private Customer customer

    private Binder<Customer> binder = new Binder<>(Customer)

    CustomerForm(GrailsUI myUI) {

        this.myUI = myUI
        setSizeUndefined()
        HorizontalLayout buttons = new HorizontalLayout(save, delete)
        addComponents(firstName, lastName, email, phone, status, birthdate, buttons)
        status.setItems(Customer.CustomerStatus.values())

        save.styleName = ValoTheme.BUTTON_PRIMARY
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER)

        binder.bindInstanceFields(this)

        save.addClickListener({ e -> save()})
        delete.addClickListener( { e -> delete()})

    }

    void setCustomer(Customer customer) {
        this.customer = customer
        binder.bean = customer

        // Show delete button for only customers already in the database
        delete.setVisible(customer.id != null)
        visible = true
        firstName.selectAll()
    }

    void delete() {
        myUI.contactService.delete(customer)
        myUI.updateList()
        visible = false
    }

    void save() {
        myUI.contactService.save(customer)
        myUI.updateList()
        visible = false
    }

}
