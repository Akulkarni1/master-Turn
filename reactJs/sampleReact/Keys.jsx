import React from 'react';

class Keys extends React.Component{
    constructor() {
        super();
        this.state ={data:[{component: 'First.',
            id:1},{
            component: 'sec',
                id: 2
            },{
            component: 'third',
                id: 3
            }]}
    }
    render() {return(<div><div>
        {this.props.componentData.component}
    </div>
    <div>{this.props.componentData.id}</div>
    </div>);
    }

}