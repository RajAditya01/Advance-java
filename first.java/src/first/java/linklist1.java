package first.java;

public class linklist1 {
	int Emp_Id;
	String name;
	int Salary;
	public int getEmp_Id() {
		return Emp_Id;
	}
	public void setEmp_Id(int emp_Id) {
		Emp_Id = emp_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public linklist1() {
		super();
		// TODO Auto-generated constructor stub
			Emp_Id = emp_Id;
			this.name = name;
			Salary = salary;
		}
		@Override
		public String toString() {
			return "Employee1 [Emp_Id=" + Emp_Id + ", name=" + name + ", Salary=" + Salary + "]";
		}

		}
