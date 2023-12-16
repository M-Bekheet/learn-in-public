import {
  StyleSheet,
  View,
  Text,
  Button,
  Alert,
  FlatList,
  useWindowDimensions,
} from "react-native";
import Title from "../components/ui/Title";
import { useEffect, useState } from "react";
import NumberContainer from "../components/game/NumberContainer";
import PrimaryButton from "../components/ui/PrimaryButton";
import Card from "../components/ui/Card";
import InstructionText from "../components/ui/InstructionText";
import Ionicons from "@expo/vector-icons/Ionicons";
import GuessLogItem from "../components/game/GuessLogItem";
function generateRandomNumber(min, max, exclude) {
  const randNum = Math.floor(Math.random() * (max - min)) + min;
  if (randNum === exclude) return generateRandomNumber(min, max, exclude);
  return randNum;
}

let minBoundary = 1,
  maxBoundary = 100;

function GameScreen({ userNumber, onGameOver, onGuess }) {
  const initialGuess = generateRandomNumber(1, 100, userNumber);
  const [currentGuess, setCurrentGuess] = useState(initialGuess);
  const [guessRounds, setGuessRounds] = useState([initialGuess]);

  const { height } = useWindowDimensions();

  useEffect(() => {
    if (currentGuess === userNumber) onGameOver();
  }, [currentGuess, userNumber, onGameOver]);

  useEffect(() => {
    minBoundary = 1;
    maxBoundary = 100;
    onGuess();
  }, []);

  function nextGuessHandler(direction) {
    if (
      (direction === "lower" && userNumber > currentGuess) ||
      (direction === "higher" && userNumber < currentGuess)
    ) {
      return Alert.alert("Don't lie", "You know that this is wrong...", [
        {
          text: "Sorry!",
          style: "cancel",
        },
      ]);
    }

    //lower or higher
    if (direction === "lower") {
      maxBoundary = currentGuess - 1;
    } else {
      minBoundary = currentGuess + 1;
    }
    onGuess();
    const newGuess = generateRandomNumber(
      minBoundary,
      maxBoundary,
      currentGuess
    );
    setGuessRounds((prev) => [...prev, newGuess]);
    setCurrentGuess(newGuess);
  }

  let content = (
    <>
      <NumberContainer>{currentGuess}</NumberContainer>
      <Card>
        <InstructionText style={styles.instructionText}>
          Higher or lower?
        </InstructionText>
        <View style={styles.buttonsContainer}>
          <View style={styles.buttonContainer}>
            <PrimaryButton onPress={nextGuessHandler.bind(this, "higher")}>
              <Ionicons name="md-add" size={24} color="#fff" />
            </PrimaryButton>
          </View>
          <View style={styles.buttonContainer}>
            <PrimaryButton onPress={nextGuessHandler.bind(this, "lower")}>
              <Ionicons name="md-remove" size={24} color="#fff" />
            </PrimaryButton>
          </View>
        </View>
      </Card>
    </>
  );

  if (height < 500) {
    content = (
      <>
        <View style={styles.buttonsContainerWide}>
          <View style={styles.buttonContainer}>
            <PrimaryButton onPress={nextGuessHandler.bind(this, "higher")}>
              <Ionicons name="md-add" size={24} color="#fff" />
            </PrimaryButton>
          </View>
          <NumberContainer>{currentGuess}</NumberContainer>
          <View style={styles.buttonContainer}>
            <PrimaryButton onPress={nextGuessHandler.bind(this, "lower")}>
              <Ionicons name="md-remove" size={24} color="#fff" />
            </PrimaryButton>
          </View>
        </View>
      </>
    );
  }

  return (
    <View style={styles.screen}>
      <Title>Opponent's Guess</Title>
      {content}
      <View style={styles.listContainer}>
        <FlatList
          style={styles.guessesList}
          data={guessRounds}
          renderItem={(itemData) => (
            <GuessLogItem
              style={styles.guess}
              guess={itemData.item}
              roundNumber={guessRounds.length - itemData.index}
            />
          )}
          keyExtractor={(item) => item}
        />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  screen: {
    flex: 1,
    padding: 24,
    alignItems: "center",
  },
  instructionText: {
    marginBottom: 12,
  },
  buttonsContainer: {
    flexDirection: "row",
  },
  buttonContainer: {
    flex: 1,
  },
  buttonsContainerWide: {
    flexDirection: "row",
    alignItems: "center",
  },
  listContainer: {
    flex: 1,
    padding: 16,
  },
});
export default GameScreen;
