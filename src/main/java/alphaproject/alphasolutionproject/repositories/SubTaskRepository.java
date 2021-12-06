package alphaproject.alphasolutionproject.repositories;

import alphaproject.alphasolutionproject.domain.model.SubTask;
import alphaproject.alphasolutionproject.domain.services.SampleExeption;

import java.util.ArrayList;

public interface SubTaskRepository {
  SubTask createSubTask(SubTask subTask, int id) throws SampleExeption;
  //ArrayList<SubTask> loadSubTasksByTaskID(int id);

}
