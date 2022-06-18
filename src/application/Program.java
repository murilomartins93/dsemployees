package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String name = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		System.out.print("Email: ");
		sc.nextLine();
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String phone = sc.nextLine();
		Department dept = new Department(name, payDay, new Address(email, phone));
		
		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.printf("Dados do funcionário %d:%n", i+1);
			System.out.print("Nome: ");
			sc.nextLine();
			String empName = sc.nextLine();
			System.out.print("Salário: ");
			double empSalary = sc.nextDouble();
			dept.addEmployee(new Employee(empName, empSalary));	
		}
		
		showReport(dept);
		
		sc.close();
	}
	
	public static void showReport(Department dept) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("\nFOLHA DE PAGAMENTO:");
		sb.append("\nDepartamento " + dept.getName() + " = R$ " + String.format("%.2f", dept.payroll()));
		sb.append("\nPagamento realizado no dia " + dept.getPayDay());
		sb.append("\nFuncionários:\n");
		for (Employee list : dept.getEmployees()) {
			sb.append(list.getName() + "\n");
		}
		sb.append("Para dúvidas favor entrar em contato: " + dept.getAddress().getEmail());
		System.out.println(sb.toString());
	
	}

}