import React, {Component} from "react";
import axios from "axios";
import {Link} from "react-router-dom";
import Book from "./Book";
import Filters from "./Filters";

class Books extends Component {
    constructor(props) {
        super(props);
        this.state = {
            List: []
        }
    }

    componentDidMount() {
        axios.get("http://localhost:8080/api/books")
            .then(response => {
                this.setState({
                    List: response.data
                });
                console.log("resp " + response);
                console.log(response);
            })
            .catch(error => {
                console.log("error " + error)
            });
    }

    onDeleteElement = (bookISBN) => {
        axios.delete(`http://localhost:8080/api/books/${bookISBN}`)
            .then(response => {
                console.log(response);
                this.setState({ List: this.state.List.filter(l => l.isbn !== bookISBN)});
            })
            .catch(error => console.log(error.response))
    };

    markAsRead = (bookISBN) => {
        axios.patch(`http://localhost:8080/api/books/${bookISBN}/markAsRead`)
            .then(response => {
                console.log(response);
            })
            .catch(error => console.log(error.response))
    };

    render() {
        console.log("render");
        console.log("state.list", this.state.List);

        const newList = this.state.List.map(book =>
            <Book ISBN={book.isbn}
                  title={book.title}
                  publicationDate={book.publicationDate}
                  authorName={book.authorName}
                  review={book.review}
                  numberPages={book.numberPages}
                  read={book.read}
                  favourite={book.favourite}
                  genres={book.bookGenres}
                  imageUrl={book.imageUrl}
                  key={book.isbn}
                  onDelete={this.onDeleteElement}
                  markAsRead={this.markAsRead}
            />);
        return (
            <div className="container mt-4">
                <div className={"row"}>
                <div className={"col-md-3"}>
                    <Filters/>
                </div>
                <div className={"col-md-9"}>
                <div className="row m-0">
                    <div className={"text-right"} style={{flex: "auto"}}>
                        <Link to={"/books/new"}>
                            <button className="btn btn-outline-secondary">
                                <span><strong>Add new book</strong></span>
                            </button>
                        </Link>
                    </div>
                    {this.state.List.length > 0 ?
                        <div style={{width: "100%"}}>
                            {newList}
                        </div>
                        :
                        <h3> The List of Books is empty</h3>}

                </div>
            </div>
            </div>
            </div>
        )
    }
}

export default Books