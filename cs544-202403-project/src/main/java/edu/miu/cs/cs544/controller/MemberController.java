//package edu.miu.cs.cs544.controller;
//
//import edu.miu.cs.cs544.domain.Role;
//import edu.miu.cs.cs544.service.MemberService;
//import edu.miu.cs.cs544.service.RegistrationService;
//import edu.miu.cs.cs544.service.contract.RegistrationPayload;
//import edu.miu.cs.cs544.service.contract.RequestRolePayload;
//import edu.miu.cs.cs544.service.contract.ScanPayload;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import edu.miu.common.controller.BaseReadWriteController;
//import edu.miu.cs.cs544.domain.Member;
//import edu.miu.cs.cs544.service.contract.MemberPayload;
//
//@RestController
//@RequestMapping("/members")
//@RequiredArgsConstructor
//public class MemberController extends BaseReadWriteController<MemberPayload, Member, Long> {
//
//    @Autowired
//    private RegistrationService registrationService;
//
//    //Member registers an event
//    @PostMapping("/{memberId}/register/{eventId}")
//    public ResponseEntity<?> registerEvent(@PathVariable Long memberId, @PathVariable Long eventId) {
//        registrationService.registerEvent(memberId, eventId);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//
//    //-------Sam
//
//    @Autowired
//    private final MemberService memberService;
//
//
//    @GetMapping(path = "/{memberId}/roles")
//    public ResponseEntity<?>  getAllRoles(@PathVariable(value = "memberId") Long memberId) {
//        return ResponseEntity.ok(this.memberService.getAllRoleForMember(memberId));
//
//    }
//
//
//    @GetMapping(path="/{memberId}/roles/{roleId}")
//    public  ResponseEntity<?>getRoleForMember(@PathVariable(value = "memberId")Long memberId,@PathVariable(value = "roleId")Long roleId ) {
//        return ResponseEntity.ok (this.memberService.getRoleForMember(memberId,roleId));
//
//    }
//    @PostMapping (path = "/{memberId}/roles")
//    public ResponseEntity <?> createRole  (@PathVariable(value = "memberId") Long memberId, @RequestBody Role role) {
//        return ResponseEntity.ok (this.memberService.createRole(memberId,role));
//
//    }
//
//    @PutMapping ("/{memberId}/roles")
//    public ResponseEntity <?> updateRole(@PathVariable (value = "memberId") Long memberId, @RequestBody RequestRolePayload requestRolePayload) {
//        this.memberService.updateRole(memberId, requestRolePayload);
//        return new ResponseEntity<>(HttpStatus.OK);
//
//    }
//
//    @DeleteMapping ("/{memberId}/roles/{roleId}")
//    public ResponseEntity<?> deleteRole(@PathVariable (value = "memberId") Long memberId, @PathVariable(value = "roleId") Long roleId) {
//        this.memberService.deleteRoleForMember(memberId,roleId);
//       return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//
//}
