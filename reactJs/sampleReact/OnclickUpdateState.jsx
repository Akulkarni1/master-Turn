import React from 'react';

class OnclickUpdateState extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            data: 'initial data...'
        }
        this.updateState = this.updateState.bind(this);
    };

    updateState() {
        this.setState({data: 'data updated'})
    }

    render() {
        return (<div>
            <button onClick={this.updateState}>click</button>
            <h4>{this.state.data}</h4></div>);
    }
}