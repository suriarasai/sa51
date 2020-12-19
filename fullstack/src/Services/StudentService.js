import axios from "axios";

const STUDENT_API_BASE_URL = "http://localhost:8080/api/students";

class StudentDataService {
  getStudents() {
    return axios.get(STUDENT_API_BASE_URL);
  }
  createStudent(student) {
    return axios.post(STUDENT_API_BASE_URL, student);
  }
  getStudentById(id) {
    return axios.get(STUDENT_API_BASE_URL+"/"+id);
  }
  updateStudent(id, student) {
    return axios.put(STUDENT_API_BASE_URL+"/edit/"+id, student)
  }
  deleteStudent(id) {
    return axios.delete(STUDENT_API_BASE_URL+"/"+id);
  }
  deleteAll() {
    return axios.delete(STUDENT_API_BASE_URL);
  }
  findByName(name) {
    return axios.get(STUDENT_API_BASE_URL+"?name="+name);
  }
}

export default new StudentDataService();
