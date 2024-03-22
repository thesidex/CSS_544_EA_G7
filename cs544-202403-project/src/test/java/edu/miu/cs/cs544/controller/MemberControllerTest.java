package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.RegistrationService;
import edu.miu.cs.cs544.service.contract.MemberPayload;
import edu.miu.cs.cs544.service.contract.ScanPayload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MemberControllerTest {

    @Mock
    private RegistrationService registrationService;

    @InjectMocks
    private MemberController memberController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        memberController = new MemberController(registrationService);
    }

    @Test
    void testRegisterEvent_Success() {
        long memberId = 1L;
        long eventId = 1L;

        ResponseEntity<?> responseEntity = memberController.registerEvent(memberId, eventId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(registrationService, times(1)).registerEvent(memberId, eventId);
    }
}
