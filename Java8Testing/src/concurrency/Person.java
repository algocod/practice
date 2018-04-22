package concurrency;

public class Person {
	
	public Integer age ;
	public String name;
	public String sex;
	
	public Person(Integer i , String j , String k)
	{
		this.age=i;
		this.name=j;
		this.sex=k;
	}

	public Object getAge() {
			return age;	
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	
}
