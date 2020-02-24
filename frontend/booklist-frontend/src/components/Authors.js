import React, {Component} from "react";
import ReactPaginate from "react-paginate";
import axios from "axios";
import {Link} from "react-router-dom";
import Book from "./Book";
import Filters from "./Filters";
import {Dropdown} from "react-bootstrap"
import ButtonToolbar from "react-bootstrap/ButtonToolbar";
import DropdownButton from "react-bootstrap/DropdownButton";
import Author from "./Author";
import GridList from "@material-ui/core/GridList";

class Books extends Component {
    constructor(props) {
        super(props);
        this.state = {
            authors: [],
            page: 0,
            pageSize: 6,
            totalPages: 0,
            search: ""
        }
    }

    fetchBooks = (page = this.state.page,
                  size = this.state.pageSize,
                  authors = this.state.authorIds,
                  search = this.state.search
    ) => {
        axios.get(`http://localhost:8080/api/authors?search=${search}&page=${page}&pageSize=${size}`)
            .then(response => {
                console.log(response);
                this.setState({ authors: response.data.content,
                    page: response.data.pageable.pageNumber,
                    pageSize: response.data.pageable.pageSize,
                    totalPages: response.data.totalPages
                });
            })
            .catch(error => console.log(error.response))
    };

    componentDidMount() {
        this.fetchBooks(0);
    }

    onDeleteElement = (authorId) => {
        axios.delete(`http://localhost:8080/api/authors/${authorId}`)
            .then(response => {
                console.log(response);
                this.setState({ authors: this.state.authors.filter(l => l.id !== authorId)});
                this.fetchBooks(0);
            })
            .catch(error => console.log(error.response))
    };

    onFilter = (search) => {
        this.fetchBooks(0)
    };

    handlePageClick = (pageChangedEvent) => {
        this.fetchBooks(pageChangedEvent.selected);
    };

    onSearchChange = (e) => {
        this.setState({search: e.target.value});
    };

    renderPaginate = () =>
        <ReactPaginate previousLabel={'← Previous'}
                       nextLabel={'Next →'}
                       breakLabel={<span className="gap">...</span>}
                       breakClassName={'break-me'}
                       pageCount={this.state.totalPages}
                       marginPagesDisplayed={2}
                       pageRangeDisplayed={6}
                       pageClassName={'page-item'}
                       pageLinkClassName={'page-link btn'}
                       previousClassName={'page-item'}
                       nextClassName={'page-item'}
                       previousLinkClassName={'page-link btn'}
                       nextLinkClassName={'page-link btn btn-outline-secondary'}
                       forcePage={this.state.page}
                       onPageChange={this.handlePageClick}
                       containerClassName={'pagination justify-content-center'}
                       activeClassName={'active'}
                       activeLinkClassName={'active bg-secondary border-secondary'}
                       disabledClassName={"disabled"}
        />;

    render() {
        const newList = this.state.authors.map(author =>
            <div className={"col-md-4 mb-5"} style={{display: "inline-block"}}>
            <Author authorId={author.id}
                    name={author.name}
                    birthDate={author.birthDate}
                    birthPlace={author.birthPlace}
                    imageUrl={author.imageUrl}
                    biography={author.biography}
                    books={author.books}
                    key={author.id}
                    onDelete={this.onDeleteElement}
                    style={{display: "inline-block"}}
            /></div>);
        return (
            <div className="container my-4"
                 style={{width: "80%", backgroundColor: "whitesmoke"}}>
                <div className={"d-flex justify-content-center"}>
                    <div className={"row m-4"}
                         style={{width: "100%"}}>
                    <input className="form-control"
                           style={{width: "200px"}}
                           type="text"
                           placeholder="Search"
                           aria-label="Search"
                           onChange={this.onSearchChange}
                    />
                    <button className="btn btn-sm btn-outline-secondary"
                            onClick={this.onFilter}>
                        <span className={"fa fa-search"}></span>
                    </button>
                    <Link to={"/authors/new"} className={"ml-auto"}>
                            <button type="button ml-auto"
                                    className="btn btn-outline-secondary ml-auto"
                                    style={{}}>
                                <span><strong>Add new author</strong></span>
                            </button>
                        </Link>
                    </div>
                </div>
                <div className={"row start"}>
                    {newList}
                </div>
                <div className={"row justify-content-center"}>
                    {this.renderPaginate()}
                </div>
            </div>
        )
    }
}

export default Books