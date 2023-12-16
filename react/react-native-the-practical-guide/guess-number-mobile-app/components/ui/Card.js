import { Dimensions, StyleSheet, View } from "react-native";
import { COLORS } from "../../constants/colors";

export default function Card({ children }) {
  return <View style={styles.container}>{children}</View>;
}

const deviceWidth = Dimensions.get("window").width;

const styles = StyleSheet.create({
  container: {
    justifyContent: "center",
    alignItems: "center",
    borderWidth: 4,
    marginTop: deviceWidth < 380 ? 24 : 36,
    marginHorizontal: 24,
    padding: 16,
    backgroundColor: COLORS.primary800,
    borderRadius: 8,
    elevation: 50,
    shadowColor: "black",
    shadowOffset: {
      width: 0,
      height: 10,
    },
  },
});
