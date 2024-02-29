package com.learning.transactionmanagement.service;

import com.learning.transactionmanagement.entity.Address;
import com.learning.transactionmanagement.entity.Employee;
import com.learning.transactionmanagement.model.EmployeeReqDTO;
import com.learning.transactionmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressService addressService;

   // @Transactional
    
    public void addEmployee(EmployeeReqDTO employeeReqDTO) throws Exception {
        Employee employee = new Employee();
        employee.setName(employeeReqDTO.getName());
        Employee employeeSavedToDB = this.employeeRepository.save(employee);
        throw new RuntimeException();

    /*  //  Address address = null;
        Address address = new Address();
        address.setAddressId(123L);
        address.setAddress("Varanasi");
        address.setEmployee(employee);

        this.addressService.addAddress(address);*/
      //  return employeeSavedToDB;
    }
}
