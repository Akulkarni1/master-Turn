import React from 'react';

class Clock extends React.Component {
    render() {
        return (
            <div>
                <h2>It is {this.state.date.toLocaleTimeString()} .</h2>
            </div>)
    }
}