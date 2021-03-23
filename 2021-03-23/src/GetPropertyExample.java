import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");

		System.out.println("OS : " + osName);
		System.out.println("Username : " + userName);
		System.out.println("Userhome : " + userHome);

		System.out.println("----------------------------");
		Properties props = System.getProperties();
		Set keys = props.keySet();
		for (Object k : keys) {
			String key = (String) k;
			String value = System.getProperty(key);

			System.out.println(key + "  " + value);
		}
	}

}
