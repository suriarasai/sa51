import React, { Component } from "react";
import StudentService from "../Services/StudentService";

export default class CreateStudent extends Component {
  constructor(props) {
    super(props);
    this.onChangeStudentId = this.onChangeStudentId.bind(this);
    this.onChangeName = this.onChangeName.bind(this);
    this.onChangeNickName = this.onChangeNickName.bind(this);
    this.onChangeMarks = this.onChangeMarks.bind(this);
    this.saveStudent = this.saveStudent.bind(this);
    this.newStudent = this.newStudent.bind(this);

    this.state = {
      id: null,
      studentId: "",
      name: "",
      nickName: "",
      marks: 0
    };
  }

  onChangeStudentId(e) {
    this.setState({
      studentId: e.target.value
    });
  }

  onChangeName(e) {
    this.setState({
      name: e.target.value
    });
  }
  onChangeNickName(e) {
    this.setState({
      nickName: e.target.value
    });
  }

  onChangeMarks(e) {
    this.setState({
      marks: e.target.value
    });
  }


  saveStudent() {
    var data = {
      studentId: this.state.studentId,
      name: this.state.name,
      nickName: this.state.nickName,
      marks: this.state.marks
    };

    StudentService.createStudent(data)
      .then(response => {
        this.setState({
          id: response.data.id,
          studentId: response.data.studentId,
          name: response.data.name,
          nickName: response.data.nickName,
          marks: response.data.marks
        });
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  newStudent() {
    this.setState({
      id: null,
      studentId: "",
      name: "",
      nickName: "",
      marks: 0
    });
  }

  render() {
    return (
      <div className="submit-form">
        {this.state.submitted ? (
          <div>
            <h4>You submitted successfully!</h4>
            <button className="btn btn-success" onClick={this.newStudent}>
              Add
            </button>
          </div>
        ) : (
            <div>
              <div className="form-group">
                <label htmlFor="title">ID</label>
                <input
                  type="text"
                  className="form-control"
                  id="studentId"
                  required
                  value={this.state.studentId}
                  onChange={this.onChangeStudentId}
                  name="studentId"
                />
              </div>

              <div className="form-group">
                <label htmlFor="name">Name</label>
                <input
                  type="text"
                  className="form-control"
                  id="name"
                  required
                  value={this.state.name}
                  onChange={this.onChangeName}
                  name="name"
                />
              </div>

              <div className="form-group">
                <label htmlFor="nickName">Nick Name</label>
                <input
                  type="text"
                  className="form-control"
                  id="nickName"
                  required
                  value={this.state.nickName}
                  onChange={this.onChangeNickName}
                  name="nickName"
                />
              </div>
              <div className="form-group">
                <label htmlFor="marks">Marks</label>
                <input
                  type="text"
                  className="form-control"
                  id="marks"
                  required
                  value={this.state.marks}
                  onChange={this.onChangeMarks}
                  name="marks"
                />
              </div>

              <button onClick={this.saveStudent} className="btn btn-success">
                Submit
            </button>
            </div>
          )}
      </div>
    );
  }
}
