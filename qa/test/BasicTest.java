
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import models.*;
import play.test.*;


public class BasicTest extends UnitTest{

	Main main;
	User user1, user2;

	@Before
	public void setUp() {
		main = new Main();
		user1 = new User("Hans");
		user2 = new User("Vreni");
		main.addUser(user1);
		main.addUser(user2);

	}

	@Test
	public void shouldHaveName() {
		assertEquals("Hans", user1.getName());
		assertEquals("Vreni", user2.getName());
	}

	@Test
	public void userShouldAskQuestions() {
		assertTrue(user1.getQuestions().isEmpty());

		user1.ask("Wie geht es dir?");
		assertEquals("Wie geht es dir?", user1.getQuestions().get(0)
				.getContent());
		assertEquals("Wie geht es dir?", main.getQuestions().get(0)
				.getContent());

		user1.ask("Wie spät ist es?");
		assertEquals("Wie spät ist es?", user1.getQuestions().get(1)
				.getContent());
		assertEquals("Wie spät ist es?", main.getQuestions().get(1)
				.getContent());
	}

	@Test
	public void userShouldAnswer() {
		Question q = new Question("Wie alt bist du?");
		user1.answer(q, "Ich bin 20 Jahre alt.");

		assertEquals("Ich bin 20 Jahre alt.", user1.getAnswers().get(0)
				.getContent());
		assertEquals("Ich bin 20 Jahre alt.", q.getAnswers().get(0)
				.getContent());

	}

	@Test
	public void shouldHaveTimestamp() {
		Question q = new Question("Wie ist dein Name?");
		assertNotNull(q.getDate());// that is not a good test, but I do not know
									// how to improve it
		Answer a = new Answer("Jürg", q);
		assertNotNull(a.getDate());

	}

	@Test
	public void shouldBeVoted() {
		Question q = new Question("Warum?");
		assertEquals(0, q.getVote());
		Answer a = new Answer("Darum!", q);
		assertEquals(0, a.getVote());

		user1.voteUp(q);
		user2.voteDown(a);

		assertEquals(1, q.getVote());
		assertEquals(-1, a.getVote());

		user2.voteDown(q);
		user1.voteUp(a);

		assertEquals(0, q.getVote());
		assertEquals(0, a.getVote());

	}

	@Test
	public void userShouldBeDeleted() {
		user1.ask("Bin ich alleine?");
		user2.ask("Wo bin ich?");
		user1.answer(user2.getQuestions().get(0), "Du bist bei mir!");

		assertEquals(2, main.getQuestions().size());
		assertTrue(main.getUsers().contains(user1));
		user1.delete();
		assertFalse(main.getUsers().contains(user1));

		assertEquals(1, main.getQuestions().size());
		assertTrue(user2.getQuestions().get(0).getAnswers().isEmpty());
	}

}
