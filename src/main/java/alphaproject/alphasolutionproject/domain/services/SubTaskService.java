package alphaproject.alphasolutionproject.domain.services;

import alphaproject.alphasolutionproject.domain.model.SubTask;
import alphaproject.alphasolutionproject.repositories.SubTaskRepository;
import alphaproject.alphasolutionproject.repositories.SubTaskRespositoryImpl;
import java.util.ArrayList;

public class SubTaskService {

  private SubTaskRepository subTaskRepository;
  private SubTaskRespositoryImpl subTaskRespositoryImpl = new SubTaskRespositoryImpl();


  public SubTaskService(SubTaskRepository subTaskRepository) {
    this.subTaskRepository = subTaskRepository;
  }

  public SubTaskService() {
  }

  public SubTask createNewSubTask(SubTask subTask, int id) throws ProjectExeption {
    return subTaskRespositoryImpl.createSubTask(subTask, id);
  }

  public ArrayList<SubTask> loadSubTasksByTaskID(int id) {
    return subTaskRespositoryImpl.loadSubTasksByTaskID(id);
  }

  public SubTask loadSingleSubtask(int id) {
    return subTaskRespositoryImpl.loadSingleSubtask(id);
  }

  public void editSubtask(SubTask subtask, int id) throws ProjectExeption {
    subTaskRespositoryImpl.editSubtask(subtask, id);
  }

  public void deleteSubTask(int id) {
    subTaskRespositoryImpl.deleteSubTask(id);
  }
}
