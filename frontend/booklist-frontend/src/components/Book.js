import React, {Component} from "react";
import {BrowserRouter as Router} from 'react-router-dom'
import {Link} from "react-router-dom";

class Book extends Component{
    constructor(props) {
        super(props);
        this.state = {
            ISBN: props.ISBN,
            title: props.title,
            publicationDate: props.publicationDate,
            authorName: props.authorName,
            review: props.review,
            numberPages: props.numberPages,
            read: props.read,
            favourite: props.favourite,
            genres: props.genres,
            imageUrl: props.imageUrl
        }
    }

    render() {
        return(
            <div className={"container"}>
                <div className={"row my-2 text-left pl-0"} style={{backgroundColor: "lightgray"}}>
                    <div className={"col-md-3 pl-0"}>
                        <img src={this.state.imageUrl}
                             style={{maxWidth: "250px", maxHeight: "250px", width: "100%"}}/>
                    </div>
                    <div className={"col-md-7 mt-3 pl-0"}>
                        <h5>{this.state.title}</h5>
                        <div className={"mt-2"}>
                            <div>
                                <span className="fa fa-user mr-2"/>
                                <span>{this.state.authorName}</span>
                            </div>
                            <div>
                                <span className="fa fa-pencil mr-2"/>
                                <span>{this.state.genres}</span>
                            </div>
                            <div>
                                <span className="fa fa-calendar mr-2"/>
                                <span>{this.state.publicationDate}</span>
                            </div>
                            <div>
                                <span className="fa fa-book mr-2"/>
                                <span>{this.state.numberPages} pages</span>
                            </div>
                            <div>
                                <span className="fa fa-star mr-2"/>
                                <span>{this.state.review}</span>
                            </div>
                            <Link to={`/books/${this.state.ISBN}/details`} className="text-dark">
                                <span><strong>Read more</strong></span>
                            </Link><br/>
                            <button className="btn btn-sm btn-outline-dark mt-2" onClick={()=>this.props.markAsRead(this.state.ISBN)} title={"Mark As Read"}>
                                <span className="fa fa-book"/>
                                <span><strong> Read</strong></span>
                            </button>
                        </div>
                    </div>
                    <div className={"col-md mt-3"}>
                        <div className={"d-flex justify-content-end"}>
                        <Link to={`/books/${this.state.ISBN}/edit`} className="btn btn-sm btn-secondary mx-1" title={"Edit Book"}>
                            <span className="fa fa-edit"/>
                        </Link>
                        <button className="btn btn-sm btn-outline-secondary mx-1" onClick={()=>this.props.onDelete(this.state.ISBN)} title={"Delete Book"}>
                            <span className="fa fa-remove"/>
                        </button>
                        </div>

                    </div>
                </div>
            </div>
            /*
            <tr>
                <td><img src={this.props.imageUrl} style={{maxWidth: "100px", maxHeight: "100px"}}/></td>
                <td>{this.props.ISBN}</td>
                <td>{this.props.title}</td>
                <td>{this.props.publicationDate.toString()}</td>
                <td>{this.props.authorName}</td>
                <td>{this.props.review}</td>
                <td>{this.props.numberPages}</td>
                <td>{this.props.genres}</td>
                <td>
                    <button className="btn btn-sm btn-outline-secondary " onClick={()=>this.props.markAsRead(this.state.ISBN)}>
                        <span className="fa fa-book"/>
                        <span><strong> Read</strong></span>
                    </button>
                    <Link to={`/books/${this.state.ISBN}/edit`} className="btn btn-sm btn-secondary">
                        <span className="fa fa-edit"/>
                        <span><strong> Edit</strong></span>
                    </Link>
                    <button className="btn btn-sm btn-outline-secondary " onClick={()=>this.props.onDelete(this.state.ISBN)}>
                        <span className="fa fa-remove"/>
                        <span><strong> Remove</strong></span>
                    </button>
                    <Link to={`/books/${this.state.ISBN}/details`} className="btn btn-sm btn-outline-dark">
                        <span><strong>Details</strong></span>
                    </Link>
                </td>
            </tr>
        */)
    }
}

export default Book