import React from 'react';
import ReactDom from 'react-dom';

class FindDomNode extends React.Component {
    constructor() {
        super();
        this.findDomNodeHandler = this.findDomNodeHandler.bind(this);
    };

    findDomNodeHandler() {
        var myDiv = document.getElementById("myDiv");
        ReactDom.findDOMNode(myDiv).style.color = 'Red';
    }

    render() {
        return (
            <div>
                <button onClick={this.findDomNodeHandler}>find Dome Node</button>
                <div id="myDiv">Node</div>
            </div>
        );
    }
}