package alphaproject.alphasolutionproject.domain.services;

import alphaproject.alphasolutionproject.domain.model.Project;
import alphaproject.alphasolutionproject.domain.model.SubTask;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.repositories.DBManager;
import alphaproject.alphasolutionproject.repositories.ProjectRepositoryImpl;
import alphaproject.alphasolutionproject.repositories.SubTaskRespositoryImpl;
import alphaproject.alphasolutionproject.repositories.TaskRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    private CalculatorService calculatorService;
    private ProjectRepositoryImpl projectRepositoryImpl;
    private TaskRepositoryImpl taskRepositoryImpl;
    private SubTaskRespositoryImpl subTaskRespositoryImpl;
    private User user;
    private Project project;
    private Task task;
    private SubTask subTask;
    private DBManager db;

    public int findProjectId() throws SQLException {
        db = new DBManager();
        Connection connection = DBManager.getConnection();
        String SQL ="select * from alphasoloution.project limit 1";
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int pas = resultSet.getInt("projectid");
        return pas;
    }


    /*@Test
    void shouldShowTotalSubtaskTime() throws SQLException, SampleExeption {
        calculatorService = new CalculatorService();
        projectRepositoryImpl = new ProjectRepositoryImpl();
        taskRepositoryImpl = new TaskRepositoryImpl();
        subTaskRespositoryImpl = new SubTaskRespositoryImpl();
        user = new User();
        project = new Project();
        task = new Task();
        subTask = new SubTask();
        user.setFirstName("TestName");
        user.setLastName("TestLastName");
        user.setAuthority(true);
        user.setEmail("TestMail");
        project.setProjectName("TestProject");
        project.setProjectDescription("irelevant");
        project.setProjectTimeEstimate(1);
        task.setTaskName("TestTask");
        task.setTaskDescription("irelevant");
        task.setTaskTimeEstimate(1);
        subTask.setSubTaskName("TestSubTask");
        subTask.setSubTaskDescription("irelevant");
        subTask.setSubTaskTimeEstimate(5);


        projectRepositoryImpl.createProject(project, user);

        int projectid = findProjectId();
        subTaskRespositoryImpl.createSubTask(subTask, projectid);
        //projekt til rep, det samme med subtask, og nok bruge projektid, sql statement for sidste projekt id. gem id i int, kalde og hente fra rep

    }

     */



}