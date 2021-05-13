import React from 'react';

class SetState extends React.Component {
    constructor(){
        super();
        this.state = {data: []}
        this.setStateHandler = this.setStateHandler.bind(this);
    };
    setStateHandler(){
        var item = "setState..."
        var myArray = this.state.data.slice();
        myArray.push(item);
        this.setState({data: myArray})
    };
    render(){
        return(
        <div>
        <button onClick = {this.setStateHandler}>set State</button>
        <h4> state array: {this.state.data}</h4>
        </div>
        );
    }
}
export default App;