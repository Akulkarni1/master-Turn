import {ThemeContext2} from './Themed2';

function ThemeTogglerButton() {
    // The Theme Toggler Button receives not only the theme
    // but also a toggleTheme function from the context
    return (
        <ThemeContext2.Consumer>
            {({theme2, toggleTheme}) => (
                <button
                    onClick={toggleTheme}
                    style={{backgroundColor: theme2.background}}>
                    Toggle Theme
                </button>
            )}
        </ThemeContext2.Consumer>
    );
}

export default ThemeTogglerButton;