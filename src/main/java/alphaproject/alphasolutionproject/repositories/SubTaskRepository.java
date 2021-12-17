package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.SubTask;
import alphaproject.alphasolutionproject.domain.services.ProjectExeption;

import java.util.ArrayList;

public interface SubTaskRepository {
  SubTask createSubTask(SubTask subTask, int id) throws ProjectExeption;

  ArrayList<SubTask> loadSubTasksByTaskID(int id);

  SubTask loadSingleSubtask(int id);

  void editSubtask(SubTask subTask, int id) throws ProjectExeption;

  void deleteSubTask(int id);

}
