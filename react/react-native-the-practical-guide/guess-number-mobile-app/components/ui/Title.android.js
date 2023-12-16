import { StyleSheet, Text, Platform } from "react-native";

function Title({ children }) {
  return <Text style={styles.title}>{children}</Text>;
}

const styles = StyleSheet.create({
  title: {
    fontFamily: "open-sans-bold",
    fontSize: 24,
    textAlign: "center",
    color: "white",
    borderColor: "white",
    borderWidth: 2,
    padding: 12,
    width: 300,
    maxWidth: "80%",
  },
});
export default Title;
