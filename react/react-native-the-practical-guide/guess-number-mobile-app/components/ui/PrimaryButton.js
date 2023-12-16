import { Pressable, StyleSheet, Text, View } from "react-native";
import { COLORS } from "../../constants/colors";

function PrimaryButton({ children, onPress }) {
  return (
    <View style={styles.holder}>
      <Pressable
        style={({ pressed }) => [styles.container, pressed && styles.pressed]}
        onPress={onPress}
        android_ripple={{ color: COLORS.primary600 }}
      >
        <Text style={styles.text}>{children}</Text>
      </Pressable>
    </View>
  );
}

const styles = StyleSheet.create({
  holder: {
    margin: 4,
    overflow: "hidden",
    borderRadius: 28,
  },
  container: {
    backgroundColor: COLORS.primary500,
    paddingVertical: 8,
    paddingHorizontal: 16,
    elevation: 2,
  },
  text: {
    color: "white",
    textAlign: "center",
  },
  pressed: {
    opacity: 0.75,
  },
});

export default PrimaryButton;
