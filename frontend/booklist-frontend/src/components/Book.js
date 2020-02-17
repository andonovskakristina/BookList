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
        )
    }
}

export default Book