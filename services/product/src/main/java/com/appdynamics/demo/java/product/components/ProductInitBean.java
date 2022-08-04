package com.appdynamics.demo.java.product.components;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.appdynamics.demo.java.product.entities.Product;
import com.appdynamics.demo.java.product.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@RequiredArgsConstructor
@Log4j2
class ProductInitBean implements InitializingBean {

    private final ProductRepository productRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

        List<Product> initProducts = new LinkedList<>();
        initProducts.add(new Product(UUID.fromString("1aead14e-e32b-412f-a522-ead4d03b6c37"), "Cheese - Colby",
                new BigDecimal("80.2")));
        initProducts.add(new Product(UUID.fromString("a5652e28-0c82-4d23-a241-d2e992e624e5"), "Pan Grease",
                new BigDecimal("23.89")));
        initProducts.add(new Product(UUID.fromString("2275bdfa-7999-4a93-a2c0-4c35c871b11d"),
                "Bread - Sour Sticks With Onion", new BigDecimal("82.42")));
        initProducts.add(new Product(UUID.fromString("6fe35bed-73bf-447f-8e6d-db196a2d85b9"), "Juice - V8, Tomato",
                new BigDecimal("12.14")));
        initProducts.add(new Product(UUID.fromString("9747bb46-ad7e-4700-90ff-47d11c14d7ac"),
                "Nut - Almond, Blanched, Ground", new BigDecimal("61.55")));
        initProducts.add(new Product(UUID.fromString("4de4e42c-b0f2-4dad-91d6-ff8244c183bc"), "Kippers - Smoked",
                new BigDecimal("80.09")));
        initProducts.add(new Product(UUID.fromString("1e8e483e-0c8b-4b7f-b5a4-77641ec3cedb"),
                "Calypso - Strawberry Lemonade", new BigDecimal("33.19")));
        initProducts.add(new Product(UUID.fromString("035e014a-5230-49eb-a45b-35f46dcea21c"), "Water Chestnut - Canned",
                new BigDecimal("41.92")));
        initProducts.add(new Product(UUID.fromString("56ac6b98-6694-4021-9c67-f4d438ed2405"), "Corn Kernels - Frozen",
                new BigDecimal("64.15")));
        initProducts.add(new Product(UUID.fromString("d8d39de2-86b7-4e06-b0c8-84288b05a43f"), "Propel Sport Drink",
                new BigDecimal("58.06")));
        initProducts.add(new Product(UUID.fromString("dd7fcecb-59d1-46f7-90c8-9a8d98618195"),
                "Carbonated Water - Orange", new BigDecimal("59.62")));
        initProducts.add(new Product(UUID.fromString("04ae67a6-5e73-4416-98ac-945b88f6f5da"), "Chicken - Whole",
                new BigDecimal("58.34")));
        initProducts.add(new Product(UUID.fromString("9ba06785-5533-46f7-b02f-bc7107091e15"), "Chicken - Livers",
                new BigDecimal("69.77")));
        initProducts.add(new Product(UUID.fromString("c6ce7610-ee17-448e-841c-d9bc56034fa7"),
                "Table Cloth 81x81 Colour", new BigDecimal("57.13")));
        initProducts.add(new Product(UUID.fromString("93672a93-b9b1-4766-b04b-4361e556021a"),
                "Wine - George Duboeuf Rose", new BigDecimal("2.18")));
        initProducts.add(new Product(UUID.fromString("d70a79a0-b446-49d7-ad1b-3d00b978edbc"), "Truffle Cups Green",
                new BigDecimal("54.18")));
        initProducts.add(new Product(UUID.fromString("7361d947-e76b-4927-adf2-70f29a153fa6"), "Sour Puss Raspberry",
                new BigDecimal("60.44")));
        initProducts.add(new Product(UUID.fromString("6ce58155-6d91-43af-9f01-b5bf850221b5"), "Vodka - Lemon, Absolut",
                new BigDecimal("17.1")));
        initProducts.add(new Product(UUID.fromString("058f6f0d-c355-4f1c-a652-ee9ef0892247"), "Zucchini - Green",
                new BigDecimal("44.58")));
        initProducts.add(
                new Product(UUID.fromString("3071b172-4091-4278-996c-7211b9ced5e0"), "Limes", new BigDecimal("5.0")));
        productRepository.saveAll(initProducts);

        log.info("[x] created initial Products ");

    }

}