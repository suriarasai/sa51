package sg.edu.iss.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.demo.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}