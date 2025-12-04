package application;

import java.util.Locale;
import java.util.Scanner;

import exception.DomainException;
import model.entities.Product;
import model.entities.StockManager;

public class Main {
			public static void main(String[] args) throws Exception {
				Locale.setDefault(Locale.US);
				Scanner input = new Scanner(System.in);
				StockManager sm = new StockManager();
				int x = 0;
				System.out.println("Sejam bem vindos!");
				while (x != 7) {

					System.out.println("\nMenu");
					System.out.println("1 - Cadastro de produtos.");
					System.out.println("2 - Remover produtos.");
					System.out.println("3 - Busca de produtos.");
					System.out.println("4 - Preco total estoque.");
					System.out.println("5 - Quantidade estoque.");
					System.out.println("6 - Atualizar Item.");
					System.out.println("0 - Sair.");
					System.out.println("Escolha uma das opções: ");
					try {
						x = input.nextInt();
						input.nextLine();
						if (x < 1 || x > 7) {
							throw new DomainException("Opcao invalida. Escolha de 1 a 6 (0 Sair).");
						}
						switch (x) {
						case 1:
							System.out.println();
							System.out.print("ID: ");
							int id = input.nextInt();
							input.nextLine();
							System.out.print("Nome: ");
							String name = input.nextLine();
							System.out.print("Preco: ");
							double price = input.nextDouble();
							input.nextLine();
							System.out.print("Quantidade: ");
							int quantity = input.nextInt();
							input.nextLine();
							Product pd = new Product(id, name, price, quantity);
							sm.addProduct(pd);
							System.out.println();
							break;
						case 2:
							System.out.println();
							System.out.println("Digite o ID do produto: ");
							int searchID = input.nextInt();
							sm.removeProduct(searchID);
							break;
						case 3:
							System.out.println();
							System.out.println("Digite o ID do produto: ");
							int idProduct = input.nextInt();
							System.out.println(sm.findProduct(idProduct));
							break;
						case 4:
							System.out.println(sm.totalPriceInStock());
							break;
						case 5:
							System.out.println(sm.totalStock());
							break;
						case 6:
							System.out.println("Por favor insira os dados que deseja atualizar.");
							System.out.print("ID: ");
							id = input.nextInt();
							input.nextLine();
							System.out.print("Nome: ");
							name = input.nextLine();
							System.out.print("Preco: ");
							price = input.nextDouble();
							input.nextLine();
							System.out.print("Quantidade: ");
							quantity = input.nextInt();
							input.nextLine();
							pd = new Product(id, name, price, quantity);
							sm.updateItem(pd, id);
							System.out.println();
							break;
						case 0:
							System.out.println("Fechando...");
							break;
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());

					}	
				}
				input.close();
			}
}
