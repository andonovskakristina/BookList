import React, {Component} from "react";
import {Link} from "react-router-dom";
import Card from "react-bootstrap/Card"

const Author = (props) => {

        return(
            <Card className={"m-auto"} style={{ width: '18rem' }}>
                <Card.Img variant="top"
                          src={props.imageUrl}
                          style={{maxHeight: "310px", height: "310px"}}/>
                <Card.Body>
                    <Card.Title><Link to={`/authors/${props.authorId}/details`}
                                      className="text-dark">{props.name}
                    </Link></Card.Title>
                </Card.Body>
            </Card>
        )
};

export default Author