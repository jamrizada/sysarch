package com.rizada.sysarch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "bangka")
public class Bangka {


    @Id
    private String id; // MongoDB will generate this automatically
    private String bangkaName;
    private double totalPrices;
}
