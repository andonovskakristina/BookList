import React, {Component} from "react";
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
            imageUrl: props.imageUrl,
            isReadPage: props.isReadPage
        }
    }

    markAsFavourite = () => {
        var btnFave = document.getElementById("btnFave");
        var btnFaveText = document.getElementById("btnFaveText");
        if(btnFave.title === "Mark As Favourite") {
            btnFave.title = "Not Favourite";
            btnFaveText.innerText = " Not Favourite";
        }
        else {
            btnFave.title = "Mark As Favourite";
            btnFaveText.innerText = " Favourite";
        }
    };

    markAsRead() {
        var btnRead = document.getElementById("btnRead");
        var btnReadText = document.getElementById("btnReadText");
        if(btnRead.title === "Mark As Read") {
            btnRead.title = "Not Read";
            btnReadText.innerText = " Not Read";
        }
        else {
            btnRead.title = "Mark As Read";
            btnReadText.innerText = " Read";
        }
    };

    render() {
        return(
            <div className={"container"}>
                <div className={"row my-2 text-left pl-0"}
                     style={{backgroundColor: "lightgray"}}>
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
                            <Link to={`/books/${this.state.ISBN}/details`}
                                  className="text-dark">
                                <span><strong>Read more</strong></span>
                            </Link><br/>
                            {this.state.read !== true ?
                                <button className="btn btn-sm btn-outline-dark mt-2"
                                        title={"Mark As Read"} id={"btnRead"} value={this.state.read}
                                        onClick={e => { this.markAsRead(); this.props.markAsRead(this.state.ISBN)}}>
                                    <span className="fa fa-book"/>
                                    <span><strong id={"btnReadText"}> Read</strong></span>
                                </button>
                                :
                                <div>
                                    <span id={"spanRead"} hidden={this.state.isReadPage}> You read this book.</span>
                                    <button className="btn btn-sm btn-outline-dark mt-2"
                                            title={"Mark As Favourite"}
                                            id={"btnFave"}
                                            value={this.state.favourite}
                                            onClick={e => { this.props.markAsFavourite(this.state.ISBN);
                                                this.markAsFavourite()}}
                                            hidden={!this.state.isReadPage}>
                                        <span className="fa fa-heart"/>
                                        <span><strong id={"btnFaveText"}> Favourite</strong></span>
                                    </button>
                                </div>
                            }

                        </div>
                    </div>
                    <div className={"col-md mt-3"}>
                        <div className={"d-flex justify-content-end"}>
                        <Link to={`/books/${this.state.ISBN}/edit`}
                              className="btn btn-sm btn-secondary mx-1"
                              title={"Edit Book"}>
                            <span className="fa fa-edit"/>
                        </Link>
                        <button className="btn btn-sm btn-outline-secondary mx-1"
                                onClick={()=>this.props.onDelete(this.state.ISBN)}
                                title={"Delete Book"}>
                            <span className="fa fa-remove"/>
                        </button>
                        </div>

                    </div>
                </div>
            </div>
            )
    }
}

export default Book