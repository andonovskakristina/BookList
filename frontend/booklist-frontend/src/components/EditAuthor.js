import React, {Component} from "react";
import {Link} from "react-router-dom";
import axios from "axios";
import backgroundImage from "../images/createNewBackground.jpg"
import css from "../css/createNewBook.css"
import DatePickerr from "./DatePicker";

class EditAuthor extends Component{
    constructor(props) {
        super(props);
        this.state = {
            authorId: this.props.match.params.authorId,
            name: "",
            birthDate: "",
            birthPlace: "",
            imageUrl: "",
            biography: "",
            oldState: {}
        }
    }

    componentDidMount() {
        axios.get(`http://localhost:8080/api/authors/${this.state.authorId}`)
            .then(response => {
                this.setState({
                    name: response.data.name,
                    birthDate: response.data.birthDate,
                    birthPlace: response.data.birthPlace,
                    imageUrl: response.data.imageUrl,
                    biography: response.data.biography,
                    oldState: {
                        "name": response.data.name,
                        "birthDate": response.data.birthDate,
                        "birthPlace": response.data.birthPlace,
                        "imageUrl": response.data.imageUrl,
                        "biography": response.data.biography,
                    }
                })
            });
    }

    onFormSubmit = (e) => {
        e.preventDefault();
        this.validateInputs();

        const newAuthor = new FormData();
        newAuthor.set('name', this.state.name);
        newAuthor.set('birthDate', this.state.birthDate);
        newAuthor.set('birthPlace', this.state.birthPlace);
        newAuthor.set('imageUrl', this.state.imageUrl);
        newAuthor.set('biography', this.state.biography);

        axios.patch(`http://localhost:8080/api/authors/${this.state.authorId}`, newAuthor, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }
        )
            .then(response => {
                console.log(response);
                this.props.history.push("/authors");
            })
            .catch(error => console.log(error.response));
    };

    onInputChange = (e) => {
        this.setState({[e.target.name]: e.target.value});
    };

    onDateChange = (value) => {
        this.setState({birthDate: value})
    };

    onReset = () => {
        this.setState({
            name: this.state.oldState.name,
            birthDate: this.state.oldState.birthDate,
            birthPlace: this.state.oldState.birthPlace,
            imageUrl: this.state.oldState.imageUrl,
            biography: this.state.oldState.biography
        });
    };

    validateInputs() {
        if(!this.state.birthDate) {
            date = Date.now();
            var d = new Date(date),
                month = '' + (d.getMonth() + 1),
                day = '' + d.getDate(),
                year = d.getFullYear();

            if (month.length < 2)
                month = '0' + month;
            if (day.length < 2)
                day = '0' + day;

            var date = [year, month, day].join('-');
            this.setState({birthDate: date});
        }

        if(!this.state.name || !this.state.birthDate || !this.state.birthPlace || !this.state.imageUrl ||
            !this.state.biography)
            document.getElementById("errorMessage").hidden = false;
        else
            document.getElementById("errorMessage").hidden = true;
    };

    render() {
        return (
            <div style={{backgroundImage: `url(${backgroundImage})`,
                backgroundSize: "cover", paddingTop: "50px", paddingBottom: "50px",
                width: "100%", height: "100%"}}>
                <div className="container text-center"
                     style={{marginTop: "0px", width: "60%", padding: "10px",
                         border: "1px solid darkgray", borderRadius: "6px", backgroundColor: "white"}}>
                    <h4>Edit Author</h4>
                    <hr style={{border: "0.5px solid darkgray", padding: 0}}/>
                    <form className={"m-auto"}
                          style={{width: "90%"}}
                          onSubmit={this.onFormSubmit}>
                        <input type={"text"}
                               name={"name"}
                               placeholder={"Author name"}
                               className={"form-control my-2"}
                               onChange={this.onInputChange}
                               defaultValue={this.state.name}
                               value={this.state.name}/>
                        <input type={"text"}
                               name={"birthPlace"}
                               placeholder={"Birth place"}
                               className={"form-control my-2"}
                               onChange={this.onInputChange}
                               defaultValue={this.state.birthPlace}
                               value={this.state.birthPlace}/>
                        <input type={"text"}
                               name={"imageUrl"}
                               placeholder={"Image Url"}
                               className={"form-control my-2"}
                               onChange={this.onInputChange}
                               defaultValue={this.state.imageUrl}
                               value={this.state.imageUrl}/>
                        <textarea type={"text"}
                                  name={"biography"}
                                  placeholder={"Author biography"}
                                  className={"form-control my-2"}
                                  onChange={this.onInputChange}
                                  defaultValue={this.state.biography}
                                  value={this.state.biography}/>
                        <div className={"text-left my-2"}
                             style={{color: "#495057"}}>Date of Birth
                            <DatePickerr name={"publicationDate"}
                                         onChange={this.onInputChange}
                                         onDateChange={this.onDateChange}/></div>
                        <h6 className={"text-danger text-left"}
                            hidden={true}
                            id={"errorMessage"}>All Fields Are Required!</h6>

                        <div className={"row m-0 mt-3 justify-content-end"}>
                            <button
                                type="submit"
                                className="btn btn-primary text-upper m-2"
                                id="btnSave">
                                Save
                            </button>

                            <button type="button"
                                    onClick={this.onReset}
                                    className="btn btn-warning text-upper m-2">
                                Reset
                            </button>

                            <Link to={"/books"}>
                                <button type="button"
                                        className="btn btn-danger text-upper my-2 ml-2 mr-0">
                                    Cancel
                                </button>
                            </Link>
                        </div>
                    </form>
                </div>
            </div>
        );
    }
}

export default EditAuthor