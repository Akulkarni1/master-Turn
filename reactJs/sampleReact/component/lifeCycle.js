import React from 'react';
import ReactDom from 'react-dom';
import LifeCycle from './LifeCycleMethod';

ReactDom.render(<LifeCycle/>, document.getElementById('app'));

setTimeout(() => {
    ReactDOM.unmountComponentAtNode(document.getElementById('app'));
}, 10000);