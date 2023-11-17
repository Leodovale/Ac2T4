package com.example.ac2t4.dtos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CursoDTO {

  private Long id; 
  private String descricao;
  private Integer cargaHoraria;
  private String objetivos;
  private String ementa;
  private Long professorId;
  
}
