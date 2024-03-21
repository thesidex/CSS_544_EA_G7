    package edu.miu.cs.cs544.service;

import edu.miu.common.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.domain.Record;
import edu.miu.cs.cs544.repository.*;
import edu.miu.cs.cs544.service.contract.RequestRolePayload;
import edu.miu.cs.cs544.service.contract.ScanPayload;
import edu.miu.cs.cs544.service.mapper.MemberToMemberPayloadMapper;
import edu.miu.cs.cs544.service.mapper.RecordToRecordPayloadMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.common.service.BaseReadWriteServiceImpl;
import edu.miu.cs.cs544.service.contract.MemberPayload;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

    @Service
@Transactional
public class MemberServiceImpl extends BaseReadWriteServiceImpl<MemberPayload, Member, Long> implements MemberService {

    @Autowired
    private ScannerRepository scannerRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private RecordRepository recordRepository;
    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RecordToRecordPayloadMapper recordMapper;
    @Autowired
    private MemberToMemberPayloadMapper memberMapper;

    @Override
    public void takeAttendance(Long scannerId, ScanPayload scanPayload) {
        Scanner scanner = scannerRepository.findById(scannerId)
                .orElseThrow(() -> new ResourceNotFoundException("Scanner not found with id: " + scannerId));
        Member member = memberRepository.findByBarcode(scanPayload.getMemberBarcode())
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + scanPayload.getMemberBarcode()));
        Session session = sessionRepository.findById(scanPayload.getSessionId())
                .orElseThrow(() -> new ResourceNotFoundException("Session not found with id: " + scanPayload.getSessionId()));

        boolean isRegistered = registrationRepository.existsById(new EventRegistrationId(member.getId(), scanner.getEvent().getId()));

        if (!isRegistered) {
            throw new RuntimeException("Member is not registered for the event");
        }
        Record record = new Record(member, scanner, session);
        recordRepository.save(record);
    }


    //-----Sam
        @Override
        public List<Role> getAllRoleForMember(Long memberId) {
//            memberRepository.findById(memberId)   ;
            Optional<Member> memberOptional  = this.memberRepository. findById (memberId);
            if(memberOptional.isPresent())  {
                Member  member = memberOptional.get();
                return member . getRoles();
            }

            return new ArrayList<>();

        }

        @Override
        public Role getRoleForMember(Long memberId, Long roleId) {
            Optional<Member> memberOptional = this.memberRepository.findById(memberId);
            if(memberOptional.isPresent()){
                Member member = memberOptional.get();
                Optional<Role> roleOptional = member.getRoles().stream().filter(role -> role.getId().equals(roleId))
                        .findFirst();
                if(roleOptional.isPresent()) {
                    return roleOptional.get();

                }
            }
            return null;

        }

        @Override
        public void updateRole(Long memberId, RequestRolePayload requestRolePayload) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()-> new ResourceNotFoundException("We cant find Members"));
        member.getRoles().stream().filter(role -> role.getId().equals(requestRolePayload.getOldRoleId())).findFirst()
                .stream().peek(role -> role.setId(requestRolePayload.getNewRoleId()));
        memberRepository.save(member);

        }

        @Override
        public Role createRole(Long memberId, Role role) {
            Optional<Member> memberOptional = this.memberRepository.findById(memberId);
            if(memberOptional.isPresent()) {
                Member member = memberOptional.get();
                member.getRoles().add(role);
                this.memberRepository.save(member);
                return role;
            }
            return null;

        }

        public void deleteRoleForMember(Long memberId, Long roleId) {
            Member member = memberRepository.findById(memberId)
                    .orElseThrow(() -> new ResourceNotFoundException("Member is not found"));

            Role roleToRemove = member.getRoles().stream()
                    .filter(role -> role.getId().equals(roleId))
                    .findFirst()
                    .orElseThrow(() -> new ResourceNotFoundException("Role is not found for this member"));

            member.getRoles().remove(roleToRemove);

            memberRepository.save(member);
        }

    }