import React, { Component } from "react";
import StudentDataService from "../Services/StudentService";
import { Link } from "react-router-dom";

export default class StudentList extends Component {
  constructor(props) {
    super(props);
    this.retrieveStudents = this.retrieveStudents.bind(this);
    this.refreshList = this.refreshList.bind(this);
    this.setActiveStudent = this.setActiveStudent.bind(this);
    this.removeAllStudents = this.removeAllStudents.bind(this);
    

    this.state = {
      students: [],
      currentStudent: null,
      currentIndex: -1,
    };
  }

  componentDidMount() {
    this.retrieveStudents();
  }


  retrieveStudents() {
    StudentDataService.getStudents()
      .then(response => {
        this.setState({
          students: response.data
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  refreshList() {
    this.retrieveStudents();
    this.setState({
      currentStudent: null,
      currentIndex: -1
    });
  }

  setActiveStudent(student, index) {
    this.setState({
      currentStudent: student,
      currentIndex: index
    });
  }

  removeAllStudents() {
    StudentDataService.deleteAll()
      .then(response => {
        console.log(response.data);
        this.refreshList();
      })
      .catch(e => {
        console.log(e);
      });
  }


  render() {
    const { students, currentStudent, currentIndex } = this.state;

    return (
      <div className="list row">
        <div className="col-md-6">
          <h4>Students List</h4>

          <ul className="list-group">
            {students &&
              students.map((student, index) => (
                <li
                  className={
                    "list-group-item " +
                    (index === currentIndex ? "active" : "")
                  }
                  onClick={() => this.setActiveStudent(student, index)}
                  key={index}
                >
                  {student.name}
                </li>
              ))}
          </ul>

          <button
            className="m-3 btn btn-sm btn-danger"
            onClick={this.removeAllStudents}
          >
            Remove All
          </button>
        </div>
        <div className="col-md-6">
          {currentStudent ? (
            <div>
              <h4>Student</h4>
              <div>
                <label>
                  <strong>ID:</strong>
                </label>{" "}
                {currentStudent.studentId}
              </div>
              <div>
                <label>
                  <strong>Name:</strong>
                </label>{" "}
                {currentStudent.name}
              </div>
              <div>
                <label>
                  <strong>Nick Name:</strong>
                </label>{" "}
                {currentStudent.nickName}
              </div>
              <div>
                <label>
                  <strong>Marks:</strong>
                </label>{" "}
                {currentStudent.marks}
              </div>
              <Link
                to={"/students/" + currentStudent.id}
                className="badge badge-warning"
              >
                Edit
              </Link>
            </div>
          ) : (
            <div>
              <br />
              <p>Please click on a Student...</p>
            </div>
          )}
        </div>
      </div>
    );
  }
}
