package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final MemberRepository memberRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository, MemberRepository memberRepository){
        this.roleRepository = roleRepository;
        this.memberRepository = memberRepository;
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);

    }

    public void addRoleToMember(Long memberId, Long roleId){
        Member member = memberRepository.findById(memberId);
//                .orElseThrow(() -> new RuntimeException("Member not found"));
        Role role = roleRepository.findById(roleId);

        member.getRoles().add(role);
        memberRepository.save(member);

    }

    public void removeRoleFromMember(Long memberId, Long roleId){
        Member member = memberRepository.findById(memberId);

        Role role = member.getRoles().stream()
                        .filter(r -> r.getId().equals(roleId))
                                .findFirst()
                                        .orElseThrow(() -> new RuntimeException("Role not assigned to this member"));

        member.getRoles().remove(role);
        memberRepository.save(member);
    }

    public List<Role> findAllRoles(){
        return roleRepository.findAll();
    }


}
