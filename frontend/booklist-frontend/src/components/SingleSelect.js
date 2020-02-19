import React, { useState } from "react";
import Select from "react-dropdown-select";

const SingleSelect = (props) => {
    const authors = props.authorOptions;
    const indexes = props.authorOptionsIndexes;
    const isMulti = props.isMulti;

    var options = [];

    for(var i = 0; i < authors.length; i++) {
        options[i] = {label: authors[i], value: indexes[i]}
    }

    const [selected, setSelected] = useState([]);

    return (
        <div style={{textAlign: "left !important", fontSize: "1rem !important"}} className={"my-2"}>
            <Select
                options={options}
                value={selected}
                onChange={e => { setSelected(e); props.onAuthorChange(e)}}
                labelledBy={"Select"}
                searchable={true}
                placeholder={"Author"}
                className={"form-control"}
                multi={isMulti}
            />
        </div>
    );
};

export default SingleSelect;