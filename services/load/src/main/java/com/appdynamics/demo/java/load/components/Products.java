package com.appdynamics.demo.java.load.components;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

@Component
public class Products {

    private final List<UUID> validProductsList = new LinkedList<>();
    private final List<UUID> invalidProductsList = new LinkedList<>();
    private final List<UUID> productsList = new LinkedList<>();

    public Products() {
        validProductsList.add(UUID.fromString("1aead14e-e32b-412f-a522-ead4d03b6c37"));
        validProductsList.add(UUID.fromString("a5652e28-0c82-4d23-a241-d2e992e624e5"));
        validProductsList.add(UUID.fromString("2275bdfa-7999-4a93-a2c0-4c35c871b11d"));
        validProductsList.add(UUID.fromString("6fe35bed-73bf-447f-8e6d-db196a2d85b9"));
        validProductsList.add(UUID.fromString("9747bb46-ad7e-4700-90ff-47d11c14d7ac"));
        validProductsList.add(UUID.fromString("4de4e42c-b0f2-4dad-91d6-ff8244c183bc"));
        validProductsList.add(UUID.fromString("1e8e483e-0c8b-4b7f-b5a4-77641ec3cedb"));
        validProductsList.add(UUID.fromString("035e014a-5230-49eb-a45b-35f46dcea21c"));
        validProductsList.add(UUID.fromString("56ac6b98-6694-4021-9c67-f4d438ed2405"));
        validProductsList.add(UUID.fromString("d8d39de2-86b7-4e06-b0c8-84288b05a43f"));
        validProductsList.add(UUID.fromString("dd7fcecb-59d1-46f7-90c8-9a8d98618195"));
        validProductsList.add(UUID.fromString("04ae67a6-5e73-4416-98ac-945b88f6f5da"));
        validProductsList.add(UUID.fromString("9ba06785-5533-46f7-b02f-bc7107091e15"));
        validProductsList.add(UUID.fromString("c6ce7610-ee17-448e-841c-d9bc56034fa7"));
        validProductsList.add(UUID.fromString("93672a93-b9b1-4766-b04b-4361e556021a"));
        validProductsList.add(UUID.fromString("d70a79a0-b446-49d7-ad1b-3d00b978edbc"));
        validProductsList.add(UUID.fromString("7361d947-e76b-4927-adf2-70f29a153fa6"));
        validProductsList.add(UUID.fromString("6ce58155-6d91-43af-9f01-b5bf850221b5"));
        validProductsList.add(UUID.fromString("058f6f0d-c355-4f1c-a652-ee9ef0892247"));
        validProductsList.add(UUID.fromString("3071b172-4091-4278-996c-7211b9ced5e0"));

        invalidProductsList.add(UUID.fromString("6e9cca23-041c-460e-8ab3-37e8d7f4a69a"));

        productsList.addAll(validProductsList);
        productsList.addAll(invalidProductsList);
    }

    public UUID getRandomProduct() {
        int randomElementIndex = ThreadLocalRandom.current().nextInt(productsList.size());
        return productsList.get(randomElementIndex);
    }

    public UUID getRandomValidProduct() {
        int randomElementIndex = ThreadLocalRandom.current().nextInt(validProductsList.size());
        return validProductsList.get(randomElementIndex);
    }

    public UUID getRandomInvalidProduct() {
        int randomElementIndex = ThreadLocalRandom.current().nextInt(invalidProductsList.size());
        return invalidProductsList.get(randomElementIndex);
    }

}
