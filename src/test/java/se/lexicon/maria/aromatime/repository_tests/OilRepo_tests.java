package se.lexicon.maria.aromatime.repository_tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import se.lexicon.maria.aromatime.entity.Oil;
import se.lexicon.maria.aromatime.repositories.OilRepo;


@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class OilRepo_tests {
	
	@Autowired 
	private OilRepo testRepo;
	
	private Oil testOil;
	
	@Before
	public void init() {
		Oil bergamott = new Oil("Bergamott");
		Oil basilika = new Oil("Basilika");
		testOil = testRepo.save(bergamott);
		testRepo.save(basilika);
	}
	
	@Test
	public void test_findByNameIgnoreCase() {
		List<Oil> expected = Arrays.asList(testOil);
		List<Oil> actual = testRepo.findByOilNameIgnoreCase("bergamott");
		assertEquals(expected, actual);		
	}
	
	@Test
	public void test_findByNameIgnoreCase_all_returned_match_param() {
		String param = "Basilika";
		List<Oil> result = testRepo.findByOilNameIgnoreCase(param);		
		
		assertTrue(result.stream()
				.allMatch(bergamott -> bergamott.getOilName().equalsIgnoreCase(param)));
	}		

}
