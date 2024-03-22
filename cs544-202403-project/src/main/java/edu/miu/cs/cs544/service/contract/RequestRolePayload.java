package edu.miu.cs.cs544.service.contract;

import lombok.Data;

import java.io.Serializable;

@Data
public class RequestRolePayload implements Serializable {
    private Long oldRoleId;
    private Long newRoleId;
}
