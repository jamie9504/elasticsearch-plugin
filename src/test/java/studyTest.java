import static org.junit.Assert.*;

import org.junit.Test;

public class studyTest {

	@Test
	public void 스트링빌더_어펜더() {
		StringBuilder sb = new StringBuilder();
		String 우리나라 = "우리나라";

		sb.append(우리나라);
		assertThrows(NullPointerException.class, () -> sb.append((char[])null));
	}
}
