package oopConcept;

import org.junit.Test;

public class Testing {

	@Test
	public void test1() {

		Tesla t = new Tesla(4);

		Car c[] = new Car[4];
		c[0] = new BMW();
		c[1] = new Tesla(6);

		for (int i = 0; i < c.length; i++) {

			c[i].move();
			c[i].engine();
			c[i].exaust();

			System.out.println(c[i]);
		}

	}

	@Test
	public void test2() {
		
		SourceLog sa = new SourceLog();
		sa.setUserID("rock");
		sa.setPassword("asdf1234");
		sa.login(sa.getUserID(), sa.getPassword());

		SourceLog sb = new SourceLog();
		sb.setUserID("rock1");
		sb.setPassword("asdf1234.1");
		sb.login(sb.getUserID(), sb.getPassword());

	}

	@Test
	public void test3() {
		
		Day d = Day.SUNDAY;
		Day d1[] = Day.values();

		for (Day x : d1) {
			System.out.println(x);
		}

	}

}