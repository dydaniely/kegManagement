package com.example.storeManagement.services.calls;

import com.example.storeManagement.domain.Action;
import com.example.storeManagement.domain.Call;
import com.example.storeManagement.services.customers.CustomerNotFoundException;

import java.util.Collection;

public interface CallHandlingService 
{
	// DO NOT IMPLEMENT THIS INTERFACE UNTIL A LATER CHAPTER!
	
	/**
	 * Records a call with the customer management services, and also records
	 * any actions in the diary services
	 */

	public void recordCall(int customerId, Call newCall, Collection<Action> actions) throws CustomerNotFoundException;
}
