package com.example.storeManagement.services.calls;


import com.example.storeManagement.domain.Action;
import com.example.storeManagement.domain.Call;
import com.example.storeManagement.services.customers.CustomerManagementService;
import com.example.storeManagement.services.customers.CustomerNotFoundException;
import com.example.storeManagement.services.diary.DiaryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Collection;

/**
 * Created by Daniel on 10/26/2016.
 */
@Transactional
@Service("callHandlingService")
public class CallHandlingServiceImpl implements CallHandlingService {

    private CustomerManagementService customerService;
     private DiaryManagementService diaryService;

    @Autowired
    public CallHandlingServiceImpl(CustomerManagementService customerService, DiaryManagementService diaryService) {
        this.customerService = customerService;
        this.diaryService = diaryService;
    }

    @Override
    public void recordCall(int customerId, Call newCall, Collection<Action> actions) throws CustomerNotFoundException {

        Calendar calendar = Calendar.getInstance();
        System.out.println("Customer services is called");
        customerService.recordCall(customerId, newCall);

        for (Action nextAction:actions){
            System.out.println("record action is called");
        diaryService.recordAction(nextAction);
    }
    }

    public CustomerManagementService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerManagementService customerService) {
        this.customerService = customerService;
    }

    public DiaryManagementService getDiaryService() {
        return diaryService;
    }

    public void setDiaryService(DiaryManagementService diaryService) {
        this.diaryService = diaryService;
    }
}
