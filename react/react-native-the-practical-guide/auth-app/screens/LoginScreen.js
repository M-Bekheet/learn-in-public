import { useContext, useState } from "react";
import AuthContent from "../components/Auth/AuthContent";
import { loginUser } from "../util/auth";
import LoadingOverlay from "../components/ui/LoadingOverlay";
import { Alert } from "react-native";
import { AuthContext } from "../store/auth-context";

function LoginScreen() {
  const [isLogging, setIsLogging] = useState(false);
  const authContext = useContext(AuthContext);
  async function loginHandler({ email, password }) {
    setIsLogging(true);
    try {
      const { idToken } = await loginUser(email, password);
      authContext.authenticate(idToken);
    } catch (error) {
      console.log(error);
      Alert.alert(
        "Authentication Failed!!",
        "Could not log you in. Please check your credentials or try again later!"
      );
    }
    setIsLogging(false);
  }

  if (isLogging) return <LoadingOverlay message="Logging..." />;
  return <AuthContent isLogin onAuthenticate={loginHandler} />;
}

export default LoginScreen;
