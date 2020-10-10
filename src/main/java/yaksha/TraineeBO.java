package yaksha;

import java.util.*;

class TraineeBO {
	TraineeBO() {
	}

	public void printAllTraineeDetailsFromBatch(List<Trainee> traineeList, String batchName) {
		boolean flag = true;
		for (Trainee t : traineeList) {
			if (t.getBatch().equals(batchName)) {
				if (flag)
					System.out.println("Id       Name                 Age   Batch      Score");
				System.out.println(t);
				flag = false;
			}
		}
		if (flag)
			System.out.println("Batch Name " + batchName + " not found");
	}

	public void printTraineeDetails(ArrayList<Trainee> traineeList, String traineeName) {
		boolean flag = true;
		for (Trainee t : traineeList) {
			if (t.getName().equals(traineeName)) {
				if (flag)
					System.out.println("Id       Name                 Age   Batch      Score");
				System.out.println(t);
				flag = false;
			}
		}
		if (flag)
			System.out.println("Trainee Named " + traineeName + " not found");
	}

	public void printTraineeDetailsFirstAttempt70AndAbove(ArrayList<Trainee> traineeList) {
		boolean flag = true;
		for (Trainee t : traineeList) {
			if (t.getScore() >= 70 && t.getAttemptNumber() == 1) {
				if (flag)
					System.out.println("Id       Name                 Age   Batch      Score");
				System.out.println(t);
				flag = false;
			}
		}
		if (flag)
			System.out.println("No records found");
	}
}
