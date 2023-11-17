package com.example.ac2t4.services;
import java.util.List;
import com.example.ac2t4.dtos.CursoDTO;
import com.example.ac2t4.models.Curso;

public interface CursoService {

  Curso salvar(CursoDTO cursoDTO);
  Curso obterPorId(Long id);
  List<CursoDTO> listarTodos();
  void excluir (Long id);
  void editar (Long id, CursoDTO cursoDTO);

}
