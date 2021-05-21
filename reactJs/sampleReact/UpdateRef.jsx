import React from 'react';
import ReactDom from 'react-dom';

class UpdateRef extends React.Component {
    constructor(props) {
        super(props);
        this.state = {data: ''}
        this.updateState = this.updateState.bind(this);
        this.clearInput = this.clearInput.bind(this);
    };

    updateState(e) {
        this.setState({data: e.target.value});
    }

    clearInput() {
        this.setState({data: ''});
        ReactDom.findDOMNode(this.refs.myInput).focus();
    }

    render() {
        return (<div>
                <input value={this.state.data} onChange={this.updateState}
                       ref="myInput"></input>
                <button onClick={this.clearInput}>CLEAR</button>
                <h4>{this.state.data}</h4>
            </div>
        );
    }
}