import React from 'react';
import ReactDom from 'react-dom';
import {Router, Route, Link, browserHistory, IndexRoute} from 'react-router';

class components extends React.Component {
    render() {
        return (
            <div>
                <ul>
                    <li>Home</li>
                    <li>About</li>
                    <li>Contact</li>
                </ul>
                {this.props.children}
            </div>
        )
    }
}

class Home extends React.Component {
    render() {
        return (
            <div>
                <h1>Home...</h1>
            </div>
        )
    }
}

class About extends React.Component {
    render() {
        return (
            <div>
                <h1>About...</h1>
            </div>
        )
    }
}

class Contact extends React.Component {
    render() {
        return (
            <div>
                <h1>Contact...</h1>
            </div>
        )
    }
}