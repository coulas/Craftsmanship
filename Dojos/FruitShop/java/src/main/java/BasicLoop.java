import java.util.Scanner;

public class BasicLoop {

	private int total = 0;
	private int cerises = 0;
	private int bananes = 0;
	private int apples = 0;
	private int mele = 0;
	private int pommesGlobale = 0;
	private int fruitGlobale = 0;


	public void loop() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("> ");
		while (scanner.hasNextLine()) {
			String input = scanner.nextLine();
			System.out.println(doSomethingWithInput(input));
			System.out.print("> ");
		}
	}

	public String doSomethingWithInput(String input) {
		try {
			String[] articles = input.split(",");
			for (String article : articles) {
				switch (Articles.valueOf(article.trim().toLowerCase())) {
				case pommes:
					total += 100;
					total += remisePommesGlobale();
					break;
				case apples:
					total += 100;
					total += remiseApples();
					total += remisePommesGlobale();
					break;
				case mele:
					total += 100;
					total += remiseMele();
					total += remisePommesGlobale();
					break;
				case cerises:
					total += 75;
					total += remiseCerises();
					break;
				case bananes:
					total += 150;
					total += remiseBananes();
					break;
				}
				total += remiseFruitGlobale();
			}
			return "< " + String.valueOf(total);
		} catch (IllegalArgumentException|NullPointerException e) {
			return "< " + input;
		}
	}

	private int remiseBananes() {
		bananes++;
		if (bananes % 2 == 0) {
			return -150;
		}
		return 0;
	}

	private int remiseCerises() {
		cerises++;
		if (cerises % 2 == 0) {
			return -20;
		}
		return 0;
	}
	
	private int remiseApples() {
		apples ++;
		if (apples % 3 == 0) {
			return -100;
		}
		return 0;
	}
	
	private int remiseMele() {
		mele ++;
		if (mele  % 2 == 0) {
			return -100;
		}
		return 0;
	}
	
	private int remisePommesGlobale() {
		pommesGlobale ++;
		if (pommesGlobale  % 4 == 0) {
			return -100;
		}
		return 0;
	}
	
	private int remiseFruitGlobale() {
		fruitGlobale ++;
		if (fruitGlobale  % 5 == 0) {
			return -200;
		}
		return 0;
	}
	public static void main(String[] args) {
		new BasicLoop().loop();
	}

}
