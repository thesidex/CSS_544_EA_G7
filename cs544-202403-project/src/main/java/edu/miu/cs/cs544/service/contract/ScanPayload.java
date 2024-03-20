package edu.miu.cs.cs544.service.contract;

import lombok.Data;

import java.io.Serializable;

@Data
public class ScanPayload implements Serializable {
    private String memberBarcode;
    private Long sessionId;

}
