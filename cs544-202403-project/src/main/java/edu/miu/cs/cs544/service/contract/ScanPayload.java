package edu.miu.cs.cs544.service.contract;

import lombok.Data;

import java.io.Serializable;

@Data
public class ScanPayload implements Serializable {
    private static final long serialVersionUID = 1L;

    private String memberBarcode;
    private Long sessionId;

}
