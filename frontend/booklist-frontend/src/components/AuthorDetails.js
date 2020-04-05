import React, {Component} from "react";
import axios from "axios";
import {Link} from "react-router-dom";
import BookCarousel from "./BookCarousel";
import PageNotFound from "./PageNotFound";

class BookDetails extends Component{
    constructor(props) {
        super(props);
        this.state = {
            authorId: this.props.match.params.authorId,
            name: "",
            birthDate: "",
            birthPlace: "",
            imageUrl: "",
            biography: "",
            notFound: false
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
            })
            .catch(error => {
                console.log(error);
                this.setState({notFound: true});
            });
    }

    render() {

        return(
            <div>
                {this.state.notFound === true ?
                    <PageNotFound/>
                    :
                    <div className={"container my-4"}>
                        <div className={"row"}>
                            <div className={"col-md-3"}>
                                <div style={{width: "90%"}}
                                     className={"text-center"}>
                                    <div className={"row m-auto"}
                                         style={{width: "100%"}}>
                                        <img src={this.state.imageUrl}
                                             style={{height: "300px", width: "240px"}}/>
                                    </div>
                                    <div className={"mt-2"}>
                                        Date of Birth: {this.state.birthDate}
                                    </div>
                                    <div>
                                        Birth Place: {this.state.birthPlace}
                                    </div>
                                </div>
                            </div>
                            <div className={"col-md-6 text-left"}>
                                <div className={"row"}>
                                    <h4 style={{display: "block"}}>{this.state.name}</h4>
                                </div>
                                <div className={"row mt-3"}>
                                    <div>{this.state.biography}</div>
                                </div>
                            </div>
                            <div className={"col-md-3 d-flex justify-content-end"}>
                                <div style={{width: "90%"}}>
                                    <div className={"row text-center d-flex justify-content-start"}>
                                        <h5>Books by {this.state.name}: </h5>
                                        <hr style={{border: "1px solid darkgray"}}/>
                                        <div style={{width: "180px"}}>
                                            <BookCarousel ISBN={"0"}
                                                          booksByAuthor={true}
                                                          authorId={this.state.authorId}/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                }
            </div>
        )
    }
}

export default BookDetails