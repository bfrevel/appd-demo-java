package com.appdynamics.demo.java.load.components;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

@Component
public class Customers {

    private final List<UUID> validCustomersList = new LinkedList<>();
    private final List<UUID> invalidCustomersList = new LinkedList<>();
    private final List<UUID> customersList = new LinkedList<>();

    public Customers() {
        validCustomersList.add(UUID.fromString("f3816755-bd56-45f3-87f1-84f6533ac8e7"));
        validCustomersList.add(UUID.fromString("1fbe4da1-8ad7-4738-a847-321d0837388b"));
        validCustomersList.add(UUID.fromString("31ddb087-c7e1-450b-9172-e3ef914ef1e5"));
        validCustomersList.add(UUID.fromString("8f7ec18d-314f-48fc-b8c0-cdc2ce4588c6"));
        validCustomersList.add(UUID.fromString("eb69a52c-2967-44ed-ad8d-81a455d434ee"));
        validCustomersList.add(UUID.fromString("c259be0b-27a1-4b9a-a396-409ac71e6d3d"));
        validCustomersList.add(UUID.fromString("b7901328-b4a6-40b7-9c46-c94a83d8564c"));
        validCustomersList.add(UUID.fromString("24932dcd-a40d-4644-8343-305345da3c38"));
        validCustomersList.add(UUID.fromString("5dc162e5-a2eb-4589-b92d-3380e45a5b67"));
        validCustomersList.add(UUID.fromString("cc8d4572-a1df-4ea5-8674-b2df6a1ae4e1"));
        validCustomersList.add(UUID.fromString("c3b0b4a8-c367-4fcc-a1f2-f02931fe926c"));
        validCustomersList.add(UUID.fromString("73097129-cdf9-4992-b560-2ca1ad44a9f5"));
        validCustomersList.add(UUID.fromString("a3a6bdbc-d912-4fa3-a909-9b0593cf2aab"));
        validCustomersList.add(UUID.fromString("e72569fa-2bca-476e-ba71-382f7462bf03"));
        validCustomersList.add(UUID.fromString("04cb92d4-ae97-441d-b955-048f74759627"));
        validCustomersList.add(UUID.fromString("3468b93d-04e5-424b-85a7-8507dc1d6290"));
        validCustomersList.add(UUID.fromString("b8fc542c-fe92-483a-8307-7dd3513f5a69"));
        validCustomersList.add(UUID.fromString("201ea626-ccb0-43b0-97ad-c116561a2d0a"));
        validCustomersList.add(UUID.fromString("e9dc10ad-9472-4b82-8e11-3e9c8d69d383"));
        validCustomersList.add(UUID.fromString("e464a760-8856-4550-870a-ebd584f20edf"));

        invalidCustomersList.add(UUID.fromString("c7d511d1-9de1-406d-bd67-96489f449d29"));

        customersList.addAll(validCustomersList);
        customersList.addAll(invalidCustomersList);
    }

    public UUID getRandomCustomer() {
        int randomElementIndex = ThreadLocalRandom.current().nextInt(customersList.size());
        return customersList.get(randomElementIndex);
    }

    public UUID getRandomValidCustomer() {
        int randomElementIndex = ThreadLocalRandom.current().nextInt(validCustomersList.size());
        return validCustomersList.get(randomElementIndex);
    }

    public UUID getRandomInvalidCustomer() {
        int randomElementIndex = ThreadLocalRandom.current().nextInt(invalidCustomersList.size());
        return invalidCustomersList.get(randomElementIndex);
    }

}
