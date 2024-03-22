package edu.miu.cs.cs544.repository;

import edu.miu.common.exception.ResourceNotFoundException;
import edu.miu.cs.cs544.domain.Member;
import edu.miu.cs.cs544.domain.Role;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void findByBarcode() {
        Role role = new Role("Staff");
        Role role1 = new Role("Student");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        roles.add(role1);
        entityManager.persist(role);
        entityManager.persist(role1);
        String barcode = "BC78623";
        Member member = new Member("Joe", "Smith", "smithjoe@gmail.com", barcode, roles);
        entityManager.persist(member);
        entityManager.flush();
        Member found = memberRepository.findByBarcode(member.getBarcode())
                .orElseThrow(() -> new ResourceNotFoundException("Member is not found with barcode: " + barcode));
        assertThat(found.getBarcode()).isEqualTo(member.getBarcode());
    }
}