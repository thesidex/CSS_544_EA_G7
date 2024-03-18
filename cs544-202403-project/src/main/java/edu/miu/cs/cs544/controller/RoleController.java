package edu.miu.cs.cs544.controller;


import edu.miu.cs.cs544.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member/{memberId}/roles")
public class RoleController {
    private final RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<Void> addRoleToMember(@PathVariable Long memberId, @RequestBody Long roleId){
        roleService.addRoleToMember(memberId,roleId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<Void> removeRoleFromMember(@PathVariable Long memberId, @PathVariable Long roleId){
        roleService.removeRoleFromMember(memberId,roleId);;
        return ResponseEntity.ok().build();
    }
}
