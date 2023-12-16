import * as Font from "expo-font";
import { LinearGradient } from "expo-linear-gradient";
import * as SplashScreen from "expo-splash-screen";
import { useEffect, useState, useCallback } from "react";
import { ImageBackground, SafeAreaView, StyleSheet } from "react-native";
import { COLORS } from "./constants/colors";
import GameOverScreen from "./screens/GameOverScreen";
import GameScreen from "./screens/GameScreen";
import StartGameScreen from "./screens/StartGameScreen";
import { StatusBar } from "expo-status-bar";

SplashScreen.preventAutoHideAsync();

export default function App() {
  const [userNumber, setUserNumber] = useState();
  const [gameOver, setGameOver] = useState(true);
  const [roundsNumber, setRoundsNumber] = useState(0);
  const [appIsReady, setAppIsReady] = useState(false);

  useEffect(() => {
    async function prepare() {
      try {
        // Pre-load fonts, make any API calls you need to do here
        await Font.loadAsync({
          "open-sans": require("./assets/fonts/OpenSans-Regular.ttf"),
          "open-sans-bold": require("./assets/fonts/OpenSans-Bold.ttf"),
        });
      } catch (e) {
        console.warn(e);
      } finally {
        // Tell the application to render
        setAppIsReady(true);
      }
    }

    prepare();
  }, []);

  const onLayoutRootView = useCallback(async () => {
    if (appIsReady) {
      // This tells the splash screen to hide immediately! If we call this after
      // `setAppIsReady`, then we may see a blank screen while the app is
      // loading its initial state and rendering its first pixels. So instead,
      // we hide the splash screen once we know the root view has already
      // performed layout.
      await SplashScreen.hideAsync();
    }
  }, [appIsReady]);

  function pickedNumberHandler(pickedNumber) {
    setUserNumber(pickedNumber);
    setGameOver(false);
  }
  function gameOverHandler() {
    setGameOver(true);
  }

  function restartGameHandler() {
    setRoundsNumber(0);
    setUserNumber(null);
  }

  if (!appIsReady) {
    return null;
  }

  let screen = <StartGameScreen onPickNumber={pickedNumberHandler} />;
  if (userNumber)
    screen = (
      <GameScreen
        onGameOver={gameOverHandler}
        userNumber={userNumber}
        onGuess={() => setRoundsNumber((prev) => prev + 1)}
      />
    );
  if (userNumber && gameOver)
    screen = (
      <GameOverScreen
        userNumber={userNumber}
        roundsNumber={roundsNumber}
        onRestartGame={restartGameHandler}
      />
    );

  return (
    <>
      <StatusBar style="light" />
      <LinearGradient
        colors={[COLORS.primary700, COLORS.accent500]}
        style={styles.container}
        onLayout={onLayoutRootView}
      >
        <ImageBackground
          source={require("./assets/images/background.png")}
          resizeMode="cover"
          style={styles.container}
          imageStyle={styles.backgroundImage}
        >
          <SafeAreaView style={styles.container}>{screen}</SafeAreaView>
        </ImageBackground>
      </LinearGradient>
    </>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  backgroundImage: {
    opacity: 0.15,
  },
});
