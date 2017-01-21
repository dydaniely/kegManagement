package com.example.storeManagement.dao;

import com.example.storeManagement.domain.Call;
import com.example.storeManagement.domain.Customer;
import com.example.storeManagement.services.customers.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Daniel on 11/23/2016.
 */
@Repository
public class CustomerDaoHibernateVersion implements  CustomerDao {


    private HibernateTemplate hibernateTemplate;

    @Autowired
    public CustomerDaoHibernateVersion(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void create(Customer newCustomer) {
    hibernateTemplate.save(newCustomer);
    }

    @Override
    public Customer getById(int customerId) throws RecordNotFoundException {

    return (Customer)  hibernateTemplate.findByNamedQuery("from Customer",customerId);
   }

    @Override
    public List<Customer> getByName(String name)  throws CustomerNotFoundException {

        List<Customer> customers = (List<Customer>) hibernateTemplate.find(name, Customer.class);
        if (customers.isEmpty()) {
            throw new CustomerNotFoundException();
        }
            return customers;
    }


    @Override
    public void update(Customer customerToUpdate) throws RecordNotFoundException {

    }

    @Override
    public void delete(Customer oldCustomer) throws RecordNotFoundException {
        Customer foundCustomer= (Customer) hibernateTemplate.find(String.valueOf(oldCustomer.getCustomerId()));
        hibernateTemplate.delete(oldCustomer);
    }
    @Override
    public List<Customer> getAllCustomers() {

        return null;
    }
    @Override
    public Customer getFullCustomerDetail(int customerId) throws RecordNotFoundException {
        return (Customer) hibernateTemplate.find(String.valueOf(customerId),Customer.class);
    }

    @Override
    public void addCall(Call newCall, int customerId) throws RecordNotFoundException {
        hibernateTemplate.update(newCall);
    }
}
