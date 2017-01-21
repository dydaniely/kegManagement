package com.example.storeManagement.services.customers;


import com.example.storeManagement.dao.CustomerDao;
import com.example.storeManagement.dao.RecordNotFoundException;
import com.example.storeManagement.domain.Call;
import com.example.storeManagement.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Daniel on 11/3/2016.
 */
@Transactional
@Service("customerManagementService")
public class CustomerManagementServiceImpl implements CustomerManagementService  {


    private CustomerDao customerDao;

    @Autowired
    public CustomerManagementServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void newCustomer(Customer newCustomer) {
        customerDao.create(newCustomer);
    }

    @Override
    public void updateCustomer(Customer changedCustomer) throws CustomerNotFoundException  {
        try {
            customerDao.update(changedCustomer);
        }
        catch (RecordNotFoundException e){
            throw new CustomerNotFoundException();
        }
    }

    @Override
    public void deleteCustomer(Customer oldCustomer) throws CustomerNotFoundException{
        try {
            customerDao.delete(oldCustomer);
        }
        catch (RecordNotFoundException e)
        {
            throw new CustomerNotFoundException();
        }
    }

    @Override
    public Customer findCustomerById(int customerId) throws CustomerNotFoundException {

        try {
            return customerDao.getById(customerId);
        }
        catch (RecordNotFoundException e){
            throw  new CustomerNotFoundException();
        }


    }

    @Override
    public List<Customer> findCustomersByName(String name) throws CustomerNotFoundException {
        return customerDao.getByName(name);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    public Customer getFullCustomerDetail(int customerId) throws CustomerNotFoundException {
        try {
            return customerDao.getFullCustomerDetail(customerId);
        } catch (RecordNotFoundException e) {
            throw new CustomerNotFoundException();
        }
    }
    @Override
    public void recordCall(int customerId, Call callDetails) throws CustomerNotFoundException {
    try {
        customerDao.addCall(callDetails, customerId);
    }
    catch (RecordNotFoundException e)
    {
        throw  new CustomerNotFoundException();
    }
    }
}
