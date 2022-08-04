package com.appdynamics.demo.java.customer.components;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.appdynamics.demo.java.customer.entities.Customer;
import com.appdynamics.demo.java.customer.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@RequiredArgsConstructor
@Log4j2
class CustomerInitBean implements InitializingBean {

    private final CustomerRepository customerRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

        List<Customer> initCustomers = new LinkedList<>();
        initCustomers.add(new Customer(UUID.fromString("f3816755-bd56-45f3-87f1-84f6533ac8e7"), "Demimbu"));
        initCustomers.add(new Customer(UUID.fromString("1fbe4da1-8ad7-4738-a847-321d0837388b"), "Cogibox"));
        initCustomers.add(new Customer(UUID.fromString("31ddb087-c7e1-450b-9172-e3ef914ef1e5"), "Kazu"));
        initCustomers.add(new Customer(UUID.fromString("8f7ec18d-314f-48fc-b8c0-cdc2ce4588c6"), "Mybuzz"));
        initCustomers.add(new Customer(UUID.fromString("eb69a52c-2967-44ed-ad8d-81a455d434ee"), "Aimbu"));
        initCustomers.add(new Customer(UUID.fromString("c259be0b-27a1-4b9a-a396-409ac71e6d3d"), "Buzzster"));
        initCustomers.add(new Customer(UUID.fromString("b7901328-b4a6-40b7-9c46-c94a83d8564c"), "Flipstorm"));
        initCustomers.add(new Customer(UUID.fromString("24932dcd-a40d-4644-8343-305345da3c38"), "Bluejam"));
        initCustomers.add(new Customer(UUID.fromString("5dc162e5-a2eb-4589-b92d-3380e45a5b67"), "Skippad"));
        initCustomers.add(new Customer(UUID.fromString("cc8d4572-a1df-4ea5-8674-b2df6a1ae4e1"), "Zava"));
        initCustomers.add(new Customer(UUID.fromString("c3b0b4a8-c367-4fcc-a1f2-f02931fe926c"), "Meetz"));
        initCustomers.add(new Customer(UUID.fromString("73097129-cdf9-4992-b560-2ca1ad44a9f5"), "Trilia"));
        initCustomers.add(new Customer(UUID.fromString("a3a6bdbc-d912-4fa3-a909-9b0593cf2aab"), "Babbleopia"));
        initCustomers.add(new Customer(UUID.fromString("e72569fa-2bca-476e-ba71-382f7462bf03"), "Topicstorm"));
        initCustomers.add(new Customer(UUID.fromString("04cb92d4-ae97-441d-b955-048f74759627"), "Kimia"));
        initCustomers.add(new Customer(UUID.fromString("3468b93d-04e5-424b-85a7-8507dc1d6290"), "Nlounge"));
        initCustomers.add(new Customer(UUID.fromString("b8fc542c-fe92-483a-8307-7dd3513f5a69"), "Youtags"));
        initCustomers.add(new Customer(UUID.fromString("201ea626-ccb0-43b0-97ad-c116561a2d0a"), "Mynte"));
        initCustomers.add(new Customer(UUID.fromString("e9dc10ad-9472-4b82-8e11-3e9c8d69d383"), "Janyx"));
        initCustomers.add(new Customer(UUID.fromString("e464a760-8856-4550-870a-ebd584f20edf"), "Mita"));

        customerRepository.saveAll(initCustomers);

        log.info("[x] created initial customers ");

    }

}