package yaksha;

class Trainee {
	private int id;
	private String name;
	private int age;
	private String batch;
	private double score;
	private int attemptNumber;

	Trainee() {

	}

	Trainee(int id, String name, int age, String batch, double score, int attemptNumber) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.batch = batch;
		this.score = score;
		this.attemptNumber = attemptNumber;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getBatch() {
		return batch;
	}

	public double getScore() {
		return score;
	}

	public int getAttemptNumber() {
		return attemptNumber;
	}

	public void setId(int id) {
		id = this.id;
	}

	public void setName(String name) {
		name = this.name;
	}

	public void setAge(int age) {
		age = this.age;
	}

	public void setBatch(String batch) {
		batch = this.batch;
	}

	public void setScore(double score) {
		score = this.score;
	}

	public void setAttemptNumber(int attemptNumber) {
		attemptNumber = this.attemptNumber;
	}

	public String toString() {
		return String.format("%-8d %-20s %-5d %-10s %-2.2f", getId(), getName(), getAge(), getBatch(), getScore());
	}
}
