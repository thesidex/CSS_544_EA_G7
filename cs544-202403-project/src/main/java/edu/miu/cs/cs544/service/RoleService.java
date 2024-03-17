package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.repository.MemberRepository;
import edu.miu.cs.cs544.repository.RoleRepository;

public class RoleService {
    private final RoleRepository roleRepository;
    private final MemberRepository memberRepository;

    public RoleService(RoleRepository roleRepository, MemberRepository memberRepository){
        this.roleRepository = roleRepository;
        this.memberRepository = memberRepository;
    }


}
