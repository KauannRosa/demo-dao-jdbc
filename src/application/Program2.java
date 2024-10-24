package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: findById =======");
		Department dep = departmentDao.findById(2);
		System.out.println(dep);

		System.out.println("\n=== TEST 2: findAll =======");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}

		System.out.println("\n=== TEST 3: insert ====");
		Department newDp = new Department(null, "Food");
		departmentDao.insert(newDp);
		System.out.println("Insert! New id = " + newDp.getId());

		System.out.println("\n=== TEST 4: update ====");
		Department dep2 = departmentDao.findById(6);
		dep2.setName("Music");
		departmentDao.update(dep2);
		System.out.println("Update completed");

		System.out.println("\n=== TEST 5: delete ====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");

		sc.close();

	}

}
