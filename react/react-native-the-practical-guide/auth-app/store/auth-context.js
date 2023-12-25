import { createContext, useEffect, useState } from "react";
import AsyncStorage from "@react-native-async-storage/async-storage";

export const AuthContext = createContext({
  token: "",
  isAuthenticated: false,
  authenticate: () => {},
  logout: () => {},
});

// *NOTE: In this app we don't refresh the token which expires in an hour. To fix this, you will need to set a timer to logout the user before expiration or rely on the received refresh token to update the saved access token.
// Reference: (https://firebase.google.com/docs/reference/rest/auth#section-refresh-token)

export function AuthProvider({ children }) {
  const [authToken, setAuthToken] = useState("");

  function authenticate(token) {
    setAuthToken(token);
    AsyncStorage.setItem("auth-token", token);
  }

  function logout() {
    setAuthToken(null);
    AsyncStorage.removeItem("auth-token");
  }

  const value = {
    token: authToken,
    isAuthenticated: !!authToken,
    authenticate,
    logout,
  };
  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
}

export default AuthProvider;
