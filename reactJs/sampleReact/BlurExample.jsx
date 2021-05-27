import React from 'react';

//Learning from React tutorial.

class BlurExample extends React.Component {
    constructor(props) {
        super(props);
        this.state = {isOpen: false};
        this.timeOutId = null;
        this.onClickHandler = this.onClickHandler.bind(this);
        this.onBlurHandler = this.onBlurHandler.bind(this);
        this.onFocusHandler = this.onFocusHandler.bind(this);
    }

    onClickHandler() {
        this.setState(currentState => ({isOpen: !currentState.isOpen}));
    }

    onBlurHandler() {
        this.timeOutId = setTimeout(() => {
            this.setState({isOpen: false});
        });
    }

    onFocusHandler() {
        clearTimeout(this.timeOutId);
    }

    render() {
        // React assists us by bubbling the blur and
        // focus events to the parent.
        return (
            <div onBlur={this.onBlurHandler}
                 onFocus={this.onFocusHandler}>
                <button onClick={this.onClickHandler}
                        aria-haspopup="true"
                        aria-expanded={this.state.isOpen}>
                    Select an option
                </button>
                {this.state.isOpen && (
                    <ul>
                        <li>Option 1</li>
                        <li>Option 2</li>
                        <li>Option 3</li>
                    </ul>
                )}
            </div>
        );
    }
}