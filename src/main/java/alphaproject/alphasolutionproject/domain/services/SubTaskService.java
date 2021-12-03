package alphaproject.alphasolutionproject.domain.services;

import alphaproject.alphasolutionproject.domain.model.SubTask;
import alphaproject.alphasolutionproject.repositories.SubTaskRepository;
import alphaproject.alphasolutionproject.repositories.SubTaskRespositoryImpl;

public class SubTaskService {

    private SubTaskRepository subTaskRepository;
    private SubTaskRespositoryImpl subTaskRespositoryImpl = new SubTaskRespositoryImpl();

    public SubTaskService(SubTaskRepository subTaskRepository){
      this.subTaskRepository = subTaskRepository;
    }

    public SubTask createNewSubTask(SubTask subTask, int id) throws SampleExeption{
      return subTaskRespositoryImpl.createSubTask(subTask, id);
    }
  }
