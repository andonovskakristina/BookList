import React, {Component} from "react";
import {Link} from "react-router-dom";
import Card from "react-bootstrap/Card"
import css from "../css/authors.css"

const Author = (props) => {

        return(
            <Card className={"m-auto"} style={{ width: '18rem' }}>
                <div id={"proba"}>
                    <div id={"btns"} style={{position: "absolute", right: 0, zIndex: 5}}>
                        <Link to={`/authors/${props.authorId}/edit`}
                              className="btn btn-sm btn-secondary"
                              title={"Edit Author"}>
                            <span className="fa fa-edit"/>
                        </Link>
                        <button className="btn btn-sm btn-secondary m-1"
                                onClick={()=>props.onDelete(props.authorId)}
                                title={"Delete Author"}>
                            <span className="fa fa-remove"/>
                        </button>
                    </div>
                    <Card.Img variant="top"
                              src={props.imageUrl}
                              style={{maxHeight: "310px", height: "310px",
                                  position: "relative", display: "inline-block"}}
                              id={"img"}/>
                </div>
                <Card.Body>
                    <Card.Title><Link to={`/authors/${props.authorId}/details`}
                                      className="text-dark">{props.name}
                    </Link></Card.Title>
                </Card.Body>
            </Card>
        )
};

export default Author