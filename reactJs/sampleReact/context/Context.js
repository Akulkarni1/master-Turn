import {ThemeContext, themes} from "./theme-context";
import ThemedButton from "./themed-button";

function Toolbar(props) {
    return (<ThemedButton onClick={props.changeTheme}>Change Theme</ThemedButton>);
}

class Context extends React.Component {
    constructor(props) {
        super(props);
        this.state = {themes: themes.light};
        this.toggleTheme = () => {
            this.setState(state => ({theme: this.state.theme === themes.dark ? themes.light : themes.dark,}));
        };
    }

    render() {
        return (<page><ThemeContext.Provider value={this.state.theme}>
            <Toolbar changeTheme={this.toggleTheme}/>
        </ThemeContext.Provider>
            <Section>
                <ThemedButton/>
            </Section></page>);
    }
}

ReactDOM.render(<Context/>, document.root);