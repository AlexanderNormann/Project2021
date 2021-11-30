package alphaproject.alphasolutionproject.domain.services;

import alphaproject.alphasolutionproject.domain.model.SubTask;
import alphaproject.alphasolutionproject.domain.model.Task;
import alphaproject.alphasolutionproject.domain.model.User;
import alphaproject.alphasolutionproject.repositories.SubTaskRepository;
import alphaproject.alphasolutionproject.repositories.SubTaskRespositoryImpl;
import alphaproject.alphasolutionproject.repositories.TaskRepository;
import alphaproject.alphasolutionproject.repositories.TaskRepositoryImpl;

public class SubTaskService {

    private SubTaskRepository subTaskRepository;
    private SubTaskRespositoryImpl subTaskRespositoryImpl = new SubTaskRespositoryImpl();

    public SubTaskService(SubTaskRepository subTaskRepository){
      this.subTaskRepository = subTaskRepository;
    }

    public SubTask createNewSubTask(SubTask subTask, User user) throws SampleExeption{
      return subTaskRespositoryImpl.createSubTask(subTask, user);
    }
  }
