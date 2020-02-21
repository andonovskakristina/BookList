import React, {Component} from "react";
import axios from "axios";
import {Link} from "react-router-dom";

class BookDetails extends Component{
    constructor(props) {
        super(props);
        this.state = {
            ISBN: this.props.match.params.ISBN,
            title: "",
            publicationDate: "",
            authorId: 0,
            authorName: "",
            review: 0,
            description: "",
            numberPages: 0,
            imageUrl: "",
            read: false,
            favourite: false,
            comment: "",
            genres: ""
        }
    }

    componentDidMount() {
        axios.get(`http://localhost:8080/api/books/${this.state.ISBN}`)
            .then(response => {this.setState({
                title: response.data.title,
                authorId: response.data.authorId,
                authorName: response.data.authorName,
                review: response.data.review,
                publicationDate: response.data.publicationDate,
                numberPages: response.data.numberPages,
                imageUrl: response.data.imageUrl,
                genres: response.data.bookGenres,
                description: response.data.description,
                read: response.data.read,
                favourite: response.data.favourite,
                comment: response.data.comment
            });
                this.stars();
            });
    }

    stars = () => {
        var count = 0;
        for (var i = 0; i < parseInt(this.state.review); i++) {
            document.getElementById("stars").innerHTML += "<span class=\"fa fa-star text-warning\"></span>";
            count++;
        }

        if(count !== 5) {
            if(this.state.review - parseInt(this.state.review) >= 0.5) {
                document.getElementById("stars").innerHTML += "<span class=\"fa fa-star-half-empty text-warning\"></span>";
                count++;
            }
        }

        for(var i = count; i < 5; i++){
            document.getElementById("stars").innerHTML += "<span class=\"fa fa-star text-secondary\"></span>";
        }

        document.getElementById("stars").innerHTML += " " + "<small>" + this.state.review + "</small>";
    };

    render() {

        var pom = this.state.genres.split(",");
        var tableGenres = [];
        for(var i = 0; i < pom.length; i++) {
            tableGenres[i] = <tr className={"d-flex align-items-center pl-2"} style={{borderTop: "1px solid darkgray", maxHeight: "40px", height: "40px"}} >{pom[i]}</tr>;
        }
        return(
            <div className={"container mt-4"}>
                <div className={"row"}>
                    <div className={"col-md-3"}>
                        <div style={{width: "90%"}}
                             className={"text-center"}>
                            <div className={"row m-auto"}
                                 style={{width: "90%"}}>
                                <img src={this.state.imageUrl} style={{height: "300px", width: "200px"}}/>
                            </div>
                            <div className={"row justify-content-center"}>
                                <div id={"stars"} className={"text-center"}>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div className={"col-md-6 text-left"}>
                        <div className={"row"}>
                            <h4 style={{display: "block"}}>{this.state.title}</h4>
                        </div>
                        <div className={"row"}>
                            <Link to={`/authors/${this.state.authorId}/details`} className="text-dark">
                                <h6>{this.state.authorName}</h6>
                            </Link>
                        </div>
                        <div className={"row"}>
                            <span style={{borderRight: "1px solid darkgray", fontSize: "smaller"}}
                                  className={"pr-1"}>
                                ISBN: {this.state.ISBN}
                            </span>
                            <span style={{borderRight: "1px solid darkgray", fontSize: "smaller"}}
                                  className={"pr-1 ml-1"}>
                                {this.state.numberPages} pages
                            </span>
                            <span className={"ml-1"}
                                  style={{fontSize: "smaller"}}>
                                Publication Date: {this.state.publicationDate}
                            </span>
                        </div>
                        <div className={"row mt-3"}>
                            <div>{this.state.description}</div>
                        </div>
                    </div>
                    <div className={"col-md-3 d-flex justify-content-end"}>
                        <div style={{width: "90%"}}>
                        <div className={"row text-left"}>
                            <h5>Genres</h5>
                            <table className={"table"}
                                   style={{borderTop: "1px solid darkgray", borderBottom: "1px solid darkgray"}}>
                                {tableGenres}
                            </table>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default BookDetails