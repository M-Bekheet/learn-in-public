import { useState } from "react";
import {
  Alert,
  Dimensions,
  KeyboardAvoidingView,
  ScrollView,
  StyleSheet,
  Text,
  TextInput,
  View,
  useWindowDimensions,
} from "react-native";
import PrimaryButton from "../components/ui/PrimaryButton";
import { COLORS } from "../constants/colors";
import Title from "../components/ui/Title";
import Card from "../components/ui/Card";
import InstructionText from "../components/ui/InstructionText";

const StartGameScreen = ({ onPickNumber }) => {
  const [enteredNumber, setEnteredNumber] = useState("");
  const { height } = useWindowDimensions("");

  const marginTop = height < 380 ? 30 : 100;

  function numberInputHandler(enteredText) {
    setEnteredNumber(enteredText);
  }
  function resetInputHandler() {
    setEnteredNumber("");
  }
  function confirmInputHandler() {
    const chosenNumber = parseInt(enteredNumber);

    if (isNaN(chosenNumber) || chosenNumber <= 0 || chosenNumber > 99) {
      //show alert
      Alert.alert(
        "Invalid Number",
        "Number has to be a number between 1 and 99.",
        [
          {
            text: "Okay",
            style: "destructive",
            onPress: resetInputHandler,
          },
        ]
      );
      return;
    }

    onPickNumber(chosenNumber);
  }

  return (
    <ScrollView>
      <KeyboardAvoidingView style={styles.screen} behavior="padding">
        <View style={[styles.rootContainer, { marginTop }]}>
          <Title>Guess My Number</Title>
          <Card>
            <InstructionText style={styles.label}>Your guess:</InstructionText>
            <TextInput
              style={styles.numberInput}
              keyboardType="number-pad"
              autoCapitalize="none"
              autoCorrect={false}
              value={enteredNumber}
              onChangeText={numberInputHandler}
              maxLength={2}
            />
            <View style={styles.buttonsContainer}>
              <View style={styles.buttonContainer}>
                <PrimaryButton onPress={resetInputHandler}>Reset</PrimaryButton>
              </View>
              <View style={styles.buttonContainer}>
                <PrimaryButton onPress={confirmInputHandler}>
                  Confirm
                </PrimaryButton>
              </View>
            </View>
          </Card>
        </View>
      </KeyboardAvoidingView>
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  screen: {
    flex: 1,
  },
  rootContainer: {
    flex: 1,
    alignItems: "center",
  },
  numberInput: {
    height: 50,
    width: 50,
    fontSize: 32,
    textAlign: "center",
    borderBottomColor: COLORS.accent500,
    borderBottomWidth: 2,
    color: COLORS.accent500,
    marginVertical: 8,
    fontWeight: "bold",
  },
  buttonsContainer: {
    flexDirection: "row",
  },
  buttonContainer: {
    flex: 1,
  },
});

export default StartGameScreen;
