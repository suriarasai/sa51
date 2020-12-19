import React, { Component } from "react";
import StudentService from "../Services/StudentService";

export default class EditStudent extends Component {
    constructor(props) {
        super(props);
        this.onChangeStudentId = this.onChangeStudentId.bind(this);
        this.onChangeName = this.onChangeName.bind(this);
        this.onChangeNickName = this.onChangeNickName.bind(this);
        this.onChangeMarks = this.onChangeMarks.bind(this);
        this.getStudent = this.getStudent.bind(this);
        this.updateStudent = this.updateStudent.bind(this);
        this.deleteStudent = this.deleteStudent.bind(this);

        this.state = {
            currentStudent: {
                id: null,
                studentId: "",
                name: "",
                nickName: "",
                marks: 0
            },
            message: ""
        };
    }

    componentDidMount() {
        this.getStudent(this.props.match.params.id);
    }

    onChangeStudentId(e) {
        const studentId = e.target.value;

        this.setState(function (prevState) {
            return {
                currentStudent: {
                    ...prevState.currentStudent,
                    studentId: studentId
                }
            };
        });
    }
    
    onChangeName(e) {
        const name = e.target.value;

        this.setState(function (prevState) {
            return {
                currentStudent: {
                    ...prevState.currentStudent,
                    name: name
                }
            };
        });
    }

    onChangeNickName(e) {
        const nickName = e.target.value;

        this.setState(function (prevState) {
            return {
                currentStudent: {
                    ...prevState.currentStudent,
                    nickName: nickName
                }
            };
        });
    }
    onChangeMarks(e) {
        const marks = e.target.value;

        this.setState(function (prevState) {
            return {
                currentStudent: {
                    ...prevState.currentStudent,
                    marks: marks
                }
            };
        });
    }

    getStudent(id) {
        StudentService.getStudentById(id)
            .then(response => {
                this.setState({
                    currentStudent: response.data
                });
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    }

    updateStudent() {
        StudentService.updateStudent(
            this.state.currentStudent.id,
            this.state.currentStudent            
        )
            .then(response => {
                console.log(response.data);
                this.setState({
                    message: "The student was updated successfully!"
                });
            })
            .catch(e => {
                console.log(e);
            });
    }

    deleteStudent() {
        StudentService.deleteStudent(this.state.currentStudent.id)
            .then(response => {
                console.log(response.data);
                this.props.history.push('/students')
            })
            .catch(e => {
                console.log(e);
            });
    }

    render() {
        const { currentStudent } = this.state;

        return (
            <div>
                {currentStudent ? (
                    <div className="edit-form">
                        <h4>Student</h4>
                        <form>
                            <div className="form-group">
                                <label htmlFor="studentId">ID</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="studentId"
                                    value={currentStudent.studentId}
                                    onChange={this.onChangeStudentId}
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="name">Name</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="name"
                                    value={currentStudent.name}
                                    onChange={this.onChangeName}
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="nickName">Nick Name</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="nickName"
                                    value={currentStudent.nickName}
                                    onChange={this.onChangeNickName}
                                />
                            </div>
                            <div className="form-group">
                                <label htmlFor="marks">Marks</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="marks"
                                    value={currentStudent.marks}
                                    onChange={this.onChangeMarks}
                                />
                            </div>
                        </form>

                        <button
                            className="badge badge-danger mr-2"
                            onClick={this.deleteStudent} >
                            Delete
                        </button>

                        <button
                            type="submit"
                            className="badge badge-success"
                            onClick={this.updateStudent}
                        >
                            Update
                        </button>
                        <p>{this.state.message}</p>
                    </div>
                ) : (
                        <div>
                            <br />
                            <p>Please click on a Student...</p>
                        </div>
                    )}
            </div>
        );
    }
}
