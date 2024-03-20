package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.service.RegistrationService;
import edu.miu.cs.cs544.service.contract.RegistrationPayload;
import edu.miu.cs.cs544.service.contract.ScanPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.miu.common.controller.BaseReadWriteController;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.service.contract.MemberPayload;

@RestController
@RequestMapping("/members")
public class MemberController extends BaseReadWriteController<MemberPayload, Member, Long> {

    @Autowired
    private RegistrationService registrationService;

    //Member registers an event
    @PostMapping("/{memberId}/register/{eventId}")
    public ResponseEntity<?> registerEvent(@PathVariable Long memberId, @PathVariable Long eventId) {
        registrationService.registerEvent(memberId, eventId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
