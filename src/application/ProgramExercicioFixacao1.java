package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class ProgramExercicioFixacao1 {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> products = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i) ? ");
			char c = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if (c == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				products.add(new ImportedProduct(name, price, customsFee));
			} else if (c == 'u') {
				System.out.print("Manufacure Date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				products.add(new UsedProduct(name, price, manufactureDate));
			} else {
				products.add(new Product(name, price));
			}
		}

		System.out.println();
		
		System.out.println("PRICE TAGS:");
		for (Product product : products) {
			System.out.println(product.priceTag()); 
		}
	}

}
