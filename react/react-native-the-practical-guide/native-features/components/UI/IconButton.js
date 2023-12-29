import { Platform, Pressable, StyleSheet, Text } from "react-native";
import { Ionicons } from "@expo/vector-icons";
function IconButton({ icon, size, color, onPress }) {
  return (
    <Pressable
      onPress={onPress}
      style={({ pressed }) => [styles.button, pressed && styles.pressed]}
    >
      <Ionicons style={styles.icon} name={icon} color={color} size={size} />
    </Pressable>
  );
}

const styles = StyleSheet.create({
  button: {
    padding: 7,
    marginRight: Platform.OS === "ios" ? 12 : 0,
    justifyContent: "center",
    alignItems: "center",
  },
  pressed: {
    opacity: 0.7,
  },
});
export default IconButton;
