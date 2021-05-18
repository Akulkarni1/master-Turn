import React from 'react';

class OnChange extends React.Component {
    constructor(props) {
        super(props);
        this.state = {data: 'Intital data'}
        this.updateState = this.updateState.bind(this);
    };

    updateState(e) {
        this.setState({data: e.target.value});
    }

    render() {
        return (<div><input type='text' value={this.state.data} onChange={this.updateState}/>
            <h5>this.state.data</h5>
        </div>);
    }
}