import React, { useState } from "react";
import Select from "react-dropdown-select";
import css from "../css/multiSelect.css"

const MultiSelect = (props) => {
    const genres = props.genreOptions;

    const options = genres.map((name) => ({
        label: name,
        value: name
    }));

    const [selected, setSelected] = useState([]);

    return (
        <div style={{textAlign: "left !important", fontSize: "1rem !important"}} className={"my-2"}>
            <Select
                options={options}
                value={selected}
                onChange={setSelected}
                labelledBy={"Select"}
                onDropdownClose={()=>props.onGenreChange(selected)}
                searchable={true}
                placeholder={"Genres"}
                multi={true}
                className={"form-control"}
            />
        </div>
    );
};

export default MultiSelect;