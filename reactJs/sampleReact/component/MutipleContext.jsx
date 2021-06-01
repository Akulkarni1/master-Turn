import React from 'react';

const themeContext =React.CreateContext('light');
const UserContext = React.createContext({
    name: 'Guest',
});
class MutipleContext extends React.Component{
    render() {
        const {signedInUser, theme} = this.props;

        // App component that provides initial context values
        return (
            <ThemeContext.Provider value={theme}>
                <UserContext.Provider value={signedInUser}>
                    <Layout />
                </UserContext.Provider>
            </ThemeContext.Provider>
        );
    }
}
function Layout() {
    return (
        <div>
            <Sidebar />
            <Content />
        </div>
    );
}
function Content() {
    return (
        <ThemeContext.Consumer>
            {theme => (
                <UserContext.Consumer>
                    {user => (
                        <ProfilePage user={user} theme={theme} />
                    )}
                </UserContext.Consumer>
            )}
        </ThemeContext.Consumer>
    );
}