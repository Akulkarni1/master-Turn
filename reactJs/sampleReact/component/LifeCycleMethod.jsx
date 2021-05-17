/*
Below are LifeCycle Methods in React.
1.)componentWillMount: this will be executed before rendering on both
client and server side.
2.)componentDidMount: this method will be executed after the first
render only on the client side.This is where AJAX requests and DOM
or state udpates should occur.This method  is also used for integration
with other javascript frameworks and any functions with delay execution
such as setTimeout or setInterval. We are using it to update the state
so we can trigger the other lifecycle methods.
3.)componentWillReceiveProps: this method will be invoked soon as the
props are updated before another render is called . We triggered it from
setNewNumber when we update the state.
4.)shouldComponentUpdate: this method return true or false value.This
will determine if the component will be updated  or not.This is set to
true by default. If you are sure that the component doesnt need to render
5.)componentWillUpdate: is called just before rendering.
6.)componentDidupdate: is called just after rendering.
7.)componentWillUnmount: is called after the component is unmounted from
the DOM. we are unmounting our component in main.js.

 */
import React from 'react'

class LifeCycleMethod extends React.Component {
    constructor(props) {
        super(props);
        this.state = {data: 0}
        this.setNewNumber = this.setNewNumber.bind(this);
    };

    setNewNumber() {
        this.setState({data: this.state.data + 1})
    }

    render() {
        return (<div>
            <button onClick={this.setNewNumber}>Increment</button>
            <Content myNumber={this.state.data}></Content>
        </div>);
    }
}