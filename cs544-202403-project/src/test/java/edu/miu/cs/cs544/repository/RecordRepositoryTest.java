package edu.miu.cs.cs544.repository;

import edu.miu.cs.cs544.domain.*;
import edu.miu.cs.cs544.domain.Record;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class RecordRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired RecordRepository recordRepository;

    @Test
    public void findByScannerId() {
        // Create a scanner and associated records
        Scanner scanner = new Scanner(1L, new Location(), new Event());
        Role role = new Role("Staff");
        Role role1 = new Role("Student");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        roles.add(role1);
        entityManager.persist(role);
        entityManager.persist(role1);
        entityManager.persist(roles);
        String barcode = "BC7823";
        Member member = new Member("Joe", "Smith", "smithjoe@gmail.com", barcode, roles);
        entityManager.persist(member);
        entityManager.flush();
        Record record1 = new Record(member, scanner, new Session());
        //Record record2 = new Record(new Member(), scanner, new Session());
        entityManager.persist(record1);
        //entityManager.persist(record2);
        entityManager.persist(scanner);
        entityManager.flush();

        // Call findByScannerId method
        System.out.println(scanner.getId());
        List<Record> records = recordRepository.findByScannerId(scanner.getId());

        assertThat(records.size()).isEqualTo(2);

    }
}