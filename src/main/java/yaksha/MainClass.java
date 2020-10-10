package yaksha;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.*;

class MainClass {
	public static void main(String args[]) throws Exception {
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader r = new BufferedReader(i);
		Connection con = DB.getConnection();
		PICO pico = new PICO();
		int id, age, attemptNumber;
		double score;
		String name, batch;
		System.out.println("Enter the number of trainees");
		int n = Integer.parseInt(r.readLine());
		Trainee[] t = new Trainee[n];
		ArrayList<Trainee> traineeList = new ArrayList<Trainee>();
		for (int j = 0; j < n; j++) {
			System.out.println("Enter the id of trainee " + (j + 1));
			id = Integer.parseInt(r.readLine());
			System.out.println("Enter the name of trainee " + (j + 1));
			name = r.readLine();
			System.out.println("Enter the age of trainee " + (j + 1));
			age = Integer.parseInt(r.readLine());
			System.out.println("Enter the batch of trainee " + (j + 1));
			batch = r.readLine();
			System.out.println("Enter the score of trainee " + (j + 1));
			score = Double.parseDouble(r.readLine());
			System.out.println("Enter the attempt number of trainee " + (j + 1));
			attemptNumber = Integer.parseInt(r.readLine());
			t[j] = new Trainee(id, name, age, batch, score, attemptNumber);
			traineeList.add(t[j]);
			String query = "insert into trainee values (?,?,?,?,?,?)";
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setInt(1, t[j].getId());
			pStatement.setString(2, t[j].getName());
			pStatement.setInt(3, t[j].getAge());
			pStatement.setString(4, t[j].getBatch());
			pStatement.setDouble(5, t[j].getScore());
			pStatement.setInt(6, t[j].getAttemptNumber());
			pStatement.executeUpdate();
			pico.viewTraineeDetails();
		}

		System.out.println(
				"Menu :\n1) Print the details of all trainees belonging to a particular batch\n2) Search for and display the details of a particular trainee\n3) Print the details of all trainees who have scored 70% and above in the first attempt");
		System.out.println("Enter your choice : 1 or 2 or 3");
		int choice = Integer.parseInt(r.readLine());
		TraineeBO traineeBO = new TraineeBO();
		switch (choice) {
		case 1:
			System.out.println("Enter the batch name");
			batch = r.readLine();
			traineeBO.printAllTraineeDetailsFromBatch(traineeList, batch);
			break;
		case 2:
			System.out.println("Enter the trainee name");
			name = r.readLine();
			traineeBO.printTraineeDetails(traineeList, name);
			break;
		case 3:
			traineeBO.printTraineeDetailsFirstAttempt70AndAbove(traineeList);
			break;
		default:
			break;
		}
	}
}
