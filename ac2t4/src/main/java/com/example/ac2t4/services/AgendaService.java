package com.example.ac2t4.services;
import java.util.List;
import com.example.ac2t4.dtos.AgendaDTO;
import com.example.ac2t4.models.Agenda;

public interface AgendaService {

  Agenda salvar(AgendaDTO agendaDTO);
  Agenda obterPorId(Long id);
  List<AgendaDTO> listarTodos();
  void excluir (Long id);
  void editar (Long id, AgendaDTO agendaDTO);
  boolean verificarProfessorDisponivel(AgendaDTO agendaDTO);

}
