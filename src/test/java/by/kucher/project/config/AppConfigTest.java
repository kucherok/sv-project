package by.kucher.project.config;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import by.kucher.project.model.sport.SportKind;
import by.kucher.project.model.sport.SportKindCategory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfigTest.class })
public class AppConfigTest {

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	@Transactional
	public void firstTest() {

		SportKind sportKind = new SportKind();
		sportKind.setName("sportKind");
		sportKind.setDescription("description sport kind text");
		sportKind.setDateStart(new Date());
		sportKind.setSportKindCategory(SportKindCategory.SUMMER);

		entityManager.persist(sportKind);
		entityManager.flush();
		entityManager.clear();

		List<SportKind> kind = new ArrayList<SportKind>();
		kind.add(entityManager.find(SportKind.class, sportKind.getId()));

		assertEquals(1, kind.size());
	}

}
