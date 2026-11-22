

public class Hello {
	public static void main(String[] args) {
		String name = System.getenv("USER");
		System.out.println("Hello " + name + ", Tote Check!");
		System.out.println("Order received: 2x Oat Milk");

		int i=3;
		if (i == 2) {
			System.out.println("MATCHED!");}
			else { System.out.println("UNMATCHED!");}
	}
}

