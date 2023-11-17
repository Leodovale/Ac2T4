package com.example.ac2t4;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.ac2t4.models.Agenda;
import com.example.ac2t4.models.Curso;
import com.example.ac2t4.models.Professor;
import com.example.ac2t4.repositories.AgendaRepository;
import com.example.ac2t4.repositories.CursoRepository;
import com.example.ac2t4.repositories.ProfessorRepository;

@SpringBootApplication
public class Ac2t4Application {

		/**
	 * Método que converte horário
	 * @param horario
	 * @return LocalTime
	 */
	private LocalTime formatarHoras(String horario) {
		return LocalTime.parse(horario);
	}

	@Bean
	public CommandLineRunner init(@Autowired ProfessorRepository professorRepository, @Autowired CursoRepository cursoRepository, @Autowired AgendaRepository agendaRepository) {
		return args -> {
			
			System.out.println("\n\r-------- Cursos inseridos --------\n\r");
			cursoRepository.save(new Curso(1L, "Fisioterapia", 257, "forma profissionais capazes de tratar e prevenir doenças e lesões, empregando técnicas como massagens e ginástica"));

			cursoRepository.save(new Curso(2L, "Abordagens terapêuticas", 499, "Abordagem Da Fisioterapia No Pré, Intra E Pós-Operatório De Cirurgias Plásticas foi desenvolvido visando a formação dos fisioterapeutas ou alunos no ultimo ano de curso"));

			System.out.println("\n\r-------- Professores inseridos --------n\r");
			professorRepository.save(new Professor(1L, "Arnaldo César", "562754265", "52789564", "Rua facens, 334", "1599999-9999", "Abordagens terapêuticas"));

			professorRepository.save(new Professor(2L, "Marcelo Alberto", "75829759", "7529548", "Rua Facens, 534", "1599999-9999", "Abordagens terapêuticas"));

			professorRepository.save(new Professor(3L, "Maria Cavalcante", "5728649", "54278954", "Rua Facens, 432", "1599999-9999", "Fisioterapia"));

			Curso curso1 = cursoRepository.findById(1L).get();

			Curso curso2 = cursoRepository.findById(2L).get();

			List<Professor> listaProfessores = professorRepository.findAllById(Arrays.asList(1L, 2L));

			curso1.setProfessores(listaProfessores);

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

			agendaRepository.save(new Agenda(1L, dateFormat.parse("01/08/2023"), dateFormat.parse("28/10/2023"), formatarHoras("08:00"), formatarHoras("17:00"), professorRepository.findById(1L).get(), curso1));
			agendaRepository.save(new Agenda(2L, dateFormat.parse("01/09/2023"), dateFormat.parse("20/11/2023"), formatarHoras("09:00"), formatarHoras("18:00"), professorRepository.findById(3L).get(), curso2));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac2t4Application.class, args);
	}

}
